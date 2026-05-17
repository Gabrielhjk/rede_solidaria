package rede_solidaria.database.model.enums;

public enum TipoBeneficiario {
    FAMILIA("Família"),
    INSTITUICAO("Instituição"),
    ONG("ONG"),
    ESCOLA("Escola"),
    ABRIGO("Abrigo"),
    OUTRO("Outro");

    private String tipo;

    TipoBeneficiario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }
}