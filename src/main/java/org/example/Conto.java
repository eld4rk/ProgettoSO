package org.example;

public class Conto {
    private String nome;
    private double saldo;
    boolean inTransazione;
    Transazione ultimaTransazione;

    public Conto(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
        this.inTransazione = false;
        this.ultimaTransazione = null;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isInTransazione() {
        return inTransazione;
    }

    public Transazione getUltimaTransazione() {
        return ultimaTransazione;
    }

    public boolean deposita(double somma){
        if(somma>0){
            this.saldo += somma;
            return true;
        }
        return false;
    }

    public boolean preleva(double somma){
        if(somma>0 && somma<=this.saldo){
            this.saldo -= somma;
            return true;
        }
        return false;
    }
}
