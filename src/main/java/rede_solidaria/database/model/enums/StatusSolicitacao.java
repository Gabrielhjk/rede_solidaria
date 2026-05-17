package rede_solidaria.database.model.enums;

public enum StatusSolicitacao {
    PENDENTE("Pendente"),
    APROVADA("Aprovada"),
    REJEITADA("Rejeitada"),
    CONCLUIDA("Concluída"),
    CANCELADA("Cancelada"),
    EM_ANDAMENTO("Em Andamento");

    private String statusSolicitacao;

    StatusSolicitacao(String statusSolicitacao) {
        this.statusSolicitacao = statusSolicitacao;
    }

    public String getStatusSolicitacao() {
        return statusSolicitacao;
    }
}
