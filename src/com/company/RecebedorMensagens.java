package com.company;

import java.io.InputStream;
import java.util.Scanner;

public class RecebedorMensagens implements Runnable {

    private InputStream mFluxoMensagensServidor;

    public RecebedorMensagens(InputStream fluxoMensagensServidor) {
        mFluxoMensagensServidor = fluxoMensagensServidor;
    }

    @Override
    public void run() {
        Scanner s = new Scanner(mFluxoMensagensServidor);

        while(s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
    }
}
