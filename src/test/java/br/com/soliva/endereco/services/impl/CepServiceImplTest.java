package br.com.soliva.endereco.services.impl;
import br.com.soliva.endereco.dto.AddressDTO;
import br.com.soliva.endereco.integrations.client.ViaCepClient;
import br.com.soliva.endereco.services.CepService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CepServiceImplTest {

    @Mock
    ViaCepClient viaCepClient;

    @InjectMocks
    private CepServiceImpl cepService;

    @Test
    void shouldGetAddress() {

        // Preparação
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCep("20230260");
        addressDTO.setLogradouro("Rua de Santana");
        addressDTO.setBairro("Centro");

        Mockito.when(viaCepClient.getAddressByCep(any())).thenReturn(addressDTO);

        // Execução
        AddressDTO response = viaCepClient.getAddressByCep("20230260");

        // Asserção
        Assertions.assertEquals("20230260", response.getCep());
        Assertions.assertEquals("Rua de Santana", response.getLogradouro());
        Assertions.assertEquals("Centro", response.getBairro());
    }
}