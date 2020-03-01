package yal.arbre;

import java.util.ArrayList;

/**
 * 21 novembre 2018
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArrayList<ArbreAbstrait> programme ;

    public BlocDInstructions(int n) {
        super(n) ;
        programme = new ArrayList<>() ;
    }
    
    public void ajouter(ArbreAbstrait a) {
        programme.add(a) ;
    }
    
    @Override
    public String toString() {
        return programme.toString() ;
    }

    @Override
    public void verifier() {
        for (ArbreAbstrait arb: programme) {
            arb.verifier();
        }
    }
    
    @Override
    public String toMIPS() {

        StringBuilder fichiermips = new StringBuilder();

        for (ArbreAbstrait inst: programme) {
            fichiermips.append(inst.toMIPS());
        }
        return fichiermips.toString();
        //throw new UnsupportedOperationException("Not supported yet.");

    }

}
