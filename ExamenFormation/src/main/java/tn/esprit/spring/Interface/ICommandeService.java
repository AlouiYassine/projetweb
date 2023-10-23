package tn.esprit.spring.Interface;





import tn.esprit.spring.Entity.Commande;

import java.util.List;
import java.util.Optional;

public interface ICommandeService {

    List<Commande> getAllCommandes();

    Optional<Commande> getCommandeById(Long id);

    Commande createCommande(Commande commande);

    Commande updateCommande(Long id, Commande updatedCommande);

    void deleteCommande(Long id);
}
