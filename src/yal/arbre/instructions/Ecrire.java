package yal.arbre.instructions;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Idf;
import yal.exceptions.NotDeclaredException;
import yal.table.Entree;
import yal.table.Tds;

public class Ecrire extends Instruction {

    protected Expression exp ;

    public Ecrire (Expression e, int n) throws NotDeclaredException {
        super(n) ;
        exp = e ;
    }


    @Override
    public void verifier() {
        exp.verifier();
    }

    @Override
    public String toMIPS() {
        String stringMIPS = "#instruction:\n"+"li $v0,1\n"+/*exp.toMIPS()+*/"syscall\n";
        return stringMIPS;
    }

}
