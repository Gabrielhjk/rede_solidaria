package rede_solidaria.database.model.enums;

public enum NivelPrioridade {
    URGENTE("Urgente"),
    ALTA("Alta"),
    MEDIA("Média"),
    BAIXA("Baixa");

    private String prioridade;

    NivelPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getPrioridade() {
        return prioridade;
    }
}