package com.aulas.iris;

import java.util.ArrayList;
import java.util.List;

public class Mao {

    private List<Carta> cartas = new ArrayList<>();
    private String donoDaMao;

    public Mao(String donoDaMao) {
        this.donoDaMao = donoDaMao;
    }

    public String getDonoDaMao() {
        return donoDaMao;
    }

    public void setDonoDaMao(String donoDaMao) {
        this.donoDaMao = donoDaMao;
    }

    public void receberCarta(Carta carta) {
        cartas.add(carta);
    }

    public int getPontos() {
        int total = 0;
        for (Carta carta: cartas) {
            total += carta.getPontos();
        }
        return total;
    }

    public void mostrarMao() {
        System.out.println("mao do ".concat(donoDaMao));
        cartas.forEach(Carta::getNome);
        System.out.println(getPontos() + " pontos");
    }
}
