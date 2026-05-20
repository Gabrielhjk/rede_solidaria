package rede_solidaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rede_solidaria.database.model.Doador;
import rede_solidaria.database.repository.AdministradorDoadorRepository;
import rede_solidaria.dto.doadorDto.DoadorCreatedDto;

@Service
@RequiredArgsConstructor
public class AdministradorDoadorService {
    private AdministradorDoadorRepository administradorDoadorRepository;

    public List<Doador> listarDoadores() {
        return administradorDoadorRepository.findAll();
    }

    public void cadastrarDoador(DoadorCreatedDto doadorCreatedDto) {

        Doador novoDoador = Doador.builder()
            .nome(doadorCreatedDto.getNome())
            .telefone(doadorCreatedDto.getTelefone())
            .email(doadorCreatedDto.getEmail())
            .senha(doadorCreatedDto.getSenha())
            .endereco(doadorCreatedDto.getEndereco())
            .build();
        
            administradorDoadorRepository.save(novoDoador);
    }
    
    // ver se vou permitir que o admin possa atualizar os dados do doador, ou se ele so pode cadastrar, listar e deletar
    // public Doador atualizarDadosDoador(Integer id, DoadorDto doadorDto) {
    //     Doador doadorId = doadores.stream()
    //         .filter(d -> d.getId().equals(id))
    //         .findAny()
    //         .orElseThrow(null);

    //     doadorId.setNome(doadorDto.getNome());
    //     doadorId.setTelefone(doadorDto.telefone());
    //     doadorId.setEmail(doadorDto.getEmail());
    //     doadorId.setSenha(doadorDto.getSEnha());
    //     doadorId.setEndereco(doadorDto.getEndereco());

    //     return doadorId;
    // }


    public void deletarDoador(Integer id) {
        administradorDoadorRepository.deleteById(id);
    }
}
