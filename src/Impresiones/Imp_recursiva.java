package Impresiones;

import java.util.HashMap;
import java.util.Map;

import asint.SintaxisAbstractaEval;
import asint.SintaxisAbstractaEval.*;

public class Imp_recursiva extends SintaxisAbstractaEval {
	
	public class ECteNoDefinida extends RuntimeException {
        public ECteNoDefinida(String msg) {
            super(msg);
        }
    }
    public class ECteDuplicada extends RuntimeException {
        public ECteDuplicada(String msg) {
            super(msg);
        }
    }
    private Map<String,Float> env;
    
    public Imp_recursiva() {
        this.env = new HashMap<>();
    }
    
    public void evalua(Prog n) {
    	System.out.println("{");
    	evalDecs(n.dcs());
    	evalInst(n.inst());
    	System.out.println("}");
    }
    
    private void evalDecs(DeclaracionesConSep d) {
    	if(claseDe(d, Declaraciones_Con_Separador.class)) {
    		evalDecs(d.ldecs());
    		System.out.println("&&");
    	}
    }
    
    private void evalDecs(LDecs d) {
    	if(claseDe(d, Muchas_decs.class)) {
    		evalDecs(d.ldecs());
    		System.out.println(";");
    	}
    	evalDecs(d.dec());
    }
    
    private void evalDecs(Declaracion d) {
    	
    	if(claseDe(d, DecTipo.class)) {
    		evalTipo(d.tipo());
    		System.out.println(d.iden() + "$f:"+d.leeFila()+",c:"+d.leeCol()+"$");
    	}
    	else if(claseDe(d, DecType.class)) {
    		System.out.println("<type>");
    		evalTipo(d.tipo());
    		System.out.println(d.iden() + "$f:"+d.leeFila()+",c:"+d.leeCol()+"$");
    	}
    	else if(claseDe(d, DecProc.class)) {
    		System.out.println("<proc>");
    		System.out.println(d.iden() + "$f:"+d.leeFila()+",c:"+d.leeCol()+"$");
    		evalParams(d.params());		
    		evalua(d.cuerpo());
    	}
    }
   
    
    private void evalTipo(Tipo t) {
    	if(claseDe(t, TipoArray.class)) {
    		evalTipo(t.tipo());
    		System.out.println("[");
    		System.out.println(t.size());
    		System.out.println("]$f:"+t.leeFila()+",c:"+t.leeCol()+"$");
    	}
    	else if (claseDe(t, TipoPuntero.class)) {
    		System.out.println("^");
    		evalTipo(t.tipo());
    	}
    	else if(claseDe(t, TipoInt.class)) {
    		System.out.println("<int>");
    	}
    	else if(claseDe(t, TipoReal.class)) {
    		System.out.println("<real>");
    	}
    	else if(claseDe(t, TipoBool.class)) {
    		System.out.println("<bool>");
    	}
    	else if(claseDe(t, TipoString.class)) {
    		System.out.println("<string>");
    	}
    	else if(claseDe(t, TipoStruct.class)) {
    		System.out.println("<struct>");
    		System.out.println("{");
    		evalCampos(t.campos());
    		System.out.println("}");
    	}
    	else if(claseDe(t, TipoIden.class)) {
    		System.out.println(t.iden()+"$f:"+t.leeFila()+",c:"+t.leeCol()+"$");
    	}
    	else if(claseDe(t, ParametroValor.class)) {
    		evalTipo(t.tipo());
    		System.out.println(t.iden()+"$f:"+t.leeFila()+",c:"+t.leeCol()+"$");
    	}
    	else if(claseDe(t, ParametroReferencia.class)) {
    		System.out.println("&");
    		evalTipo(t.tipo());
    		System.out.println(t.iden());
    	}
    }
    
    private void evalParams(Params p) {
    	System.out.println("(");
    	if(claseDe(p, ConParametros.class)) {
    		evalParams(p.lparam());
    	}
    	System.out.println(")");
    }
    
    private void evalParams(LParam p) {
    	if(claseDe(p, Muchos_param.class)) {
    		evalParams(p.lparam());
    		System.out.println(",");
    	}
    	evalTipo(p.tipo());
    }
    
    private void evalCampos(Cmps c) {
    	if(claseDe(c, Muchos_campos.class)) {
    		evalCampos(c.campos());
    		
    		System.out.println(",");
    	}
    	evalDecs(c.dec());
    }
    
    private void evalInst(Insts i) {
    	if(claseDe(i, Lista_Instrucciones.class)) {
    		evalInst(i.insts());
    	}
    }
    
    private void evalInst(LIns i) {
    	if(claseDe(i, Muchas_instrucciones.class)) {
    		evalInst(i.insts());
    		System.out.println(";");
    	}
    	evalInst(i.inst());
    }
    
    private void evalInst(Instruccion i) {
    	if(claseDe(i, InstruccionEval.class)) {
    		System.out.println("@");
    		evalExp(i.exp());
    	}
    	else if (claseDe(i, InstruccionIf.class)) {
    		System.out.println("<if>");
    		evalExp(i.exp());
    		evalua(i.prog());
    		evalElse(i.elseOpt());
    	}
    	else if (claseDe(i, InstruccionWhile.class)) {
    		System.out.println("<while>");
    		evalExp(i.exp());
    		evalua(i.prog());
    	}
    	else if (claseDe(i, InstruccionRead.class)) {
    		System.out.println("<read>");
    		evalExp(i.exp());
    	}
    	else if (claseDe(i, InstruccionWrite.class)) {
    		System.out.println("<write>");
    		evalExp(i.exp());
    	}
    	else if (claseDe(i, InstruccionNl.class)) {
    		System.out.println("<nl>");
    	}
    	else if (claseDe(i, InstruccionNew.class)) {
    		System.out.println("<new>");
    		evalExp(i.exp());
    	}
    	else if (claseDe(i, InstruccionDelete.class)) {
    		System.out.println("<delete>");
    		evalExp(i.exp());
    	}
    	else if (claseDe(i, InstruccionCall.class)) {
    		System.out.println("<call>");
    		System.out.println(i.iden()+ "$f:" + i.leeFila() + ",c:"+i.leeCol()+"$");
    		evalArgs(i.args());
    	}
    	else if (claseDe(i, InstruccionPrograma.class)) {
    		evalua(i.prog());
    	}
    }
    
    private void evalElse(Else e){
    	if(claseDe(e, ElseOptElse.class)) {
    		System.out.println("<else>");
    		evalua(e.prog());
    	}
    }
    
    private void evalArgs(Argus a) {
    	System.out.println("(");
    	if(claseDe(a, ConArgumentos.class)) {	
    		evalArgs(a.args());	
    	}
    	System.out.println(")");
    }
    private void evalArgs(LArgs a) {
    	if(claseDe(a, Muchos_arg.class)) {
    		evalArgs(a.args());
    		System.out.println(",");
    	}
    	evalExp(a.exp());
    }
    
    private void evalExp(Expresion e) {
    	if(claseDe(e, ExpAsignacion.class)) {
    		evalExp(e.Opn0());
    		System.out.println("=$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpRelMenor.class)) {
    		evalExp(e.Opn0());
    		System.out.println("<$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpRelMayor.class)) {
    		evalExp(e.Opn0());
    		System.out.println(">$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpRelMenorIgual.class)) {
    		evalExp(e.Opn0());
    		System.out.println("<=$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpRelMayorIgual.class)) {
    		evalExp(e.Opn0());
    		System.out.println(">=$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpRelIgualIgual.class)) {
    		evalExp(e.Opn0());
    		System.out.println("==$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpRelDistinto.class)) {
    		evalExp(e.Opn0());
    		System.out.println("!=$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpAdicSuma.class)) {
    		evalExp(e.Opn0());
    		System.out.println("+$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpAdicResta.class)) {
    		evalExp(e.Opn0());
    		System.out.println("-$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    		
    	}
    	else if (claseDe(e, ExpLogAnd.class)) {
    		evalExp(e.Opn0());
    		System.out.println("<and>$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpLogOr.class)) {
    		evalExp(e.Opn0());
    		System.out.println("<or>$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpMul.class)) {
    		evalExp(e.Opn0());
    		System.out.println("*$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    		
    	}else if (claseDe(e, ExpDiv.class)) {
    		evalExp(e.Opn0());
    		System.out.println("/$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpMod.class)) {
    		evalExp(e.Opn0());
    		System.out.println("%$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    	}
    	else if (claseDe(e, ExpUnariaMenos.class)) {
    		System.out.println("-$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn0());
    	}
    	else if (claseDe(e, ExpUnariaNot.class)) {
    		System.out.println("<not>$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn0());
    	}
    	else if (claseDe(e, ExpAccesoArray.class)) {
    		evalExp(e.Opn0());
    		System.out.println("[$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		evalExp(e.Opn1());
    		System.out.println("]");
    	}
    	else if (claseDe(e, ExpAccesoPunto.class)) {
    		evalExp(e.Opn0());
    		System.out.println(".");
    		System.out.println(e.campo()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    	}
    	else if (claseDe(e, ExpAccesoPuntero.class)) {
    		evalExp(e.Opn0());
    		System.out.println("^$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    		
    	}
    	else if (claseDe(e, FactorLitEnt.class)) {
    		System.out.println(e.lit()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    	}
    	else if (claseDe(e, FactorLitReal.class)) {
    		System.out.println(e.lit()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    	}
    	else if (claseDe(e, FactorLitBool.class)) {
    		System.out.println(e.lit()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    	}
    	else if (claseDe(e, FactorLitCadena.class)) {
    		System.out.println(e.lit()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    	}
    	else if (claseDe(e, FactorIdentificador.class)) {
    		System.out.println(e.lit()+"$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    	}
    	else if (claseDe(e, FactorNull.class)) {
    		System.out.println("<null>$f:" + e.leeFila() + ",c:"+e.leeCol()+"$");
    	}
    }

    private boolean claseDe(Object o, Class c) {
        return o.getClass() == c;
    }
}
