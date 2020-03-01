package yal.table;

public class SymboleEntier extends Symbole {
    private String type;
    private  int decal;
    public SymboleEntier() {

    }

    @Override
    public void setDecal(int decal) {
        super.setDecal(decal);
    }

    @Override
    public int getDecal() {
        return super.getDecal();
    }

    public String getType() {
        type="entier";
        return type;
    }
}
