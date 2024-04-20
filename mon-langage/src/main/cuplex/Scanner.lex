package generated.fr.ul.miage.rs.langage;
import java_cup.runtime.Symbol;

%%
/* options */
%line
%public
%cupsym Sym
%cup

%{
	void erreur(){
		System.out.println("Caractère inattendu");
		System.exit(1);
	}
%}
/* macros */
SEP	= [ \t\r\n]
NUM = [0-9]+
COM	= #.*\n
IDF = [a-zA-Z] [a-zA-Z0-9]*
%%
/* règles */
/* règles pour les opérateurs */
"<"     { return new Symbol(Sym.INF); }
">"     { return new Symbol(Sym.SUP); }
">="    { return new Symbol(Sym.SUPE); }
"<="    { return new Symbol(Sym.INFE); }
"=="    { return new Symbol(Sym.EG); }
"!="    { return new Symbol(Sym.DIFF);}
"="     { return new Symbol(Sym.AFFE);}
"+"		{ return new Symbol(Sym.ADD);}
"*"		{ return new Symbol(Sym.MUL);}
"-"		{ return new Symbol(Sym.SOUS);}
"/"		{ return new Symbol(Sym.DIV);}
"("		{ return new Symbol(Sym.PO);}
")"		{ return new Symbol(Sym.PF);}
"{"		{ return new Symbol(Sym.AO);}
"}"		{ return new Symbol(Sym.AF);}
{NUM}	{ return new Symbol(Sym.NUM, Integer.valueOf(yytext()));}
{SEP}	{;}
{COM}	{;}
","  { return new Symbol(Sym.VIRGULE);}
";"   { return new Symbol(Sym.PVIRGULE);}
<<EOF>>	{ return new Symbol(Sym.EOF);}
"si"	{ return new Symbol(Sym.SI);}
"sinon"	{ return new Symbol(Sym.SINON);}
"ecrire"	{ return new Symbol(Sym.ECRIRE);}
"lire"	{ return new Symbol(Sym.LIRE);}
"tantque"	{ return new Symbol(Sym.TANTQUE);}
"retourne" { return new Symbol(Sym.RETOURNE);}
"vide"	{ return new Symbol(Sym.VIDE);}
"entier"	{ return new Symbol(Sym.ENTIER);}
{IDF}	{ return new Symbol(Sym.IDF,yytext());}
.		{erreur();}