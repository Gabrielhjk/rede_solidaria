package rede_solidaria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import rede_solidaria.dto.doadorDto.DoadorCreatedDto;
import rede_solidaria.dto.doadorDto.DoadorResponseDto;
import rede_solidaria.service.AdministradorDoadorService;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/admin")
public class AdminstradorDoadorController {
    private final AdministradorDoadorService administradorDoadorService;

    // endpoint para listar todos os doadores
    @GetMapping("/doadores/listar")
    public ResponseEntity<List<DoadorResponseDto>> listarDoadores() {
        return new ResponseEntity<>(administradorDoadorService.listarDoadores(), HttpStatus.OK);
    }

    // endpoint para cadastar doadores
    @PostMapping("/doadores/cadastrar")
    public ResponseEntity<String> cadastrarDoador(@Valid @RequestBody DoadorCreatedDto doadorCreatedDto) {
        administradorDoadorService.cadastrarDoador(doadorCreatedDto);
        return new ResponseEntity<>("Doador cadastrado com sucesso", HttpStatus.CREATED);
    }

    // endpoint para excluir doadores
    @DeleteMapping("/doadores/{id}")
    public ResponseEntity<String> deletarDoador(@PathVariable Integer id) {
        administradorDoadorService.deletarDoador(id);
        return new ResponseEntity<>("Doador deletado com sucesso", HttpStatus.NO_CONTENT);
    } 
}
