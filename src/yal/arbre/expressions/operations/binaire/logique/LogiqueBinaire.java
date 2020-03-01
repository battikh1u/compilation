package yal.arbre.expressions.operations.binaire.logique;

import yal.arbre.expressions.operations.binaire.Binaire;
import yal.arbre.expressions.Expression;


public abstract class LogiqueBinaire extends Binaire {

    protected LogiqueBinaire(Expression expgauche, Expression expdroite) {
        super(expgauche, expdroite) ;

    }
    
	@Override
	public void verifier() {
		this.expgauche.verifier();
		this.expdroite.verifier();
		
	}
}
