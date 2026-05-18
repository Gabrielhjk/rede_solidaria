package rede_solidaria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import rede_solidaria.database.model.Doador;
import rede_solidaria.dto.doadorDto.DoadorCreatedDto;
import rede_solidaria.service.DoadorService;

@RestController
@RequiredArgsConstructor
public class DoadorController {
    private final DoadorService doadorService;

    @GetMapping("/doadores")
    public ResponseEntity<List<Doador>> listarDoadores() {
        return new ResponseEntity<>(doadorService.listarDoadores(), HttpStatus.OK);
    }

    @PostMapping("/doadores")
    public ResponseEntity<Doador> cadastrarDoador(@RequestBody DoadorCreatedDto doadorCreatedDto) {
        return new ResponseEntity<>(doadorService.cadastrarDoador(doadorCreatedDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/doadores/{id}")
    public ResponseEntity<Void> deletarDoador(@PathVariable Integer id) {
        doadorService.deletarDoador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
}
