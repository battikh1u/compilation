package yal.arbre.expressions.operations.binaire.comparaison;


import yal.arbre.expressions.Expression;

public class Different extends Comparaison {

	public Different(Expression expgauche, Expression expdroite) {
		super(expgauche, expdroite);
	}

	@Override
	public String operateur() {
		return " != ";
	}
	
	@Override
	public void verifier() {
		this.expgauche.verifier();
		this.expdroite.verifier();
		
	}
	
	@Override
	public String toMIPS() {
		String mips;
		int i = getEtiquette();
		mips=super.toMIPS()+
				"# Début different\n"+
				"Si"+ i +":\n"+
				"# comp1-comp2\n"+
				"sub $v0, $t8, $v0\n"+
				"# comparer le resultat obtenu avec 0\n"+
				"beqz $v0, Sinon" + i +"\n"+
				"# if !=0 then return true\n"+
				"Alors"+ i +":\n"+
				"li $v0, 1\n"+
				"b Fin"+ i +"\n"+
				"# else return false\n"+
				"Sinon"+ i +":\n"+
				"li $v0, 0\n"+
				"Fin"+ i +":\n";
		return mips;
	}
	
	

}
