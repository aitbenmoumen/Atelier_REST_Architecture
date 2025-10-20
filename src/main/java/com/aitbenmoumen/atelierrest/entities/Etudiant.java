package com.aitbenmoumen.atelierrest.entities;

import com.aitbenmoumen.atelierrest.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Students")
@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nom_et" ,nullable = false)
    private String nom;
    @Column(name="prenom_et" ,nullable = false)
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    private Centre centre;
}
