package rede_solidaria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import rede_solidaria.database.model.Beneficiario;
import rede_solidaria.dto.BeneficiarioDto;

@Service
public class AdministradorService {
    public Beneficiario cadastrarBeneficiario(BeneficiarioDto beneficiarioDto) {
        Beneficiario novoBeneficiario = Beneficiario.builder()
            .nome(beneficiarioDto.getNome())
            .telefone(beneficiarioDto.getTelefone())
            .email(beneficiarioDto.getEmail())
            .senha(beneficiarioDto.getSenha())
            .endereco(beneficiarioDto.getEndereco())
            .tipoBeneficiario(beneficiarioDto.getTipoBeneficiario())
            .nivelPrioridade(beneficiarioDto.getNivelPrioridade())
            .build();
            
        return novoBeneficiario;
    }
}
