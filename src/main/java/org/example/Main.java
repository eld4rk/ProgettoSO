package org.example;

public class Main {
    public static void main(String[] args) {
        Server conto1=new Server();
        Server conto2=new Server();
        conto1.apriConto("Mario");
        conto2.apriConto("Luigi");

        conto1.apriSessione("Mario");
        conto1.eseguiTransazione("Mario","Luigi",100);

        conto1.chiudiSessione("Mario");

    }
}
