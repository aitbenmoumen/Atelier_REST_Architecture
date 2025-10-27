package com.aitbenmoumen.clientrest.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class EtudiantClientService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost:8081/etudiants";
    private final String BASE_URL2 = "http://localhost:8081/etudiants/search/findEtudiantByNom?n={nom}";

    public List<Map<String, Object>> getAllEtudiants() {
        Map response = restTemplate.getForObject(BASE_URL, Map.class);
        return (List<Map<String, Object>>) ((Map)response.get("_embedded")).get("etudiants");
    }
    public List<Map<String, Object>> getEtudiantByNom(String nom) {
        Map response = restTemplate.getForObject(BASE_URL2, Map.class, nom);
        return (List<Map<String, Object>>) ((Map)response.get("_embedded")).get("etudiants");
    }
    public Map<String, Object> getEtudiantById(int id) {
        return restTemplate.getForObject(BASE_URL+"/"+id, Map.class, id);
    }
    public void addEtudiant(Map<String, Object> etudiant) {
        restTemplate.postForObject(BASE_URL, etudiant, Map.class);
    }
    public String deleteEtudiantById(int id) {
        restTemplate.delete(BASE_URL+"/"+id);
        return "Etudiant "+id+" deleted";
    }
    public String updateEtudiantById(int id, Map<String, Object> etudiant) {
        restTemplate.put(BASE_URL+"/"+id, etudiant);
        return "Etudiant "+id+" updated";
    }
    public List<Map<String, Object>> getEtudiants(int page, int size, String sort, String order) {
        String url = BASE_URL + "?page={page}&size={size}&sort={sort}&sort={order}";
        Map<String, Object> response = restTemplate.getForObject(url, Map.class, page, size, sort);
        return (List<Map<String, Object>>) ((Map)response.get("_embedded")).get("etudiants");
    }
}
