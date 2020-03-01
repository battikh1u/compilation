package yal.arbre.expressions.operations;

import yal.arbre.BlocDInstructions;
import yal.arbre.expressions.Expression;
import yal.arbre.instructions.Instruction;
import yal.outils.Etiquette;

public class Boucle extends Instruction {

	private BlocDInstructions bloc;
	private Expression expression;
	
	public Boucle(Expression e, int n) {
		super(n);
		expression = e;
	}

	public void ajouter(BlocDInstructions b) {
		bloc = b;
	}
	
	@Override
	public void verifier() {
		expression.verifier();
		bloc.verifier();
	}

	
	@Override
	public String toMIPS() {
		// Demande une étiquette
		int i = Etiquette.getInstance().getNbTant();
		Etiquette.getInstance().setNbTant();
		String mips;
		mips="# Début du Tantque " + i + ": label + évaluation de expr\n"+
				"Tantque" + i + " :\n"+
				expression.toMIPS()+
				"beqz $v0, FinTantque" + i + "\n"+
				"#Tantque " + i + " bloc instruction\n"+
				bloc.toMIPS()+
				"b Tantque" + i + "\n"+
				"FinTantque" + i + ":\n";
		
		return mips;
	}

}
