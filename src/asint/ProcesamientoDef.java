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

public class ProcesamientoDef implements Procesamiento {
	public void procesa(Prog n) {}

	public void procesa(Declaraciones_Con_Separador n){}

	public void procesa(Sin_Declaraciones n){}

	public void procesa(Una_dec n){}

	public void procesa(Muchas_decs n){}

	public void procesa(DecTipo n){}

	public void procesa(DecType n){}

	public void procesa(DecProc n){}

	public void procesa(TipoArray n){}

	public void procesa(TipoPuntero n){}

	public void procesa(TipoInt n){}

	public void procesa(TipoReal n){}

	public void procesa(TipoBool n){}

	public void procesa(TipoString n){}

	public void procesa(TipoStruct n){}

	public void procesa(TipoIden n){}

	public void procesa(Un_campo n){}

	public void procesa(Muchos_campos n){}

	public void procesa(ConParametros n){}

	public void procesa(SinParametros n){}

	public void procesa(Un_param n){}

	public void procesa(Muchos_param n){}

	public void procesa(Lista_Instrucciones n){}

	public void procesa(Sin_Instrucciones n){}

	public void procesa(InstruccionEval n){}

	public void procesa(InstruccionIf n){}

	public void procesa(InstruccionWhile n){}

	public void procesa(InstruccionRead n){}

	public void procesa(InstruccionWrite n){}

	public void procesa(InstruccionNl n){}

	public void procesa(InstruccionNew n){}

	public void procesa(InstruccionDelete n){}

	public void procesa(InstruccionCall n){}

	public void procesa(InstruccionPrograma n){}

	public void procesa(ElseOptElse n){}

	public void procesa(ElseOptVacio n){}

	public void procesa(ConArgumentos n){}

	public void procesa(SinArgumentos n){}

	public void procesa(Un_arg n){}

	public void procesa(Muchos_arg n){}

	public void procesa(ExpAsignacion n){}

	public void procesa(ExpRelMenor n){}

	public void procesa(ExpRelMayor n){}

	public void procesa(ExpRelMenorIgual n){}

	public void procesa(ExpRelMayorIgual n){}

	public void procesa(ExpRelIgualIgual n){}

	public void procesa(ExpRelDistinto n){}

	public void procesa(ExpAdicSuma n){}

	public void procesa(ExpAdicResta n){}

	public void procesa(ExpLogAnd n){}

	public void procesa(ExpLogOr n){}

	public void procesa(ExpMul n){}

	public void procesa(ExpDiv n){}

	public void procesa(ExpMod n){}

	public void procesa(ExpUnariaMenos n){}

	public void procesa(ExpUnariaNot n){}

	public void procesa(ExpAccesoArray n){}

	public void procesa(ExpAccesoPunto n){}

	public void procesa(ExpAccesoPuntero n){}

	public void procesa(FactorLitEnt n){}

	public void procesa(FactorLitReal n){}

	public void procesa(FactorLitBool n){}

	public void procesa(FactorLitCadena n){}

	public void procesa(FactorIdentificador n){}

	public void procesa(FactorNull n){}

	public void procesa(ParametroValor parametroValor){}

	public void procesa(ParametroReferencia parametroReferencia){}

	public void procesa(Muchas_instrucciones muchas_instrucciones){}

	public void procesa(Una_instruccion una_instruccion){}
}
