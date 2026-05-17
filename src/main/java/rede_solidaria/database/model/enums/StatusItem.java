package rede_solidaria.database.model.enums;

public enum StatusItem {
    DISPONIVEL("Disponível"),
    INDISPONIVEL("Indisponível"),
    RESERVADO("Reservado"),
    ENVIADO0("Enviado"),
    RECEBIDO("Recebido");

    private String status;

    StatusItem(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}