package com.santander.customers.controller;

import com.santander.customers.service.CepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cep")
public class CepController {

    private final CepService service;

    public CepController(CepService service) {
        this.service = service;
    }

    @GetMapping("{cep}")
    public ResponseEntity<Object> cep(@PathVariable("cep") String cep) {
        try {
            service.getCep(cep);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
