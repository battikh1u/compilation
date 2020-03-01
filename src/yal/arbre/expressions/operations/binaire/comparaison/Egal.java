package yal.arbre.expressions.operations.binaire.comparaison;
import yal.arbre.expressions.Expression;


public class Egal extends Comparaison {

    public Egal(Expression expgauche, Expression expdroite) {
        super(expgauche, expdroite);
    }
    
    @Override
    public String operateur() {
        return " == ";
    }
    
	@Override
	public void verifier() {
		this.expgauche.verifier();
		this.expdroite.verifier();
		
	}
	
	public String toMIPS() {
		String mips ;
		int i = getEtiquette();
		mips=super.toMIPS()+
				"# Début égalité\n"+
				"Si"+ i +":\n"+
				"# 1-2\n"+
				"sub $v0, $t8, $v0\n"+
				"# Comparer le resultat avec 0\n"+
				"beqz $v0, Sinon" + i+"\n"+
				"# if !=0 return false\n"+
				"Alors"+ i +":\n"+
				"li $v0, 0\n"+
				"b Fin"+ i +"\n"+
				"# else return true\n"+
				"Sinon"+ i +":\n"+
				"li $v0, 1\n"+
				"Fin"+ i+":\n";
				
		return mips;
	}
}
