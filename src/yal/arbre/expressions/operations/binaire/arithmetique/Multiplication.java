package yal.arbre.expressions.operations.binaire.arithmetique;

import yal.arbre.expressions.Expression;


public class Multiplication extends BinaireArith {

    public Multiplication(Expression expgauche, Expression expdroite) {
        super(expgauche, expdroite);
    }
  
    @Override
    public String operateur() {
        return " * ";
    }
    
	@Override
	public String toMIPS() {
		String mips;
		mips=super.toMIPS()+
			"# multiplication\n"+
			"mult $v0, $t8\n"+
			"mflo $v0\n";
		return mips;
	}
}
