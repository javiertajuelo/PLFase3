package c_ast_descendente;
import java.io.FileReader;

public class Main{
   public static void main(String[] args) throws Exception {
      ConstructorASTsTiny asint = new ConstructorASTsTinyDJ(new FileReader("sample1d.in"));
      asint.disable_tracing();
      try {
          System.out.println(asint.analiza());
      }catch(TokenMgrError e) {
     	 System.out.println("ERROR_LEXICO");
     	 //System.out.println(e.getMessage());

      }catch(ParseException e) {
     	 System.out.println("ERROR_SINTACTICO");
     	 //System.out.println(e.getMessage());

      }	
   }
}