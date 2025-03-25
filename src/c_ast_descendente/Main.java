package c_ast_descendente;
import java.io.FileReader;

import Impresiones.Imp_Visitante;
import Impresiones.Imp_recursiva;
import asint.SintaxisAbstractaEval.Prog;

public class Main{
   public static void main(String[] args) throws Exception {
	   
	   System.out.println("CONSTRUCCION AST DESCENDENTE");
		ConstructorASTsTiny asint = new ConstructorASTsTinyDJ(new FileReader("sample5d.in"));
		asint.disable_tracing();

		try {
			Prog p = asint.analiza();
			System.out.print(p);
			System.out.println("IMPRESION RECURSIVA");
			new Imp_recursiva().evalua(p);
			System.out.println("IMPRESION INTERPRETE");
			p.imprime();
			System.out.println("IMPRESION VISITANTE");
			p.procesa(new Imp_Visitante());
			
		} catch (TokenMgrError e) {
			System.out.print("ERROR_LEXICO");
			// System.out.println(e.getMessage());

		} catch (ParseException e) {
			System.out.print("ERROR_SINTACTICO");
			// System.out.println(e.getMessage());

		}
		
		
      }	
   }