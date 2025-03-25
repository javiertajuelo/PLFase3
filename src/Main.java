import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

import Impresiones.Imp_Visitante;
import Impresiones.Imp_recursiva;
import asint.SintaxisAbstractaEval.Prog;
import c_ast_ascendente.AnalizadorLexicoEval;
import c_ast_ascendente.AnalizadorSintacticoEval;
import c_ast_ascendente.AnalizadorSintacticoEvalDJ;
import c_ast_ascendente.GestionErroresEval.ErrorLexico;
import c_ast_ascendente.GestionErroresEval.ErrorSintactico;
import c_ast_descendente.ConstructorASTsTiny;
import c_ast_descendente.ConstructorASTsTinyDJ;
import c_ast_descendente.ParseException;
import c_ast_descendente.TokenMgrError;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Reader input = new InputStreamReader(new FileInputStream("sample1a.in"));
		char mode = (char) input.read();
		System.out.println("char: "+mode);
		
		if (mode == 'a') {
			System.out.println("CONSTRUCCION AST ASCENDENTE");
		
			ComplexSymbolFactory csf = new ComplexSymbolFactory();
			AnalizadorLexicoEval alex = new AnalizadorLexicoEval(input);
			AnalizadorSintacticoEval asint = new AnalizadorSintacticoEvalDJ(alex, csf);
			
			// asint.setScanner(alex);
			try {
				Object result = asint.debug_parse();
				if (result instanceof Symbol) {
					Symbol sym = (Symbol) result;
					System.out.println(sym.value);
				} else {
					System.out.println(result);
				}

			} catch (ErrorLexico e) {
				System.out.println("ERROR_LEXICO");

			} catch (ErrorSintactico e) {
				System.out.println("ERROR_SINTACTICO");
				// System.out.println(e.getMessage());
			} catch (ClassCastException e) {
			}
			
			System.out.println("IMPRESION RECURSIVA");
			Prog prog = (Prog) asint.parse().value;
			new Imp_recursiva().evalua(prog);
			System.out.println("IMPRESION INTERPRETE");
			prog.imprime();
			System.out.println("IMPRESION VISITANTE");
			prog.procesa(new Imp_Visitante());
			
		} else {
			System.out.println("CONSTRUCCION AST DESCENDENTE");
			ConstructorASTsTiny asint = new ConstructorASTsTinyDJ(new FileReader("sample1d.in"));
			asint.disable_tracing();
			asint.analiza().procesa(new Imp_Visitante());

			new Imp_recursiva().evalua(asint.analiza());
			try {
				System.out.println(asint.analiza());
			} catch (TokenMgrError e) {
				System.out.println("ERROR_LEXICO");
				// System.out.println(e.getMessage());

			} catch (ParseException e) {
				System.out.println("ERROR_SINTACTICO");
				// System.out.println(e.getMessage());

			}
			
			System.out.println("IMPRESION RECURSIVA");
			new Imp_recursiva().evalua(asint.analiza());
			System.out.println("IMPRESION INTERPRETE");
			asint.analiza().imprime();
			System.out.println("IMPRESION VISITANTE");
			asint.analiza().procesa(new Imp_Visitante());
		}

	}

}
