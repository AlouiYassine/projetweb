package tn.esprit.spring.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Commande;
import tn.esprit.spring.Repository.CommandeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commande")
@CrossOrigin(origins = "*")
public class CommandeController {
    @Autowired
    private CommandeRepository commandeRepository;

    @GetMapping("get")
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Commande> getCommandeById(@PathVariable Long id) {
        return commandeRepository.findById(id);
    }

    @PostMapping("add")
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeRepository.save(commande);
    }

    @PutMapping("update/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande updatedCommande) {
        if (commandeRepository.existsById(id)) {
            updatedCommande.setMat_commande(id);
            return commandeRepository.save(updatedCommande);
        } else {
            // Handle not found
            return null;
        }
    }

    @DeleteMapping("delete/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeRepository.deleteById(id);
    }
}
