package rede_solidaria.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;

import rede_solidaria.service.AdministradorService;
import rede_solidaria.database.model.Beneficiario;
import rede_solidaria.dto.BeneficiarioDto;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Beneficiario cadastrarBeneficiario(@RequestBody BeneficiarioDto beneficiarioDto) {
        return administradorService.cadastrarBeneficiario(beneficiarioDto);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarBeneficiario(@PathVariable Integer id) {
        administradorService.deletarBeneficiario(id);
    }

}

