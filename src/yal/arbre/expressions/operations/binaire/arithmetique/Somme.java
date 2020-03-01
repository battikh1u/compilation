package yal.arbre.expressions.operations.binaire.arithmetique;

import yal.arbre.expressions.Expression;

public class Somme extends BinaireArith {

    public Somme(Expression expgauche, Expression expdroite) {
        super(expgauche, expdroite);
    }
    
    @Override
    public String operateur() {
        return " + " ;
    }

	@Override
	public String toMIPS() {
		String mips;
		mips=super.toMIPS()+
				"# Somme\n"+
				"add $v0, $v0, $t8\n";
		return mips;
	}

}
