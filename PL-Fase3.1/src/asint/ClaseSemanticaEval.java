package asint;

public class ClaseSemanticaEval extends SintaxisAbstractaEval {
    public ClaseSemanticaEval() {
        super();
    }
    

    public Expresion mkop(String op, Expresion opnd1, Expresion opnd2) {
        switch(op) {
            case "+":
                return expresionAdiSuma(opnd1, opnd2); 
            case "-":
                if(opnd2 != null)
                    return expresionAdiResta(opnd1, opnd2); 
                else
                    return expresionUnariaMenos(opnd1); 
            case "*":
                return expresionMul(opnd1, opnd2); 
            case "/":
                return expresionDiv(opnd1, opnd2); 
            case "%":
                return expresionMod(opnd1, opnd2); 
            case "<":
                return expresionRelMenor(opnd1, opnd2); 
            case ">":
                return expresionRelMayor(opnd1, opnd2);
            case "<=":
                return expresionRelMenorIgual(opnd1, opnd2); 
            case ">=":
                return expresionRelMayorIgual(opnd1, opnd2); 
            case "==":
                return expresionRelIgualIgual(opnd1, opnd2); 
            case "!=":
                return expresionRelDistinto(opnd1, opnd2); 
            case "and":
                return expresionLogAnd(opnd1, opnd2); 
            case "or":
                return expresionLogOr(opnd1, opnd2); 
            case "not":
                return expresionUnariaNot(opnd1); 
            default:
                throw new UnsupportedOperationException("Operador no soportado: " + op);
        }
    }
    
}
