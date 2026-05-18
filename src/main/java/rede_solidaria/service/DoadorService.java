package rede_solidaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rede_solidaria.database.model.Doador;
import rede_solidaria.dto.doadorDto.DoadorCreatedDto;

@Service
@RequiredArgsConstructor
public class DoadorService {
    
    private static final List<Doador> doadores = new ArrayList<>();
    
    static {
        doadores.add(Doador.builder()
            .id(1)
            .nome("Carlos Oliveira")
            .telefone("11987654321")
            .email("carlos.oliveira@email.com")
            .build());
        doadores.add(Doador.builder()
            .id(2)
            .nome("Ana Santos")
            .telefone("11912345678")
            .email("ana.santos@email.com")
            .senha("1234")
            .endereco("rua abc, 123")
            .build());
    }

    public List<Doador> listarDoadores() {
        return new ArrayList<>(doadores);
    }

    public Doador cadastrarDoador(DoadorCreatedDto doadorCreatedDto) {

        // incremento de id manual por enquanto
        Integer id = doadores.stream()
            .mapToInt(Doador::getId)
            .max()
            .orElse(0) + 1;

        Doador novoDoador = Doador.builder()
            .id(id)
            .nome(doadorCreatedDto.getNome())
            .telefone(doadorCreatedDto.getTelefone())
            .email(doadorCreatedDto.getEmail())
            .senha(doadorCreatedDto.getSenha())
            .endereco(doadorCreatedDto.getEndereco())
            .build();
        
        doadores.add(novoDoador);
        return novoDoador;
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
        doadores.removeIf(d -> d.getId().equals(id));
    }
}
