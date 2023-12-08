/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_tp_speed_click_amirault_bottraud;

/**
 *
 * @author guilenebottraud
 */
public class CelluleLumineuse {
    private boolean etat;
    public CelluleLumineuse(boolean par) {
        etat = false;// initialisation à éteinte 
    
    }

    /**
     * Permet d'activer la cellule c'est à dire changer son état initial
     */
    public void activerCellule(){ 
        etat= !etat;
    }
    
    /**
     * Permet d'eteindre la cellule
     */
    public void eteindreCellule(){
        etat = false;
    }
    
    /**
     * Permet de verifier l'etat de la cellule, ici voir si elle est eteinte 
     * @return
     */
    public boolean estEteint(){
    return !etat;
    }
    
    
   

    /**
     * Permet simplement de verifier l'etat de la cellule, ce qui nous donnera soit activée soit eteinte
     * @return
     */
    public boolean getEtat(){
        return etat;
        
    }
    
    /**
     * Permet d'avoir des X et O dans les cellules et non les references objets ce qui rend la lecture plus simple 
     * @return
     */
    @Override
    public String toString () {    // méthode string 
        
        if (etat){
            return "0";
        }else{
            return "X";
        }//
    }

}
