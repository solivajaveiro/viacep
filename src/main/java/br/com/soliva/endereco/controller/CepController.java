package br.com.soliva.endereco.controller;

import br.com.soliva.endereco.dto.AddressDTO;
import br.com.soliva.endereco.services.CepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/cep")
public class CepController {

    private CepService cepService;

    @Autowired
    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public AddressDTO getAddressByCep(@PathVariable("cep") String cep) {
        return cepService.getAddressByCep(cep);
    }
}
