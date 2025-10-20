package com.aitbenmoumen.atelierrest.repositories;

import com.aitbenmoumen.atelierrest.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
