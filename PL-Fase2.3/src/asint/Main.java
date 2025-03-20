package asint;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoEval;
import errors.GestionErroresEval.ErrorLexico;
import errors.GestionErroresEval.ErrorSintactico;

public class Main {
   public static void main(String[] args) throws Exception {
	   Reader input = new InputStreamReader(new FileInputStream("sample3.in"));
	     AnalizadorLexicoEval alex = new AnalizadorLexicoEval(input);
	     AnalizadorSintacticoEval asint = new AnalizadorSintacticoEvalDJ(alex);
		 //asint.setScanner(alex);
	     try {    
	         asint.debug_parse();
	     }
	     catch(ErrorLexico e) {
	        System.out.println("ERROR_LEXICO"); 
	     }
	     catch(ErrorSintactico e) {
	        System.out.println("ERROR_SINTACTICO"); 
	     }catch(ClassCastException e) {}
 }
}   
   
