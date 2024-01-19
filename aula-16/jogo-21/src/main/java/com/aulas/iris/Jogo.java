package com.aulas.iris;

import java.util.Scanner;

public class Jogo {

    private Baralho baralho = new Baralho();
    private Mao maoJogador = new Mao("jogador");
    private Mao maoDealer = new Mao("dealer");

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        while (true) {
            jogo.limparTerminal();

            if (jogo.maoJogador.getPontos() > 21) {
                jogo.pararDePegarCartas();
                break;
            } else {
                System.out.println();
                jogo.maoJogador.mostrarMao();
                System.out.println();

                System.out.println("Escolha uma opcao: ");
                System.out.println("Continue? s/n");

                Scanner scanner = new Scanner(System.in);
                String escolhaUsuario = scanner.next();

                if ("s".equals(escolhaUsuario)) {
                    jogo.pegarOutraCarta();
                } else if ("n".equals(escolhaUsuario)) {
                    jogo.pararDePegarCartas();
                    break;
                } else {
                    System.out.println("Opcao invalida");
                }
            }
        }

        jogo.mostrarMensagensFinalDoJogo();
    }

    public Jogo() {
        maoJogador.receberCarta(baralho.pegarCarta());
        maoDealer.receberCarta(baralho.pegarCarta());
        maoJogador.receberCarta(baralho.pegarCarta());
        maoDealer.receberCarta(baralho.pegarCarta());
    }

    public void mostrarMensagensFinalDoJogo() {
        System.out.println();
        System.out.println("Acabou o jogo");
        maoJogador.mostrarMao();
        System.out.println();
        maoDealer.mostrarMao();

        this.mostrarQuemGanhou();
    }

    public void mostrarQuemGanhou() {
        if (maoJogador.getPontos() > 21 && maoDealer.getPontos() > 21) {
            System.out.println("Dealer ganhou, e tu se lascou! AKAKAKAKAKA˚⊹♡");
        }else if (maoJogador.getPontos() > 21) {
            System.out.println("Dealer ganhou, e tu se lascou! AKAKAKAKAKA˚⊹♡");
        }else if (maoDealer.getPontos() > 21){
            System.out.println("Parabéns, você ganhou!˚⊹♡");
        }else if (maoJogador.getPontos() == maoDealer.getPontos()){
            System.out.println("Deu emṕate! Que tal tentar de novo, em truta?");
        }else if (maoJogador.getPontos() > maoDealer.getPontos()){
            System.out.println("Parabéns, você ganhou!˚⊹♡");
        }else {
            System.out.println("Cê é ruim mesmo, em, cara, até o robô ganha de você!˚⊹♡");
        }
    }

    public void limparTerminal() {
        for (int i = 0; i < 1000; i++) {
            System.out.println();
        }
    }

    public void pegarOutraCarta() {
        maoJogador.receberCarta(baralho.pegarCarta());
    }

    public void pararDePegarCartas() {
        while (maoDealer.getPontos() < 17) {
            maoDealer.receberCarta(baralho.pegarCarta());
        }
    }
}
