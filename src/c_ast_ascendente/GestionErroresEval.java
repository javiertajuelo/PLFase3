package c_ast_ascendente;


public class GestionErroresEval {
   public class ErrorLexico extends RuntimeException {
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorLexico(String msg) {
           super(msg);
       }
   } 
   public class ErrorSintactico extends RuntimeException {
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorSintactico(String msg) {
           super(msg);
       }
   } 
   public void errorLexico(int fila, int columna, String lexema) {
     throw new ErrorLexico("ERROR_LEXICO"); 
   }  
   public void errorSintactico(UnidadLexica unidadLexica) {
	 throw new ErrorSintactico("ERROR_LEXICO");
	}
}
