
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Diego Jacobs
 * @param <T>
 *
 */
public class Node<T> {
	private String id;
	private ArrayList<Node> precedence;
	private double probability;
	private String expression;
	
	public Node(String id){
		this.id = id;
		this.precedence = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Node> getPrecedence() {
		return precedence;
	}

	public void setPrecedence(ArrayList<Node> precedence) {
		this.precedence = precedence;
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
	
	public void addToPrecedence(Node node) {
		this.precedence.add(node);
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

	@Override
	public String toString() {
		return "Node [id = " + id.toString() + ", precedence = " + precedence
				+ ", probability = " + probability + "]";
	}
}
