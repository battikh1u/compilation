package yal.arbre.expressions;

import yal.exceptions.NotDeclaredException;
import yal.table.*;

public class Idf extends Expression {
    private String nom;
    private EntreeVar entreeVar;
    private Tds tds;
    public Idf(int n,String nom) {
        super(n);
        this.nom=nom;
        entreeVar=new EntreeVar(nom);
    }

    @Override
    public void verifier() {
        try {
            Tds.getInstance().identifier(entreeVar);
        }
        catch (NotDeclaredException e){
            System.out.println(e);
        }
    }

    @Override
    public String toMIPS() {
        Symbole symbole= Tds.getInstance().identifier(entreeVar);
        symbole.setDecal(-4);
        System.out.println(symbole.getDecal());
        int indice=symbole.getDecal();
        String tomips="lw $v0,"+indice+"($sp)\n";
        return tomips;
    }
    public Symbole getSymbole(){
        return Tds.getInstance().identifier(entreeVar);
    }
    public Entree getEntree(){
        return entreeVar;
    }

}
