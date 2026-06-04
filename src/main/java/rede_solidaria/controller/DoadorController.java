package rede_solidaria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rede_solidaria.service.DoacaoEfetivadaService;
import rede_solidaria.service.DoadorService;
import rede_solidaria.database.model.enums.StatusItem;
import rede_solidaria.dto.itemDoacaoDto.ItemDoacaoCreatedDto;
import rede_solidaria.dto.itemDoacaoDto.ItemDoacaoResponseDto;
import rede_solidaria.dto.loginDto.LoginDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doador")
public class DoadorController {
    private final DoadorService doadorService;
    private final DoadorService itemDoacaoService;
    private final DoacaoEfetivadaService doacaoEfetivadaService;

    // endpoint de login de doador
    @PostMapping("/logar")
    public ResponseEntity<String> logar(@RequestBody LoginDto loginDto) {
        doadorService.logar(loginDto);
        return new ResponseEntity<>("Login realizado com sucesso", HttpStatus.OK);
    }

    // endpoint para listar itens do doador 
    @GetMapping("/itens/listar")
    public ResponseEntity<List<ItemDoacaoResponseDto>> listarItensDoacao() {
        return new ResponseEntity<>(itemDoacaoService.listarItensDoacao(), HttpStatus.OK);
    }

    // endpoint para listar item por id
    @GetMapping("/itens/{id}")
    public ResponseEntity<ItemDoacaoResponseDto> listarItem(@PathVariable Integer id) {
        return new ResponseEntity<>(doadorService.listarItem(id), HttpStatus.OK);
    }

    // endpoint para cadastar item para doacao
    @PostMapping("/itens/cadastrar")
    public ResponseEntity<String> cadastrarItemDoacao(@RequestBody ItemDoacaoCreatedDto itemDoacaoEfetivadaCreatedDto) {
        itemDoacaoService.cadastrarItemDoacao(itemDoacaoEfetivadaCreatedDto);
        return new ResponseEntity<>("Item cadastrado com sucesso", HttpStatus.CREATED);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<ItemDoacaoResponseDto> atualizarDadosItem(@PathVariable Integer id, @RequestBody ItemDoacaoEfetivadaCreatedDto itemDoacaoEfetivadaCreatedDto) {
    //     return new ResponseEntity<>(itemDoacaoService.atualizarDadosItem(id, itemDoacaoEfetivadaCreatedDto), HttpStatus.OK);
    // }

    // endpoint para excluir item
    @DeleteMapping("/itens/{id}")
    public ResponseEntity<String> deletarItemDoacao(@PathVariable Integer id) {
        itemDoacaoService.deletarItemDoacao(id);
        return new ResponseEntity<>("Item deletado com sucesso", HttpStatus.NO_CONTENT);
    }

    // endpoint para atualizar status do item
    @PutMapping("/itens/{id}/status")
    public ResponseEntity<String> atualizarStatus(@PathVariable Integer id, @RequestParam ("status") StatusItem statusItem) {
        doadorService.atualizarStatus(id, statusItem);
        return new ResponseEntity<>("Status Atualizado", HttpStatus.OK);
    }

    // endpoint para aprovar solicitacao
    @PutMapping("/solicitacoes/{id}/aprovar")
    public ResponseEntity<String> aprovarSolicitacao(@PathVariable Integer id) {
        doacaoEfetivadaService.aprovarSolicitacao(id);
        return new ResponseEntity<>("Doação Aprovada", HttpStatus.OK);
    }

    // endpoint para rejeitar solicitacao
    @PutMapping("/solicitacoes/{id}/rejeitar")
    public ResponseEntity<String> rejeitarSolicitacao(@PathVariable Integer id) {
        doacaoEfetivadaService.rejeitarSolicitacao(id);
        return new ResponseEntity<>("Solicitação Rejeitada", HttpStatus.OK);
    }

}
