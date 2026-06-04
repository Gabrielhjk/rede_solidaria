package rede_solidaria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rede_solidaria.dto.loginDto.LoginDto;

import lombok.AllArgsConstructor;
import rede_solidaria.service.AdministradorService;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdministradorController {
    private AdministradorService administradorService;

    // endpoint de login do administrador
    @PostMapping("/logar")
    public ResponseEntity<String> logar(@RequestBody LoginDto loginDto) {
        administradorService.logar(loginDto);
        return new ResponseEntity<>("Logado com Sucesso", HttpStatus.OK);
    }
}
