package com.santander.customers.service;

import javax.json.Json;
import javax.json.JsonObject;

import com.santander.customers.model.CepLog;
import com.santander.customers.repository.CepLogRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CepService implements Cep {

    private final CepLogRepository repository;
    private final RestTemplate restTemplate;

    public CepService (CepLogRepository repository) {
        this.repository = repository;
        this.restTemplate = this.restTemplate();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public boolean getCep(String cep) {

        // mockoon
        // exemple response: {"city": "Ubatuba"}
        String url = "http://localhost:3000/cep/02910055";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().value() == 200) {
            JsonObject jsonObject = Json.createReader(new StringReader(response.getBody())).readObject();

            var CepLog = new CepLog();
            CepLog.setId(UUID.randomUUID().toString());
            CepLog.setCity(jsonObject.getString("city"));
            CepLog.setDate(LocalDateTime.now());
            repository.save(CepLog);
            return true;
        }
        throw new RuntimeException("erro...");
    }

}