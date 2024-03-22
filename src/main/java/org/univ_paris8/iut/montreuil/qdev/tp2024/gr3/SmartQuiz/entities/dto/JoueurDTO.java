package org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.entities.dto;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr3.SmartQuiz.Utiles.Langues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JoueurDTO {
    private String prenom;
    private String pseudo;
    private int anneeNaissance;
    private Langues languePref;

    private String description;
    private List<String> centresDInteret;



    // private Statistiques statistiques

    public JoueurDTO(String prenom, String pseudo, int anneeNaissance, Langues languePref, String centresInterets) {
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.languePref = languePref;
        this.anneeNaissance = anneeNaissance;
        this.description = null;
        this.centresDInteret = new ArrayList<>(Arrays.asList(centresInterets.split(",")));
        //this.statistiques = statistiques
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }


    public List<String> getCentresDInteret() {
        return centresDInteret;
    }

    public void setCentresDInteret(List<String> centresDInteret) {
        this.centresDInteret = centresDInteret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoueurDTO joueurDTO = (JoueurDTO) o;
        return anneeNaissance == joueurDTO.anneeNaissance && Objects.equals(prenom, joueurDTO.prenom) && Objects.equals(pseudo, joueurDTO.pseudo) && Objects.equals(languePref, joueurDTO.languePref) && Objects.equals(centresDInteret, joueurDTO.centresDInteret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, pseudo, anneeNaissance, languePref, centresDInteret);
    }

    @Override
    public String toString() {
        return "JoueurDTO{" +
                "prenom='" + prenom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", anneeNaissance=" + anneeNaissance +
                ", languePref='" + languePref + '\'' +
                ", centresDInteret=" + centresDInteret +
                '}';
    }
}
