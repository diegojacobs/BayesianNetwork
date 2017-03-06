
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
		        }
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
