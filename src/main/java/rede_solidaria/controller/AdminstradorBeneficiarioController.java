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
import rede_solidaria.dto.beneficiarioDto.BeneficiarioCreatedDto;
import rede_solidaria.dto.beneficiarioDto.BeneficiarioResponseDto;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/admin")
public class AdminstradorBeneficiarioController {
    private final AdministradorBeneficiarioService administradorBeneficiarioService;
    
    @GetMapping("/beneficiarios/listar")
    public ResponseEntity<List<BeneficiarioResponseDto>> listarBeneficiarios() {
        return new ResponseEntity<>(administradorBeneficiarioService.listarBeneficiarios(), HttpStatus.OK);
    }

    @PostMapping("/beneficiarios/cadastrar")
    public ResponseEntity<String> cadastrarBeneficiario(@Valid @RequestBody BeneficiarioCreatedDto beneficiarioCreatedDto) {
        administradorBeneficiarioService.cadastrarBeneficiario(beneficiarioCreatedDto);
        return new ResponseEntity<>("Beneficiário cadastrado com sucesso", HttpStatus.CREATED);
    }
    
    @DeleteMapping("/beneficiarios/{id}")
    public ResponseEntity<String> deletarBeneficiario(@PathVariable Integer id) {
        administradorBeneficiarioService.deletarBeneficiario(id);
        return new ResponseEntity<>("Beneficiário deletado com sucesso", HttpStatus.NO_CONTENT);
    }
}

