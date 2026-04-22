package rede_solidaria.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import rede_solidaria.service.AdministradorService;
import rede_solidaria.database.model.Beneficiario;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdministradorController {
    private final AdministradorService administradorService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Beneficiario> listarBeneficiarios() {
        return administradorService.listarBeneficiarios();
    }

    
    
}

