package asint;


public class SintaxisAbstractaEval {

    public static abstract class Nodo {
        private int fila, col;
        public Nodo() { fila = col = -1; }
        public Nodo ponFila(int fila) { this.fila = fila; return this; }
        public Nodo ponCol(int col) { this.col = col; return this; }
        public int leeFila() { return fila; }
        public int leeCol() { return col; }
        public abstract void imprime(); //Patrón Intérprete
    }

    public static class Prog extends Nodo {
        private DeclaracionesConSep dcs;
        private Insts insts;
        public Prog(DeclaracionesConSep dcs, Insts insts) {
            super();
            this.dcs = dcs;
            this.insts = insts;
        }
        public String toString() { return ""; }
        public DeclaracionesConSep dcs() {return this.dcs;}
        public Insts inst() {return this.insts;}
        //public String toString() { return "prog(" + dcs + ", " + insts + ")"; }
		
        @Override //Patrón Intérprete
		public void imprime() {
				System.out.println("{");
				this.dcs.imprime();
				this.insts.imprime();
				System.out.println("}");
		}
    }
    
    public static abstract class DeclaracionesConSep extends Nodo {
    	public DeclaracionesConSep() {}
        public LDecs ldecs() {throw new UnsupportedOperationException();}
    }
    
    public static class Declaraciones_Con_Separador extends DeclaracionesConSep {
        private LDecs decs;
        public Declaraciones_Con_Separador(LDecs decs) { 
            super();
            this.decs = decs; 
        }
        public String toString() { return "decs(" + decs + ")"; }
        public LDecs ldecs() {return this.decs;}
		
        @Override //Patrón Intérprete
		public void imprime() {decs.imprime(); System.out.println("&&");}
    }
    
    public static class Sin_Declaraciones extends DeclaracionesConSep {
        public Sin_Declaraciones() { super(); }
        public String toString() { return "sin_decs()"; }
		
        @Override //Patrón Intérprete
		public void imprime() {}
    }
    
    public static abstract class LDecs extends Nodo { 
    	public LDecs() {
 		   super();
        }
        public Declaracion dec() {throw new UnsupportedOperationException();}
        public LDecs ldecs() {throw new UnsupportedOperationException();}
    
    }
    
    public static class Una_dec extends LDecs {
        private Declaracion dec;
        public Una_dec(Declaracion dec) { 
            super();
            this.dec = dec; 
        }
        public String toString() { return "una_dec(" + dec + ")"; }
        public Declaracion dec() {return this.dec;}
		
        @Override //Patrón Intérprete
		public void imprime() {
        	dec.imprime();
        }
    }
    
    public static class Muchas_decs extends LDecs {
        private LDecs decs;
        private Declaracion dec;
        public Muchas_decs(LDecs decs, Declaracion dec) { 
            super();
            this.decs = decs; 
            this.dec = dec; 
        }
        public String toString() { return "muchas_decs(" + decs + ", " + dec + ")"; }
        public LDecs ldecs() {return this.decs;}
        public Declaracion dec() {return this.dec;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			decs.imprime();
			System.out.println(";");
			dec.imprime();
		}
    }
    
    public static abstract class Declaracion extends Nodo {
    	public Declaracion() {
  		   super();
         }
         public Tipo tipo() {throw new UnsupportedOperationException();}
         public String iden() {throw new UnsupportedOperationException();}
         public Params params() {throw new UnsupportedOperationException();}
         public Prog cuerpo() {throw new UnsupportedOperationException();}
    
    }
    
    public static class DecTipo extends Declaracion {
        private Tipo tipo;
        private String id;
        public DecTipo(Tipo tipo, String id) { 
            this.tipo = tipo; 
            this.id = id; 
        }
        public String toString() { return "dec_tipo(" + tipo + ", " + id +"["+leeFila()+","+leeCol()+"]" + ")"; }
        public Tipo tipo() {return this.tipo;}
        public String iden() {return this.id;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			tipo.imprime();
			System.out.println(id + "$f:"+this.leeFila()+",c:"+this.leeCol()+"$");
		}
    }
    
    public static class DecType extends Declaracion {
        private Tipo tipo;
        private String id;
        public DecType(Tipo tipo, String id) { 
            this.tipo = tipo; 
            this.id = id; 
        }
        public String toString() { return "dec_type(" + tipo + ", " + id +"["+leeFila()+","+leeCol()+"]"+ ")"; }
        public Tipo tipo() {return this.tipo;}
        public String iden() {return this.id;}
		
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("<type>");
    		tipo.imprime();
    		System.out.println(id + "$f:"+this.leeFila()+",c:"+this.leeCol()+"$");
		}
    }
    
    public static class DecProc extends Declaracion {
        public String id;
        public Params params;
        public Prog cuerpo;
        
        public DecProc(String id, Params params, Prog cuerpo) {
            this.id = id;
            this.params = params;
            this.cuerpo = cuerpo;
        }
        
        public String toString() { return "dec_proc(" + id +"["+leeFila()+","+leeCol()+"]," + params + ", " + cuerpo + ")"; }
        public String iden() {return this.id;}
        public Params params() {return this.params;}
        public Prog cuerpo() { return this.cuerpo;}

		@Override //Patrón Intérprete
		public void imprime() {
			System.out.println("<proc>");
    		System.out.println(id + "$f:"+this.leeFila()+",c:"+this.leeCol()+"$");
    		params.imprime();	
    		cuerpo.imprime();
		}
    }
    
   
    public static abstract class Tipo extends Nodo {
    	public Tipo() {
   		   super();
          }
    	public String iden() {throw new UnsupportedOperationException();}
    	public Tipo tipo() {throw new UnsupportedOperationException();}
        public String size() {throw new UnsupportedOperationException();}
        public Cmps campos() {throw new UnsupportedOperationException();}
    }
    
    public static class TipoArray extends Tipo {
        private Tipo base;
        private String size;
        public TipoArray(Tipo base, String size) {
            super();
            this.base = base;
            this.size = size;
        }
        public String toString() { return "tipo_array(" + base + ", " + size + ")"; }
        public Tipo tipo() {return this.base;}
        public String size() {return this.size;}
		@Override
		public void imprime() { //Patrón Intérprete
			base.imprime();
    		System.out.println("[");
    		System.out.println(size);
    		System.out.println("]$f:"+this.leeFila()+",c:"+this.leeCol()+"$");
		}
    }
    
    public static class TipoPuntero extends Tipo {
        private Tipo base;
        public TipoPuntero(Tipo base) { 
            super();
            this.base = base; 
        }
        public String toString() { return "tipo_puntero(" + base + ")"; }
        public Tipo tipo() {return this.base;}
		
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("^");
    		base.imprime();
		}
    }
    
    public static class TipoInt extends Tipo {
        public TipoInt() { super(); }

        public String toString() { return "tipo_int"; }
		
        @Override //Patrón Intérprete
		public void imprime() {
			System.out.println("<int>");
		}
    }
    
    public static class TipoReal extends Tipo {
        public TipoReal() { super(); }

        public String toString() { return "tipo_real"; }
        @Override //Patrón Intérprete
		public void imprime() {
			System.out.println("<real>");
		}
    }
    
    public static class TipoBool extends Tipo {
        public TipoBool() { super(); }

        public String toString() { return "tipo_bool"; }
        @Override //Patrón Intérprete
		public void imprime() {
			System.out.println("<bool>");
		}
    }
    
    public static class TipoString extends Tipo {
        public TipoString() { super(); }

        public String toString() { return "tipo_string"; }
        @Override //Patrón Intérprete
		public void imprime() {
			System.out.println("<string>");
		}
    }
    
    public static class TipoStruct extends Tipo {
        private Cmps campos;
        public TipoStruct(Cmps campos) { 
            super();
            this.campos = campos; 
        }

        public String toString() { return "tipo_struct(" + campos + ")"; }
        public Cmps campos() {return this.campos;}
		
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("<struct>");
    		System.out.println("{");
    		campos.imprime();
    		System.out.println("}");
		}
    }
    
    public static class TipoIden extends Tipo {
        private String id;
        public TipoIden(String id) { 
            super();
            this.id = id; 
        }

        public String toString() { return "tipo_iden(" + id + ")"; }
        public String iden() {return this.id;}
		@Override
		public void imprime() {
			System.out.println(id +"$f:"+this.leeFila()+",c:"+this.leeCol()+"$");
		}
    }
    
   
    public static abstract class Cmps extends Nodo { 
    	public Cmps(){super();}
    	public Declaracion dec() {throw new UnsupportedOperationException();}
        public Cmps campos() {throw new UnsupportedOperationException();}
    }
    
    public static class Un_campo extends Cmps {
        private Declaracion dec;
        public Un_campo(Declaracion dec) { 
            super();
            this.dec = dec; 
        }

        public String toString() { return "un_campo(" + dec + ")"; }
        public Declaracion dec() {return this.dec;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			dec.imprime();
		}
    }
    
    public static class Muchos_campos extends Cmps {
        private Cmps campos;
        private Declaracion dec;
        public Muchos_campos(Cmps campos, Declaracion dec) { 
            super();
            this.campos = campos;
            this.dec = dec;
        }

        public String toString() { return "muchos_campos(" + campos + ", " + dec + ")"; }
        public Declaracion dec() {return this.dec;}
        public Cmps campos() {return this.campos;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			campos.imprime();
			System.out.println(",");
			dec.imprime();
		}
    }
    
    
    public static abstract class Params extends Nodo {
    	public Params() {super();}
    	public LParam lparam() {throw new UnsupportedOperationException();}
    }
    
    public static class ConParametros extends Params {
    	private LParam lparam;
        public ConParametros(LParam lparam) { 
            super();
            this.lparam = lparam; 
        }

        public String toString() { return "con_params(" + lparam + ")"; }
        public LParam lparam() {return this.lparam;}
		
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("(");
			lparam.imprime();
			System.out.println(")");
		}
    }
    
    public static class SinParametros extends Params {
        public SinParametros() { super(); }

        public String toString() { return "sin_parametros"; }
		
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("(");
			System.out.println(")");
        }
    }
    
    public static abstract class LParam extends Nodo {
    	public LParam() {super();}
    	public LParam lparam() {throw new UnsupportedOperationException();}
    	 public Tipo tipo() {throw new UnsupportedOperationException();}
    }
    
    public static class Un_param extends LParam {
        private Tipo param;
        public Un_param(Tipo param) { 
            super();
            this.param = param; 
        }

        public String toString() { return "un_param(" + param + ")"; }
        public Tipo tipo() {return this.param;}
		@Override
		public void imprime() {
			param.imprime();
		}
    }
    
    public static class Muchos_param extends LParam {
        private LParam lparam;
        private Tipo param;
        public Muchos_param(LParam lparam, Tipo param) { 
            super();
            this.lparam = lparam;
            this.param = param;
        }

        public String toString() { return "muchos_param(" + lparam + ", " + param + ")"; }
        public LParam lparam() {return this.lparam;}
        public Tipo tipo() {return this.param;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			lparam.imprime();
			System.out.println(",");
			param.imprime();
		}
    }
    
    
    //public static abstract class Param extends Nodo { }
    
    public static class ParametroValor extends Tipo {
        private Tipo tipo;
        private String id;
        public ParametroValor(Tipo tipo, String id) { 
            super();
            this.tipo = tipo; 
            this.id = id; 
        }

        public String toString() { return "parametro(" + tipo + ", " + id + ")"; }
        public Tipo tipo() {return this.tipo;}
        public String iden() {return this.id;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			tipo.imprime();
    		System.out.println(id+"$f:"+this.leeFila()+",c:"+this.leeCol()+"$");
		}
    }
    
    public static class ParametroReferencia extends Tipo {
        private Tipo tipo;
        private String id;
        public ParametroReferencia(Tipo tipo, String id) { 
            super();
            this.tipo = tipo; 
            this.id = id; 
        }

        public String toString() { return "parametro_referencia(" + tipo + ", " + id + ")"; }
        public Tipo tipo() {return this.tipo;}
        public String iden() {return this.id;}
		@Override
		public void imprime() {
			System.out.println("&");
    		tipo.imprime();
    		System.out.println(id);
		}
    }
    
   
    public static abstract class Insts extends Nodo { 
    	public Insts() {super(); }
    	public LIns insts() {throw new UnsupportedOperationException();}
    }
    
    public static class Lista_Instrucciones extends Insts {
        private LIns insts;
        public Lista_Instrucciones(LIns insts) { 
            super();
            this.insts = insts; 
        }

        public String toString() { return "lista_instrucciones" + insts; }
        public LIns insts() {return this.insts;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			insts.imprime();
		}
    }
    
    public static class Sin_Instrucciones extends Insts {
        public Sin_Instrucciones() { super(); }

        public String toString() { return "sin_instrucciones"; }
		@Override
		public void imprime() {}
    }
    public static abstract class LIns extends Nodo { 
    	public LIns() {super();}
    	public Instruccion inst() {throw new UnsupportedOperationException();}
        public LIns insts() {throw new UnsupportedOperationException();}
    }

    public static class Una_instruccion extends LIns {
        private Instruccion inst;
        public Una_instruccion(Instruccion inst) { 
            super();
            this.inst = inst; 
        }

        public String toString() { return "un_instruccion(" + inst + ")"; }
        public Instruccion inst() {return this.inst;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			inst.imprime();
		}
    }
    
    public static class Muchas_instrucciones extends LIns {
        private LIns insts;
        private Instruccion inst;
        public Muchas_instrucciones(LIns insts, Instruccion inst) { 
            super();
            this.insts = insts;
            this.inst = inst;
        }

        public String toString() { return "muchas_instrucciones(" + insts + ", " + inst + ")"; }
        public Instruccion inst() {return this.inst;}
        public LIns insts() {return this.insts;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			insts.imprime();
			System.out.println(";");
			inst.imprime();
		}
    }
   
    public static abstract class Instruccion extends Nodo {
    	public Instruccion() {super();}
    	public Expresion exp() {throw new UnsupportedOperationException();}
    	public Prog prog() {throw new UnsupportedOperationException();}
        public Else elseOpt() {throw new UnsupportedOperationException();}
        public String iden() {throw new UnsupportedOperationException();}
        public Argus args() {throw new UnsupportedOperationException();}
    }
    
    public static class InstruccionEval extends Instruccion {
        private Expresion exp;
        public InstruccionEval(Expresion exp) { 
            super();
            this.exp = exp; 
        }

        public String toString() { return "@(" + exp + ")"; }
        public Expresion exp() {return this.exp;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			System.out.println("@");
    		exp.imprime();
		}
    }
    
    public static class InstruccionIf extends Instruccion {
        private Expresion cond;
        private Prog thenProg;
        private Else elseOpt;
        public InstruccionIf(Expresion cond, Prog thenProg, Else elseOpt) { 
            super();
            this.cond = cond; 
            this.thenProg = thenProg; 
            this.elseOpt = elseOpt;
        }

        public String toString() { return "if(" + cond + ", " + thenProg + ", " + elseOpt + ")"; }
        public Expresion exp() {return this.cond;}
        public Prog prog() {return this.thenProg;}
        public Else elseOpt() {return this.elseOpt;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			System.out.println("<if>");
    		cond.imprime();
    		thenProg.imprime();
    		elseOpt.imprime();
		}
    }
    
    public static class InstruccionWhile extends Instruccion {
        private Expresion cond;
        private Prog cuerpo;
        public InstruccionWhile(Expresion cond, Prog cuerpo) { 
            super();
            this.cond = cond; 
            this.cuerpo = cuerpo; 
        }

        public String toString() { return "while(" + cond + ", " + cuerpo + ")"; }
        public Expresion exp() {return this.cond;}
        public Prog prog() {return this.cuerpo;}
		
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("<while>");
    		cond.imprime();
    		cuerpo.imprime();
		}
    }
    
    public static class InstruccionRead extends Instruccion {
        private Expresion exp;
        public InstruccionRead(Expresion exp) { 
            super();
            this.exp = exp; 
        }

        public String toString() { return "read(" + exp + ")"; }
        public Expresion exp() {return this.exp;}
		
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("<read>");
    		exp.imprime();
		}
    }
    
    public static class InstruccionWrite extends Instruccion {
        private Expresion exp;
        public InstruccionWrite(Expresion exp) { 
            super();
            this.exp = exp; 
        }

        public String toString() { return "write(" + exp + ")"; }
        public Expresion exp() {return this.exp;}
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("<write>");
    		exp.imprime();
		}
    }
    
    public static class InstruccionNl extends Instruccion {
        public InstruccionNl() { super(); }

        public String toString() { return "nl()"; }
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("<nl>");
		}
    }
    
    public static class InstruccionNew extends Instruccion {
        private Expresion exp;
        public InstruccionNew(Expresion exp) { 
            super();
            this.exp = exp; 
        }

        public String toString() { return "new(" + exp + ")"; }
        public Expresion exp() {return this.exp;}
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("<new>");
    		exp.imprime();
		}
    }
    
    public static class InstruccionDelete extends Instruccion {
        private Expresion exp;
        public InstruccionDelete(Expresion exp) { 
            super();
            this.exp = exp; 
        }

        public String toString() { return "delete(" + exp + ")"; }
        public Expresion exp() {return this.exp;}
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("<delete>");
    		exp.imprime();
		}
    }
    
    public static class InstruccionCall extends Instruccion {
        private String id;
        private Argus args;
        public InstruccionCall(String id, Argus args) { 
            super();
            this.id = id; 
            this.args = args; 
        }

        public String toString() { return "call(" + id + ", " + args + ")"; }
        public String iden() {return this.id;}
        public Argus args() {return this.args;}
		@Override //Patrón Intérprete
		public void imprime() {
			System.out.println("<call>");
    		System.out.println(id+ "$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		args.imprime();
		}
    }
    
    public static class InstruccionPrograma extends Instruccion {
        private Prog prog;
        public InstruccionPrograma(Prog prog) { 
            super();
            this.prog = prog; 
        }

        public String toString() { return "instruccion_programa(" + prog + ")"; }
        public Prog prog() {return this.prog;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			prog.imprime();
			
		}
    }
    
   
    public static abstract class Else extends Nodo {
    	public Else() {super();}
    	public Prog prog() {throw new UnsupportedOperationException();}
    }
    
    public static class ElseOptElse extends Else {
        private Prog prog;
        public ElseOptElse(Prog prog) { 
            super();
            this.prog = prog; 
        }

        public String toString() { return "else(" + prog + ")"; }
        public Prog prog() {return this.prog;}
		
        @Override //Patrón Intérprete
		public void imprime() {
        	System.out.println("<else>");
			prog.imprime();
		}
    }
    
    public static class ElseOptVacio extends Else {
        public ElseOptVacio() { super(); }

        public String toString() { return "else_vacio"; }
		@Override
		public void imprime() {}
    }
    
    
    public static abstract class Argus extends Nodo {
    	public Argus() {super();}
    	public LArgs args() {throw new UnsupportedOperationException();}
    }
    
    public static class ConArgumentos extends Argus {
        private LArgs args;
        public ConArgumentos(LArgs args) { 
            super();
            this.args = args; 
        }

        public String toString() { return "lista_argumentos" + args; }
        public LArgs args() {return this.args;}
		
        @Override //Paatrón Intérprete
		public void imprime() {
			System.out.println("(");
			args.imprime();
			System.out.println(")");
		}
    }
    
    public static class SinArgumentos extends Argus {
        public SinArgumentos() { super(); }

        public String toString() { return "sin_argumentos"; }
		@Override
		public void imprime() {}
    }
    
    public static abstract class LArgs extends Nodo {
    	public LArgs() {super();}
    	public LArgs args() {throw new UnsupportedOperationException();}
        public Expresion exp() {throw new UnsupportedOperationException();}
    }
    
    public static class Un_arg extends LArgs {
        private Expresion exp;
        public Un_arg(Expresion exp) { 
            super();
            this.exp = exp; 
        }

        public String toString() { return "un_arg(" + exp + ")"; }
        public Expresion exp() {return this.exp;}
		
        @Override //Patrón Intérprete
		public void imprime() {
			exp.imprime();
		}
    }
    
    public static class Muchos_arg extends LArgs {
        private LArgs args;
        private Expresion exp;
        public Muchos_arg(LArgs args, Expresion exp) { 
            super();
            this.args = args;
            this.exp = exp;
        }

        public String toString() { return "muchos_arg(" + args + ", " + exp + ")"; }
        public LArgs args() {return this.args;}
        public Expresion exp() {return this.exp;}
		@Override
		public void imprime() {
			args.imprime();
			System.out.println(",");
			exp.imprime();
			
		}
    }
    
    public static abstract class Expresion extends Nodo {
    	public Expresion() {super();}
    	public Expresion Opn0() {throw new UnsupportedOperationException();}
        public Expresion Opn1() {throw new UnsupportedOperationException();}
        public String campo() {throw new UnsupportedOperationException();}
        public String lit() {throw new UnsupportedOperationException();}
    }
    
    public static class ExpAsignacion extends Expresion {
        private Expresion izq, der;
        public ExpAsignacion(Expresion izq, Expresion der) { 
            super();
            this.izq = izq; this.der = der; 
        }
 
        public String toString() { return "asign(" + izq + ", " + der + ")"; }
        public Expresion Opn0() {return this.izq;}
        public Expresion Opn1() {return this.der;}
		@Override //Patrón Intérprete
		public void imprime() {
			izq.imprime();
    		System.out.println("=$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		der.imprime();
		}
    }
    
    public static class ExpRelMenor extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpRelMenor(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }
        public String toString() { return "menor(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println("<$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpRelMayor extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpRelMayor(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }

        public String toString() { return "mayor(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println(">$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpRelMenorIgual extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpRelMenorIgual(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }
        
        public String toString() { return "menor_igual(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println("<=$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpRelMayorIgual extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpRelMayorIgual(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }
   
        public String toString() { return "mayor_igual(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println(">=$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpRelIgualIgual extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpRelIgualIgual(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }
       
        public String toString() { return "igual_igual(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println("==$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpRelDistinto extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpRelDistinto(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }
       
        public String toString() { return "distinto(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println("!=$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpAdicSuma extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpAdicSuma(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }
  
        public String toString() { return "suma(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println("+$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpAdicResta extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpAdicResta(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }

        public String toString() { return "resta(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println("-$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpLogAnd extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpLogAnd(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }
  
        public String toString() { return "and(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println("<and>$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpLogOr extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpLogOr(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }
 
        public String toString() { return "or(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println("<or>$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpMul extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpMul(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }
    
        public String toString() { return "mul(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println("*$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpDiv extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpDiv(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }

        public String toString() { return "div(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println("/$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpMod extends Expresion {
        private Expresion opnd0, opnd1;
        public ExpMod(Expresion opnd0, Expresion opnd1) { 
            super();
            this.opnd0 = opnd0; this.opnd1 = opnd1; 
        }

        public String toString() { return "mod(" + opnd0 + ", " + opnd1 + ")"; }
        public Expresion Opn0() {return this.opnd0;}
        public Expresion Opn1() {return this.opnd1;}
        @Override //Patrón Intérprete
		public void imprime() {
			opnd0.imprime();
    		System.out.println("%$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd1.imprime();
		}
    }
    
    public static class ExpUnariaMenos extends Expresion {
        private Expresion opnd;
        public ExpUnariaMenos(Expresion opnd) { 
            super();
            this.opnd = opnd; 
        }
      
        public String toString() { return "menos(" + opnd + ")"; }
        public Expresion Opn0() {return this.opnd;}
        @Override //Patrón Intérprete
		public void imprime() {
    		System.out.println("-$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd.imprime();
		}
    }
    
    public static class ExpUnariaNot extends Expresion {
        private Expresion opnd;
        public ExpUnariaNot(Expresion opnd) { 
            super();
            this.opnd = opnd; 
        }

        public String toString() { return "not(" + opnd + ")"; }
        public Expresion Opn0() {return this.opnd;}
        @Override //Patrón Intérprete
		public void imprime() {
    		System.out.println("<not>$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		opnd.imprime();
		}
    }
    
    public static class ExpAccesoArray extends Expresion {
        private Expresion array;
        private Expresion indice;
        public ExpAccesoArray(Expresion array, Expresion indice) { 
            super();
            this.array = array; this.indice = indice; 
        }
    
        public String toString() { return "acceso_array(" + array + ", " + indice + ")"; }
        public Expresion Opn0() {return this.array;}
        public Expresion Opn1() {return this.indice;}
        @Override //Patrón Intérprete
		public void imprime() {
			array.imprime();
    		System.out.println("[$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
    		indice.imprime();
    		System.out.println("]");
		}
    }
    
    public static class ExpAccesoPunto extends Expresion {
        private Expresion exp;
        private String campo;
        public ExpAccesoPunto(Expresion exp, String campo) { 
            super();
            this.exp = exp; this.campo = campo; 
        }

        public String toString() { return "acceso_punto(" + exp + ", " + campo + ")"; }
        public Expresion Opn0() {return this.exp;}
        public String campo() {return this.campo;}
        @Override //Patrón Intérprete
		public void imprime() {
			exp.imprime();
			System.out.println(".");
    		System.out.println(campo+"$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
		}
        
    }
    
    public static class ExpAccesoPuntero extends Expresion {
        private Expresion exp;
        public ExpAccesoPuntero(Expresion exp) { 
            super();
            this.exp = exp; 
        }
      
        public String toString() { return "acceso_puntero(" + exp + ")"; }
        public Expresion Opn0() {return this.exp;}
        @Override //Patrón Intérprete
		public void imprime() {
			exp.imprime();
    		System.out.println("^$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");
		}
    }
    
    public static class FactorLitEnt extends Expresion {
        private String valor;
        public FactorLitEnt(String valor) { 
            super();
            this.valor = valor; 
        }
  
        public String toString() { return "lit_ent(" + valor + ")"; }
        public String lit() {return this.valor;}
		@Override //Patrón Intérprete
		public void imprime() {
			System.out.println(valor+"$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");	
		}
    }
    
    public static class FactorLitReal extends Expresion {
        private String valor;
        public FactorLitReal(String valor) { 
            super();
            this.valor = valor; 
        }
    
        public String toString() { return "lit_real(" + valor + ")"; }
        public String lit() {return this.valor;}
        @Override //Patrón Intérprete
		public void imprime() {
			System.out.println(valor+"$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");	
		}
    }
    
    public static class FactorLitBool extends Expresion {
        private String valor;
        public FactorLitBool(String valor) { 
            super();
            this.valor = valor; 
        }
    
        public String toString() { return "lit_bool(" + valor + ")"; }
        public String lit() {return this.valor;}
        @Override //Patrón Intérprete
		public void imprime() {
			System.out.println(valor+"$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");	
		}
    }
    
    public static class FactorLitCadena extends Expresion {
        private String valor;
        public FactorLitCadena(String valor) { 
            super();
            this.valor = valor; 
        }
  
        public String toString() { return "lit_cadena(" + valor + ")"; }
        public String lit() {return this.valor;}
        @Override //Patrón Intérprete
		public void imprime() {
			System.out.println(valor+"$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");	
		}
    }
    
    public static class FactorIdentificador extends Expresion {
        private String id;
        public FactorIdentificador(String id) { 
            super();
            this.id = id; 
        }

        public String toString() { return "iden(" + id + ")"; }
        public String lit() {return this.id;}
        @Override //Patrón Intérprete
		public void imprime() {
			System.out.println(id+"$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");	
		}
    }
    
    public static class FactorNull extends Expresion {
        public FactorNull() { super(); }

        public String toString() { return "null"; }
        @Override //Patrón Intérprete
		public void imprime() {
			System.out.println("<null>$f:" + this.leeFila() + ",c:"+this.leeCol()+"$");	
		}
    }


    
 public Prog prog(DeclaracionesConSep dcs, Insts insts) {
     return new Prog(dcs, insts);
 }

 public DeclaracionesConSep declaraciones_con_separador(LDecs ldec) {
     return new Declaraciones_Con_Separador(ldec);
 }
 public DeclaracionesConSep sin_declaraciones() {
     return new Sin_Declaraciones();
 }

 public LDecs una_dec(Declaracion dec) {
     return new Una_dec(dec);
 }
 public LDecs muchas_decs(LDecs ldec, Declaracion dec) {
     return new Muchas_decs(ldec, dec);
 }

 public Declaracion declaracion_tipo(Tipo tipo, String id) {
     return new DecTipo(tipo, id);
 }
 public Declaracion declaracion_type(Tipo tipo, String id) {
     return new DecType(tipo, id);
 }
 public Declaracion declaracion_proc(String id, Params params, Prog prog) {
     return new DecProc(id, params, prog);
 }

 public Tipo tipo_array(Tipo base, String size) {
     return new TipoArray(base, size);
 }
 public Tipo tipo_puntero(Tipo base) {
     return new TipoPuntero(base);
 }
 public Tipo tipo_int() {
     return new TipoInt();
 }
 public Tipo tipo_real() {
     return new TipoReal();
 }
 public Tipo tipo_bool() {
     return new TipoBool();
 }
 public Tipo tipo_string() {
     return new TipoString();
 }
 public Tipo tipo_struct(Cmps campos) {
     return new TipoStruct(campos);
 }
 public Tipo tipo_iden(String id) {
     return new TipoIden(id);
 }

 public Cmps un_campo(Declaracion d) {
     return new Un_campo(d);
 }
 public Cmps muchos_campos(Cmps cp, Declaracion d) {
     return new Muchos_campos(cp, d);
 }

 public Params lista_parametros(LParam params) {
     return new ConParametros(params);
 }
 public Params sin_parametros() {
     return new SinParametros();
 }
 public LParam muchos_parametros(LParam params, Tipo param) {
     return new Muchos_param(params, param);
 }
 
 public LParam un_parametro(Tipo param) {
     return new Un_param(param);
 }
 public Tipo parametro(Tipo tipo, String id) {
     return new ParametroValor(tipo, id);
 }
 public Tipo parametro_referencia(Tipo tipo, String id) {
     return new ParametroReferencia(tipo, id);
 }

 public Insts lista_instrucciones(LIns insts) {
     return new Lista_Instrucciones(insts);
 }
 public Insts sin_instrucciones() {
     return new Sin_Instrucciones();
 }

 public LIns muchas_instrucciones(LIns insts, Instruccion inst) {
     return new Muchas_instrucciones(insts, inst);
 }
 
 public LIns una_instruccion(Instruccion inst) {
     return new Una_instruccion(inst);
 }
 public Instruccion instruccion_eval(Expresion exp) {
     return new InstruccionEval(exp);
 }
 public Instruccion instruccion_if(Expresion cond, Prog thenProg, Else elseOpt) {
     return new InstruccionIf(cond, thenProg, elseOpt);
 }
 public Instruccion instruccion_while(Expresion cond, Prog prog) {
     return new InstruccionWhile(cond, prog);
 }
 public Instruccion instruccion_read(Expresion exp) {
     return new InstruccionRead(exp);
 }
 public Instruccion instruccion_write(Expresion exp) {
     return new InstruccionWrite(exp);
 }
 public Instruccion instruccion_nl() {
     return new InstruccionNl();
 }
 public Instruccion instruccion_new(Expresion exp) {
     return new InstruccionNew(exp);
 }
 public Instruccion instruccion_delete(Expresion exp) {
     return new InstruccionDelete(exp);
 }
 public Instruccion instruccion_call(String id, Argus args) {
     return new InstruccionCall(id, args);
 }
 public Instruccion instruccion_programa(Prog prog) {
     return new InstruccionPrograma(prog);
 }

 public Else else_opt_else(Prog prog) {
     return new ElseOptElse(prog);
 }
 public Else else_opt_vacio() {
     return new ElseOptVacio();
 }

 public Argus lista_argumentos(LArgs args) {
     return new ConArgumentos(args);
 }
 public Argus sin_argumentos() {
     return new SinArgumentos();
 }
 public LArgs muchos_argumentos(LArgs args, Expresion exp) {
     return new Muchos_arg(args, exp);
 }
 
 public LArgs un_argumento(Expresion exp) {
     return new Un_arg(exp);
 }
 public Expresion expresion_asignacion(Expresion izq, Expresion der) {
     return new ExpAsignacion(izq, der);
 }
 public Expresion expresion_rel_menor(Expresion opnd0, Expresion opnd1) {
     return new ExpRelMenor(opnd0, opnd1);
 }
 public Expresion expresion_rel_mayor(Expresion opnd0, Expresion opnd1) {
     return new ExpRelMayor(opnd0, opnd1);
 }
 public Expresion expresion_rel_menor_igual(Expresion opnd0, Expresion opnd1) {
     return new ExpRelMenorIgual(opnd0, opnd1);
 }
 public Expresion expresion_rel_mayor_igual(Expresion opnd0, Expresion opnd1) {
     return new ExpRelMayorIgual(opnd0, opnd1);
 }
 public Expresion expresion_rel_igual_igual(Expresion opnd0, Expresion opnd1) {
     return new ExpRelIgualIgual(opnd0, opnd1);
 }
 public Expresion expresion_rel_distinto(Expresion opnd0, Expresion opnd1) {
     return new ExpRelDistinto(opnd0, opnd1);
 }
 public Expresion expresion_adi_suma(Expresion opnd0, Expresion opnd1) {
     return new ExpAdicSuma(opnd0, opnd1);
 }
 public Expresion expresion_adi_resta(Expresion opnd0, Expresion opnd1) {
     return new ExpAdicResta(opnd0, opnd1);
 }
 public Expresion expresion_log_and(Expresion opnd0, Expresion opnd1) {
     return new ExpLogAnd(opnd0, opnd1);
 }
 public Expresion expresion_log_or(Expresion opnd0, Expresion opnd1) {
     return new ExpLogOr(opnd0, opnd1);
 }
 public Expresion expresion_mul(Expresion opnd0, Expresion opnd1) {
     return new ExpMul(opnd0, opnd1);
 }
 public Expresion expresion_div(Expresion opnd0, Expresion opnd1) {
     return new ExpDiv(opnd0, opnd1);
 }
 public Expresion expresion_mod(Expresion opnd0, Expresion opnd1) {
     return new ExpMod(opnd0, opnd1);
 }
 public Expresion expresion_unaria_menos(Expresion opnd) {
     return new ExpUnariaMenos(opnd);
 }
 public Expresion expresion_unaria_not(Expresion opnd) {
     return new ExpUnariaNot(opnd);
 }
 public Expresion expresion_acceso_array(Expresion array, Expresion indice) {
     return new ExpAccesoArray(array, indice);
 }
 public Expresion expresion_acceso_punto(Expresion exp, String campo) {
     return new ExpAccesoPunto(exp, campo);
 }
 public Expresion expresion_acceso_puntero(Expresion exp) {
     return new ExpAccesoPuntero(exp);
 }
 public Expresion factor_literal_entero(String valor) {
     return new FactorLitEnt(valor);
 }
 public Expresion factor_literal_real(String valor) {
     return new FactorLitReal(valor);
 }
 public Expresion factor_literal_bool(String valor) {
     return new FactorLitBool(valor);
 }
 public Expresion factor_literal_cadena(String valor) {
     return new FactorLitCadena(valor);
 }
 public Expresion factor_identificador(String id) {
     return new FactorIdentificador(id);
 }
 public Expresion factor_null() {
     return new FactorNull();
 }

}
