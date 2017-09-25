package com.company;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private Socket mClient;
    private String mNickname;
    private String mCorNickname;

    public Cliente(String nick, String corNick, String ipServidor, int porta) throws IOException {
        mNickname = nick;
        mCorNickname = corNick;
        mClient = new Socket(ipServidor, porta);
    }

    public void preparaEnvio() throws IOException {

        RecebedorMensagens receiver = new RecebedorMensagens(mClient.getInputStream());
        new Thread(receiver).start();

        Scanner s = new Scanner(System.in);
        PrintStream ps = new PrintStream(mClient.getOutputStream());

        while(s.hasNextLine()) {
            ps.println(mCorNickname + mNickname + Main.ANSI_RESET + " diz: " + s.nextLine());
        }

    }

}
