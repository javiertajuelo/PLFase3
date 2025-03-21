package asint;

public class ClaseSemanticaEval extends SintaxisAbstractaEval {
    public ClaseSemanticaEval() {
        super();
    }
    
    public Expresion mkop(String op, Expresion opnd1, Expresion opnd2) {
        switch(op) {
            case "+":
                return expresion_adi_suma(opnd1, opnd2);
            case "-":
                if(opnd2 != null)
                    return expresion_adi_resta(opnd1, opnd2);
                else
                    return expresion_unaria_menos(opnd1);
            case "*":
                return expresion_mul(opnd1, opnd2);
            case "/":
                return expresion_div(opnd1, opnd2);
            case "%":
                return expresion_mod(opnd1, opnd2);
            case "<":
                return expresion_rel_menor(opnd1, opnd2);
            case ">":
                return expresion_rel_mayor(opnd1, opnd2);
            case "<=":
                return expresion_rel_menor_igual(opnd1, opnd2);
            case ">=":
                return expresion_rel_mayor_igual(opnd1, opnd2);
            case "==":
                return expresion_rel_igual_igual(opnd1, opnd2);
            case "!=":
                return expresion_rel_distinto(opnd1, opnd2);
            case "and":
                return expresion_log_and(opnd1, opnd2);
            case "or":
                return expresion_log_or(opnd1, opnd2);
            case "not":
                return expresion_unaria_not(opnd1);
            default:
                throw new UnsupportedOperationException("Operador no soportado: " + op);
        }
    }
}
