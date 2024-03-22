package org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.services.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.Utiles.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.exceptions.DonneesSaisiesIncorrectesException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.exceptions.JoueurIntrouvableException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.exceptions.PseudoNonUniqueException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.services.interfaces.IServicesJoueur;

import java.util.ArrayList;

public class ServicesJoueurMock implements IServicesJoueur {
    ArrayList<JoueurDTO> listeJoueurs;
    public ServicesJoueurMock() {
        this.listeJoueurs = new ArrayList<>();
    }

    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int anneeNaissance, Langues langue, String centreInterets) throws PseudoNonUniqueException, DonneesSaisiesIncorrectesException {
        if (prenom.isEmpty() || pseudo.isEmpty() || centreInterets.isEmpty()) {
            throw new DonneesSaisiesIncorrectesException("");
        }
        if (listeJoueurs.stream().anyMatch(joueur -> joueur.getPseudo().equals(pseudo))) {
            throw new PseudoNonUniqueException("");
        }
        JoueurDTO j1 = new JoueurDTO(prenom, pseudo, anneeNaissance, langue, centreInterets);
        listeJoueurs.add(j1);

        return j1;
    }

    @Override
    public boolean supprimerJoueur(String pseudo) throws JoueurIntrouvableException, DonneesSaisiesIncorrectesException {
        return false;
    }

}
