package yal.arbre.expressions.operations.binaire;

import yal.arbre.expressions.Expression;

public abstract class Binaire extends Expression {
    
    protected Expression expgauche ;
    protected Expression expdroite ;
    protected String type;
    protected Binaire(Expression expgauche, Expression expdroite) {
        super(expgauche.getNoLigne());
        this.expgauche = expgauche;
        this.expdroite = expdroite;
    }
    
    public abstract String operateur() ;
    public void setReturnType(String type){
        this.type=type;
    }
    @Override
    public String toString() {
        return "(" + expgauche + operateur() + expdroite + ")" ;
    }
    
    @Override
    public String toMIPS() {
		StringBuilder mips = new StringBuilder();
		mips.append("# opération ");
		mips.append(operateur());
		
		mips.append(", calcul de l'expression de gauche\n");
		mips.append(expgauche.toMIPS());
		
		mips.append("# empiler l'expression de gauche\n");
		
		mips.append("sw $v0, 0($sp)\n");
		mips.append("addi $sp, $sp, -4\n");
		
		mips.append("# calcul de l'expression de droite\n");
		mips.append(expdroite.toMIPS());
		
		mips.append("# depiler l'expression de  gauche dans $t8\n");
		mips.append("addi $sp, $sp, 4\n");
		mips.append("lw $t8, 0($sp)\n");
		return mips.toString();
    }

}
