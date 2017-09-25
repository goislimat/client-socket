package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {

        String ipServidor = "127.0.0.1";
        int portaServidor = 12345;
        Scanner s = new Scanner(System.in);

        try {

            System.out.print("Entre com seu nickname: ");
            String nick = s.nextLine();

            String cor = ANSI_RESET;
            System.out.println("Escolha a cor do seu nick: ");
            System.out.print("1- Vermelho\n2- Verde\n3- Amarelo\n4- Ciano\nNúmero da cor: ");
            int option = s.nextInt();

            switch (option) {
                case 1:
                    cor = ANSI_RED;
                    break;
                case 2:
                    cor = ANSI_GREEN;
                    break;
                case 3:
                    cor = ANSI_YELLOW;
                    break;
                case 4:
                    cor = ANSI_CYAN;
                break;
            }

            Cliente cli = new Cliente(nick, cor, ipServidor, portaServidor);
            System.out.println("Conectado ao Servidor!");
            cli.preparaEnvio();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
