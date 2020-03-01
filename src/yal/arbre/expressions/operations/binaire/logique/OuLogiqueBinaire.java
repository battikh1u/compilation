package yal.arbre.expressions.operations.binaire.logique;

import yal.arbre.expressions.Expression;

public class OuLogiqueBinaire extends LogiqueBinaire {

    public OuLogiqueBinaire(Expression expgauche, Expression expdroite) {
        super(expgauche, expdroite);
    }
    
    @Override
    public String operateur() {
        return " ou " ;
    }
	
	@Override
	public String toMIPS() {
		StringBuilder mips = new StringBuilder();
		mips.append(super.toMIPS());
		mips.append("# ou logique \n");
		mips.append("or $v0, $t8, $v0\n");
		return mips.toString();
	}
    
}
