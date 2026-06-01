package rede_solidaria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rede_solidaria.service.ItemDoacaoService;
import rede_solidaria.database.model.ItemDoacaoEfetivada;
import rede_solidaria.dto.itemDoacaoEfetivadaDto.ItemDoacaoEfetivadaCreatedDto;
import rede_solidaria.dto.itemDoacaoEfetivadaDto.ItemDoacaoEfetivadaResponseDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/itens")
public class ItemDoacaoController {
    private final ItemDoacaoService itemDoacaoService;

    @GetMapping("/listar")
    public ResponseEntity<List<ItemDoacaoEfetivadaResponseDto>> listarItensDoacao() {
        return new ResponseEntity<>(itemDoacaoService.listarItensDoacao(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarItemDoacao(@RequestBody ItemDoacaoEfetivadaCreatedDto itemDoacaoEfetivadaCreatedDto) {
        itemDoacaoService.cadastrarItemDoacao(itemDoacaoEfetivadaCreatedDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<ItemDoacaoEfetivada> atualizarDadosItem(@PathVariable Integer id, @RequestBody ItemDoacaoEfetivadaCreatedDto itemDoacaoEfetivadaCreatedDto) {
    //     return new ResponseEntity<>(itemDoacaoService.atualizarDadosItem(id, itemDoacaoEfetivadaCreatedDto), HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemDoacao(@PathVariable Integer id) {
        itemDoacaoService.deletarItemDoacao(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
