
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Diego Jacobs
 * @param <T>
 *
 */
public class Node {
	private String id;
	private ArrayList<Node> previous;
	private double probability;
	private String expression;
	
	public Node(String id){
		this.id = id;
		this.previous = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Node> getPrecedence() {
		return previous;
	}

	public void setPrevious(ArrayList<Node> precedence) {
		this.previous = precedence;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	public void addToPrevious(Node node) {
		this.previous.add(node);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) 
			return false;
		
        Node node = (Node)obj;
        
        if (this.expression == null || node.getExpression() == null)
            return this.id.equals(node.getId());
        
        if (this.id == null )
            return this.expression.equals(node.getExpression());

        return this.id.equals(node.getId()); 
	}
	
	public String specialToString() {
        String prevNodes = "";
        for (Node bn: this.previous) {
            prevNodes += bn.getId() + ", ";
        }
        
        return "Id: " + this.id + " prevNodes: " + (prevNodes.isEmpty() ? "No tiene" : prevNodes);
    }
	
	@Override
	public String toString() {
		return "Node [expression = " + expression.toString() + ", probability = " + probability + "]";
	}
}
