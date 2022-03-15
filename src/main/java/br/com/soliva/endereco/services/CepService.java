package br.com.soliva.endereco.services;

import br.com.soliva.endereco.dto.AddressDTO;

public interface CepService {

    AddressDTO getAddressByCep(String cep);
}
