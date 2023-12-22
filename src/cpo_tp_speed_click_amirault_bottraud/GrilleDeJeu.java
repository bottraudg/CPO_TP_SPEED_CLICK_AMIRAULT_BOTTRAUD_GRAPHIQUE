/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_tp_speed_click_amirault_bottraud;

import java.util.Random;

/**
 *
 * @author guilenebottraud
 */
public class GrilleDeJeu {
    private CelluleLumineuse[][] matriceCellules;
    private int nbLignes;
    private int nbColonne;

    public GrilleDeJeu(int nbColonne, int nbLignes) {
        this.nbColonne = nbColonne;
        this.nbLignes = nbLignes;
        matriceCellules = new CelluleLumineuse[nbLignes][nbColonne];// creation de la grille sous forme de tableau

        // Initialisation de la grille avec des cellules éteintes
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonne; j++) {
                matriceCellules[i][j] = new CelluleLumineuse(false);
            }
        }
    }
    
    
    public void EteindreToutesLesCellules (){
        for (int i =0; i<nbLignes ; i++){
            for (int j=0; j<nbColonne; j++){
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }
    
    public int[] ActiverUneCellule(){
        Random random = new Random();
         // Générer des indices aléatoires pour la ligne et la colonne
        int ligneAleatoire = random.nextInt(this.nbLignes);
        //System.out.println(ligneAleatoire);
        int colonneAleatoire = random.nextInt(this.nbColonne);

        // Allumer la cellule aléatoire
        matriceCellules[ligneAleatoire][colonneAleatoire].activerCellule();
        int tab[] = new int[2];
        tab[0] = ligneAleatoire;
        tab[1] = colonneAleatoire;
        return tab;
    }
    
    public void DesactiverUneCellule(){
        for (int i=0; i<nbLignes ; i++){
            for (int j=0; j<nbColonne; j++){
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonne() {
        return nbColonne;
    }

    public CelluleLumineuse[][] getMatriceCellules() {
        return matriceCellules;
    }
    
    
    
    
    /*public void melangerMatriceAleatoirement(int nbTours) {
        Random random = new Random();

        for (int tour = 0; tour < nbTours; tour++) {
            this.activerLigneColonneOuDiagonaleAleatoire();
        }}*/
  @Override
 
    public String toString() {
        String chaine = "   |";
        for (int i=0;i<nbLignes;i++){
                chaine+= " "+i+" |";
        }
       
        chaine += "\n";
       
        for (int i=0;i<nbLignes+1;i++){
            chaine+= "----";
        }
       
        chaine += "\n";
           
        for (int j=0;j<nbLignes;j++){
            chaine+= " "+j+" |";
            for (int k=0;k<nbColonne;k++){
                chaine+=" "+matriceCellules[j][k].toString()+" |";
            }
            chaine += "\n";
            for (int i=0;i<nbLignes+1;i++){
            chaine+= "----";
            }
            chaine += "\n";
        }
       
        return chaine;
    }   
}
