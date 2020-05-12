package com.mcommandes.web.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mcommandes.dao.CommandesDao;
import com.mcommandes.model.Commande;
import com.mcommandes.web.exceptions.CommandeNotFoundException;
import com.mcommandes.web.exceptions.ImpossibleAjouterCommandeException;


@RestController
public class CommandeController {

    @Autowired
    CommandesDao commandesDao;
    List<Commande>	employeeList =new ArrayList<Commande>();
    
//    @PostMapping("/savecommandes")
//    @ResponseStatus(HttpStatus.CREATED)
//    Commande newBook(@Valid @RequestBody Commande newBook) {
//    	if(nouvelleCommande == null) throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");
//        return commandesDao.save(newBook);
//    }

    @PostMapping (value = "/savecommandes")
    public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande){

        Commande nouvelleCommande = commandesDao.save(commande);

  if(nouvelleCommande == null) throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");

        return new ResponseEntity<Commande>(commande, HttpStatus.CREATED);
    }
    @GetMapping(value = "/")
    public String strtUneCommande(){
    	return "Hello Controller";
    }
    @GetMapping(value = "/commandes")
    public List<Commande> recupererUneCommande(){
    	
    	employeeList=commandesDao.findAll();
    	return employeeList;
    
    }
    @PutMapping(value = "/commandes/{id}")
 
    public Commande update(@RequestBody @Valid Commande commande) {
        return commandesDao.save(commande);
    }
    
    @GetMapping(value = "/commandes/{id}")
    public Optional<Commande> recupererUneCommande(@PathVariable int id){

        Optional<Commande> commande = commandesDao.findById(id);

        if(!commande.isPresent()) throw new CommandeNotFoundException("Cette commande n'existe pas");

        return commande;
    }
//    @DeleteMapping("/books/{id}")
//    void deleteBook(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
	@DeleteMapping("/commandes/{id}")
	public void delete(@PathVariable("id") int id) {
		commandesDao.deleteById(id);

	}
}
