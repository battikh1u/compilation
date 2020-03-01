package yal.arbre.expressions.operations.binaire.logique;


import yal.arbre.expressions.Expression;

public class EtLogiqueBinaire extends LogiqueBinaire {

    public EtLogiqueBinaire(Expression expgauche, Expression expdroite) {
        super(expgauche, expdroite);
    }
    
    @Override
    public String operateur() {
        return " et " ;
    }
	
	@Override
	public String toMIPS() {
		StringBuilder mips= new StringBuilder();
		mips.append(super.toMIPS());
		mips.append("# et logique\n");
		mips.append("and $v0, $t8, $v0\n");
		return mips.toString();
	}
}
