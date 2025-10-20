package com.aitbenmoumen.atelierrest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "centres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomCentre;
    private String adresse;

    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;
}
