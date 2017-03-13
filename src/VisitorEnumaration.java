import java.util.ArrayList;
import java.util.Arrays;


public class VisitorEnumaration extends BayesGrammarBaseVisitor<Object> {
	private boolean isCondition = false;
    private String numerator = "";
    private String denominator = "";
    private ArrayList<String> hiddenVarsNumerator = new ArrayList<>();
    private ArrayList<String> hiddenVarsDenominator = new ArrayList<>();
    private String input = "";
    
	@Override
    public Object visitCliBayes(BayesGrammarParser.CliBayesContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
            // Cuando es el ultimo tomamos la expresion final
            if (i == ctx.getChildCount() - 1) {
                // Si tenemos variables de condicion
                if (isCondition) {
                    input = numerator + " / " + denominator;
                } else {
                    input = numerator;
                }
                
                // Limpiamos la expresion
                numerator = "";
                denominator = "";
            }
        }
        return super.visitCliBayes(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCondition(BayesGrammarParser.ConditionContext ctx) {
        // Activar bandera ya que tenemos condicion
        isCondition = true;
        return super.visitCondition(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
        Tomamos el numerador, el numerador es la parte izquierda de la expresion
    */
    @Override
    public Object visitOperator(BayesGrammarParser.OperatorContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String variable = ctx.getChild(i).getText();
            
            numerator += variable;
        }
        return super.visitOperator(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object visitOp2(BayesGrammarParser.Op2Context ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String variable = ctx.getChild(i).getText();
            denominator += variable;
            if (variable.contains(",")) {
                variable = variable.replace(",", "");
            }
            
            // Agregamos la variable de condicion al numerador para completarla ya que tomamos ',' como condicion
            numerator += "," + variable;
        }
        return super.visitOp2(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void getHiddenVars(ArrayList<Node> bayesNetwork) {
        String[] numeratorVariables = numerator.split(",");
        
        getHiddenVarsX(numeratorVariables, bayesNetwork, "numerator");
        
        if (!denominator.isEmpty()) {
            String[] denominatorVariables = numerator.split(",");
            getHiddenVarsX(denominatorVariables, bayesNetwork, "denominator");
        } else {
            hiddenVarsDenominator = new ArrayList();
        }
    }
    
    public void getHiddenVarsX(String[] expVariables, ArrayList<Node> bayesNetwork, String eval) {
        for (Node node : bayesNetwork) {
            boolean found = false;
            for (String expVariable : expVariables) {
                String tmp = expVariable.replace("!", "");
                if (tmp.equals(node.getId())) {
                    found = true;
                }
            }
            if (!found) {
                if ("numerator".equals(eval)) {
                    hiddenVarsNumerator.add(node.getId());
                } else {
                    hiddenVarsDenominator.add(node.getId());
                }
            }
        }
    }
    
    public double calcEnumerationTotal(String exp, ArrayList<Node> bayesNetwork) {
        return 0;
    }
    
    public double enumerateNumerator(String exp, ArrayList<Node> bayesNetwork) {
        double total = 0;
        // totalPosibilities is the simulation of the sum(hiddenvariable)sum....
        int totalPosibilities = (int)Math.pow(2, hiddenVarsNumerator.size());
        for (int i = 0; i < totalPosibilities; i++) {
            // 1 -> 01, 2 -> 10, tomamos la representacion en la tabla
            String binRepresentation = Integer.toBinaryString(i);
            // Normalizamos la representacion a la cantidad de variables que tenemos
            while(binRepresentation.length() < hiddenVarsNumerator.size()) {
                binRepresentation = "0" + binRepresentation;
            }
            
            // Obtenemos la secuencia separada
            char[] bin = binRepresentation.toCharArray();
            String[] strHiddenVars = new String[hiddenVarsNumerator.size()];
            
            for (int j = 0; j < hiddenVarsNumerator.size(); j++) {
                if (bin[j] == '0') {
                    // si la variable es TRUE, la agregamos normal
                    strHiddenVars[j] = hiddenVarsNumerator.get(j);
                } else {
                    // Si la varaible es FALSE, la negamos
                    strHiddenVars[j] = "!" + hiddenVarsNumerator.get(j);
                }
            }
            
            String expExtended = generateNewExpression(exp, new ArrayList(Arrays.asList(strHiddenVars)));
            total += evaluateExpression(expExtended, bayesNetwork);
        }
        return total;
    }
    
    public double enumerateDenominator(String exp, ArrayList<Node> bayesNetwork) {
        double total = 0;
        int totalHiddenVars = hiddenVarsDenominator.size();
        if (totalHiddenVars == 0) {
            return 1; // Return 1, porque no podemos dividir dentro de 0
        }
        
        for (int i = 0; i < totalHiddenVars; i++) {
            // 1 -> 01, 2 -> 10, tomamos la representacion en la tabla
            String binRepresentation = Integer.toBinaryString(i);
            // Normalizamos la representacion a la cantidad de variables que tenemos
            while(binRepresentation.length() < hiddenVarsDenominator.size()) {
                binRepresentation = "0" + binRepresentation;
            }
            
            // Obtenemos la secuencia separada
            char[] bin = binRepresentation.toCharArray();
            String[] strHiddenVars = new String[hiddenVarsDenominator.size()];
            
            for (int j = 0; j < hiddenVarsDenominator.size(); j++) {
                if (bin[j] == '0') {
                    // si la variable es TRUE, la agregamos normal
                    strHiddenVars[j] = hiddenVarsDenominator.get(j);
                } else {
                    // Si la varaible es FALSE, la negamos
                    strHiddenVars[j] = "!" + hiddenVarsDenominator.get(j);
                }
            }
            
            String expExtended = generateNewExpression(exp, new ArrayList(Arrays.asList(strHiddenVars)));
            total += evaluateExpression(expExtended, bayesNetwork);
        }
        
        return total;
    }
    
    public String generateNewExpression(String expression, ArrayList<String> vars) {
        String expr = "";
        for (int j = 0; j < vars.size(); j++) {
            String variable = vars.get(j);
            String tempVariable = variable.replace("!", "");
            // Tomamos cada uno de los terminos que tenemos
            String[] expTerm = expression.split(":");
            for (int i = 0; i < expTerm.length; i++) {
                String term = expTerm[i];
                String newString = "";
                // Por cada variable
                for (char ch: term.toCharArray()) {
                    if (ch == (tempVariable.toCharArray()[0])) {
                        newString += variable;
                    } else {
                        newString += ch;
                    }
                }
                expr += newString + ":";
                   
            }
            
            // Iteramos sobre la nueva expresion
            expression = expr;
            if (j != vars.size() - 1)
                expr = "";
        }
        return expr;
    }
    
    public double evaluateExpression(String expression, ArrayList<Node> completeNetwork) {
        System.out.println(expression);
        String[] arrayExpr = expression.split(":");
        double prob = 1;
        for (int i = 0; i < arrayExpr.length;i++) {
            String expr = arrayExpr[i];
            if (!expr.isEmpty()) {
                for (Node node: completeNetwork) {
                    if (node.getExpression().equals(expr)) {
                        prob *= node.getProbability();
                    }
                }
            }
            
        }
        System.out.println(prob);
        return prob;
    }
}
