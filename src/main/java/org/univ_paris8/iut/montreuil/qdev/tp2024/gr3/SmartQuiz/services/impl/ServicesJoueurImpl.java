package org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.Utiles.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.exceptions.DonneesSaisiesIncorrectesException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.exceptions.JoueurIntrouvableException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.exceptions.PseudoNonUniqueException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.services.interfaces.IServicesJoueur;

import java.util.ArrayList;
import java.util.List;

public class ServicesJoueurImpl implements IServicesJoueur {
    private static ServicesJoueurImpl instance;
    private List<JoueurDTO> listeJoueurs;

    private ServicesJoueurImpl() {
        listeJoueurs = new ArrayList<>();
    }

    public static ServicesJoueurImpl getInstance() {
        if (instance == null) {
            synchronized (ServicesJoueurImpl.class) {
                if (instance == null) {
                    instance = new ServicesJoueurImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int anneeNaissance, Langues langue, String centreInterets) throws PseudoNonUniqueException, DonneesSaisiesIncorrectesException {
        // Vérifier si les données saisies sont correctes
        if (prenom == null || prenom.isEmpty() || pseudo == null || pseudo.isEmpty() || langue == null || centreInterets == null || centreInterets.isEmpty()) {
            throw new DonneesSaisiesIncorrectesException("Les données saisies sont incomplètes ou incorrectes.");
        }

        // Vérifier si le pseudo est unique
        synchronized (listeJoueurs) {
            for (JoueurDTO joueur : listeJoueurs) {
                if (joueur.getPseudo().equals(pseudo)) {
                    throw new PseudoNonUniqueException("Le pseudo \"" + pseudo + "\" est déjà utilisé.");
                }
            }

            JoueurDTO nouveauJoueur = new JoueurDTO(prenom, pseudo, anneeNaissance, langue, centreInterets);
            listeJoueurs.add(nouveauJoueur);
            return nouveauJoueur;
        }
    }

    @Override
    public boolean supprimerJoueur(String pseudo) throws JoueurIntrouvableException {
        synchronized (listeJoueurs) {
            boolean joueurTrouve = listeJoueurs.stream().anyMatch(joueur -> joueur.getPseudo().equals(pseudo));
            if (!joueurTrouve) {
                throw new JoueurIntrouvableException("Aucun joueur avec le pseudo '" + pseudo + "' n'a été trouvé.");
            }
            return listeJoueurs.removeIf(joueur -> joueur.getPseudo().equals(pseudo));
        }
    }



}
