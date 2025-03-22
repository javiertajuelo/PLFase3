package c_ast_ascendente;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import c_ast_ascendente.GestionErroresEval.ErrorLexico;
import c_ast_ascendente.GestionErroresEval.ErrorSintactico;

public class Main {
   public static void main(String[] args) throws Exception {
    Reader input = new InputStreamReader(new FileInputStream("sample1a.in"));
    AnalizadorLexicoEval alex = new AnalizadorLexicoEval(input);
	AnalizadorSintacticoEval asint = new AnalizadorSintacticoEvalDJ(alex);
	 //asint.setScanner(alex);
	 try {    
		 System.out.println(asint.debug_parse());
     }
     catch(ErrorLexico e) {
        System.out.println("ERROR_LEXICO"); 
        
     }
     catch(ErrorSintactico e) {
        System.out.println("ERROR_SINTACTICO"); 
    	System.out.println(e.getMessage());
     }catch(ClassCastException e) {}
 }
}   
   