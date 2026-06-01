package rede_solidaria.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rede_solidaria.database.repository.AdministradoRepository;
import rede_solidaria.dto.loginDto.LoginDto;
import rede_solidaria.handler.BusinessException;

@Service
@RequiredArgsConstructor
public class AdministradorService {
    private final AdministradoRepository administradoRepository;

    public void logar(LoginDto loginDto) {
        if (!administradoRepository.existsByEmailAndSenha(loginDto.getEmail(), loginDto.getSenha())) {
            throw new BusinessException("Email ou senha inválidos ou não existe");
        }   
    }
}
