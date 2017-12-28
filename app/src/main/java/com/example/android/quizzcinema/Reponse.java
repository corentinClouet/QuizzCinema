package com.example.android.quizzcinema;

/**
 * Created by Corentin on 17/12/2017.
 */

public class Reponse {
    private String reponse;
    private boolean estLaBonneReponse;

    public Reponse(){
        reponse = "";
        estLaBonneReponse = false;
    }

    public Reponse(String pReponse, boolean pEstLaBonneReponse){
        reponse = pReponse;
        estLaBonneReponse = pEstLaBonneReponse;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public boolean getEstLaBonneReponse() {
        return estLaBonneReponse;
    }

    public void setEstLaBonneReponse(boolean estLaBonneReponse) {
        this.estLaBonneReponse = estLaBonneReponse;
    }
}
