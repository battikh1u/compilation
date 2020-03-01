package yal.arbre.expressions.operations.binaire.arithmetique;

import yal.arbre.expressions.Expression;
import yal.outils.Etiquette;


public class Division extends BinaireArith {

    public Division(Expression expressiongauche, Expression expressiondroite) {
        super(expressiongauche, expressiondroite);
    }

    @Override
    public String operateur() {
        return " / ";
    }
    
	@Override
	public void verifier() {
		super.verifier();
		//Affichage du texte mips en cas de division par 0
		Etiquette.getInstance().setDivPar0();
	}
    
	@Override
	public String toMIPS() {
		String mips;
		mips=super.toMIPS()+
			"#verifier si ce n'est pas une division par 0\n"+
			"beqz $v0, divByZero\n"+
			"# div left to right \n"+
			"div $v0, $t8, $v0\n";
		return mips;
	}
}
