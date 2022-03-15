package br.com.soliva.endereco.integrations.client;

import br.com.soliva.endereco.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "via-cep", url = "viacep.com.br/ws/")
public interface ViaCepClient {

    @GetMapping("{cep}/json/")
    AddressDTO getAddressByCep(@PathVariable("cep") String cep);
}
