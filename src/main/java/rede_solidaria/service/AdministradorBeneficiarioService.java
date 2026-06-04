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

        // validando se o email existe no banco 
        if (administradorBeneficiarioRepository.existsByEmail(beneficiarioCreatedDto.getEmail())) {
            throw new BusinessException("Beneficiário já cadastrado com este email.");
        }        

        // conversao do dto para model
        Beneficiario novoBeneficiario = Beneficiario.builder()
            .nome(beneficiarioCreatedDto.getNome())
            .telefone(beneficiarioCreatedDto.getTelefone())
            .email(beneficiarioCreatedDto.getEmail())
            .senha(beneficiarioCreatedDto.getSenha())
            .endereco(beneficiarioCreatedDto.getEndereco())
            .tipoBeneficiario(beneficiarioCreatedDto.getTipoBeneficiario())
            .nivelPrioridade(beneficiarioCreatedDto.getNivelPrioridade())
            .build();
            
        // salva no banco 
        administradorBeneficiarioRepository.save(novoBeneficiario);

    }

    public void deletarBeneficiario(Integer id) {
        // valida se o id do beneficiario existe
        if (!administradorBeneficiarioRepository.existsById(id)) {
            throw new BusinessException("Beneficiario não encontrado");
        }

        // deleta beneficiario no banco 
        administradorBeneficiarioRepository.deleteById(id);;
    }

    public List<BeneficiarioResponseDto> buscarItensPorNivelPrioridade (NivelPrioridade nivelPrioridade) {
        return administradorBeneficiarioRepository.findByNivelPrioridade(nivelPrioridade)
                                     .stream()
                                     .map(this::converterParaDto)
                                     .toList(); 
    }
}
