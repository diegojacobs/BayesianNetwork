
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * 
 */

/**
 * @author Diego Jacobs
 *
 */
public class BayesianNework {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		myFile file = new myFile();
		try{
			file.pickFile();
			
			if (file.getSb().toString().equals("No file selected"))
			{
				JOptionPane.showMessageDialog(null, "You didn't select a file.");
			}
			else
			{
				CharStream cs =  new ANTLRInputStream(file.getSb().toString());
				BayesGrammarLexer lexer = new BayesGrammarLexer(cs);
		        CommonTokenStream tokens = new CommonTokenStream( lexer);
		        BayesGrammarParser  parser = new BayesGrammarParser(tokens);
		        BayesGrammarParser.ProgramContext contexto = parser.program();
		        ParseTree tree = contexto;
		        
		        int errorsCount = parser.getNumberOfSyntaxErrors();
		        System.out.println(errorsCount);
		        if(errorsCount == 0){
		            Visitor visitor = new Visitor();
		            visitor.visit(tree);
		            GraphicNetwork graphViz = new GraphicNetwork(visitor.getBayesianNetwork());
		            /*BayesStructureVisitor structure = new BayesStructureVisitor();
		            structure.visit(tree);
		            String pTotal = structure.totalExpression();
		            structure.completeTable();
		            System.out.println(pTotal + " pTotal");
		            System.out.println("");
		            boolean valid = manager.getCantLines() == visitor.validateNetwork();
		            System.out.println(visitor.getNetwork());
		            ArrayList<Node> network = visitor.getNetwork();
		            ArrayList<Node> completeNetwork = structure.getStructure();
		            if (valid) {
		                while (true) {
		                    String expression = JOptionPane.showInputDialog(
		                       null,
		                       "Expression to evaluate",
		                       "",
		                       JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante
		                    
		                    
		                    expression = expression.toUpperCase();
		                    cs =  new ANTLRInputStream(expression);
		                    lexer = new BayesGrammarLexer(cs);
		                    tokens = new CommonTokenStream( lexer);
		                    parser = new BayesGrammarParser(tokens);
		                    BayesGrammarParser.CliBayesContext context = parser.cliBayes();
		                    tree = context;
		                    errorsCount = parser.getNumberOfSyntaxErrors();
		                    if (errorsCount > 0) {
		                        JOptionPane.showMessageDialog(null, "Expresión mal ingresada", "Error", JOptionPane.ERROR_MESSAGE);
		                    }
		                    else {
		                        EnumerationVisitor enumeration = new EnumerationVisitor();
		                        enumeration.visit(tree);
		                        enumeration.getHiddenVars(network);
		                        pTotal = enumeration.includeExpression(pTotal, expression);
		                        double answer = enumeration.enumerate(pTotal, completeNetwork);
		                        JOptionPane.showMessageDialog(null, expression+" = "+answer);
		                    
		                    }
		                }
		            }*/
		        }
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
