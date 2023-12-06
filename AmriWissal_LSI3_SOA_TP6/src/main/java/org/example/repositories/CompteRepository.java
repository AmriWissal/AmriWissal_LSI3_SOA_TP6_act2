package org.example.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entities.Compte;
import org.springframework.stereotype.Repository;
@Repository // Indique que cette interface est un composant Spring et devrait être détectée lors de l'analyse des composants

public interface CompteRepository extends JpaRepository<Compte,Long> {
// Cette interface hérite de méthodes  fournies par JpaRepository
// pour manipuler les entités de type Compte dans la base de données.
}
