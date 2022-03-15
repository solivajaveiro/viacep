package br.com.soliva.endereco.services.impl;

import br.com.soliva.endereco.dto.AddressDTO;
import br.com.soliva.endereco.integrations.client.ViaCepClient;
import br.com.soliva.endereco.services.CepService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CepServiceImpl implements CepService {

    private ViaCepClient viaCepClient;

    @Override
    public AddressDTO getAddressByCep(String cep) {
        return viaCepClient.getAddressByCep(cep);
    }
}
