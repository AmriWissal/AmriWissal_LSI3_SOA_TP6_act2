package org.example.entities; // definition  du package
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
@Getter //Génère automatiquement les méthodes getters pour tous les champs de la classe
@Setter //Génère automatiquement les méthodes setters pour tous les champs de la classe
@NoArgsConstructor //Génère automatiquement un constructeur sans parametres
@AllArgsConstructor // Génère automatiquement un constructeur avec parametres
@ToString // Génère automatiquement la méthode toString pour la classe
@Table //Spécifie que cette classe est mappée sur une table de base de données.
@Entity // Indique que cette classe est une entité JPA
//Definition de la classe compte
public class Compte {
    @Id // indique que cette entité est un clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie la stratégie de génération de la valeur de la clé primaire
    // Declaration des attributs
   @Column // Indique que le champ est mappé sur une colonne de la table.
    Long Id ;
    @Column
    double solde ;
    @Column
    Date dateCreation ;
    @Column
    TypeCompte type;
    @Column
    EtatCompte etat ;
}
