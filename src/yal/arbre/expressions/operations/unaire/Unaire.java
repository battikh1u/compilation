package yal.arbre.expressions.operations.unaire;

import yal.arbre.expressions.Expression;


public abstract class Unaire extends Expression {
    
    protected Expression expression ;

    protected Unaire(Expression expr) {
        super(expr.getNoLigne());
        expression = expr ;
    }
    
    public abstract String operateur() ;

    @Override
    public String toString() {
        return "(" + operateur() + expression + ")" ;
    }
    
    @Override
    public String toMIPS() {
    	String mips;
    	mips="# opération "+
    	        operateur()+
                ", calcul de l'operations\n"+ expression.toMIPS();

    	return mips;
    }

}
