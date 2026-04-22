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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import rede_solidaria.service.ItemDoacaoService;
import rede_solidaria.database.model.ItemDoacao;
import rede_solidaria.dto.ItemDoacaoDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/itens")
public class ItemDoacaoController {
    private final ItemDoacaoService itemDoacaoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDoacao> listarItensDoacao() {
        return itemDoacaoService.listarItensDoacao();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDoacao cadastrarItemDoacao(@RequestBody ItemDoacaoDto itemDoacaoDto) {
        return itemDoacaoService.cadastrarItemDoacao(itemDoacaoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDoacao atualizarDadosItem(@PathVariable Integer id, @RequestBody ItemDoacaoDto itemDoacaoDto) {
        return itemDoacaoService.atualizarDadosItem(id, itemDoacaoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarItemDoacao(@PathVariable Integer id) {
        itemDoacaoService.deletarItemDoacao(id);
    }

}
