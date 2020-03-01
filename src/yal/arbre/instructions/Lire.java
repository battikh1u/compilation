package yal.arbre.instructions;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Idf;

public class Lire extends Instruction {
    private Idf var;
    public Lire(int n, String nom) {
        super(n);
        this.var=new Idf(n,nom);
    }

    @Override
    public void verifier() {
        var.verifier();
    }

    @Override
    public String toMIPS() {
        String mips="#debut Lire\n"+"li $v0, 5\n"+"syscall\n"+"sw $v0,"+var.getSymbole().getDecal()+"($sp)\n";
        return mips;
    }
}
