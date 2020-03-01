package yal.analyse ;

import java_cup.runtime.*;
import yal.exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{

  private StringBuilder chaine ;

  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

idf = [A-Za-z_][A-Za-z_0-9]*

csteE = [0-9]+

finDeLigne = \r|\n
commentaire = \/\/.*{finDeLigne}
espace = {finDeLigne}  | [ \t\f] | {commentaire}

%%

"programme"            {return symbol(CodesLexicaux.PROGRAMME); }
"debut"                { return symbol(CodesLexicaux.DEBUT); }
"fin"              	   { return symbol(CodesLexicaux.FIN); }

"ecrire"               { return symbol(CodesLexicaux.ECRIRE); }
"lire"                 { return symbol(CodesLexicaux.LIRE);}
"entier"               { return symbol(CodesLexicaux.ENTIER);}
"booleen"              { return symbol(CodesLexicaux.BOOLEAN);}

";"                    { return symbol(CodesLexicaux.POINTVIRGULE); }


"non"                  { return symbol (CodesLexicaux.NON , yytext()); }
"ou"                   { return symbol (CodesLexicaux.OPOU, yytext()); }
"et"                   { return symbol (CodesLexicaux.OPET, yytext()); }


"="                    { return symbol (CodesLexicaux.EGALE); }
"=="                   { return symbol (CodesLexicaux.OPEREGALE); }
"!="                   { return symbol (CodesLexicaux.OPERNEGALE); }


"<"                    { return symbol (CodesLexicaux.PPQ); }
">"                    { return symbol (CodesLexicaux.PGQ); }


"+"                    { return symbol (CodesLexicaux.PLUS); }
"-"                    { return symbol (CodesLexicaux.MOINS); }
"*"                    { return symbol (CodesLexicaux.MULT); }
"/"                    { return symbol (CodesLexicaux.DIV); }


"("                    { return symbol (CodesLexicaux.PARGAUCHE); }
")"                    { return symbol (CodesLexicaux.PARDROITE); }


{csteE}      	       { return symbol(CodesLexicaux.CSTENTIERE, yytext()); }

{idf}     	           { return symbol(CodesLexicaux.IDF, yytext()); }

{espace}               { }
.                      { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }

