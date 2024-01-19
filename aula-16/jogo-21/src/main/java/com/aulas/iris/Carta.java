package com.aulas.iris;

public class Carta {

    private int valor;
    private int naipe;

    public Carta(int valor, int naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getNaipe() {
        return naipe;
    }

    public void setNaipe(int naipe) {
        this.naipe = naipe;
    }

    public String getNomeNaipe() {
        return switch (naipe) {
            case 1 -> "Espadas";
            case 2 -> "Copas";
            case 3 -> "Espadilha";
            case 4 -> "Ouro";
            default -> throw new IllegalStateException();
        };
    }

    public String getNomeValor() {
        return switch (valor) {
            case 1 -> "As";
            case 2 -> "Dois";
            case 3 -> "Três";
            case 4 -> "Quatro";
            case 5 -> "Cinco";
            case 6-> "Seis";
            case 7-> "Sete";
            case 8-> "Oito";
            case 9-> "Nove";
            case 10-> "Dez";
            case 11-> "Valete";
            case 12-> "Rainha";
            case 13-> "Rei";
            default -> throw new IllegalStateException();
        };
    }

    public String getNome() {
        return getNomeValor().concat(" de ").concat(getNomeNaipe());
    }

    public int getPontos() {
        if (valor >= 1 && valor <= 9) {
            return valor;
        } else if (valor >= 10 && valor <= 13) {
            return 10;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
