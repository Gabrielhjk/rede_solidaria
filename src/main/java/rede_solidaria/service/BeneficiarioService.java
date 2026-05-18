package rede_solidaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rede_solidaria.database.model.Beneficiario;
import rede_solidaria.dto.beneficiarioDto.BeneficiarioCreatedDto;
import rede_solidaria.database.repository.BeneficiarioRepository;

@Service
@RequiredArgsConstructor
public class BeneficiarioService {
    private BeneficiarioRepository beneficiarioRepository;

    public List<Beneficiario> listarBeneficiarios() {
        return beneficiarioRepository.findAll();
    }

 public void cadastrarBeneficiario(BeneficiarioCreatedDto beneficiarioCreatedDto) {

        Beneficiario novoBeneficiario = Beneficiario.builder()
            .nome(beneficiarioCreatedDto.getNome())
            .telefone(beneficiarioCreatedDto.getTelefone())
            .email(beneficiarioCreatedDto.getEmail())
            .senha(beneficiarioCreatedDto.getSenha())
            .endereco(beneficiarioCreatedDto.getEndereco())
            .tipoBeneficiario(beneficiarioCreatedDto.getTipoBeneficiario())
            .nivelPrioridade(beneficiarioCreatedDto.getNivelPrioridade())
            .build();
            
        beneficiarioRepository.save(novoBeneficiario);

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
        beneficiarioRepository.removeIf(b -> b.getId().equals(id));
    }
}
