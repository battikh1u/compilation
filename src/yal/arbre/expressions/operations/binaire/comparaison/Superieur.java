package yal.arbre.expressions.operations.binaire.comparaison;
import yal.arbre.expressions.Expression;


public class Superieur extends Comparaison {

    public Superieur(Expression expgauche, Expression expdroite) {
        super(expgauche, expdroite);
    }

    @Override
    public String operateur() {
        return " > ";
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
				"# Début sup\n"+
				"Si"+ i +":\n"+
				"# 1-2\n"+
				"sub $v0, $t8, $v0\n"+
				"# Comparer le resultat avec 0\n"+
				"bgtz $v0, Alors" + i +"\n"+
				"# else <=0 return false\n"+
				"Sinon"+ i +":\n"+
				"li $v0, 0\n"+
				"b Fin"+ i +"\n"+
				"# if >0 return true\n"+
				"Alors"+ i +":\n"+
				"li $v0, 1\n"+
				"Fin"+ i +":\n";
				
		return mips.toString();
	}

}
