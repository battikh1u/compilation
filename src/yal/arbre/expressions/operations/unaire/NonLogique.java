package yal.arbre.expressions.operations.unaire;

import yal.arbre.expressions.Expression;

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expression) {
        super(expression);
        
    }

    @Override
    public String operateur() {
        return " non " ;
    }

	@Override
	public void verifier() {
		
	}
	
	@Override
	public String toMIPS() {
		String mips;
		mips=super.toMIPS()+
		"#non logique\n"+
		"xori $v0, $v0, 1\n";
		return mips;
	}
    
}
