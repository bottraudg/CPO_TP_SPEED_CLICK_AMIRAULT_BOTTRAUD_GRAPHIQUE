/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_tp_speed_click_amirault_bottraud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;

/**
 *
 * @author guilenebottraud
 */
public class GrilleDeJeu extends JPanel {
    private CelluleLumineuse[][] matriceCellules;
    private int nbLigne;
    private int nbColonne;
    private int score;
    private boolean lancée = false;
    private int mode = 0;
    private int cellulesRestantes = 0;

    public GrilleDeJeu(int nbColonne, int nbLigne) {
        
        Reset(nbColonne, nbLigne);
    }

    private void Reset(int nbc, int nbl)
    {
        this.removeAll();
        this.nbColonne = nbc;
        this.nbLigne = nbl;
        matriceCellules = new CelluleLumineuse[nbLigne][nbColonne];// creation de la grille sous forme de tableau
        this.setLayout(new GridLayout(nbLigne, nbColonne));
        // Initialisation de la grille avec des cellules éteintes
        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
                matriceCellules[i][j] = new CelluleLumineuse(i,j, mode);
                matriceCellules[i][j].addActionListener(new onButtonClick(i, j));
                this.add(matriceCellules[i][j]);
            }
        }
        matriceCellules[0][0].Colorer(Color.GREEN);
        matriceCellules[0][1].Colorer(Color.BLUE);
        matriceCellules[0][2].Colorer(Color.RED);
        lancée = false;
        repaint();
    }

    public class onButtonClick implements ActionListener{
        private int i;
        private int j;

        onButtonClick(int i, int j)
        {
            this.i = i;
            this.j = j;
        }

        public void actionPerformed(ActionEvent e)
        {
            if (!lancée)
            {
                if (i == 0 && j <= 3)
                {
                    mode = j;
                    Start();
                }
            }
            else
            {
                if (mode <= 1) //facile ou moyen
                {
                    if (matriceCellules[i][j].etat)
                    {
                        score += 1;
                    }
                    else
                    {
                        score -= 1;
                    }
                    EteindreToutesLesCellules();
                    ActiverUneCellule();
                }
                else // dur
                {
                    if (matriceCellules[i][j].etat)
                    {
                        matriceCellules[i][j].eteindreCellule();
                        cellulesRestantes -= 1;
                        if (cellulesRestantes <= 0)
                        {
                            score += 1;
                            EteindreToutesLesCellules();
                            ActiverDeuxCellules();
                        }
                    }
                    else
                    {
                        score -= 1;
                        EteindreToutesLesCellules();
                        ActiverDeuxCellules();
                    }
                }
            }
        }
    }

    public void Start()
    {
        Reset(mode +3 , mode +3);
        score = 0;
        lancée = true;
        matriceCellules[0][0].Colorer(Color.WHITE);
        matriceCellules[0][1].Colorer(Color.WHITE);
        matriceCellules[0][2].Colorer(Color.WHITE);
        EteindreToutesLesCellules();
        if (mode <= 1)
        {
            ActiverUneCellule();
        }
        else
        {
            ActiverDeuxCellules();
        }
    }

    public void Stop()
    {
        Reset(3,3);
    }

    public int GetScore()
    {
        return score;
    }

    public boolean IsStarted()
    {
        return lancée;
    }
    
    public void EteindreToutesLesCellules (){
        for (int i =0; i<nbLigne ; i++){
            for (int j=0; j<nbColonne; j++){
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }
    
    public int[] ActiverUneCellule(){
        Random random = new Random();
         // Générer des indices aléatoires pour la ligne et la colonne
        int ligneAleatoire = random.nextInt(this.nbLigne);
        //System.out.println(ligneAleatoire);
        int colonneAleatoire = random.nextInt(this.nbColonne);

        // Allumer la cellule aléatoire
        matriceCellules[ligneAleatoire][colonneAleatoire].activerCellule();
        int tab[] = new int[2];
        tab[0] = ligneAleatoire;
        tab[1] = colonneAleatoire;
        return tab;
    }

    public void ActiverDeuxCellules(){
        Random random = new Random();
        int compteAllumées = 0;
        while (compteAllumées < 2) {
            int ligneAleatoire = random.nextInt(this.nbLigne);
            int colonneAleatoire = random.nextInt(this.nbColonne);
            if (!matriceCellules[ligneAleatoire][colonneAleatoire].etat)
            {
                matriceCellules[ligneAleatoire][colonneAleatoire].activerCellule();
                compteAllumées++;
            }
        }
        cellulesRestantes = 2;
    }
    
    public void DesactiverUneCellule(){
        for (int i=0; i<nbLigne ; i++){
            for (int j=0; j<nbColonne; j++){
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    public int getNbLignes() {
        return nbLigne;
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
        for (int i=0;i<nbLigne;i++){
                chaine+= " "+i+" |";
        }
       
        chaine += "\n";
       
        for (int i=0;i<nbLigne+1;i++){
            chaine+= "----";
        }
       
        chaine += "\n";
           
        for (int j=0;j<nbLigne;j++){
            chaine+= " "+j+" |";
            for (int k=0;k<nbColonne;k++){
                chaine+=" "+matriceCellules[j][k].toString()+" |";
            }
            chaine += "\n";
            for (int i=0;i<nbLigne+1;i++){
            chaine+= "----";
            }
            chaine += "\n";
        }
       
        return chaine;
    }   
}
