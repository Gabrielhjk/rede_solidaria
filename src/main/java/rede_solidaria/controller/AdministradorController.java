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
import rede_solidaria.database.model.Doador;
import rede_solidaria.dto.BeneficiarioDto;
import rede_solidaria.dto.DoadorDto;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdministradorController {
    private final AdministradorService administradorService;
    
    // rotas para beneficiarios 
    @GetMapping("/beneficiarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Beneficiario> listarBeneficiarios() {
        return administradorService.listarBeneficiarios();
    }

    @PostMapping("/beneficiarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Beneficiario cadastrarBeneficiario(@RequestBody BeneficiarioDto beneficiarioDto) {
        return administradorService.cadastrarBeneficiario(beneficiarioDto);
    }
    
    @DeleteMapping("/beneficiarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarBeneficiario(@PathVariable Integer id) {
        administradorService.deletarBeneficiario(id);
    }

    // rotas para doadores
    @GetMapping("/doadores")
    @ResponseStatus(HttpStatus.OK)
    public List<Doador> listarDoadores() {
        return administradorService.listarDoadores();
    }

    @PostMapping("/doadores")
    @ResponseStatus(HttpStatus.CREATED)
    public Doador cadastrarDoador(@RequestBody DoadorDto doadorDto) {
        return administradorService.cadastrarDoador(doadorDto);
    }

    @DeleteMapping("/doadores/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarDoador(@PathVariable Integer id) {
        administradorService.deletarDoador(id);
    }
}

