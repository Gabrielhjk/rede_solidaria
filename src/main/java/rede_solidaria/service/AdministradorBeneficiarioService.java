package rede_solidaria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rede_solidaria.database.model.Beneficiario;
import rede_solidaria.database.model.enums.NivelPrioridade;
import rede_solidaria.dto.beneficiarioDto.BeneficiarioCreatedDto;
import rede_solidaria.dto.beneficiarioDto.BeneficiarioResponseDto;
import rede_solidaria.handler.BusinessException;
import rede_solidaria.database.repository.AdministradorBeneficiarioRepository;

@Service
@RequiredArgsConstructor
public class AdministradorBeneficiarioService {
    private final AdministradorBeneficiarioRepository administradorBeneficiarioRepository;

    // conversao do model para Dto
    private BeneficiarioResponseDto converterParaDto(Beneficiario beneficiario) {
        return BeneficiarioResponseDto.builder()
            .id(beneficiario.getId())
            .nome(beneficiario.getNome())
            .telefone(beneficiario.getTelefone())
            .email(beneficiario.getEmail())
            .endereco(beneficiario.getEndereco())
            .tipoBeneficiario(beneficiario.getTipoBeneficiario())
            .nivelPrioridade(beneficiario.getNivelPrioridade())
            .build();
    }

    public List<BeneficiarioResponseDto> listarBeneficiarios() {
        return administradorBeneficiarioRepository.findAll()
                                                  .stream()
                                                  .map(this::converterParaDto)
                                                  .toList();
    }

    public void cadastrarBeneficiario(BeneficiarioCreatedDto beneficiarioCreatedDto) {

        if (administradorBeneficiarioRepository.existsByEmail(beneficiarioCreatedDto.getEmail())) {
            throw new BusinessException("Beneficiário já cadastrado com este email.");
        }        

        Beneficiario novoBeneficiario = Beneficiario.builder()
            .nome(beneficiarioCreatedDto.getNome())
            .telefone(beneficiarioCreatedDto.getTelefone())
            .email(beneficiarioCreatedDto.getEmail())
            .senha(beneficiarioCreatedDto.getSenha())
            .endereco(beneficiarioCreatedDto.getEndereco())
            .tipoBeneficiario(beneficiarioCreatedDto.getTipoBeneficiario())
            .nivelPrioridade(beneficiarioCreatedDto.getNivelPrioridade())
            .build();
            
        administradorBeneficiarioRepository.save(novoBeneficiario);

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
        administradorBeneficiarioRepository.deleteById(id);;
    }

    public List<BeneficiarioResponseDto> buscarItensPorNivelPrioridade (NivelPrioridade nivelPrioridade) {
        return administradorBeneficiarioRepository.findByNivelPrioridade(nivelPrioridade)
                                     .stream()
                                     .map(this::converterParaDto)
                                     .toList(); 
    }
}
