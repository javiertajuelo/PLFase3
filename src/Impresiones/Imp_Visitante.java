package Impresiones;

import asint.ProcesamientoDef;
import asint.SintaxisAbstractaEval.*;

public class Imp_Visitante extends ProcesamientoDef{
	
	private void imprimeOpnd(Expresion opnd, int np) {
        if(opnd.prioridad() < np) {System.out.println("(");};
        opnd.procesa(this);
        if(opnd.prioridad() < np) {System.out.println(")");};        
    }
    private void imprimeExpBin(Expresion opnd0, String op, Expresion opnd1, int np0, int np1, int f, int c) {
        imprimeOpnd(opnd0,np0);
        System.out.println(op+"$f:" + f + ",c:"+c+"$");
        imprimeOpnd(opnd1,np1);
    }
	
	public void procesa(Prog p) {
		System.out.println("{");
    	p.dcs().procesa(this);
    	p.inst().procesa(this);
    	System.out.println("}");
	}
	
	public void procesa(Declaraciones_Con_Separador d) {
		d.ldecs().procesa(this);
		System.out.println("&&");
	}
	
	public void procesa(Muchas_decs d) {
		d.ldecs().procesa(this);
		System.out.println(";");
		d.dec().procesa(this);
	}
	
	public void procesa(Una_dec d) {
		d.dec().procesa(this);
	}
	
	public void procesa(DecTipo d) {
		d.tipo().procesa(this);
		System.out.println(d.iden() + "$f:"+d.leeFila()+",c:"+d.leeCol()+"$");
	}
	
	public void procesa(DecType d) {
		System.out.println("<type>");
		d.tipo().procesa(this);
		System.out.println(d.iden() + "$f:"+d.leeFila()+",c:"+d.leeCol()+"$");
	}
	
	public void procesa(DecProc d) {
		System.out.println("<proc>");
		System.out.println(d.iden() + "$f:"+d.leeFila()+",c:"+d.leeCol()+"$");
		d.params().procesa(this);		
		d.cuerpo().procesa(this);
	}
	
	public void procesa(TipoArray t) {
		t.tipo().procesa(this);
		System.out.println("[");
		System.out.println(t.size());
		System.out.println("]$f:"+t.leeFila()+",c:"+t.leeCol()+"$");
	}
	
	public void procesa(TipoPuntero t) {
		System.out.println("^");
		t.tipo().procesa(this);
	}
	
	public void procesa(TipoInt t) {
		System.out.println("<int>");
	}
	
	public void procesa(TipoReal t) {
		System.out.println("<real>");
	}
	
	public void procesa(TipoBool t) {
		System.out.println("<bool>");
	}
	
	public void procesa(TipoString t) {
		System.out.println("<string>");
	}
	
	public void procesa(TipoStruct t) {
		System.out.println("<struct>");
		System.out.println("{");
		t.campos().procesa(this);
		System.out.println("}");
	}
	
	public void procesa(TipoIden t) {
		System.out.println(t.iden()+"$f:"+t.leeFila()+",c:"+t.leeCol()+"$");
	}
	
	public void procesa(Muchos_campos c) {
		c.campos().procesa(this);
		System.out.println(",");
		c.dec().procesa(this);
	}
	
	public void procesa(Un_campo c) {
		c.dec().procesa(this);
	}
	
	public void procesa(ParametroValor t) {
		t.tipo().procesa(this);
		System.out.println(t.iden()+"$f:"+t.leeFila()+",c:"+t.leeCol()+"$");
	}
	
	public void procesa(ParametroReferencia t) {
		t.tipo().procesa(this);
		System.out.println("&");
		System.out.println(t.iden()+"$f:"+t.leeFila()+",c:"+t.leeCol()+"$");
	}
	
	public void procesa(ConParametros p) {
		System.out.println("(");
		p.lparam().procesa(this);
		System.out.println(")");
	}
	
	public void procesa(SinParametros p) {
		System.out.println("(");
		System.out.println(")");
	}
	
	public void procesa(Muchos_param p) {
		p.lparam().procesa(this);
		System.out.println(",");
		p.tipo().procesa(this);
	}
	
	public void procesa(Un_param p) {
		p.tipo().procesa(this);
	}
	
	public void procesa(Lista_Instrucciones i) {
		i.insts().procesa(this);
	}
	
	public void procesa(Muchas_instrucciones i) {
		i.insts().procesa(this);
		System.out.println(";");
		i.inst().procesa(this);
	}
	
	public void procesa(Una_instruccion i) {
		i.inst().procesa(this);
	}
	
	public void procesa(InstruccionEval i) {
		System.out.println("@");
		i.exp().procesa(this);
	}
	
	public void procesa(InstruccionIf i) {
		System.out.println("<if>");
		i.exp().procesa(this);
		i.prog().procesa(this);
		i.elseOpt().procesa(this);
	}
	
	public void procesa(InstruccionWhile i) {
		System.out.println("<while>");
		i.exp().procesa(this);
		i.prog().procesa(this);
	}
	
	public void procesa(InstruccionRead i) {
		System.out.println("<read>");
		i.exp().procesa(this);
	}
	
	public void procesa(InstruccionWrite i) {
		System.out.println("<write>");
		i.exp().procesa(this);
	}
	
	public void procesa(InstruccionNl i) {
		System.out.println("<nl>");
	}
	
	public void procesa(InstruccionNew i) {
		System.out.println("<new>");
		i.exp().procesa(this);
	}
	
	public void procesa(InstruccionDelete i) {
		System.out.println("<delete>");
		i.exp().procesa(this);
	}
	
	public void procesa(InstruccionCall i) {
		System.out.println("<call>");
		System.out.println(i.iden()+ "$f:" + i.leeFila() + ",c:"+i.leeCol()+"$");
		i.args().procesa(this);
	}
	
	public void procesa(InstruccionPrograma i) {
		i.prog().procesa(this);
	}
	
	public void procesa(ElseOptElse e) {
		System.out.println("<else>");
		e.prog().procesa(this);
	}
	
	public void procesa(ConArgumentos a) {
		System.out.println("(");
		a.args().procesa(this);
		System.out.println(")");
	}
	
	public void procesa(SinArgumentos a) {
		System.out.println("(");
		System.out.println(")");
	}
	
	public void procesa(Muchos_arg a) {
		a.args().procesa(this);
		System.out.println(",");
		a.exp().procesa(this);
	}
	
	public void procesa(Un_arg a) {
		a.exp().procesa(this);
	}
	
	public void procesa(ExpAsignacion e) {
		imprimeExpBin(e.Opn0(), "=", e.Opn1(),1,0, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpRelMenor e) {
		imprimeExpBin(e.Opn0(), "<", e.Opn1(),1,2, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpRelMayor e) {
		imprimeExpBin(e.Opn0(), ">", e.Opn1(),1,2, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpRelMenorIgual e) {
		imprimeExpBin(e.Opn0(), "<=", e.Opn1(),1,2, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpRelMayorIgual e) {
		imprimeExpBin(e.Opn0(), ">=", e.Opn1(),1,2, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpRelIgualIgual e) {
		imprimeExpBin(e.Opn0(), "==", e.Opn1(),1,2, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpRelDistinto e) {
		imprimeExpBin(e.Opn0(), "!=", e.Opn1(),1,2, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpAdicSuma e) {
		imprimeExpBin(e.Opn0(), "+", e.Opn1(),2,3, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpAdicResta e) {
		imprimeExpBin(e.Opn0(), "-", e.Opn1(),3,3, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpLogAnd e) {
		imprimeExpBin(e.Opn0(), "<and>", e.Opn1(),4,3, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpLogOr e) {
		imprimeExpBin(e.Opn0(), "<or>", e.Opn1(),4,4, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpMul e) {
		imprimeExpBin(e.Opn0(), "*", e.Opn1(),4,5, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpDiv e) {
		imprimeExpBin(e.Opn0(), "/", e.Opn1(),4,5, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpMod e) {
		imprimeExpBin(e.Opn0(), "%", e.Opn1(),4,5, e.leeFila(), e.leeCol());	
	}
	
	public void procesa(ExpUnariaMenos e) {
		System.out.println("-$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
		e.Opn0().procesa(this);
	}
	
	public void procesa(ExpUnariaNot e) {
		System.out.println("<not>$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
		e.Opn0().procesa(this);
	}
	
	public void procesa(ExpAccesoArray e) {
		e.Opn0().procesa(this);
		System.out.println("[$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
		e.Opn1().procesa(this);
		System.out.println("]");
	}
	
	public void procesa(ExpAccesoPunto e) {
		e.Opn0().procesa(this);
		System.out.println(".");
		System.out.println(e.campo()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
	}
	
	public void procesa(ExpAccesoPuntero e) {
		e.Opn0().procesa(this);
		System.out.println("^$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
	}
	
	public void procesa(FactorLitEnt e) {
		System.out.println(e.lit()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
	}
	
	public void procesa(FactorLitReal e) {
		System.out.println(e.lit()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
	}
	
	public void procesa(FactorLitBool e) {
		System.out.println(e.lit()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
	}
	
	public void procesa(FactorLitCadena e) {
		System.out.println(e.lit()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
	}
	
	public void procesa(FactorIdentificador e) {
		System.out.println(e.lit()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
	}
	
	public void procesa(FactorNull e) {
		System.out.println("<null>$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
	}
}
