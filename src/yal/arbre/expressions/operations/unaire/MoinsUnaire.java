package yal.arbre.expressions.operations.unaire;

import yal.arbre.expressions.Expression;

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expression) {
        super(expression);
  
    }

    @Override
    public String operateur() {
        return "- " ;
    }

	@Override
	public void verifier() {
	
	}
	
	@Override
	public String toMIPS() {
		// -x = inverser tous les bits et on ajoute 1
		String mips;
		mips=super.toMIPS()+
			"# moins unaire\n"+
			"xori $v0, $v0, 0xFFFFFFFF\n"+
			"addi $v0, $v0, 1\n";
		return mips;
	}
}
