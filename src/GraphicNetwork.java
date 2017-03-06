import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class GraphicNetwork {
	private ArrayList<Node> bayesianNetwork;
    
    public GraphicNetwork(ArrayList<Node> bayesianNetwork) throws FileNotFoundException, UnsupportedEncodingException, IOException{
    	this.bayesianNetwork = bayesianNetwork;
    	this.CreateGraph("Network");
    }
    
    private void CreateGraph(String fileName) throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        PrintWriter writer;
        writer= new PrintWriter(fileName + ".dot", "UTF-8");
        writer.println("digraph " + fileName + " {");
        writer.println("rankdir=LR;");
        
        String text = new String();
        
		text += "\tgraph [label=\"" + fileName + "\", labelloc=t, fontsize=20]; \n";
        text +="\tnode [shape=doublecircle, style = filled, fillcolor=white, color = black];";

        text+="\n";
        text +="\tnode [shape=circle];"+"\n";
        text +="\tnode [color=black, fontcolor=black];\n" +"	edge [color=black];"+"\n";

        for(int i=0;i < bayesianNetwork.size();i++){
            Node node = bayesianNetwork.get(i);
            ArrayList<Node> destination = this.getNodes(node.getId(), bayesianNetwork);
            for  (int j = 0; j < destination.size(); j++) {
               Node dest = destination.get(j);
               text += "\t" + node.getId() + " -> " + dest.getId() + "\n";
           }
        }
        
        writer.println(text);
        writer.println("}");
        writer.close();
        Runtime rt = Runtime.getRuntime();
        rt.exec("\"D:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe\" -Tjpg " + "\"D:\\Diego Jacobs\\workspace\\BayesianNetwork\\" + fileName + ".dot\" -o " + "\"D:\\Diego Jacobs\\workspace\\BayesianNetwork\\" + fileName + ".jpg\"");
        
    }

    private ArrayList<Node> getNodes(String id, ArrayList<Node> network) {
        ArrayList<Node> destination = new ArrayList();
        for (int i = 0; i < network.size(); i++) {
            Node node = network.get(i);
            ArrayList<Node> prec = node.getPrecedence();
            for (int j = 0; j < prec.size(); j++) {
                Node actualNode = prec.get(j);
                if (actualNode.getId().equals(id)) {
                    destination.add(node);
                }
            }
        }
        return destination;
    }
}
