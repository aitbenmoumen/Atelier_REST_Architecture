package com.aitbenmoumen.clientrest.controllers;

import com.aitbenmoumen.clientrest.services.EtudiantClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("etudiants")
public class EtudiantClientController {
    @Autowired
    private EtudiantClientService service;
    @GetMapping
    public List<Map<String, Object>> getEtudiants() {
        return service.getAllEtudiants();
    }
    @GetMapping("/{p}")
    public Map<String, Object> getEtudiant(@PathVariable("p") int id) {
        return service.getEtudiantById(id);
    }
    @PostMapping
    public void addEtudiant(@RequestBody Map<String, Object> etudiant) {
        service.addEtudiant(etudiant);
    }
}
