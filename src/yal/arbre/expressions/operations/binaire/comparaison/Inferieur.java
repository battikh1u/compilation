package yal.arbre.expressions.operations.binaire.comparaison;

import yal.arbre.expressions.Expression;

public class Inferieur extends Comparaison {

    public Inferieur(Expression expgauche, Expression expdroite) {
        super(expgauche, expdroite);
    }

    @Override
    public String operateur() {
        return " < ";
    }

	@Override
	public void verifier() {
		this.expgauche.verifier();
		this.expdroite.verifier();
		
	}
    
    @Override
	public String toMIPS() {
		String mips = "";
		int i = getEtiquette();
		mips=mips+super.toMIPS()+"# Début inférieur\n"+
				"Si"+ i +":\n"+
				"# 1-2\n" +"sub $v0, $t8, $v0\n"+
				"# Comparer le résultat avec 0\n"+"bltz $v0, Alors" + i +"\n"+
				"# if >=0 then return true\n"+
				"Sinon"+ i +":\n"+
				"li $v0, 0\n"+
				"b Fin"+ i +"\n"+
				"# else return true\n"+
				"Alors"+ i +":\n"+
				"li $v0, 1\n"+
				"Fin"+ i +":\n";
		return mips;
	}
}
