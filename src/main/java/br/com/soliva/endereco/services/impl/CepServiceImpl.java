package br.com.soliva.endereco.services.impl;

import br.com.soliva.endereco.dto.AddressDTO;
import br.com.soliva.endereco.integrations.client.ViaCepClient;
import br.com.soliva.endereco.services.CepService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class CepServiceImpl implements CepService {

    private final ViaCepClient viaCepClient;

    @Override
    public AddressDTO getAddressByCep(String cep) {
        validateCep(cep);
        return viaCepClient.getAddressByCep(cep);
    }

    private void validateCep(String cep) {
        if (cep.length() != 8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cep Invalido.");
        }
    }
}
