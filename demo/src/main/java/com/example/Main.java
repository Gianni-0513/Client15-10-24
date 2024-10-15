package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client avviato");
        Socket s = new Socket("localhost", 3000);
        System.out.println("client connesso");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        do{
            System.out.println("1)Maiuscolo\n2)Minuscolo\n3)Ribalto stringa\n4)qta carratere\n5)exit");
            System.out.println("inserisci scelta: ");
            Scanner scan = new Scanner(System.in);
            String scelta = scan.nextLine();
            if(scelta.equals("5")){
                System.out.println("in chiusura");
                s.close();
                break;
            }

            out.writeBytes(scelta + "\n");

            System.out.println("inserisci parola: ");
            out.writeBytes(scan.nextLine() + "\n");
            System.out.println("stringa ricevuta " + in.readLine());
        }while(true);
    }
}