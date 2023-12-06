package org.example.AmriWissal_LSI3_SOA_TP6;
import org.example.entities.Compte;
import org.example.entities.EtatCompte;
import org.example.entities.TypeCompte;
import org.example.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.Date;
import java.util.List;
@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.repositories")
@EntityScan("org.example.entities")
@ComponentScan("org.example")
public class
AmriWissalLSI3SOATP6APPLICATION {
        public static void main(String[] args) {
            // Lancement de  l'application Spring Boot
            SpringApplication.run(AmriWissalLSI3SOATP6APPLICATION.class,args);

        }
        @Bean  // Bean utilisé pour exécuter des opérations au démarrage de l'application
        public CommandLineRunner initData(CompteRepository compteRepository) {
            return (args) -> {
                // Ajout des comptes à la base de données
                compteRepository.save(new Compte(null, 200, new Date(), TypeCompte.COURANT, EtatCompte.ACTIVE));
                compteRepository.save(new Compte(null, 200, new Date(), TypeCompte.EPARGNE, EtatCompte.SUSPENDU));
                compteRepository.save(new Compte(null, 200, new Date(), TypeCompte.EPARGNE, EtatCompte.BLOQUE));
                // Récupèreration de  tous les comptes de la base de données
                List<Compte> comptes = compteRepository.findAll();
                // Affichage des soldes des comptes
                for (Compte compte : comptes) {
                    System.out.println(" le Solde du compte est  " + compte.getId() + ": " + compte.getSolde());
                }

            };
        }
}
