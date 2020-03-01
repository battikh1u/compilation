package yal.exceptions;

public class DoubleDeclarationException extends AnalyseException {
    public DoubleDeclarationException(int ligne, String m) {
        super("Erreur double declaration "+m +" ligne:"+ ligne +  "\n");
    }
}
