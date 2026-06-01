package rede_solidaria.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rede_solidaria.database.repository.BeneficiarioRepository;
import rede_solidaria.dto.beneficiarioDto.BeneficiarioCreatedDto;
import rede_solidaria.dto.loginDto.LoginDto;
import rede_solidaria.handler.BusinessException;

// services para beneficiarios
// + atualizarDadosBeneficiario()
// + listarDoadores()
// + listarItens()
// + buscarItensDisponiveis()
// + obterNivelPrioridade() 
// + solicitarItem() 
// + listarSolicitacoes() 
// + logar()


@Service
@RequiredArgsConstructor
public class BeneficiarioService {
    private final BeneficiarioRepository beneficiarioRepository;

    public void logar(LoginDto loginDto) {
        if (!beneficiarioRepository.existsByEmailAndSenha(loginDto.getEmail(), loginDto.getSenha())) {
            throw new BusinessException("Email ou senha inválidos ou não existe");
        }   
    }

}
