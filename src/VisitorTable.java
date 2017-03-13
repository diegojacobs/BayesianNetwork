import java.util.ArrayList;


public class VisitorTable extends BayesGrammarBaseVisitor<Object> {
	private ArrayList<Node> bayesianNetwork;
    private Node currentNode;
    
    public VisitorTable() {
        this.bayesianNetwork = new ArrayList<>();
    }

    @Override
    public Object visitProbability(BayesGrammarParser.ProbabilityContext ctx) {
            String expression = ctx.getText();
            Double probability = Double.parseDouble(expression.substring(expression.indexOf("=") + 1, expression.length()).trim());
            
            currentNode = new Node(null);
            currentNode.setProbability(probability);
            currentNode.setExpression(expression.substring(0, expression.indexOf("=")));
            
            if (!this.bayesianNetwork.contains(currentNode))
                this.bayesianNetwork.add(currentNode);
            
        
        return null;
    }

    public ArrayList<Node> getNetwork() {
        return this.bayesianNetwork;
    } 
    
    public ArrayList<Node> getCompleteNetwork() {
        ArrayList<Node> complete = new ArrayList<>();
        for (Node node : this.bayesianNetwork) {
            String expression = node.getExpression();
            int index = expression.indexOf("(") + 1;
            Node newNode = new Node("");
            
            newNode.setProbability(1 - node.getProbability());
            newNode.setExpression("P(!"+expression.substring(index, expression.length()));
            
            complete.add(node); 
            complete.add(newNode);
        }
        this.bayesianNetwork = complete;
        
        return this.bayesianNetwork;
    }
    
    public String totalExpression() {
        String exp = "";
        ArrayList<String> expressions = new ArrayList<>();
        for (Node node : this.bayesianNetwork) {
            String tmp = node.getExpression();
            tmp = tmp.replace("!", "");
            if (!expressions.contains(tmp)) {
                expressions.add(tmp);
                exp += ":"+tmp;
            }
            
        }
        return exp;
    }
}
