package rede_solidaria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import rede_solidaria.database.model.enums.StatusItem;
import rede_solidaria.dto.doadorDto.DoadorResponseDto;
import rede_solidaria.dto.itemDoacaoDto.ItemDoacaoResponseDto;
import rede_solidaria.dto.loginDto.LoginDto;
import rede_solidaria.service.BeneficiarioService;

@RestController
@AllArgsConstructor
@RequestMapping("/beneficiarios")
public class BeneficiarioController {
    private final BeneficiarioService beneficiarioService;

    @PostMapping("/logar")
    public ResponseEntity<String> logar(@RequestBody LoginDto loginDto) {
        beneficiarioService.logar(loginDto);
        return new ResponseEntity<>("Usuário logado com sucesso", HttpStatus.OK);
    }

    @GetMapping("/doadores/listar")
    public ResponseEntity<List<DoadorResponseDto>> listarDoadores() {
        return new ResponseEntity<>(beneficiarioService.listarDoadores(), HttpStatus.OK);
    }

    @GetMapping("/itens/listar")
    public ResponseEntity<List<ItemDoacaoResponseDto>> listarItens() {
        return new ResponseEntity<>(beneficiarioService.listarItens(), HttpStatus.OK);
    }

    @GetMapping("/itens/status")
    public ResponseEntity<List<ItemDoacaoResponseDto>> buscarItensPorStatus(@RequestParam("status") StatusItem statusItem) {
        return new ResponseEntity<>(beneficiarioService.buscarItensPorStatus(statusItem), HttpStatus.OK);
    }
}
