package rede_solidaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import rede_solidaria.database.model.Beneficiario;
import rede_solidaria.database.model.Doador;
import rede_solidaria.dto.BeneficiarioDto;
import rede_solidaria.dto.DoadorDto;

@Service
public class AdministradorService {
    
    //beneficiarios 
    private static final List<Beneficiario> beneficiarios = new ArrayList<>();
    //doadores
    private static final List<Doador> doadores = new ArrayList<>();
    

    //static de beneficiarios
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

    // static de doadores 
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

    public List<Beneficiario> listarBeneficiarios() {
        return new ArrayList<>(beneficiarios);
    }

    public List<Doador> listarDoadores() {
        return new ArrayList<>(doadores);
    }

    public Beneficiario cadastrarBeneficiario(BeneficiarioDto beneficiarioDto) {

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


    public Doador cadastrarDoador(DoadorDto doadorDto) {


        // incremento de id manual por enquanto
        Integer id = doadores.stream()
            .mapToInt(Doador::getId)
            .max()
            .orElse(0) + 1;

        Doador novoDoador = Doador.builder()
            .id(id)
            .nome(doadorDto.getNome())
            .telefone(doadorDto.getTelefone())
            .email(doadorDto.getEmail())
            .senha(doadorDto.getSenha())
            .endereco(doadorDto.getEndereco())
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
