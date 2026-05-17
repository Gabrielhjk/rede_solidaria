package rede_solidaria.service;

import java.util.ArrayList;
import java.util.List;

import rede_solidaria.database.model.Beneficiario;
import rede_solidaria.dto.beneficiarioDto.BeneficiarioCreatedDto;

public class BeneficiarioService {
    
    private static final List<Beneficiario> beneficiarios = new ArrayList<>();

    static {
        beneficiarios.add(Beneficiario.builder()
            .id(1)
            .nome("Maria Silva")
            .telefone("11987654321")
            .email("maria.silva@email.com")
            .senha("senha123")
            .endereco("Rua A, 123")
            .tipoBeneficiario(rede_solidaria.database.model.enums.TipoBeneficiario.ABRIGO)
            .nivelPrioridade(rede_solidaria.database.model.enums.NivelPrioridade.ALTA)
            .build());

        beneficiarios.add(Beneficiario.builder()
            .id(2)
            .nome("João Souza")
            .telefone("11912345678")
            .email("joao.souza@email.com")
            .senha("senha123")
            .endereco("Rua B, 456")
            .tipoBeneficiario(rede_solidaria.database.model.enums.TipoBeneficiario.INSTITUICAO)
            .nivelPrioridade(rede_solidaria.database.model.enums.NivelPrioridade.MEDIA)
            .build());
    }

    public List<Beneficiario> listarBeneficiarios() {
        return new ArrayList<>(beneficiarios);
    }

 public Beneficiario cadastrarBeneficiario(BeneficiarioCreatedDto beneficiarioDto) {

        // incremento de id manual por enquanto
        Integer id = beneficiarios.stream()
            .mapToInt(Beneficiario::getId)
            .max()
            .orElse(0) + 1;

        Beneficiario novoBeneficiario = Beneficiario.builder()
            .id(id)
            .nome(beneficiarioDto.getNome())
            .telefone(beneficiarioDto.getTelefone())
            .email(beneficiarioDto.getEmail())
            .senha(beneficiarioDto.getSenha())
            .endereco(beneficiarioDto.getEndereco())
            .tipoBeneficiario(beneficiarioDto.getTipoBeneficiario())
            .nivelPrioridade(beneficiarioDto.getNivelPrioridade())
            .build();
            
        beneficiarios.add(novoBeneficiario);
        return novoBeneficiario;
    }

    // ver se vou permitir que o admin possa atualizar os dados do beneficiario, ou se ele so pode cadastrar, listar e deletar
    // public Beneficiario atualizarDadosBeneficiario(Integer id, BeneficiarioDto beneficiarioDto) {
    //     Beneficiario beneficiarioId = beneficiarios.stream()
    //         .filter(b -> b.getId().equals(id))
    //         .findAny()
    //         .orElseThrow(null);

    //         beneficiarioId.setNome(beneficiarioDto.getNome());
    //         beneficiarioId.setTelefone(beneficiarioDto.getTelefone());
    //         beneficiarioId.setEmail(beneficiarioDto.getEmail());
    //         beneficiarioId.setSenha(beneficiarioDto.getSenha());
    //         beneficiarioId.setEndereco(beneficiarioDto.getEndereco());
    //         beneficiarioId.setTipoBeneficiario(beneficiarioDto.getTipoBeneficiario());
    //         beneficiarioId.setNivelPrioridade(beneficiarioDto.getNivelPrioridade());

    //         return beneficiarioId;
    // }

    public void deletarBeneficiario(Integer id) {
        beneficiarios.removeIf(b -> b.getId().equals(id));
    }
}
