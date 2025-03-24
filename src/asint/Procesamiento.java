package asint;

import asint.SintaxisAbstractaEval.ConArgumentos;
import asint.SintaxisAbstractaEval.ConParametros;
import asint.SintaxisAbstractaEval.DecProc;
import asint.SintaxisAbstractaEval.DecTipo;
import asint.SintaxisAbstractaEval.DecType;
import asint.SintaxisAbstractaEval.Declaraciones_Con_Separador;
import asint.SintaxisAbstractaEval.ElseOptElse;
import asint.SintaxisAbstractaEval.ElseOptVacio;
import asint.SintaxisAbstractaEval.ExpAccesoArray;
import asint.SintaxisAbstractaEval.ExpAccesoPuntero;
import asint.SintaxisAbstractaEval.ExpAccesoPunto;
import asint.SintaxisAbstractaEval.ExpAdicResta;
import asint.SintaxisAbstractaEval.ExpAdicSuma;
import asint.SintaxisAbstractaEval.ExpAsignacion;
import asint.SintaxisAbstractaEval.ExpDiv;
import asint.SintaxisAbstractaEval.ExpLogAnd;
import asint.SintaxisAbstractaEval.ExpLogOr;
import asint.SintaxisAbstractaEval.ExpMod;
import asint.SintaxisAbstractaEval.ExpMul;
import asint.SintaxisAbstractaEval.ExpRelDistinto;
import asint.SintaxisAbstractaEval.ExpRelIgualIgual;
import asint.SintaxisAbstractaEval.ExpRelMayor;
import asint.SintaxisAbstractaEval.ExpRelMayorIgual;
import asint.SintaxisAbstractaEval.ExpRelMenor;
import asint.SintaxisAbstractaEval.ExpRelMenorIgual;
import asint.SintaxisAbstractaEval.ExpUnariaMenos;
import asint.SintaxisAbstractaEval.ExpUnariaNot;
import asint.SintaxisAbstractaEval.FactorIdentificador;
import asint.SintaxisAbstractaEval.FactorLitBool;
import asint.SintaxisAbstractaEval.FactorLitCadena;
import asint.SintaxisAbstractaEval.FactorLitEnt;
import asint.SintaxisAbstractaEval.FactorLitReal;
import asint.SintaxisAbstractaEval.FactorNull;
import asint.SintaxisAbstractaEval.InstruccionCall;
import asint.SintaxisAbstractaEval.InstruccionDelete;
import asint.SintaxisAbstractaEval.InstruccionEval;
import asint.SintaxisAbstractaEval.InstruccionIf;
import asint.SintaxisAbstractaEval.InstruccionNew;
import asint.SintaxisAbstractaEval.InstruccionNl;
import asint.SintaxisAbstractaEval.InstruccionPrograma;
import asint.SintaxisAbstractaEval.InstruccionRead;
import asint.SintaxisAbstractaEval.InstruccionWhile;
import asint.SintaxisAbstractaEval.InstruccionWrite;
import asint.SintaxisAbstractaEval.Lista_Instrucciones;
import asint.SintaxisAbstractaEval.Muchas_decs;
import asint.SintaxisAbstractaEval.Muchas_instrucciones;
import asint.SintaxisAbstractaEval.Muchos_arg;
import asint.SintaxisAbstractaEval.Muchos_campos;
import asint.SintaxisAbstractaEval.Muchos_param;
import asint.SintaxisAbstractaEval.ParametroReferencia;
import asint.SintaxisAbstractaEval.ParametroValor;
import asint.SintaxisAbstractaEval.Prog;
import asint.SintaxisAbstractaEval.SinArgumentos;
import asint.SintaxisAbstractaEval.SinParametros;
import asint.SintaxisAbstractaEval.Sin_Declaraciones;
import asint.SintaxisAbstractaEval.Sin_Instrucciones;
import asint.SintaxisAbstractaEval.TipoArray;
import asint.SintaxisAbstractaEval.TipoBool;
import asint.SintaxisAbstractaEval.TipoIden;
import asint.SintaxisAbstractaEval.TipoInt;
import asint.SintaxisAbstractaEval.TipoPuntero;
import asint.SintaxisAbstractaEval.TipoReal;
import asint.SintaxisAbstractaEval.TipoString;
import asint.SintaxisAbstractaEval.TipoStruct;
import asint.SintaxisAbstractaEval.Un_arg;
import asint.SintaxisAbstractaEval.Un_campo;
import asint.SintaxisAbstractaEval.Un_param;
import asint.SintaxisAbstractaEval.Una_dec;
import asint.SintaxisAbstractaEval.Una_instruccion;

public interface Procesamiento {

	void procesa(Prog n);

	void procesa(Declaraciones_Con_Separador n);

	void procesa(Sin_Declaraciones n);

	void procesa(Una_dec n);

	void procesa(Muchas_decs n);

	void procesa(DecTipo n);

	void procesa(DecType n);

	void procesa(DecProc n);

	void procesa(TipoArray n);

	void procesa(TipoPuntero n);

	void procesa(TipoInt n);

	void procesa(TipoReal n);

	void procesa(TipoBool n);

	void procesa(TipoString n);

	void procesa(TipoStruct n);

	void procesa(TipoIden n);

	void procesa(Un_campo n);

	void procesa(Muchos_campos n);

	void procesa(ConParametros n);

	void procesa(SinParametros n);

	void procesa(Un_param n);

	void procesa(Muchos_param n);

	void procesa(Lista_Instrucciones n);

	void procesa(Sin_Instrucciones n);

	void procesa(InstruccionEval n);

	void procesa(InstruccionIf n);

	void procesa(InstruccionWhile n);

	void procesa(InstruccionRead n);

	void procesa(InstruccionWrite n);

	void procesa(InstruccionNl n);

	void procesa(InstruccionNew n);

	void procesa(InstruccionDelete n);

	void procesa(InstruccionCall n);

	void procesa(InstruccionPrograma n);

	void procesa(ElseOptElse n);

	void procesa(ElseOptVacio n);

	void procesa(ConArgumentos n);

	void procesa(SinArgumentos n);

	void procesa(Un_arg n);

	void procesa(Muchos_arg n);

	void procesa(ExpAsignacion n);

	void procesa(ExpRelMenor n);

	void procesa(ExpRelMayor n);

	void procesa(ExpRelMenorIgual n);

	void procesa(ExpRelMayorIgual n);

	void procesa(ExpRelIgualIgual n);

	void procesa(ExpRelDistinto n);

	void procesa(ExpAdicSuma n);

	void procesa(ExpAdicResta n);

	void procesa(ExpLogAnd n);

	void procesa(ExpLogOr n);

	void procesa(ExpMul n);

	void procesa(ExpDiv n);

	void procesa(ExpMod n);

	void procesa(ExpUnariaMenos n);

	void procesa(ExpUnariaNot n);

	void procesa(ExpAccesoArray n);

	void procesa(ExpAccesoPunto n);

	void procesa(ExpAccesoPuntero n);

	void procesa(FactorLitEnt n);

	void procesa(FactorLitReal n);

	void procesa(FactorLitBool n);

	void procesa(FactorLitCadena n);

	void procesa(FactorIdentificador n);

	void procesa(FactorNull n);

	void procesa(ParametroValor parametroValor);

	void procesa(ParametroReferencia parametroReferencia);

	void procesa(Muchas_instrucciones muchas_instrucciones);

	void procesa(Una_instruccion una_instruccion);

}
