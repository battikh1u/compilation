package yal.arbre.expressions;

import yal.arbre.ArbreAbstrait;
import yal.table.Symbole;

public abstract class Expression extends ArbreAbstrait {
    private Symbole type;
    protected Expression(int n) {
        super(n) ;
    }

}
