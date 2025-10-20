package com.aitbenmoumen.atelierrest.repositories;

import com.aitbenmoumen.atelierrest.entities.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CentreRepository extends JpaRepository<Centre, Long> {
}
