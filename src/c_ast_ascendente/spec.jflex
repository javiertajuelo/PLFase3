package alex;

import errors.GestionErroresEval;

%%
%line
%column
%class AnalizadorLexicoEval
%type  UnidadLexica
%unicode
%public
%cup
%{
	private GestionErroresEval errores;
	private ALexOperations ops;
	public String lexema() {return yytext();}
	public int fila() {return yyline+1;}
	public int columna() {return yycolumn+1;}
 	public void fijaGestionErrores(GestionErroresEval errores) {
   	this.errores = errores;
  	}	
%}

%eofval{
	return ops.unidadEof();
%eofval}

%init{
	ops = new ALexOperations(this);
%init}

letra = ([A-Z]|[a-z])
subrayado = \_
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = ({digitoPositivo}{digito}* | 0)
parteDecimal = ({digito}* {digitoPositivo} | 0)
parteExponencial = [eE][\+\-]?{parteEntera}

iden = ({letra} | {subrayado})({letra} | {digito} | {subrayado})*
litEntero = [\+\-]?{parteEntera}
litReal = [\+\-]?{parteEntera}(\.{parteDecimal}{parteExponencial} | \.{parteDecimal} | {parteExponencial})
litCadena = \"([^\"])*\"
litBool = (true | false | null)

eval = @
opSuma = \+
opResta = \-
opMul =\*
opDiv = \/
opModulo = \%
puntero = \^
referencia = &
finDecl = &&

opMenor = <
opMayor = >
opMenIgual = <=
opMayIgual = >=
opIgual = ==
opDistinto = "!="
opAsignacion = =

parAp = \(
parCierre = \)
corAp = \[
corCierre = \]
llaveAp = \{
llaveCierre = \}

puntoYComa = ;
coma = ,
punto = \.

and = [aA][nN][dD]
or = [oO][rR]
not = [nN][oO][tT]
int = [iI][nN][tT]
real = [rR][eE][aA][lL]
bool = [bB][oO][oO][lL]
string = [sS][tT][rR][iI][nN][gG]
null = [nN][uU][lL][lL]
true = [tT][rR][uU][eE]
false = [fF][aA][lL][sS][eE]
proc = [pP][rR][oO][cC]
if = [iI][fF]
else = [eE][lL][sS][eE]
while = [wW][hH][iI][lL][eE]
struct = [sS][tT][rR][uU][cC][tT]
new = [nN][eE][wW]
delete = [dD][eE][lL][eE][tT][eE]
read = [rR][eE][aA][dD]
write = [wW][rR][iI][tT][eE]
nl = [nN][lL]
type = [tT][yY][pP][eE]
call = [cC][aA][lL][lL]

separador = [ \t\r\b\n]
comentario = ##[^\n]*

%%
{separador} 	{}
{comentario} 	{}

{int}			{return ops.unidadInt();}
{real}			{return ops.unidadReal();}
{bool}			{return ops.unidadBool();}
{string}		{return ops.unidadString();}
{null}			{return ops.unidadNull();}
{true}			{return ops.unidadTrue();}
{false}			{return ops.unidadFalse();}
{proc}			{return ops.unidadProc();}
{if}			{return ops.unidadIf();}
{else}			{return ops.unidadElse();}
{while}			{return ops.unidadWhile();}
{struct}		{return ops.unidadStruct();}
{new}			{return ops.unidadNew();}
{delete}		{return ops.unidadDelete();}
{read}			{return ops.unidadRead();}
{write}			{return ops.unidadWrite();}
{nl}			{return ops.unidadNl();}
{type}			{return ops.unidadType();}
{call}			{return ops.unidadCall();}

{eval}			{return ops.unidadEval();}

{litBool}		{return ops.unidadLitBool();}

{and}			{return ops.unidadAnd();}
{or}		 	{return ops.unidadOr();}
{not}		 	{return ops.unidadNot();}

{litCadena}		{return ops.unidadLitCadena();}
{litEntero}		{return ops.unidadLitEntero();}
{litReal}		{return ops.unidadLitReal();}
{iden}			{return ops.unidadIden();}

{opSuma} 		{return ops.unidadSuma();}
{opResta} 		{return ops.unidadResta();}
{opMul} 		{return ops.unidadMul();}
{opDiv} 		{return ops.unidadDiv();}
{opModulo}		{return ops.unidadModulo();}

{opMenor}		{return ops.unidadMenor();}
{opMayor}		{return ops.unidadMayor();}
{opMenIgual}	{return ops.unidadMenIgual();}
{opMayIgual}	{return ops.unidadMayIgual();}
{opIgual}		{return ops.unidadIgual();}
{opDistinto}	{return ops.unidadDistinto();}
{opAsignacion}	{return ops.unidadAsignacion();}

{puntero}		{return ops.unidadPuntero();}
{finDecl}		{return ops.unidadFinDecl();}
{referencia}	{return ops.unidadReferencia();}

{parAp}			{return ops.unidadParAp();}
{parCierre}		{return ops.unidadParCierre();}
{corAp}			{return ops.unidadCorAp();}
{corCierre}		{return ops.unidadCorCierre();}
{llaveAp}		{return ops.unidadLlaveAp();}
{llaveCierre}	{return ops.unidadLlaveCierre();}

{puntoYComa}	{return ops.unidadPuntoYComa();}
{coma}			{return ops.unidadComa();}
{punto}			{return ops.unidadPunto();}

[^]                     {errores.errorLexico(fila(),columna(),lexema());}  