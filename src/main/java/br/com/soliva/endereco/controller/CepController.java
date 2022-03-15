package br.com.soliva.endereco.controller;

import br.com.soliva.endereco.dto.AddressDTO;
import br.com.soliva.endereco.services.CepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(CepController.BASE_URL)
public class CepController {

    public static final String GET_ADDRESS_BY_CEP = "/{cep}";
    public static final String BASE_URL = "/cep";

    private CepService cepService;

    @Autowired
    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping(GET_ADDRESS_BY_CEP)
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO getAddressByCep(@PathVariable("cep") String cep) {
        return cepService.getAddressByCep(cep);
    }
}
