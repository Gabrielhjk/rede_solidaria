package rede_solidaria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import rede_solidaria.database.model.enums.StatusItem;
import rede_solidaria.dto.SolicitacaoDto.SolicitacaoCreatedDto;
import rede_solidaria.dto.SolicitacaoDto.SolicitacaoResponseDto;
import rede_solidaria.dto.doadorDto.DoadorResponseDto;
import rede_solidaria.dto.itemDoacaoDto.ItemDoacaoResponseDto;
import rede_solidaria.dto.loginDto.LoginDto;
import rede_solidaria.service.BeneficiarioService;

@RestController
@AllArgsConstructor
@RequestMapping("/beneficiarios")
public class BeneficiarioController {
    private final BeneficiarioService beneficiarioService;

    // endpoint de login para beneficiario
    @PostMapping("/logar")
    public ResponseEntity<String> logar(@RequestBody LoginDto loginDto) {
        beneficiarioService.logar(loginDto);
        return new ResponseEntity<>("Usuário logado com sucesso", HttpStatus.OK);
    }

    // endpoint para listar todos os doadores
    @GetMapping("/doadores/listar")
    public ResponseEntity<List<DoadorResponseDto>> listarDoadores() {
        return new ResponseEntity<>(beneficiarioService.listarDoadores(), HttpStatus.OK);
    }

    // enpoint para listar um doador
    @GetMapping("/doadores/{id}")
    public ResponseEntity<DoadorResponseDto> listarDoador(Integer id) {
        return new ResponseEntity<>(beneficiarioService.listarDoador(id), HttpStatus.OK);
    }

    // endpoint para listar todos os itens para doacao
    @GetMapping("/itens/listar")
    public ResponseEntity<List<ItemDoacaoResponseDto>> listarItens() {
        return new ResponseEntity<>(beneficiarioService.listarItensDoacao(), HttpStatus.OK);
    }

    // endpoint para listar um item
    @GetMapping("/itens/{id}")
    public ResponseEntity<ItemDoacaoResponseDto> listarItem(@PathVariable Integer id) {
        return new ResponseEntity<>(beneficiarioService.listarItem(id), HttpStatus.OK);
    }

    // endpoint para filtar item por status
    @GetMapping("/itens/status")
    public ResponseEntity<List<ItemDoacaoResponseDto>> buscarItensPorStatus(@RequestParam("status") StatusItem statusItem) {
        return new ResponseEntity<>(beneficiarioService.buscarItensPorStatus(statusItem), HttpStatus.OK);
    }

    // endpoint para solicitar item
    @PostMapping("/solicitacoes/solicitar")
    public ResponseEntity<Void> solicitarItem(@RequestBody SolicitacaoCreatedDto solicitacaoCreatedDto) {
        beneficiarioService.solicitarItem(solicitacaoCreatedDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // endpoint para listar solicitacoes realizadas
    @GetMapping("/solicitacoes/listar")
    public ResponseEntity<List<SolicitacaoResponseDto>> listarSolicitacoes() {
        return new ResponseEntity<>(beneficiarioService.listarSolicitacoes(), HttpStatus.OK);
    }
}
