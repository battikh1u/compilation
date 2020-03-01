package yal.arbre.instructions;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.Idf;
import yal.exceptions.NotDeclaredException;
import yal.table.Tds;

public class Affectation extends Instruction{
    private Idf var;
    private Expression exp;
    public Affectation(int n,String nom,Expression expression) {
        super(n);
        this.var=new Idf(n,nom);
        this.exp=expression;

    }

    @Override
    public void verifier() {
       /* if (var.getEntree().equals(null)){
            throw new NotDeclaredException(n)
        }*/
        var.verifier();
        exp.verifier();

    }

    @Override
    public String toMIPS() {
        //this.var.getSymbole().setDecal(-4);

        String mips="\n#affectation\n";
        mips += exp.toMIPS();
        mips = mips+"sw $v0,"+var.getSymbole().getDecal()+"($sp)";
        return mips;
    }
}
