package asint;
import java.util.List;

public class SintaxisAbstractaEval {

    public static abstract class Nodo {
        private int fila, col;
        public Nodo() { fila = col = -1; }
        public Nodo ponFila(int fila) { this.fila = fila; return this; }
        public Nodo ponCol(int col) { this.col = col; return this; }
        public int leeFila() { return fila; }
        public int leeCol() { return col; }
        public abstract <T> T accept(Visitor<T> v);
    }

    public interface Visitor<T> {
        T visit(Prog n);
        T visit(DeclaracionesConSepImpl n);
        T visit(SinDeclaraciones n);
        T visit(Muchas_decs n);
        T visit(Una_dec n);
        T visit(DecTipo n);
        T visit(DecType n);
        T visit(DecProc n);
        T visit(TipoArray n);
        T visit(TipoPuntero n);
        T visit(TipoStruct n);
        T visit(TipoInt n);
        T visit(TipoReal n);
        T visit(TipoBool n);
        T visit(TipoString n);
        T visit(TipoIden n);
        T visit(Un_campo n);
        T visit(Muchos_campos n);
        T visit(SinParametros n);
        T visit(ConParametros n);
        T visit(ParametroValor n);
        T visit(ParametroReferencia n);
        T visit(SinInstrucciones n);
        T visit(ConInstrucciones n);
        T visit(Una_inst n);
        T visit(Muchas_inst n);
        T visit(InstruccionIf n);
        T visit(InstruccionWhile n);
        T visit(InstruccionCall n);
        T visit(InstruccionPrograma n);
        T visit(InstruccionEval n);
        T visit(InstruccionRead n);
        T visit(InstruccionWrite n);
        T visit(InstruccionNl n);
        T visit(InstruccionNew n);
        T visit(InstruccionDelete n);
        T visit(ElseOptElse n);
        T visit(ElseOptVacio n);
        T visit(SinArgumentos n);
        T visit(ConArgumentos n);
        T visit(Muchos_arg  n);
        T visit(Un_arg  n);
        T visit(ExpAsignacion n);
        T visit(ExpRelMenor n);
        T visit(ExpRelMayor n);
        T visit(ExpRelMenorIgual n);
        T visit(ExpRelMayorIgual n);
        T visit(ExpRelIgualIgual n);
        T visit(ExpRelDistinto n);
        T visit(ExpAdicSuma n);
        T visit(ExpAdicResta n);
        T visit(ExpLogAnd n);
        T visit(ExpLogOr n);
        T visit(ExpMul n);
        T visit(ExpDiv n);
        T visit(ExpMod n);
        T visit(ExpUnariaMenos n);
        T visit(ExpUnariaNot n);
        T visit(ExpAccesoArray n);
        T visit(ExpAccesoPunto n);
        T visit(ExpAccesoPuntero n);
        T visit(FactorLitEnt n);
        T visit(FactorLitReal n);
        T visit(FactorLitBool n);
        T visit(FactorLitCadena n);
        T visit(FactorIdentificador n);
        T visit(FactorNull n);
    }

   
    public static class Prog extends Nodo {
        public DeclaracionesConSep decs;
        public ListaInstrucciones insts;
        public Prog(DeclaracionesConSep decs, ListaInstrucciones insts) {
        	super();
            this.decs = decs;
            this.insts = insts;
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "prog(" + decs + ", " + insts + ")"; }
    }
    
    public static abstract class DeclaracionesConSep extends Nodo {
    	public DeclaracionesConSep() {
    		
    	}
    }
    
    public static class DeclaracionesConSepImpl extends DeclaracionesConSep {
        public LDecs decs;
        public DeclaracionesConSepImpl(LDecs decs) {  
        	super();
        	this.decs = decs; 
		}
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "decs(" + decs + ")"; }
    }
    
    public static class SinDeclaraciones extends DeclaracionesConSep {
        public SinDeclaraciones() {
        	super();
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "sin_decs()"; }
    }
    
    
    public static abstract class LDecs extends Nodo {
    	public LDecs() {
    		super();
    	}
    }
    
    public static class Una_dec extends LDecs {
        public Declaracion dec;
        public Una_dec(Declaracion dec) {
        super();
        this.dec = dec; 
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "una_dec(" + dec + ")"; }
    }
    
    public static class Muchas_decs extends LDecs {
        public LDecs decs;
        public Declaracion dec;
        public Muchas_decs(LDecs decs, Declaracion dec) { 
        	super();
        	this.decs = decs; 
        	this.dec = dec; 
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "muchas_decs(" + decs + ", " + dec + ")"; }
    }
    
   
    public static abstract class Declaracion extends Nodo { }
    
    public static class DecTipo extends Declaracion {
        public Tipo tipo;
        public String id;
        public DecTipo(Tipo tipo, String id) {super();this.tipo = tipo; this.id = id; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "dec_tipo(" + tipo + ", " + id + ")"; }
    }
    
    public static class DecType extends Declaracion {
        public Tipo tipo;
        public String id;
        public DecType(Tipo tipo, String id) {
        super();
        this.tipo = tipo; this.id = id; 
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "dec_type(" + tipo + ", " + id + ")"; }
    }
    
    public static class DecProc extends Declaracion {
        public String id;
        public ListaParametros params;
        public Prog cuerpo;
        public DecProc(String id, ListaParametros params, Prog cuerpo) {
        	super();
            this.id = id;
            this.params = params;
            this.cuerpo = cuerpo;
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "dec_proc(" + id + ", " + params + ", " + cuerpo + ")"; }
    }
    
    
    public static abstract class Tipo extends Nodo { public Tipo() {super();}}
    
    public static class TipoArray extends Tipo {
        public Tipo base;
        public String size;
        public TipoArray(Tipo base, String size) {super(); this.base = base; this.size = size; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "tipo_array(" + base + ", " + size + ")"; }
    }
    
    public static class TipoPuntero extends Tipo {
        public Tipo base;
        public TipoPuntero(Tipo base) {super(); this.base = base; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "tipo_puntero(" + base + ")"; }
    }
    
    public static class TipoStruct extends Tipo {
        public LCampos campos;
        public TipoStruct(LCampos campos) { super();this.campos = campos; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "tipo_struct(" + campos + ")"; }
    }
    
    public static class TipoInt extends Tipo {
        public TipoInt() {super(); }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "tipo_int"; }
    }
    
    public static class TipoReal extends Tipo {
        public TipoReal() {super(); }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "tipo_real"; }
    }
    
    public static class TipoBool extends Tipo {
        public TipoBool() {super(); }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "tipo_bool"; }
    }
    
    public static class TipoString extends Tipo {
        public TipoString() {super(); }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "tipo_string"; }
    }
    
    public static class TipoIden extends Tipo {
        public String id;
        public TipoIden(String id) {super(); this.id = id; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "tipo_iden(" + id + ")"; }
    }
    
   
    public static abstract class LCampos extends Nodo {public LCampos(){} }
    
    public static class Un_campo extends LCampos {
        public Declaracion dec;
        public Un_campo(Declaracion dec) {super(); this.dec = dec; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "un_campo(" + dec + ")"; }
    }
    
    public static class Muchos_campos extends LCampos {
        public LCampos campos;
        public Declaracion dec;
        public Muchos_campos(LCampos campos, Declaracion dec) {super(); this.campos = campos; this.dec = dec; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "muchos_campos(" + campos + ", " + dec + ")"; }
    }
    
    
    public static abstract class ListaParametros extends Nodo {public ListaParametros(){}}
    
    public static class SinParametros extends ListaParametros {
        public SinParametros() {super(); }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "sin_parametros"; }
    }
    
    public static class ConParametros extends ListaParametros {
        public List<Parametro> params;
        public ConParametros(List<Parametro> params) {super(); this.params = params; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "lista_parametros" + params; }
    }
    
   
    public static abstract class Parametro extends Nodo {
       
        public Parametro() {super();}
    }
    
    public static class ParametroValor extends Parametro {
    	Tipo tipo;
    	String id;
        public ParametroValor(Tipo tipo, String id) { super(); this.tipo = tipo; this.id = id; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "parametro(" + tipo + ", " + id + ")"; }
    }
    
    public static class ParametroReferencia extends Parametro {
       	Tipo tipo;
    	String id;
        public ParametroReferencia(Tipo tipo, String id) { super(); this.tipo = tipo; this.id = id; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "parametro_referencia(" + tipo + ", " + id + ")"; }
    }
    
    
    public static abstract class ListaInstrucciones extends Nodo { }
    
    public static class SinInstrucciones extends ListaInstrucciones {
        public SinInstrucciones() {super(); }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "sin_instrucciones"; }
    }
    
    public static class ConInstrucciones extends ListaInstrucciones {
        public List<Instruccion> insts;
        public ConInstrucciones(List<Instruccion> insts) { super();this.insts = insts; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "lista_instrucciones" + insts; }
    }
    
    public static abstract class Instrucciones extends Nodo {
        public Instrucciones() { super(); }
    }
    
    public static class Una_inst extends Instrucciones {
        public Instruccion inst;
        public Una_inst(Instruccion inst) { 
            super();
            this.inst = inst;
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "una_inst(" + inst + ")"; }
    }
    
    public static class Muchas_inst extends Instrucciones {
        public Instrucciones insts;
        public Instruccion inst;
        public Muchas_inst(Instrucciones insts, Instruccion inst) { 
            super();
            this.insts = insts;
            this.inst = inst;
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "muchas_inst(" + insts + ", " + inst + ")"; }
    }
    
    public static abstract class ListaArgumentos extends Nodo {public ListaArgumentos(){} }
    
    public static class SinArgumentos extends ListaArgumentos {
        public SinArgumentos() {super(); }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "sin_argumentos"; }
    }
    
    public static class ConArgumentos extends ListaArgumentos {
        public List<Expresion> args;
        public ConArgumentos(List<Expresion> args) {super(); this.args = args; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "lista_argumentos" + args; }
    }
    public static abstract class Argumentos extends Nodo {
        public Argumentos() { super(); }
    }
    
    public static class Un_arg extends Argumentos {
        public Expresion exp;
        public Un_arg(Expresion exp) { 
            super(); 
            this.exp = exp; 
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "un_arg(" + exp + ")"; }
    }
    
    public static class Muchos_arg extends Argumentos {
        public Argumentos args;
        public Expresion exp;
        public Muchos_arg(Argumentos args, Expresion exp) {
            super();
            this.args = args;
            this.exp = exp;
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "muchos_arg(" + args + ", " + exp + ")"; }
    }
    
    public static abstract class Instruccion extends Nodo {public Instruccion(){} }
    
    public static class InstruccionIf extends Instruccion {
        public Expresion cond;
        public Prog thenProg;
        public ElseOpt elseOpt;
        public InstruccionIf(Expresion cond, Prog thenProg, ElseOpt elseOpt) {
        	super(); this.cond = cond; this.thenProg = thenProg; this.elseOpt = elseOpt;
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "if(" + cond + ", " + thenProg + ", " + elseOpt + ")"; }
    }
    
    public static class InstruccionWhile extends Instruccion {
        public Expresion cond;
        public Prog cuerpo;
        public InstruccionWhile(Expresion cond, Prog cuerpo) {
        	super();this.cond = cond; this.cuerpo = cuerpo;
        }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "while(" + cond + ", " + cuerpo + ")"; }
    }
    
    public static class InstruccionCall extends Instruccion {
        public String id;
        public ListaArgumentos args;
        public InstruccionCall(String id, ListaArgumentos args) { super();this.id = id; this.args = args; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "call(" + id + ", " + args + ")"; }
    }
    
    public static class InstruccionPrograma extends Instruccion {
        public Prog prog;
        public InstruccionPrograma(Prog prog) {super(); this.prog = prog; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "instruccion_programa(" + prog + ")"; }
    }
    
    public static class InstruccionEval extends Instruccion {
        public Expresion exp;
        public InstruccionEval(Expresion exp) {super(); this.exp = exp; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "@(" + exp + ")"; }
    }
    
    public static class InstruccionRead extends Instruccion {
        public Expresion exp;
        public InstruccionRead(Expresion exp) {super(); this.exp = exp; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "read(" + exp + ")"; }
    }
    
    public static class InstruccionWrite extends Instruccion {
        public Expresion exp;
        public InstruccionWrite(Expresion exp) {super(); this.exp = exp; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "write(" + exp + ")"; }
    }
    
    public static class InstruccionNl extends Instruccion {
        public InstruccionNl() {super(); }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "nl()"; }
    }
    
    public static class InstruccionNew extends Instruccion {
        public Expresion exp;
        public InstruccionNew(Expresion exp) {super(); this.exp = exp; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "new(" + exp + ")"; }
    }
    
    public static class InstruccionDelete extends Instruccion {
        public Expresion exp;
        public InstruccionDelete(Expresion exp) {super(); this.exp = exp; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "delete(" + exp + ")"; }
    }
    
    
    public static abstract class ElseOpt extends Nodo {public ElseOpt(){super();}}
    
    public static class ElseOptElse extends ElseOpt {
        public Prog prog;
        public ElseOptElse(Prog prog) { super();this.prog = prog; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "else(" + prog + ")"; }
    }
    
    public static class ElseOptVacio extends ElseOpt {
        public ElseOptVacio() {super(); }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "else_vacio"; }
    }
    
   
    public static abstract class Expresion extends Nodo {public Expresion(){super();}}
    
    public static class ExpAsignacion extends Expresion {
        public Expresion izq, der;
        public ExpAsignacion(Expresion izq, Expresion der) { super();this.izq = izq; this.der = der; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "asign(" + izq + ", " + der + ")"; }
    }
    
    public static class ExpRelMenor extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpRelMenor(Expresion opnd0, Expresion opnd1) {super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "menor(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpRelMayor extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpRelMayor(Expresion opnd0, Expresion opnd1) {super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "mayor(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpRelMenorIgual extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpRelMenorIgual(Expresion opnd0, Expresion opnd1) { super();this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "menor_igual(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpRelMayorIgual extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpRelMayorIgual(Expresion opnd0, Expresion opnd1) {super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "mayor_igual(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpRelIgualIgual extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpRelIgualIgual(Expresion opnd0, Expresion opnd1) {super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "igual_igual(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpRelDistinto extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpRelDistinto(Expresion opnd0, Expresion opnd1) {super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "distinto(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpAdicSuma extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpAdicSuma(Expresion opnd0, Expresion opnd1) {super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "suma(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpAdicResta extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpAdicResta(Expresion opnd0, Expresion opnd1) { super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "resta(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpLogAnd extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpLogAnd(Expresion opnd0, Expresion opnd1) {super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "and(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpLogOr extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpLogOr(Expresion opnd0, Expresion opnd1) {super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "or(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpMul extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpMul(Expresion opnd0, Expresion opnd1) {super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "mul(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpDiv extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpDiv(Expresion opnd0, Expresion opnd1) {super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "div(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpMod extends Expresion {
        public Expresion opnd0, opnd1;
        public ExpMod(Expresion opnd0, Expresion opnd1) {super(); this.opnd0 = opnd0; this.opnd1 = opnd1; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "mod(" + opnd0 + ", " + opnd1 + ")"; }
    }
    
    public static class ExpUnariaMenos extends Expresion {
        public Expresion opnd;
        public ExpUnariaMenos(Expresion opnd) {super(); this.opnd = opnd; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "menos(" + opnd + ")"; }
    }
    
    public static class ExpUnariaNot extends Expresion {
        public Expresion opnd;
        public ExpUnariaNot(Expresion opnd) {super(); this.opnd = opnd; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "not(" + opnd + ")"; }
    }
    
    public static class ExpAccesoArray extends Expresion {
        public Expresion array;
        public Expresion indice;
        public ExpAccesoArray(Expresion array, Expresion indice) {super(); this.array = array; this.indice = indice; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "acceso_array(" + array + ", " + indice + ")"; }
    }
    
    public static class ExpAccesoPunto extends Expresion {
        public Expresion exp;
        public String campo;
        public ExpAccesoPunto(Expresion exp, String campo) {super(); this.exp = exp; this.campo = campo; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "acceso_punto(" + exp + ", " + campo + ")"; }
    }
    
    public static class ExpAccesoPuntero extends Expresion {
        public Expresion exp;
        public ExpAccesoPuntero(Expresion exp) {super(); this.exp = exp; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "acceso_puntero(" + exp + ")"; }
    }
    
    public static class FactorLitEnt extends Expresion {
        public String valor;
        public FactorLitEnt(String valor) {super(); this.valor = valor; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "lit_ent(" + valor + ")"; }
    }
    
    public static class FactorLitReal extends Expresion {
        public String valor;
        public FactorLitReal(String valor) {super(); this.valor = valor; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "lit_real(" + valor + ")"; }
    }
    
    public static class FactorLitBool extends Expresion {
        public String valor;
        public FactorLitBool(String valor) {super(); this.valor = valor; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "lit_bool(" + valor + ")"; }
    }
    
    public static class FactorLitCadena extends Expresion {
        public String valor;
        public FactorLitCadena(String valor) {super(); this.valor = valor; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "lit_cadena(" + valor + ")"; }
    }
    
    public static class FactorIdentificador extends Expresion {
        public String id;
        public FactorIdentificador(String id) {super(); this.id = id; }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "iden(" + id + ")"; }
    }
    
    public static class FactorNull extends Expresion {
        public FactorNull() {super(); }
        public <T> T accept(Visitor<T> v) { return v.visit(this); }
        public String toString() { return "null"; }
    }
    
 
    public Prog prog(DeclaracionesConSep decs, ListaInstrucciones insts) {
        return new Prog(decs, insts);
    }
    public DeclaracionesConSep decs(LDecs ldec) {
        return new DeclaracionesConSepImpl(ldec);
    }
    public DeclaracionesConSep sinDecs() {
        return new SinDeclaraciones();
    }
    public Declaracion decTipo(Tipo tipo, String id) {
        return new DecTipo(tipo, id);
    }
    public Declaracion decType(Tipo tipo, String id) {
        return new DecType(tipo, id);
    }
    public Declaracion decProc(String id, ListaParametros params, Prog cuerpo) {
        return new DecProc(id, params, cuerpo);
    }
    public Tipo tipoArray(Tipo base, String size) {
        return new TipoArray(base, size);
    }
    public Tipo tipoPuntero(Tipo base) {
        return new TipoPuntero(base);
    }
    public Tipo tipoStruct(LCampos campos) {
        return new TipoStruct(campos);
    }
    public Tipo tipoInt() {
        return new TipoInt();
    }
    public Tipo tipoReal() {
        return new TipoReal();
    }
    public Tipo tipoBool() {
        return new TipoBool();
    }
    public Tipo tipoString() {
        return new TipoString();
    }
    public Tipo tipoIden(String id) {
        return new TipoIden(id);
    }
    public LCampos un_campo(Declaracion d) {
        return new Un_campo(d);
    }
    public LCampos muchos_campos(LCampos lc, Declaracion d) {
        return new Muchos_campos(lc, d);
    }
    public ListaParametros listaParametros(List<Parametro> params) {
        return new ConParametros(params);
    }
    public ListaParametros sinParametros() {
        return new SinParametros();
    }
    public Parametro parametro(Tipo tipo, String id) {
        return new ParametroValor(tipo, id);
    }
    public Parametro parametroReferencia(Tipo tipo, String id) {
        return new ParametroReferencia(tipo, id);
    }
    public ListaInstrucciones listaInstrucciones(List<Instruccion> insts) {
        return new ConInstrucciones(insts);
    }
    public ListaInstrucciones sinInstrucciones() {
        return new SinInstrucciones();
    }
    public Instruccion instruccionIf(Expresion cond, Prog thenProg, ElseOpt elseOpt) {
        return new InstruccionIf(cond, thenProg, elseOpt);
    }
    public Instruccion instruccionWhile(Expresion cond, Prog cuerpo) {
        return new InstruccionWhile(cond, cuerpo);
    }
    public Instruccion instruccionCall(String id, ListaArgumentos args) {
        return new InstruccionCall(id, args);
    }
    public Instruccion instruccionPrograma(Prog prog) {
        return new InstruccionPrograma(prog);
    }
    public Instruccion instruccionEval(Expresion exp) {
        return new InstruccionEval(exp);
    }
    public Instruccion instruccionRead(Expresion exp) {
        return new InstruccionRead(exp);
    }
    public Instruccion instruccionWrite(Expresion exp) {
        return new InstruccionWrite(exp);
    }
    public Instruccion instruccionNl() {
        return new InstruccionNl();
    }
    public Instruccion instruccionNew(Expresion exp) {
        return new InstruccionNew(exp);
    }
    public Instruccion instruccionDelete(Expresion exp) {
        return new InstruccionDelete(exp);
    }
    public ElseOpt elseOptElse(Prog prog) {
        return new ElseOptElse(prog);
    }
    public ElseOpt elseOptVacio() {
        return new ElseOptVacio();
    }
    public ListaArgumentos listaArgumentos(List<Expresion> args) {
        return new ConArgumentos(args);
    }
    public ListaArgumentos sinArgumentos() {
        return new SinArgumentos();
    }
    public Expresion expresionAsignacion(Expresion izq, Expresion der) {
        return new ExpAsignacion(izq, der);
    }
    public Expresion expresionRelMenor(Expresion opnd0, Expresion opnd1) {
        return new ExpRelMenor(opnd0, opnd1);
    }
    public Expresion expresionRelMayor(Expresion opnd0, Expresion opnd1) {
        return new ExpRelMayor(opnd0, opnd1);
    }
    public Expresion expresionRelMenorIgual(Expresion opnd0, Expresion opnd1) {
        return new ExpRelMenorIgual(opnd0, opnd1);
    }
    public Expresion expresionRelMayorIgual(Expresion opnd0, Expresion opnd1) {
        return new ExpRelMayorIgual(opnd0, opnd1);
    }
    public Expresion expresionRelIgualIgual(Expresion opnd0, Expresion opnd1) {
        return new ExpRelIgualIgual(opnd0, opnd1);
    }
    public Expresion expresionRelDistinto(Expresion opnd0, Expresion opnd1) {
        return new ExpRelDistinto(opnd0, opnd1);
    }
    public Expresion expresionAdiSuma(Expresion opnd0, Expresion opnd1) {
        return new ExpAdicSuma(opnd0, opnd1);
    }
    public Expresion expresionAdiResta(Expresion opnd0, Expresion opnd1) {
        return new ExpAdicResta(opnd0, opnd1);
    }
    public Expresion expresionLogAnd(Expresion opnd0, Expresion opnd1) {
        return new ExpLogAnd(opnd0, opnd1);
    }
    public Expresion expresionLogOr(Expresion opnd0, Expresion opnd1) {
        return new ExpLogOr(opnd0, opnd1);
    }
    public Expresion expresionMul(Expresion opnd0, Expresion opnd1) {
        return new ExpMul(opnd0, opnd1);
    }
    public Expresion expresionDiv(Expresion opnd0, Expresion opnd1) {
        return new ExpDiv(opnd0, opnd1);
    }
    public Expresion expresionMod(Expresion opnd0, Expresion opnd1) {
        return new ExpMod(opnd0, opnd1);
    }
    public Expresion expresionUnariaMenos(Expresion opnd) {
        return new ExpUnariaMenos(opnd);
    }
    public Expresion expresionUnariaNot(Expresion opnd) {
        return new ExpUnariaNot(opnd);
    }
    public Expresion expresionAccesoArray(Expresion array, Expresion indice) {
        return new ExpAccesoArray(array, indice);
    }
    public Expresion expresionAccesoPunto(Expresion exp, String campo) {
        return new ExpAccesoPunto(exp, campo);
    }
    public Expresion expresionAccesoPuntero(Expresion exp) {
        return new ExpAccesoPuntero(exp);
    }
    public Expresion factorLitEnt(String valor) {
        return new FactorLitEnt(valor);
    }
    public Expresion factorLitReal(String valor) {
        return new FactorLitReal(valor);
    }
    public Expresion factorLitBool(String valor) {
        return new FactorLitBool(valor);
    }
    public Expresion factorLitCadena(String valor) {
        return new FactorLitCadena(valor);
    }
    public Expresion factorIdentificador(String id) {
        return new FactorIdentificador(id);
    }
    public Expresion factorNull() {
        return new FactorNull();
    }
}
