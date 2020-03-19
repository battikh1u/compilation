package yal.arbre.instructions;

import yal.arbre.BlocDInstructions;
import yal.arbre.expressions.Expression;
import yal.arbre.instructions.Instruction;

public class RetourneFonction extends Instruction {
    private Expression expression;


    public RetourneFonction(int n, Expression expression) {
        super(n);
        this.expression=expression;
    }

    @Override
    public void verifier() {
        expression.verifier();
    }

    @Override
    public String toMIPS() {
        StringBuilder sb  = new StringBuilder();
        sb.append("#debut de la partie retour");
        sb.append(this.expression.toMIPS());
        sb.append("addi $s7, $s7, 4");
        sb.append("lw $v0, 0($s7)\n");
        sb.append("addi $s7, $s7, 8\n");
        sb.append("addi $s7, $s7, 4");
        sb.append("lw $ra, ($s7)\n");
        sb.append("move $s2, $t8\n");
        sb.append("sw $v0, ($s7)");
        sb.append("addi $s7, $s7, -4\n");
        sb.append("jr $ra\n");
        return sb.toString();
    }
}
