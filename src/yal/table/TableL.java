package yal.table;

import yal.exceptions.DoubleDeclarationException;
import yal.exceptions.NotDeclaredException;

import java.util.ArrayList;
import java.util.HashMap;

public class TableL
{
    private HashMap<Entree,Symbole> table;
    private TableL TableMain;
    private ArrayList<TableL> TableFils;
    private int nbBloc;
    private int nbRtn;

    public TableL (int n, TableL TableMain){
        this.table = new HashMap<>();
        this.TableMain = TableMain; // Table de fonction Main
        this.TableFils = new ArrayList<>(); // Table pour autres fonctions
        this.nbBloc = n; //nb de Bloc
        this.nbRtn = 0; //nb de Retourne
    }

    public HashMap<Entree, Symbole> getTable() {
        return table;
    }

    public TableL getTableMain() {
        return TableMain;
    }

    public ArrayList<TableL> getTablefils() {
        return TableFils;
    }

    public int getNbBloc() {
        return nbBloc;
    }

    public int getNbRtn() {
        return nbRtn;
    }

    // Ajouter une entree
    public void Ajouter(Entree ent_e, Symbole s){


        this.table.put(ent_e, s);
    }

    public Symbole Identifier(Entree ent_e) throws NotDeclaredException {
       return table.get(ent_e);
    }

    public void AjouterFils (TableL fils){
        this.TableFils.add(fils);
    }

}