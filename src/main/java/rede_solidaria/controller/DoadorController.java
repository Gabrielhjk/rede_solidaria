package rede_solidaria.controller;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rede_solidaria.service.DoadorService;
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

    @PostMapping("/logar")
    public ResponseEntity<String> logar(@RequestBody LoginDto loginDto) {
        doadorService.logar(loginDto);
        return new ResponseEntity<>("Login realizado com sucesso", HttpStatus.OK);
    }

    @GetMapping("itens/listar")
    public ResponseEntity<List<ItemDoacaoResponseDto>> listarItensDoacao() {
        return new ResponseEntity<>(itemDoacaoService.listarItensDoacao(), HttpStatus.OK);
    }

    @PostMapping("itens/cadastrar")
    public ResponseEntity<String> cadastrarItemDoacao(@RequestBody ItemDoacaoCreatedDto itemDoacaoEfetivadaCreatedDto) {
        itemDoacaoService.cadastrarItemDoacao(itemDoacaoEfetivadaCreatedDto);
        return new ResponseEntity<>("Item cadastrado com sucesso", HttpStatus.CREATED);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<ItemDoacaoResponseDto> atualizarDadosItem(@PathVariable Integer id, @RequestBody ItemDoacaoEfetivadaCreatedDto itemDoacaoEfetivadaCreatedDto) {
    //     return new ResponseEntity<>(itemDoacaoService.atualizarDadosItem(id, itemDoacaoEfetivadaCreatedDto), HttpStatus.OK);
    // }

    @DeleteMapping("itens/{id}")
    public ResponseEntity<String> deletarItemDoacao(@PathVariable Integer id) {
        itemDoacaoService.deletarItemDoacao(id);
        return new ResponseEntity<>("Item deletado com sucesso", HttpStatus.NO_CONTENT);
    }

}
