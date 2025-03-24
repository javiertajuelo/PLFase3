/* ConstructorASTsTiny.java */
/* Generated By:JavaCC: Do not edit this line. ConstructorASTsTiny.java */
package c_ast_descendente;
import asint.ClaseSemanticaEval;
import asint.SintaxisAbstractaEval.*;
import c_ast_ascendente.UnidadLexica.StringLocalizado;

public class ConstructorASTsTiny implements ConstructorASTsTinyConstants {
    private ClaseSemanticaEval sem = new ClaseSemanticaEval();

  final public Prog analiza() throws ParseException {
    trace_call("analiza");
    try {
Prog prog;
      prog = Programa();
      jj_consume_token(0);
{if ("" != null) return prog;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("analiza");
    }
}

  final public Prog Programa() throws ParseException {
    trace_call("Programa");
    try {
DeclaracionesConSep dcs; Insts lis;
      jj_consume_token(36);
      dcs = DeclaracionesConSeparador();
      lis = ListaInstrucciones();
      jj_consume_token(37);
{if ("" != null) return sem.prog(dcs, lis);}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Programa");
    }
}

  final public DeclaracionesConSep DeclaracionesConSeparador() throws ParseException {
    trace_call("DeclaracionesConSeparador");
    try {
LDecs decs;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case STRUCT:
      case PROC:
      case TYPE:
      case INT:
      case REAL:
      case BOOL:
      case STRING:
      case IDEN:
      case 44:{
        decs = Declaraciones();
        jj_consume_token(38);
{if ("" != null) return sem.declaraciones_con_separador(decs);}
        break;
        }
      default:
        jj_la1[0] = jj_gen;
{if ("" != null) return sem.sin_declaraciones();}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("DeclaracionesConSeparador");
    }
}

  final public LDecs Declaraciones() throws ParseException {
    trace_call("Declaraciones");
    try {
Declaracion dec; LDecs decs;
      dec = Declaracion();
      decs = DeclaracionesPrima(sem.una_dec(dec));
{if ("" != null) return decs;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Declaraciones");
    }
}

  final public LDecs DeclaracionesPrima(LDecs ah) throws ParseException {
    trace_call("DeclaracionesPrima");
    try {
Declaracion dec; LDecs decs;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 39:{
        jj_consume_token(39);
        dec = Declaracion();
        decs = DeclaracionesPrima(sem.muchas_decs(ah, dec));
{if ("" != null) return decs;}
        break;
        }
      default:
        jj_la1[1] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("DeclaracionesPrima");
    }
}

  final public Declaracion Declaracion() throws ParseException {
    trace_call("Declaracion");
    try {
Token id; Tipo tipo; Params params; Prog prog;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TYPE:{
        jj_consume_token(TYPE);
        tipo = Tipo0();
        id = jj_consume_token(IDEN);
{if ("" != null) return (Declaracion) sem.declaracion_type(tipo, id.image).ponFila(id.beginLine).ponCol(id.beginColumn);}
        break;
        }
      case PROC:{
        jj_consume_token(PROC);
        id = jj_consume_token(IDEN);
        jj_consume_token(40);
        params = ListaParametros();
        jj_consume_token(41);
        prog = Programa();
{if ("" != null) return (Declaracion) sem.declaracion_proc(id.image, params, prog).ponFila(id.beginLine).ponCol(id.beginColumn);}
        break;
        }
      case STRUCT:
      case INT:
      case REAL:
      case BOOL:
      case STRING:
      case IDEN:
      case 44:{
        tipo = Tipo0();
        id = jj_consume_token(IDEN);
{if ("" != null) return (Declaracion) sem.declaracion_tipo(tipo, id.image).ponFila(id.beginLine).ponCol(id.beginColumn);}
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Declaracion");
    }
}

  final public Tipo Tipo0() throws ParseException {
    trace_call("Tipo0");
    try {
Tipo t1; Tipo t2;
      t1 = Tipo1();
      t2 = Tipo0Prima(t1);
{if ("" != null) return t2;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Tipo0");
    }
}

  final public Tipo Tipo0Prima(Tipo ah) throws ParseException {
    trace_call("Tipo0Prima");
    try {
Token lit; Tipo res;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 42:{
        jj_consume_token(42);
        lit = jj_consume_token(LIT_ENT);
        jj_consume_token(43);
        res = Tipo0Prima((Tipo) sem.tipo_array(ah, lit.image).ponFila(lit.beginLine).ponCol(lit.beginColumn));
{if ("" != null) return res;}
        break;
        }
      default:
        jj_la1[3] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Tipo0Prima");
    }
}

  final public Tipo Tipo1() throws ParseException {
    trace_call("Tipo1");
    try {
Tipo res1; Tipo res2;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 44:{
        jj_consume_token(44);
        res1 = Tipo1();
{if ("" != null) return sem.tipo_puntero(res1);}
        break;
        }
      case STRUCT:
      case INT:
      case REAL:
      case BOOL:
      case STRING:
      case IDEN:{
        res2 = Tipo2();
{if ("" != null) return res2;}
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Tipo1");
    }
}

  final public Tipo Tipo2() throws ParseException {
    trace_call("Tipo2");
    try {
Token t; Cmps campos;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INT:{
        jj_consume_token(INT);
{if ("" != null) return sem.tipo_int();}
        break;
        }
      case REAL:{
        jj_consume_token(REAL);
{if ("" != null) return sem.tipo_real();}
        break;
        }
      case BOOL:{
        jj_consume_token(BOOL);
{if ("" != null) return sem.tipo_bool();}
        break;
        }
      case STRING:{
        jj_consume_token(STRING);
{if ("" != null) return sem.tipo_string();}
        break;
        }
      case STRUCT:{
        jj_consume_token(STRUCT);
        jj_consume_token(36);
        campos = Campos();
        jj_consume_token(37);
{if ("" != null) return sem.tipo_struct(campos);}
        break;
        }
      case IDEN:{
        t = jj_consume_token(IDEN);
{if ("" != null) return (Tipo) sem.tipo_iden(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Tipo2");
    }
}

  final public Cmps Campos() throws ParseException {
    trace_call("Campos");
    try {
Declaracion dec; Cmps cp;
      dec = Declaracion();
      cp = CamposPrima(sem.un_campo(dec));
{if ("" != null) return cp;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Campos");
    }
}

  final public Cmps CamposPrima(Cmps ah) throws ParseException {
    trace_call("CamposPrima");
    try {
Declaracion dec; Cmps res;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 45:{
        jj_consume_token(45);
        dec = Declaracion();
        res = CamposPrima(sem.muchos_campos(ah, dec));
{if ("" != null) return res;}
        break;
        }
      default:
        jj_la1[6] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("CamposPrima");
    }
}

  final public Params ListaParametros() throws ParseException {
    trace_call("ListaParametros");
    try {
LParam params;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case STRUCT:
      case INT:
      case REAL:
      case BOOL:
      case STRING:
      case IDEN:
      case 44:{
        params = Parametros();
{if ("" != null) return sem.lista_parametros(params);}
        break;
        }
      default:
        jj_la1[7] = jj_gen;
{if ("" != null) return sem.sin_parametros();}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ListaParametros");
    }
}

  final public LParam Parametros() throws ParseException {
    trace_call("Parametros");
    try {
Tipo param; LParam params;
      param = Parametro();
      params = ParametrosPrima(sem.un_parametro(param));
{if ("" != null) return params;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Parametros");
    }
}

  final public LParam ParametrosPrima(LParam ah) throws ParseException {
    trace_call("ParametrosPrima");
    try {
Tipo param; LParam params;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 45:{
        jj_consume_token(45);
        param = Parametro();
        params = ParametrosPrima(sem.muchos_parametros(ah, param));
{if ("" != null) return params;}
        break;
        }
      default:
        jj_la1[8] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ParametrosPrima");
    }
}

  final public Tipo Parametro() throws ParseException {
    trace_call("Parametro");
    try {
Tipo t; Tipo t2;
      t = Tipo0();
      t2 = ParametroPrima(t);
{if ("" != null) return t2;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Parametro");
    }
}

  final public Tipo ParametroPrima(Tipo ah) throws ParseException {
    trace_call("ParametroPrima");
    try {
Token id;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDEN:{
        id = jj_consume_token(IDEN);
{if ("" != null) return (Tipo) sem.parametro(ah, id.image).ponFila(id.beginLine).ponCol(id.beginColumn);}
        break;
        }
      case 46:{
        jj_consume_token(46);
        id = jj_consume_token(IDEN);
{if ("" != null) return (Tipo) sem.parametro_referencia(ah, id.image).ponFila(id.beginLine).ponCol(id.beginColumn);}
        break;
        }
      default:
        jj_la1[9] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ParametroPrima");
    }
}

  final public Insts ListaInstrucciones() throws ParseException {
    trace_call("ListaInstrucciones");
    try {
LIns insts;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case WHILE:
      case READ:
      case WRITE:
      case NEW:
      case DELETE:
      case CALL:
      case NL:
      case EVAL:
      case 36:{
        insts = Instrucciones();
{if ("" != null) return sem.lista_instrucciones(insts);}
        break;
        }
      default:
        jj_la1[10] = jj_gen;
{if ("" != null) return sem.sin_instrucciones();}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ListaInstrucciones");
    }
}

  final public LIns Instrucciones() throws ParseException {
    trace_call("Instrucciones");
    try {
Instruccion inst; LIns insts;
      inst = Instruccion();
      insts = InstruccionesPrima(sem.una_instruccion(inst));
{if ("" != null) return insts;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Instrucciones");
    }
}

  final public LIns InstruccionesPrima(LIns ah) throws ParseException {
    trace_call("InstruccionesPrima");
    try {
Instruccion inst; LIns insts;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 39:{
        jj_consume_token(39);
        inst = Instruccion();
        insts = InstruccionesPrima(sem.muchas_instrucciones(ah, inst));
{if ("" != null) return insts;}
        break;
        }
      default:
        jj_la1[11] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("InstruccionesPrima");
    }
}

  final public Instruccion Instruccion() throws ParseException {
    trace_call("Instruccion");
    try {
Token id; Expresion expAs; Prog prog; Argus args; Else e;Prog p;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case EVAL:{
        jj_consume_token(EVAL);
        expAs = ExpresionAsignacion();
{if ("" != null) return sem.instruccion_eval(expAs);}
        break;
        }
      case IF:{
        jj_consume_token(IF);
        expAs = ExpresionAsignacion();
        prog = Programa();
        e = ElseOpt();
{if ("" != null) return sem.instruccion_if(expAs, prog, e);}
        break;
        }
      case WHILE:{
        jj_consume_token(WHILE);
        expAs = ExpresionAsignacion();
        prog = Programa();
{if ("" != null) return sem.instruccion_while(expAs, prog);}
        break;
        }
      case READ:{
        jj_consume_token(READ);
        expAs = ExpresionAsignacion();
{if ("" != null) return sem.instruccion_read(expAs);}
        break;
        }
      case WRITE:{
        jj_consume_token(WRITE);
        expAs = ExpresionAsignacion();
{if ("" != null) return sem.instruccion_write(expAs);}
        break;
        }
      case NL:{
        jj_consume_token(NL);
{if ("" != null) return sem.instruccion_nl();}
        break;
        }
      case NEW:{
        jj_consume_token(NEW);
        expAs = ExpresionAsignacion();
{if ("" != null) return sem.instruccion_new(expAs);}
        break;
        }
      case DELETE:{
        jj_consume_token(DELETE);
        expAs = ExpresionAsignacion();
{if ("" != null) return sem.instruccion_delete(expAs);}
        break;
        }
      case CALL:{
        jj_consume_token(CALL);
        id = jj_consume_token(IDEN);
        jj_consume_token(40);
        args = ListaArgumentos();
        jj_consume_token(41);
{if ("" != null) return (Instruccion) sem.instruccion_call(id.image, args).ponFila(id.beginLine).ponCol(id.beginColumn);}
        break;
        }
      case 36:{
        p = Programa();
{if ("" != null) return sem.instruccion_programa(p);}
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Instruccion");
    }
}

  final public Else ElseOpt() throws ParseException {
    trace_call("ElseOpt");
    try {
Prog p;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ELSE:{
        jj_consume_token(ELSE);
        p = Programa();
{if ("" != null) return sem.else_opt_else(p);}
        break;
        }
      default:
        jj_la1[13] = jj_gen;
{if ("" != null) return sem.else_opt_vacio();}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ElseOpt");
    }
}

  final public Argus ListaArgumentos() throws ParseException {
    trace_call("ListaArgumentos");
    try {
LArgs args;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TRUE:
      case FALSE:
      case NULL:
      case NOT:
      case IDEN:
      case LIT_ENT:
      case LIT_REAL:
      case LIT_CADENA:
      case 40:
      case 48:{
        args = Argumentos();
{if ("" != null) return sem.lista_argumentos(args);}
        break;
        }
      default:
        jj_la1[14] = jj_gen;
{if ("" != null) return sem.sin_argumentos();}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ListaArgumentos");
    }
}

  final public LArgs Argumentos() throws ParseException {
    trace_call("Argumentos");
    try {
Expresion exp; LArgs args;
      exp = ExpresionAsignacion();
      args = ArgumentosPrima(sem.un_argumento(exp));
{if ("" != null) return args;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Argumentos");
    }
}

  final public LArgs ArgumentosPrima(LArgs ah) throws ParseException {
    trace_call("ArgumentosPrima");
    try {
Expresion exp; LArgs args;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 45:{
        jj_consume_token(45);
        exp = ExpresionAsignacion();
        args = ArgumentosPrima(sem.muchos_argumentos(ah, exp));
{if ("" != null) return args;}
        break;
        }
      default:
        jj_la1[15] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ArgumentosPrima");
    }
}

  final public Expresion ExpresionAsignacion() throws ParseException {
    trace_call("ExpresionAsignacion");
    try {
Expresion er; Expresion e2;
      er = ExpresionRelacional();
      e2 = ExpAsignPrima(er);
{if ("" != null) return e2;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpresionAsignacion");
    }
}

  final public Expresion ExpAsignPrima(Expresion ah) throws ParseException {
    trace_call("ExpAsignPrima");
    try {
Expresion ea; Token op;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 47:{
        op = jj_consume_token(47);
        ea = ExpresionAsignacion();
{if ("" != null) return (Expresion) sem.mkop(op.image,ah, ea).ponFila(op.beginLine).ponCol(op.beginColumn);}
        break;
        }
      default:
        jj_la1[16] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpAsignPrima");
    }
}

  final public Expresion ExpresionRelacional() throws ParseException {
    trace_call("ExpresionRelacional");
    try {
Expresion e; Expresion e2;
      e = ExpresionAditiva();
      e2 = ExpRelPrima(e);
{if ("" != null) return e2;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpresionRelacional");
    }
}

  final public Expresion ExpRelPrima(Expresion ah) throws ParseException {
    trace_call("ExpRelPrima");
    try {
Expresion e; Token op; Expresion e2;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 54:
      case 55:
      case 56:
      case 57:
      case 58:
      case 59:{
        op = OperadorRelacional();
        e = ExpresionAditiva();
        e2 = ExpRelPrima((Expresion) sem.mkop(op.image, ah, e).ponFila(op.beginLine).ponCol(op.beginColumn));
{if ("" != null) return e2;}
        break;
        }
      default:
        jj_la1[17] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpRelPrima");
    }
}

  final public Expresion ExpresionAditiva() throws ParseException {
    trace_call("ExpresionAditiva");
    try {
Expresion eLog; Expresion e1; Expresion e2;
      eLog = ExpresionLogica();
      e1 = ExpAditPrima(eLog);
      e2 = ExpAditPrimaPrima(e1);
{if ("" != null) return e2;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpresionAditiva");
    }
}

  final public Expresion ExpAditPrima(Expresion ah) throws ParseException {
    trace_call("ExpAditPrima");
    try {
Expresion eLog; Token op;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 48:{
        op = jj_consume_token(48);
        eLog = ExpresionLogica();
{if ("" != null) return (Expresion) sem.mkop(op.image, ah, eLog).ponFila(op.beginLine).ponCol(op.beginColumn);}
        break;
        }
      default:
        jj_la1[18] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpAditPrima");
    }
}

  final public Expresion ExpAditPrimaPrima(Expresion ah) throws ParseException {
    trace_call("ExpAditPrimaPrima");
    try {
Expresion eLog; Expresion e1; Token op;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 49:{
        op = jj_consume_token(49);
        eLog = ExpresionLogica();
        e1 = ExpAditPrimaPrima((Expresion) sem.mkop(op.image, ah, eLog).ponFila(op.beginLine).ponCol(op.beginColumn));
{if ("" != null) return e1;}
        break;
        }
      default:
        jj_la1[19] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpAditPrimaPrima");
    }
}

  final public Expresion ExpresionLogica() throws ParseException {
    trace_call("ExpresionLogica");
    try {
Expresion eMul; Expresion e1;
      eMul = ExpresionMultiplicativa();
      e1 = ExpLogicaPrima(eMul);
{if ("" != null) return e1;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpresionLogica");
    }
}

  final public Expresion ExpLogicaPrima(Expresion ah) throws ParseException {
    trace_call("ExpLogicaPrima");
    try {
Expresion e; Token op;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case AND:{
        op = jj_consume_token(AND);
        e = ExpresionLogica();
{if ("" != null) return (Expresion) (sem.mkop(op.image, ah, e).ponFila(op.beginLine).ponCol(op.beginColumn));}
        break;
        }
      case OR:{
        op = jj_consume_token(OR);
        e = ExpresionMultiplicativa();
{if ("" != null) return (Expresion) (sem.mkop(op.image, ah, e).ponFila(op.beginLine).ponCol(op.beginColumn));}
        break;
        }
      default:
        jj_la1[20] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpLogicaPrima");
    }
}

  final public Expresion ExpresionMultiplicativa() throws ParseException {
    trace_call("ExpresionMultiplicativa");
    try {
Expresion eUn; Expresion e1;
      eUn = ExpresionUnaria();
      e1 = ExpMultPrima(eUn);
{if ("" != null) return e1;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpresionMultiplicativa");
    }
}

  final public Expresion ExpMultPrima(Expresion ah) throws ParseException {
    trace_call("ExpMultPrima");
    try {
Expresion eUn; Token op; Expresion e1;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 51:
      case 52:
      case 53:{
        op = OperadorMultiplicativo();
        eUn = ExpresionUnaria();
        e1 = ExpMultPrima((Expresion) sem.mkop(op.image, ah, eUn).ponFila(op.beginLine).ponCol(op.beginColumn));
{if ("" != null) return e1;}
        break;
        }
      default:
        jj_la1[21] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpMultPrima");
    }
}

  final public Expresion ExpresionUnaria() throws ParseException {
    trace_call("ExpresionUnaria");
    try {
Expresion e; Token op; Expresion e1;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case NOT:
      case 48:{
        op = OperadorUnario();
        e = ExpresionUnaria();
{if ("" != null) return (Expresion) sem.mkop(op.image, e,null).ponFila(op.beginLine).ponCol(op.beginColumn);}
        break;
        }
      case TRUE:
      case FALSE:
      case NULL:
      case IDEN:
      case LIT_ENT:
      case LIT_REAL:
      case LIT_CADENA:
      case 40:{
        e1 = ExpresionAcceso();
{if ("" != null) return e1;}
        break;
        }
      default:
        jj_la1[22] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpresionUnaria");
    }
}

  final public Expresion ExpresionAcceso() throws ParseException {
    trace_call("ExpresionAcceso");
    try {
Expresion f; Expresion e1;
      f = Factor();
      e1 = ExpAccesoPrima(f);
{if ("" != null) return e1;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpresionAcceso");
    }
}

  final public Expresion ExpAccesoPrima(Expresion ah) throws ParseException {
    trace_call("ExpAccesoPrima");
    try {
Expresion e; Token id;Expresion e1; Token t;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 42:{
        t = jj_consume_token(42);
        e = ExpresionAsignacion();
        jj_consume_token(43);
        e1 = ExpAccesoPrima((Expresion) sem.expresion_acceso_array(ah, e).ponFila(t.beginLine).ponCol(t.beginColumn));
{if ("" != null) return e1;}
        break;
        }
      case 50:{
        jj_consume_token(50);
        id = jj_consume_token(IDEN);
        e1 = ExpAccesoPrima((Expresion)sem.expresion_acceso_punto(ah, id.image).ponFila(id.beginLine).ponCol(id.beginColumn));
{if ("" != null) return e1;}
        break;
        }
      case 44:{
        t = jj_consume_token(44);
        e1 = ExpAccesoPrima((Expresion) sem.expresion_acceso_puntero(ah).ponFila(t.beginLine).ponCol(t.beginColumn));
{if ("" != null) return e1;}
        break;
        }
      default:
        jj_la1[23] = jj_gen;
{if ("" != null) return ah;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ExpAccesoPrima");
    }
}

  final public Expresion Factor() throws ParseException {
    trace_call("Factor");
    try {
Token t; Expresion e;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 40:{
        jj_consume_token(40);
        e = ExpresionAsignacion();
        jj_consume_token(41);
{if ("" != null) return e;}
        break;
        }
      case LIT_ENT:{
        t = jj_consume_token(LIT_ENT);
{if ("" != null) return (Expresion) sem.factor_literal_entero(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case LIT_REAL:{
        t = jj_consume_token(LIT_REAL);
{if ("" != null) return (Expresion) sem.factor_literal_real(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case FALSE:{
        t = jj_consume_token(FALSE);
{if ("" != null) return (Expresion) sem.factor_literal_bool(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case TRUE:{
        t = jj_consume_token(TRUE);
{if ("" != null) return (Expresion) sem.factor_literal_bool(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case LIT_CADENA:{
        t = jj_consume_token(LIT_CADENA);
{if ("" != null) return (Expresion) sem.factor_literal_cadena(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case NULL:{
        t = jj_consume_token(NULL);
{if ("" != null) return (Expresion) sem.factor_null().ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case IDEN:{
        t = jj_consume_token(IDEN);
{if ("" != null) return (Expresion) sem.factor_identificador(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      default:
        jj_la1[24] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Factor");
    }
}

  final public Token OperadorMultiplicativo() throws ParseException {
    trace_call("OperadorMultiplicativo");
    try {
Token t;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 51:{
        t = jj_consume_token(51);
{if ("" != null) return t;}
        break;
        }
      case 52:{
        t = jj_consume_token(52);
{if ("" != null) return t;}
        break;
        }
      case 53:{
        t = jj_consume_token(53);
{if ("" != null) return t;}
        break;
        }
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("OperadorMultiplicativo");
    }
}

  final public Token OperadorUnario() throws ParseException {
    trace_call("OperadorUnario");
    try {
Token t;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case NOT:{
        t = jj_consume_token(NOT);
{if ("" != null) return t;}
        break;
        }
      case 48:{
        t = jj_consume_token(48);
{if ("" != null) return t;}
        break;
        }
      default:
        jj_la1[26] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("OperadorUnario");
    }
}

  final public Token OperadorRelacional() throws ParseException {
    trace_call("OperadorRelacional");
    try {
Token t;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 54:{
        t = jj_consume_token(54);
{if ("" != null) return t;}
        break;
        }
      case 55:{
        t = jj_consume_token(55);
{if ("" != null) return t;}
        break;
        }
      case 56:{
        t = jj_consume_token(56);
{if ("" != null) return t;}
        break;
        }
      case 57:{
        t = jj_consume_token(57);
{if ("" != null) return t;}
        break;
        }
      case 58:{
        t = jj_consume_token(58);
{if ("" != null) return t;}
        break;
        }
      case 59:{
        t = jj_consume_token(59);
{if ("" != null) return t;}
        break;
        }
      default:
        jj_la1[27] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("OperadorRelacional");
    }
}

  /** Generated Token Manager. */
  public ConstructorASTsTinyTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[28];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x1f0e000,0x0,0x1f0e000,0x0,0x1f02000,0x1f02000,0x0,0x1f02000,0x0,0x1000000,0x103fa,0x0,0x103fa,0x4,0xf081c00,0x0,0x0,0x0,0x0,0x0,0x60000,0x0,0xf081c00,0x0,0xf001c00,0x0,0x80000,0x0,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x1000,0x80,0x1000,0x400,0x1000,0x0,0x2000,0x1000,0x2000,0x4000,0x10,0x80,0x10,0x0,0x10100,0x2000,0x8000,0xfc00000,0x10000,0x20000,0x0,0x380000,0x10100,0x41400,0x100,0x380000,0x10000,0xfc00000,};
	}

  {
      enable_tracing();
  }
  /** Constructor with InputStream. */
  public ConstructorASTsTiny(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ConstructorASTsTiny(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new ConstructorASTsTinyTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ConstructorASTsTiny(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new ConstructorASTsTinyTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new ConstructorASTsTinyTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ConstructorASTsTiny(ConstructorASTsTinyTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ConstructorASTsTinyTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   trace_token(token, "");
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	   trace_token(token, " (in getNextToken)");
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[60];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 28; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 60; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  private int trace_indent = 0;
/** Enable tracing. */
  final public void enable_tracing() {
	 trace_enabled = true;
  }

/** Disable tracing. */
  final public void disable_tracing() {
	 trace_enabled = false;
  }

  protected void trace_call(String s) {
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.println("Call:	" + s);
	 }
	 trace_indent = trace_indent + 2;
  }

  protected void trace_return(String s) {
	 trace_indent = trace_indent - 2;
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.println("Return: " + s);
	 }
  }

  protected void trace_token(Token t, String where) {
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.print("Consumed token: <" + tokenImage[t.kind]);
	   if (t.kind != 0 && !tokenImage[t.kind].equals("\"" + t.image + "\"")) {
		 System.out.print(": \"" + TokenMgrError.addEscapes(t.image) + "\"");
	   }
	   System.out.println(" at line " + t.beginLine + " column " + t.beginColumn + ">" + where);
	 }
  }

  protected void trace_scan(Token t1, int t2) {
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.print("Visited token: <" + tokenImage[t1.kind]);
	   if (t1.kind != 0 && !tokenImage[t1.kind].equals("\"" + t1.image + "\"")) {
		 System.out.print(": \"" + TokenMgrError.addEscapes(t1.image) + "\"");
	   }
	   System.out.println(" at line " + t1.beginLine + " column " + t1.beginColumn + ">; Expected token: <" + tokenImage[t2] + ">");
	 }
  }

}
