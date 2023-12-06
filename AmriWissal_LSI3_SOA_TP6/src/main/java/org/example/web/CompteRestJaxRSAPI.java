package org.example.web;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.entities.Compte;
import org.example.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping("/banque")
    //Définition de la classe CompteRestJaxRSAPI
    public class CompteRestJaxRSAPI {
        @Autowired
        private CompteRepository compteRepository;
        @RequestMapping("/comptes")
        @GET
        @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
        @Transactional
        //récupération de  la liste des comptes bancaires au format JSON
        public List<Compte> compteList() {
            return compteRepository.findAll();
        }
        @GetMapping("/Comptes/{id}")
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        //récupération un compte spécifique par son identifiant
        public Compte getOne(@PathVariable("id") Long id) {
            return compteRepository.findById(id).orElse(null);
        }
        //récupération de la liste de tous les comptes
        @Path("/Comptes")
        @POST
        @Produces({MediaType.APPLICATION_JSON})
        //création d'un nouveau compte en utilisant les données fournies
        public void save(@RequestBody Compte compte) {
            compteRepository.save(compte);
        }

        @Path("Comptes/{id}")
        @PUT
        @Produces({MediaType.APPLICATION_JSON})
        //mis à jour un compte existant en utilisant les données fournies
        public Compte update(Compte compte, @PathVariable("id") Long id) {
            compte.setId(id);
            return compteRepository.save(compte);
        }
        @Path("/Comptes/{id}")
        @DELETE
        @Produces({MediaType.APPLICATION_JSON})
        //suppression d'un compte en fonction de son identifiant
        public void delete(@PathVariable("id") Long id) {
            compteRepository.deleteById(id);
        }

    }