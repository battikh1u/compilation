package yal.table;

public class SymboleFonction extends Symbole {
    private String type;
    public SymboleFonction() {
        type="fonction";
    }
    public String getType(){
        return type;
    }
    @Override
    public void setDecal(int decal) {
        super.setDecal(decal);
    }

    @Override
    public int getDecal() {
        return super.getDecal();
    }
}
