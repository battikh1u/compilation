package yal.table;

import yal.exceptions.AnalyseLexicaleException;
import yal.exceptions.AnalyseSemantiqueException;
import yal.exceptions.DoubleDeclarationException;
import yal.exceptions.NotDeclaredException;

import java.util.*;

public class Tds {
    private HashMap<Entree,Symbole> table;
    private int taille;
    private static final Tds instance=new Tds();
    private TableL TableMain;
    private TableL TableFils;
    private int bloc;

    public int getNbFonction() {
        return nbFonction;
    }

    public void setNbFonction(int nbFonction) {
        this.nbFonction = nbFonction;
    }

    private int nbFonction;
    private ArrayList<AnalyseSemantiqueException> ExceptionsSemantique = new ArrayList<>();
    private ArrayList<DoubleDeclarationException> DDE = new ArrayList<>();
    public Tds(){
        table=new HashMap<>();
        taille=0;
        nbFonction=0;
        bloc=0;
    }
    public static Tds getInstance(){
        return  instance;
    }
    public void ajouter(Entree e,Symbole s, int ligne) throws DoubleDeclarationException {
        if (table.containsKey(e)){
            throw  new DoubleDeclarationException(ligne,e.getNomEntree());
        }
        s.setDecal(taille);
        table.put(e,s);
        if (s.getClass().equals(SymboleFonction.class)){
            nbFonction++;
        }
        taille=taille-4;
    }

    public Symbole identifier(Entree entree,int ligne) throws NotDeclaredException {
        if (!table.containsKey(entree)){
            throw  new NotDeclaredException(ligne, entree.getNomEntree());
        }
        return table.get(entree);
    }
    public int getTailleZoneVariable(){
        return taille;
    }
    // Creation de la table Main
    public void entreeBloc () {
        TableL tableL = new TableL(this.bloc,this.TableFils);
        this.TableFils.AjouterFils(tableL);
        this.TableFils = tableL;
    }

    public void entreeBloc (int bloc){
        for (TableL tableMain : this.TableFils.getTablefils()){
            if (tableMain.getNbBloc()==bloc){
                this.TableFils= tableMain;
            }
        }
    }

    public void sortieBloc (int bloc){
        this.TableFils = this.TableFils.getTableMain();
    }

    public void ajouterMain (Entree entree, Symbole s){
        this.TableMain.Ajouter(entree,s);
    }

    public Symbole identifierMain (Entree entree){
        return this.TableMain.Identifier(entree);
    }

    public void AjouterException(DoubleDeclarationException dde){
        this.DDE.add(dde);
    }
    public void AjouterException(AnalyseSemantiqueException ASE){
        this.ExceptionsSemantique.add(ASE);
    }

    public void accrementerNumbloc(){
        bloc++;
    }

    public int getBloc() {
        return bloc;
    }
}
