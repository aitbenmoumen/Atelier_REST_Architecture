package com.aitbenmoumen.atelierrest;

import com.aitbenmoumen.atelierrest.entities.Centre;
import com.aitbenmoumen.atelierrest.entities.Etudiant;
import com.aitbenmoumen.atelierrest.enums.Genre;
import com.aitbenmoumen.atelierrest.repositories.CentreRepository;
import com.aitbenmoumen.atelierrest.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class AtelierRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtelierRestApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository, CentreRepository centreRepository) {
        return args -> {
            for (int i = 0; i < 3; i++) {
                Centre c = Centre.builder()
                        .adresse("adresse" + i)
                        .nomCentre("centre " + i)
                        .build();
                centreRepository.save(c);
            }

            List<Centre> centres = centreRepository.findAll();
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                Centre randomCentre = centres.get(random.nextInt(centres.size()));

                Etudiant et = Etudiant.builder()
                        .nom("Etudiant" + i)
                        .prenom("P_Etudiant" + i)
                        .genre(Math.random() > 0.5 ? Genre.HOMME : Genre.FEMME)
                        .centre(randomCentre)
                        .build();

                etudiantRepository.save(et);
            }
        };
    }
}
