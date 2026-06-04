package rede_solidaria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rede_solidaria.database.model.Doador;
import rede_solidaria.database.repository.AdministradorDoadorRepository;
import rede_solidaria.dto.doadorDto.DoadorCreatedDto;
import rede_solidaria.dto.doadorDto.DoadorResponseDto;
import rede_solidaria.handler.BusinessException;

@Service
@RequiredArgsConstructor
public class AdministradorDoadorService {
    private final AdministradorDoadorRepository administradorDoadorRepository;

    // conversao do model para Dto
    public DoadorResponseDto converterParaDto(Doador doador) {
        return DoadorResponseDto.builder()
            .id(doador.getId())
            .nome(doador.getNome())
            .telefone(doador.getTelefone())
            .email(doador.getEmail())
            .endereco(doador.getEndereco())
            .build();
    }

    public List<DoadorResponseDto> listarDoadores() {
        return administradorDoadorRepository.findAll()
                                            .stream()
                                            .map(this::converterParaDto)
                                            .toList();
    }

    public void cadastrarDoador(DoadorCreatedDto doadorCreatedDto) {
        // valida se o email existe no banco 
        if (administradorDoadorRepository.existsByEmail(doadorCreatedDto.getEmail())) {
            throw new BusinessException("Doador já cadastrado com este email.");
        }

        // conversao do dto para model
        Doador novoDoador = Doador.builder()
            .nome(doadorCreatedDto.getNome())
            .telefone(doadorCreatedDto.getTelefone())
            .email(doadorCreatedDto.getEmail())
            .senha(doadorCreatedDto.getSenha())
            .endereco(doadorCreatedDto.getEndereco())
            .build();
        
            // salva no banco 
            administradorDoadorRepository.save(novoDoador);
    }

    public void deletarDoador(Integer id) {
        // valida se o id do doador existe
        if (!administradorDoadorRepository.existsById(id)) {
            throw new BusinessException("Doador não encontrado");
        }
        
        // deleta doador no banco
        administradorDoadorRepository.deleteById(id);
    }
}
