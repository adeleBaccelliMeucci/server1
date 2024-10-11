package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server avviato");
        ServerSocket s1 = new ServerSocket(3000); //server

        /*
        do {
            Socket s = s1.accept(); //sta fermo finchè non si collega
            System.out.println("un client si è collegato");

            MioThread t = new MioThread(s);
            t.start();
        } while (true);
        */

        Socket s = s1.accept(); //sta fermo finchè non si collega
        System.out.println("un client si è collegato");





        // run
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());


        String stringaRicevuta = new String();
        do {

            stringaRicevuta = in.readLine(); //parola
            System.out.println("La stringa ricevuta: " + stringaRicevuta);

            String stringMaiuscola = stringaRicevuta.toUpperCase();
            out.writeBytes(stringMaiuscola + '\n');

        } while (!stringaRicevuta.equals("!"));

        
        s.close();
        s1.close();

    }
}