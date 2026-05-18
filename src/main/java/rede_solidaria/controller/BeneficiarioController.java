package rede_solidaria.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rede_solidaria.service.BeneficiarioService;
import rede_solidaria.database.model.Beneficiario;
import rede_solidaria.dto.beneficiarioDto.BeneficiarioCreatedDto;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class BeneficiarioController {
    private final BeneficiarioService beneficiarioService;
    
    @GetMapping("/beneficiarios")
    public ResponseEntity<List<Beneficiario>> listarBeneficiarios() {
        return new ResponseEntity<>(beneficiarioService.listarBeneficiarios(), HttpStatus.OK);
    }

    @PostMapping("/beneficiarios")
    public ResponseEntity<Beneficiario> cadastrarBeneficiario(@RequestBody BeneficiarioCreatedDto beneficiarioCreatedDto) {
        return new ResponseEntity<>(beneficiarioService.cadastrarBeneficiario(beneficiarioCreatedDto), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/beneficiarios/{id}")
    public ResponseEntity<Void> deletarBeneficiario(@PathVariable Integer id) {
        beneficiarioService.deletarBeneficiario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

