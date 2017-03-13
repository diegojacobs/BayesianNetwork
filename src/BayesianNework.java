
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
		        if(errorsCount == 0){
		            VisitorValidator visitorValidator = new VisitorValidator();
		            visitorValidator.visit(tree);
		            
		            new GraphicNetwork(visitorValidator.getBayesianNetwork());
		            
		            VisitorTable visitorTable = new VisitorTable();
		            visitorTable.visit(tree);
		            
		            String redBayesianaProbs = visitorTable.totalExpression();
		            
		            //Tabla completa
		            System.out.println("Complete Table");
		            for (Node node: visitorTable.getNetwork()) {
		                System.out.println(node.toString());
		            }
		            System.out.println("");
		            
		            boolean validCantProbs = file.getNumberOfLines() == visitorValidator.validateNetwork();
		            boolean validProbsEquality = visitorValidator.validateRepetitives(file.getSb().toString());
		            
		            System.out.println((validProbsEquality && validCantProbs) ? "Is Valid" : "Is not Valid");
		            
		            ArrayList<Node> network = visitorValidator.getBayesianNetwork();
		            ArrayList<Node> completeNetwork = visitorTable.getNetwork();
		            
		        }
		        else
		        {
		        	JOptionPane.showMessageDialog(null, "File invalid. Semantic Error");
		        }
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
