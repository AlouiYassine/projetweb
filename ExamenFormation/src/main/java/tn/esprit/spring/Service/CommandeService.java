package tn.esprit.spring.Service;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Commande;
import tn.esprit.spring.Interface.ICommandeService;
import tn.esprit.spring.Repository.CommandeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommandeService implements ICommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }

    @Override
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Long id, Commande updatedCommande) {
        if (commandeRepository.existsById(id)) {
            updatedCommande.setMat_commande(id);
            return commandeRepository.save(updatedCommande);
        } else {
            // Handle not found
            return null;
        }
    }

    @Override
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}