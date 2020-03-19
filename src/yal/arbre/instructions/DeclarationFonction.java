package yal.arbre.instructions;

import yal.arbre.BlocDInstructions;
import yal.arbre.instructions.Instruction;
import yal.table.Tds;

public class DeclarationFonction extends Instruction {
    private BlocDInstructions bloc;
    private String idf;
    private int numerobloc;
    public DeclarationFonction(int n,String idf,int numerobloc) {
        super(n);
        this.idf=idf;
        this.numerobloc=numerobloc;
    }

    @Override
    public void verifier() {

    }

    public void ajouter (BlocDInstructions bloc){
        this.bloc=bloc;
    }

    @Override
    public String toMIPS() {
        StringBuilder sb  = new StringBuilder();
        sb.append("#Declaration de la fonction");
        sb.append("j fnctjump"+ Tds.getInstance().getNbFonction()+"\n");
        Tds.getInstance().entreeBloc(numerobloc);
        sb.append(this.idf+":\n");
        //Empile l'adresse de retoure
        sb.append("sw $ra, ($s7)\n");
        sb.append("addi $sp, #s7, -4");
        sb.append("sw $s2, ($s7)\n");
        sb.append("addi $s7, $s7, -4");
        sb.append("li $v0" +this.numerobloc +"\n");
        sb.append("sw $v0,($s7)\n");
        sb.append("addi $s7,$s7,-4\n");
        sb.append("move $s2,$s7");
        sb.append(this.bloc.toMIPS());
        Tds.getInstance().sortieBloc(this.numerobloc);
        sb.append("fnctjump"+Tds.getInstance().getNbFonction()+":\n");
        return sb.toString();

    }
}
