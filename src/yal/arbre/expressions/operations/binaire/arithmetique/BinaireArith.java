package yal.arbre.expressions.operations.binaire.arithmetique;

import yal.arbre.expressions.operations.binaire.Binaire;
import yal.arbre.expressions.Expression;

public abstract class BinaireArith extends Binaire {

	protected BinaireArith(Expression expressiongauche, Expression expressiondroite) {
		super(expressiongauche, expressiondroite) ;
		this.setReturnType("int");
	}

	@Override
	public void verifier() {
		this.expgauche.verifier();
		this.expdroite.verifier();
	
	}

}
