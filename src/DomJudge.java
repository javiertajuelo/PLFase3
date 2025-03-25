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

public class DomJudge {

	public static void main(String[] args) throws Exception {

		Reader input = new InputStreamReader(System.in);
		char mode = (char) input.read();

		if (mode == 'a') {
			ComplexSymbolFactory csf = new ComplexSymbolFactory();
			AnalizadorLexicoEval alex = new AnalizadorLexicoEval(input);
			AnalizadorSintacticoEval asint = new AnalizadorSintacticoEvalDJ(alex, csf);

			// asint.setScanner(alex);
			try {
				System.out.println("CONSTRUCCION AST ASCENDENTE");
				Prog prog = (Prog) asint.debug_parse().value;
				System.out.print(prog);
				System.out.println("IMPRESION RECURSIVA");
				new Imp_recursiva().evalua(prog);
				System.out.println("IMPRESION INTERPRETE");
				prog.imprime();
				System.out.println("IMPRESION VISITANTE");
				prog.procesa(new Imp_Visitante());

			} catch (ErrorLexico e) {
				System.out.print("ERROR_LEXICO");

			} catch (ErrorSintactico e) {
				System.out.print("ERROR_SINTACTICO");
				// System.out.println(e.getMessage());
			} catch (ClassCastException e) {
			}

		} else {
			System.out.println("CONSTRUCCION AST DESCENDENTE");
			ConstructorASTsTiny asint = new ConstructorASTsTinyDJ(input);
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

}
