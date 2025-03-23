package c_ast_ascendente;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import Impresiones.Imp_recursiva;
import asint.SintaxisAbstractaEval.Prog;
import c_ast_ascendente.GestionErroresEval.ErrorLexico;
import c_ast_ascendente.GestionErroresEval.ErrorSintactico;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;

public class Main {
   public static void main(String[] args) throws Exception {
	ComplexSymbolFactory csf = new ComplexSymbolFactory();
    Reader input = new InputStreamReader(new FileInputStream("sample1a.in"));
    AnalizadorLexicoEval alex = new AnalizadorLexicoEval(input);
	AnalizadorSintacticoEval asint = new AnalizadorSintacticoEvalDJ(alex,csf);
	System.out.println("IMPRESION RECURSIVA"); 
 	  Prog prog = (Prog)asint.parse().value;
 	  new Imp_recursiva().evalua(prog);
	 //asint.setScanner(alex);
	  try {
	         Object result = asint.debug_parse();
	         if (result instanceof Symbol) {
	             Symbol sym = (Symbol) result;
	             System.out.println(sym.value);
	         } else {
	             System.out.println(result);
	         }
	         
	      }
     catch(ErrorLexico e) {
        System.out.println("ERROR_LEXICO"); 
        
     }
     catch(ErrorSintactico e) {
        System.out.println("ERROR_SINTACTICO"); 
    	//System.out.println(e.getMessage());
     }catch(ClassCastException e) {}
	  
	  
 }
}   
   