package br.com.healthtrack.platform.domain;

public enum TipoSanguineo {

    A_POS("A+"), A_NEG("A-"),
    B_POS("B+"), B_NEG("B-"),
    AB_POS("AB+"), AB_NEG("AB-"),
    O_POS("O+"), O_NEG("O-");

    private final String val;

    TipoSanguineo(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}
