/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_tp_speed_click_amirault_bottraud;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author guilenebottraud
 */
public class Partie {
 private GrilleDeJeu grille;
    int difficulte;// nb de coups 
    Scanner scanner;
    String niveau;
    int timer = 10; 
    boolean victoire;

    public Partie() {
        System.out.println("Bienvenue dans le jeu Speed Click!");
        scanner = new Scanner(System.in);
        while (difficulte == 0) {
            System.out.println("Choisisez un niveau ( facile/ moyen/ difficile ) : ");
            
            niveau = scanner.nextLine();
            int nbCellule = 0;
            // NIVEAU FACILE 
            if (niveau.equalsIgnoreCase("facile")) {
               
                nbCellule = 3; // taille de la grille - matrice 
                difficulte = 50;// nb de coups
                timer = 50;// temps 
            }
            if (niveau.equalsIgnoreCase("moyen")) {
                //grille = new GrilleDeCellules(4, 4); 
                nbCellule = 4;// taille de la grille / matrice 
                difficulte = 50;//nb de coups
                timer = 25;// temps 
            }
            if (niveau.equalsIgnoreCase("difficile")) {
                nbCellule = 5;// taille de la grille / matrice  
                difficulte = 10;//nb de coups
                timer= 15;// temps 
            }
            
             grille = new GrilleDeJeu(nbCellule, nbCellule); // Crée une nouvelle grille à taille variable 
        

        }// fin while 

    }// fin public partie 
     public void initialiserPartie() {
        grille.EteindreToutesLesCellules(); // eteint toutes les cellules
     }
    
    public void lancerPartie() {
        initialiserPartie();
        
        CountDownLatch countDownLatch = new CountDownLatch(timer);// Compte a rebours 
        for (int i = timer; i > 0; i++) {
            System.out.println("Temps restant : " + i + " secondes");
            try {
                Thread.sleep(1000); // Attendre 1 seconde
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Après le compte à rebours, vous pouvez effectuer des actions supplémentaires
        System.out.println("Temps écoulé. Fin du compte à rebours.");

        for (int i = 0; i < timer; i++) {
            System.out.println(grille);
            if (difficulte == 0) {
                System.out.println("C'est gagné");
                victoire = true; 
                break;// arret de la boucle while si toute les cellules sont allumées 
            } 
            String coup;
            System.out.println("Sur quelle ligne voulez vous desactiver la cellule ? ");
            int ligne = scanner.nextInt();// rentrer un chiffre entre 0 et nbLigne
                    scanner.nextLine();
                    grille.ActiverUneCellule();
            scanner.reset();
            coup = scanner.nextLine();// enter ligne ou colonne ou diagonale
           
                 
            }
        }
        //if (!victoire) {
           // System.out.println("Tu as perdu.");
        
    
}// fin public class partie 
