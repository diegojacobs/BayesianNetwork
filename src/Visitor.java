import java.util.ArrayList;
import java.util.HashSet;



/**
 * 
 */

/**
 * @author Diego Jacobs
 *
 */
public class Visitor extends BayesGrammarBaseVisitor{
    private ArrayList<Node> bayesianNetwork;
    private Node currentNode;
    private boolean condition;
    private String currentId;
    
	public Visitor(){
		this.condition = false;
		bayesianNetwork = new ArrayList<Node>();
	}
	
	public ArrayList<Node> getBayesianNetwork() {
		return bayesianNetwork;
	}
	
	public void setBayesianNetwork(ArrayList<Node> bayesianNetwork) {
		this.bayesianNetwork = bayesianNetwork;
	}
	
	public Node getCurrentNode() {
		return currentNode;
	}
	public void setCurrentNode(Node currentNode) {
		this.currentNode = currentNode;
	}

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	public String getCurrentId() {
		return currentId;
	}

	public void setCurrentId(String currentId) {
		this.currentId = currentId;
	}

	@Override
	public Object visitCondition(BayesGrammarParser.ConditionContext ctx) {
		// TODO Auto-generated method stub
		this.condition = true;
		return super.visitCondition(ctx);
	}

	@Override
	public Object visitNegation(BayesGrammarParser.NegationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNegation(ctx);
	}

	@Override
	public Object visitNumber(BayesGrammarParser.NumberContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNumber(ctx);
	}

	@Override
	public Object visitOp(BayesGrammarParser.OpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitOp(ctx);
	}

	@Override
	public Object visitProgram(BayesGrammarParser.ProgramContext ctx) {
		// TODO Auto-generated method stub
		return super.visitProgram(ctx);
	}

	@Override
	public Object visitProbability(BayesGrammarParser.ProbabilityContext ctx) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ctx.getChildCount(); i++){
            this.visit(ctx.getChild(i));
            if (i == ctx.getChildCount() -1 ) {
                if (!this.bayesianNetwork.contains(currentNode))
                    this.bayesianNetwork.add(currentNode);
            }
        }
		
        condition = false;
        return null;
	}

	@Override
	public Object visitOperator(BayesGrammarParser.OperatorContext ctx) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ctx.getChildCount(); i++) {
            String child = ctx.getChild(i).getText();
            if (!child.equals(",") && !child.equals("!")) {
                    currentNode = new Node(child);
                    currentId = child;
                    if (!this.bayesianNetwork.contains(currentNode))
                        this.bayesianNetwork.add(currentNode);
            }
        }
		
        return super.visitOperator(ctx);
	}
	
	@Override
	public Object visitOperator2(BayesGrammarParser.Operator2Context ctx) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ctx.getChildCount(); i++){
            String child = ctx.getChild(i).getText();
            if (!child.equals(",") && !child.equals("!")) {
                if (condition) {
                    Node node = this.searchForNode(child);
                    currentNode.addToPrecedence(node);
                } 
                else
                	currentId = child;
            }
        }
		
		return super.visitOperator2(ctx);
	}
	
	private Node searchForNode(String id){
        for (Node node : this.bayesianNetwork) {
            if (node.getId().equals(id)) {
                return node;
            }
        }
        
        return null;
    }
	
	public int validateNetwork() {
        int total = 0;
        for (int i = 0; i < this.bayesianNetwork.size(); i++) {
            Node node = this.bayesianNetwork.get(i);
            int countPrecedence = node.getPrecedence().size();
            countPrecedence = (int)Math.pow(2, countPrecedence);
            total += countPrecedence;
        }
        return total;
    }
}
