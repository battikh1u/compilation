package yal.arbre.expressions.operations;

import yal.arbre.BlocDInstructions;
import yal.arbre.expressions.Expression;
import yal.arbre.instructions.Instruction;
import yal.outils.Etiquette;

public class Condition extends Instruction {
	
	private BlocDInstructions bloc1;
	private BlocDInstructions bloc2;
	private Expression expression;

	public Condition(Expression e, int n) {
		super(n);
		expression = e;
	}
	
	public void ajouterSi(BlocDInstructions b) {
		bloc1 = b;
	}
	
	public void ajouterSinon(BlocDInstructions b) {
		bloc2 = b;
	}
	
	@Override
	public void verifier() {
		expression.verifier();
		if (bloc1 != null) {
			bloc1.verifier();
		}
		if (bloc2 != null) {
			bloc2.verifier();
		}
	}

	@Override
	public String toMIPS() {
		// Demande une étiquette
		int i = Etiquette.getInstance().getNbEtiquetteSi();
		Etiquette.getInstance().setNbEtiquetteSi();
		String mips;
		mips="# Début du Si " + i + ": évaluation de expr\n"+
		expression.toMIPS()+ "beqz $v0, Sinon" + i + "\n"+
		"#Si " + i + " bloc si\n";
		if (bloc1 != null) {
			mips=mips+bloc1.toMIPS();
		}
		mips=mips+"b FinSi" + i + "\n"+"#Si " + i + " bloc sinon\n"+ "Sinon" + i + ":\n";
		if (bloc2 != null) {
			mips=mips+bloc2.toMIPS();
		}
		
		mips=mips+"FinSi" + i + ":\n";
		
		return mips;
	}

}
