package yal.table;

import java.util.Objects;

public abstract class Entree {
    private String nomEntree;
    public Entree(String nom){
        this.nomEntree=nom;
    }

    public String getNomEntree() {
        return nomEntree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entree entree = (Entree) o;
        return Objects.equals(nomEntree, entree.nomEntree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomEntree);
    }
}
