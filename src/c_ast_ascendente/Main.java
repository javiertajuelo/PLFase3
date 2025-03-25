package c_ast_ascendente;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import Impresiones.Imp_Visitante;
import Impresiones.Imp_recursiva;
import asint.SintaxisAbstractaEval.Prog;
import c_ast_ascendente.GestionErroresEval.ErrorLexico;
import c_ast_ascendente.GestionErroresEval.ErrorSintactico;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;

public class Main {
	public static void main(String[] args) throws Exception {
		ComplexSymbolFactory csf = new ComplexSymbolFactory();
		Reader input = new InputStreamReader(new FileInputStream("sample3a.in"));
		AnalizadorLexicoEval alex = new AnalizadorLexicoEval(input);
		AnalizadorSintacticoEval asint = new AnalizadorSintacticoEvalDJ(alex, csf);
		
		// asint.setScanner(alex);
		try {
			
			Prog prog = (Prog) asint.debug_parse().value;
			System.out.println(prog);
			System.out.println("IMPRESION RECURSIVA");
			new Imp_recursiva().evalua(prog);
			System.out.println("IMPRESION INTERPRETE");
			prog.imprime();
			System.out.println("IMPRESION VISITANTE");
			prog.procesa(new Imp_Visitante());
			
		} catch (ErrorLexico e) {
			System.out.println("ERROR_LEXICO");

		} catch (ErrorSintactico e) {
			System.out.println("ERROR_SINTACTICO");
			// System.out.println(e.getMessage());
		} catch (ClassCastException e) {
		}

	}
}
