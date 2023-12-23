/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_tp_speed_click_amirault_bottraud;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author guilenebottraud
 */

public class CelluleLumineuse extends JButton {

    //CelluleLumineuse celluleLumineuseAssociee;
    int i;
    int j;
    boolean etat;
    int mode;
    Color parDefaut = Color.WHITE;

    // constructeur (appelé depuis FenetrePrincipale)

    /**
     * permet de creer une des cellules
     * @param i
     * @param j
     * @param mode
     */
    public CelluleLumineuse(int i, int j, int mode) {
        //this.celluleLumineuseAssociee = celluleLumineuseAssociee;
        this.i = i;
        this.j = j;
        this.mode = mode;
        etat = false;
        repaint();
    }
    // Methode gérant le dessin de la cellule @Override

    /**
     * savoit si la cellule est eteinte ou pas 
     * @return
     */
    public boolean estEteint(){
        return etat;
    }

    /**
     * permet de mettre 3 couleurs differente pour choisir les niveaux 
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w=this.getWidth();
        int h=this.getHeight();
    
        if (etat)
        {
            if (mode == 0)
            {
                g.setColor(Color.GREEN);  
            }
            else if (mode == 1)
            {
                g.setColor(Color.BLUE);
            }
            else
            {
                g.setColor(Color.RED);
            }
        }
        else
        {
            g.setColor(parDefaut); 
        }
        g.fillOval(2, 2, w-4, h-4);
    }

    /**
     * gere la couleur 
     * @param c
     */
    public void Colorer(Color c)
    {
        parDefaut = c;
        repaint();
    }
    
    /**
     * allume une cellule
     */
    public void activerCellule(){
        etat = true;
        repaint();
    }

    /**
     * eteint une cellule 
     */
    public void eteindreCellule(){
        etat = false;
        repaint();
    }

}