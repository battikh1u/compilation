package yal.arbre.expressions.operations.binaire.arithmetique;

import yal.arbre.expressions.Expression;


public class Soustraction extends BinaireArith {

    public Soustraction(Expression expgauche, Expression expdroite) {
        super(expgauche, expdroite);
    }

    @Override
    public String operateur() {
        return " - ";
    }

	@Override
	public String toMIPS() {
		String mips;
		mips=super.toMIPS()+
				"# soustraction\n"+
				"sub $v0, $t8, $v0\n";
		return mips;
	}
}
