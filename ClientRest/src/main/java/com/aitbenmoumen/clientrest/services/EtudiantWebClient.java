package com.aitbenmoumen.clientrest.services;

import org.springframework.stereotype.Service;

@Service
public class EtudiantWebClient {
    private final WebClient webClient WebClient.create("http://localhost:8081");
}
