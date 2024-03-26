package org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.services.impl;
import org.junit.Assert;
import org.junit.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.Utiles.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.exceptions.DonneesSaisiesIncorrectesException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.exceptions.PseudoNonUniqueException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.services.interfaces.IServicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.services.mocks.ServicesJoueurMock;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

public class ServiceJoueurTest {
    @Test
    public void ajouterJoueur() throws PseudoNonUniqueException, DonneesSaisiesIncorrectesException {
        IServicesJoueur service = new ServicesJoueurMock();

        String prenom = "John";
        String pseudo = "john12";
        int anneeNaissance = 1990;
        Langues langue = Langues.english;
        String centresInterets = "Sport,Musique";

        JoueurDTO joueurDTO = service.ajouterJoueur(prenom, pseudo, anneeNaissance, langue, centresInterets);
        //JoueurDTO joueurDTO1 = service.ajouterJoueur("riri", "riri21", 2003, Langues.english, "Sport,Musique");

        Assert.assertEquals(prenom, joueurDTO.getPrenom());
        Assert.assertEquals(pseudo, joueurDTO.getPseudo());
        Assert.assertEquals(anneeNaissance, joueurDTO.getAnneeNaissance());
        Assert.assertEquals(langue, joueurDTO.getLanguePref());
        Assert.assertEquals(Arrays.asList("Sport", "Musique"), joueurDTO.getCentresDInteret());

    }

    @Test(expected = PseudoNonUniqueException.class)
    public void testAjouterJoueurSansDoublon() throws PseudoNonUniqueException, DonneesSaisiesIncorrectesException {
        IServicesJoueur service = ServicesJoueurImpl.getInstance();

        String prenom = "John";
        String pseudo = "john123";
        int anneeNaissance = 1990;
        Langues langue = Langues.english;
        String centresInterets = "Sport,Musique";

        service.ajouterJoueur(prenom, pseudo, anneeNaissance, langue, centresInterets);
        service.ajouterJoueur(prenom, pseudo, anneeNaissance, langue, centresInterets);

        assertThrows(PseudoNonUniqueException.class, () -> {
            service.ajouterJoueur(prenom, pseudo, anneeNaissance, langue, centresInterets);
        });
    }

    @Test(expected = DonneesSaisiesIncorrectesException.class)
    public void testSaisiesIncorrectes() throws PseudoNonUniqueException, DonneesSaisiesIncorrectesException {
        //ServicesJoueurMock service = new ServicesJoueurMock();
        IServicesJoueur service = ServicesJoueurImpl.getInstance();
        String prenom = "";
        String pseudo = null;
        int anneeNaissance = 1990;
        Langues langue = Langues.english;
        String centresInterets = "Sport,Musique";

        service.ajouterJoueur(prenom, pseudo, anneeNaissance, langue, centresInterets);
        assertThrows(DonneesSaisiesIncorrectesException.class, () -> {
            service.ajouterJoueur(prenom, pseudo, anneeNaissance, langue, centresInterets);
        });
    }
}