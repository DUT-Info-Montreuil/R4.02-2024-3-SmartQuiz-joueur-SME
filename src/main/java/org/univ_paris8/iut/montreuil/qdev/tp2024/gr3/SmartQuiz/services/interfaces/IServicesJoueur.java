package org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.Utiles.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.exceptions.DonneesSaisiesIncorrectesException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.exceptions.JoueurIntrouvableException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.exceptions.PseudoNonUniqueException;

public interface IServicesJoueur {

    JoueurDTO ajouterJoueur(String prenom, String pseudo, int anneeNaissance, Langues langue, String centreInterets)
            throws PseudoNonUniqueException, DonneesSaisiesIncorrectesException;
}
