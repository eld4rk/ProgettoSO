package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    private HashMap<String, Conto> conti;
    private ArrayList<Transazione> transazioni;


    public Server() {
        this.conti = new HashMap<String, Conto>();
        this.transazioni = new ArrayList<Transazione>();
    }


    public boolean apriConto(String nome) {
        if (!conti.containsKey(nome)) {
            conti.put(nome, new Conto(nome, 0));
            return true;
        }
        return false;
    }

    public boolean chiudiConto(String nome) {
        if (conti.containsKey(nome)) {
            conti.remove(nome);
            return true;
        }
        return false;
    }

    public boolean eseguiTransazione(String nome1, String nome2, double somma) {
        if (conti.containsKey(nome1) && conti.containsKey(nome2)) {
            Transazione t = new Transazione(conti.get(nome1), conti.get(nome2), somma);
            if (t.esegui()) {
                transazioni.add(t);
                return true;
            }
        }
        return false;
    }

    public boolean apriSessione(String nome) {
        if (conti.containsKey(nome)) {
            conti.get(nome).inTransazione = true;
            return true;
        }
        return false;
    }

    public boolean chiudiSessione(String nome) {
        if (conti.containsKey(nome)) {
            conti.get(nome).inTransazione = false;
            return true;
        }
        return false;
    }

    public String getListaConti() {
        String s = "";
        for (Map.Entry<String, Conto> entry : conti.entrySet()) {
            s += entry.getKey() + " " + entry.getValue().getSaldo();
        }

        return s;
    }
}