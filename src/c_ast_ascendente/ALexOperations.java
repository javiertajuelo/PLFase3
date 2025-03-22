package c_ast_ascendente;


public class ALexOperations {
    
    
    private AnalizadorLexicoEval alex;

    public ALexOperations(AnalizadorLexicoEval alex) {
        this.alex = alex;   
    }

    public UnidadLexica unidadEof() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.EOF,"<EOF>");
    }

    public UnidadLexica unidadModulo() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MOD, "%");
    }

    public UnidadLexica unidadReferencia() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.REFERENCIA,"&");
    }

    public UnidadLexica unidadParAp() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PAP,"(");
    }

    public UnidadLexica unidadParCierre() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PCIERRE,")");
    }

    public UnidadLexica unidadMul() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.POR,"*");
    }

    public UnidadLexica unidadSuma() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MAS,"+");
    }

    public UnidadLexica unidadComa() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.COMA,",");
    }

    public UnidadLexica unidadResta() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MENOS,"-");
    }

    public UnidadLexica unidadPunto() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PUNTO,".");
    }

    public UnidadLexica unidadDiv() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.DIV, "/");
    }

    public UnidadLexica unidadLitEntero() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.LIT_ENT, alex.lexema());
    }

    public UnidadLexica unidadPuntoYComa() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PUNTOYCOMA,";");
    }

    public UnidadLexica unidadMenor() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MENOR, "<");
    }

    public UnidadLexica unidadAsignacion() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ASIGNACION, "=");
    }

    public UnidadLexica unidadMayor() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MAYOR, ">");
    }

    public UnidadLexica unidadEval() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.EVAL, "@");
    }

    public UnidadLexica unidadIden() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.IDEN, alex.lexema());
    }

    public UnidadLexica unidadCorAp() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CORAP, "[");
    }

    public UnidadLexica unidadCorCierre() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CORCIERRE, "]");
    }

    public UnidadLexica unidadPuntero() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PUNTERO, "^");
    }

    public UnidadLexica unidadLitCadena() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.LIT_CADENA, alex.lexema());
    }
    
    public UnidadLexica unidadLitBool() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.LIT_BOOLEANO, "<" +alex.lexema() + ">");
    }

    public UnidadLexica unidadLlaveAp() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.LLAVEAP, "{");
    }

    public UnidadLexica unidadLlaveCierre() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.LLAVECIERRE, "}");
    }

    public UnidadLexica unidadDistinto() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.DISTINTO, "!=");
    }

    public UnidadLexica unidadFinDecl() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.FINDECL, "&&");
    }

    public UnidadLexica unidadMenIgual() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MENIGUAL, "<=");
    }

    public UnidadLexica unidadIgual() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.IGUAL, "==");
    }

    public UnidadLexica unidadMayIgual() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MAYIGUAL, ">=");
    }
    
    public UnidadLexica unidadOr() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.OR, "<or>");
    }

    public UnidadLexica unidadIf() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.IF, "<if>");
    }

    public UnidadLexica unidadNl() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.NL, "<nl>");
    }

    public UnidadLexica unidadLitReal() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.LIT_REAL, alex.lexema());
    }

    public UnidadLexica unidadAnd() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.AND, "<and>");
    }
    
    public UnidadLexica unidadNot() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.NOT, "<not>");
    }

    public UnidadLexica unidadInt() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.INT, "<int>");
    }

    public UnidadLexica unidadNew() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.NEW, "<new>");
    }

    public UnidadLexica unidadBool() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.BOOL, "<bool>");
    }

    public UnidadLexica unidadCall() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CALL, "<call>");
    }

    public UnidadLexica unidadElse() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ELSE, "<else>");
    }

    public UnidadLexica unidadNull() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.NULL, "<null>");
    }

    public UnidadLexica unidadProc() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PROC, "<proc>");
    }

    public UnidadLexica unidadRead() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.READ, "<read>");
    }

    public UnidadLexica unidadReal() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.REAL, "<real>");
    }


    public UnidadLexica unidadType() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.TYPE, "<type>");
    }

    public UnidadLexica unidadWhile() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.WHILE, "<while>");
    }

    public UnidadLexica unidadWrite() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.WRITE, "<write>");
    }

    public UnidadLexica unidadDelete() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.DELETE, "<delete>");
    }

    public UnidadLexica unidadString() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.STRING, "<string>");
    }

    public UnidadLexica unidadStruct() {
        return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.STRUCT, "<struct>");
    }
}
