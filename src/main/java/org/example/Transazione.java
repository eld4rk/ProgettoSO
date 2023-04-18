package org.example;

public class Transazione {
    private Conto conto1;
    private Conto conto2;
    private double somma;
    private boolean completata;

    public Transazione(Conto conto1, Conto conto2, double somma) {
        this.conto1 = conto1;
        this.conto2 = conto2;
        this.somma = somma;
        this.completata = false;
    }

    public boolean esegui(){
        if(!conto1.isInTransazione() && !conto2.isInTransazione()){
            conto1.inTransazione = true;
            conto2.inTransazione = true;
            if(conto1.preleva(somma) && conto2.deposita(somma)){
                conto1.inTransazione = false;
                conto2.inTransazione = false;
                conto1.ultimaTransazione = this;
                conto2.ultimaTransazione = this;
                completata = true;
                return true;
            }
            conto1.inTransazione = false;
            conto2.inTransazione = false;
        }
        return false;
    }

    public boolean isCompletata() {
        return completata;
    }
}
