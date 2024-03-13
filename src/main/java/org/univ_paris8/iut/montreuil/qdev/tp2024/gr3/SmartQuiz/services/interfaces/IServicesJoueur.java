package org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.Utiles.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.entities.dto.JoueurDTO;

import java.util.ArrayList;

public interface IServicesJoueur {

    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int anneeNaissance, Langues langue, String centreInterets);
}