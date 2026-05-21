package rede_solidaria.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import rede_solidaria.service.AdministradorBeneficiarioService;
import rede_solidaria.database.model.Beneficiario;
import rede_solidaria.dto.beneficiarioDto.BeneficiarioCreatedDto;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/admin")
public class BeneficiarioController {
    private final AdministradorBeneficiarioService administradorBeneficiarioService;
    
    @GetMapping("/beneficiarios")
    public ResponseEntity<List<Beneficiario>> listarBeneficiarios() {
        return new ResponseEntity<>(administradorBeneficiarioService.listarBeneficiarios(), HttpStatus.OK);
    }

    @PostMapping("/beneficiarios")
    public ResponseEntity<Void> cadastrarBeneficiario(@Valid @RequestBody BeneficiarioCreatedDto beneficiarioCreatedDto) {
        administradorBeneficiarioService.cadastrarBeneficiario(beneficiarioCreatedDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @DeleteMapping("/beneficiarios/{id}")
    public ResponseEntity<Void> deletarBeneficiario(@PathVariable Integer id) {
        administradorBeneficiarioService.deletarBeneficiario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

