package yal.arbre.expressions.operations.binaire.comparaison;

import yal.arbre.expressions.operations.binaire.Binaire;
import yal.arbre.expressions.Expression;
import yal.outils.Etiquette;

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression expgauche, Expression expdroite) {
        super(expgauche, expdroite);
    }
    
    public int getEtiquette() {
		int etiquette = Etiquette.getInstance().getNbEtiquetteSi();
		Etiquette.getInstance().setNbEtiquetteSi();
		return etiquette;
	}

}
