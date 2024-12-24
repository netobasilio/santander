package com.santander.customers.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Cep {
    boolean getCep(String cep) throws JsonProcessingException;
}
