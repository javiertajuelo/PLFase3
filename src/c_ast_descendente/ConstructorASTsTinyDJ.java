package c_ast_descendente;

import java.io.Reader;

public class ConstructorASTsTinyDJ extends ConstructorASTsTiny {

    private void imprime(Token t) {
        switch (t.kind) {
            // Palabras clave
            case IF: System.out.println("<if>"); break;
            case ELSE: System.out.println("<else>"); break;
            case WHILE: System.out.println("<while>"); break;
            case READ: System.out.println("<read>"); break;
            case WRITE: System.out.println("<write>"); break;
            case NEW: System.out.println("<new>"); break;
            case DELETE: System.out.println("<delete>"); break;
            case CALL: System.out.println("<call>"); break;
            case NL: System.out.println("<nl>"); break;
            case TRUE: System.out.println("<true>"); break;
            case FALSE: System.out.println("<false>"); break;
            case NULL: System.out.println("<null>"); break;
            case STRUCT: System.out.println("<struct>"); break;
            case PROC: System.out.println("<proc>"); break;
            case TYPE: System.out.println("<type>"); break;
            case INT: System.out.println("<int>"); break;
            case REAL: System.out.println("<real>"); break;
            case BOOL: System.out.println("<bool>"); break;
            case STRING: System.out.println("<string>"); break;
            case EVAL: System.out.println("@"); break;
            case AND: System.out.println("<and>"); break;
            case OR: System.out.println("<or>"); break;
            case NOT: System.out.println("<not>"); break;
            case IDEN: System.out.println(t.image); break;
            case LIT_ENT: System.out.println(t.image); break;
            case LIT_REAL: System.out.println(t.image); break;
            case LIT_CADENA: System.out.println(t.image); break;
            case EOF: System.out.println("<EOF>"); break;
            default: System.out.println(t.image);
        }
    }

    public ConstructorASTsTinyDJ(Reader r) {
        super(r);
        disable_tracing(); // Deshabilita la traza normal de JavaCC
    }

    @Override
    final protected void trace_token(Token t, String where) {
        imprime(t);
    }
}
