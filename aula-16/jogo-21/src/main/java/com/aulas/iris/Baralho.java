package com.aulas.iris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {

    private List<Carta> cartas = new ArrayList<>();

    public Baralho() {
        criarBaralho();
        sortearBaralho();
    }

    private void criarBaralho() {
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 13; j++) {
                cartas.add(new Carta(j, i));
            }
        }
    }

    private void sortearBaralho() {
        var i1 = sortearNumero();
        var i2 = sortearNumero();
        var c1 = cartas.get(i1);
        var c2 = cartas.get(i2);
        cartas.add(i1, c2);
        cartas.add(i2, c1);
    }

    private int sortearNumero() {
        Random random = new Random();
        return random.nextInt(52);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Carta pegarCarta() {
        return cartas.remove(0);
    }
}
