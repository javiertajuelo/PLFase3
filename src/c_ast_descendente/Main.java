package c_ast_descendente;
import java.io.FileReader;

import Impresiones.Imp_recursiva;

public class Main{
   public static void main(String[] args) throws Exception {
      ConstructorASTsTiny asint = new ConstructorASTsTinyDJ(new FileReader("sample5d.in"));
      asint.disable_tracing();
      try {
          new Imp_recursiva().evalua(asint.analiza());
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