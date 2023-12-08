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

    public GrilleDeJeu(int nbCellule, int nbCellule1) {
    }
    private CelluleLumineuse[][] matriceCellules;
    private int nbLignes;
    private int nbColonne;
    
    public void EteindreToutesLesCellules (){
        for (int i =0; i<nbLignes ; i++){
            for (int j=0; j<nbColonne; j++){
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }
    
    public void ActiverUneCellule(){
        for (int i=0; i<nbLignes ; i++){
            for (int j=0; j<nbColonne; j++){
                matriceCellules[i][j].activerCellule();
            }
        }
    }
    
    public void DesactiverUneCellule(){
        for (int i=0; i<nbLignes ; i++){
            for (int j=0; j<nbColonne; j++){
                matriceCellules[i][j].eteindreCellule();
            }
        }
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
