package cpo_tp_speed_click_amirault_bottraud;
import cpo_tp_speed_click_amirault_bottraud.GrilleDeJeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author guilenebottraud
 */
public class FenetrePrincipaleSpeed extends javax.swing.JFrame {
    
    public GrilleDeJeu grille;
    private int nbSecondes;
    private Timer monChrono;
    private int limiteDeTemps;
    private int score;
    private JLabel scoreLabel;
    private JLabel timerLabel;

    /**
     * Creates new form FenetrePrincipaleSpeed
     */
    public FenetrePrincipaleSpeed(int taille, int limit) {
        initComponents();
         int nbColonne = taille;
        int nbLigne = taille;
        nbSecondes = 0;
        this.limiteDeTemps = limit;
        this.score = 0;
        PanelGrille = new javax.swing.JPanel();
        PanelGrille.setLayout(new BoxLayout(PanelGrille, BoxLayout.Y_AXIS));

        this.grille = new GrilleDeJeu(nbLigne, nbColonne);

        scoreLabel = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        
        PanelGrille.add(scoreLabel);
        PanelGrille.add(timerLabel);
        PanelGrille.add(grille);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelGrille)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelGrille)
        );
        
        ActionListener tache_recurrente = new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                nbSecondes++;
                timerLabel.setText("Temps restant : " + (limiteDeTemps - nbSecondes) + "s");
                if (nbSecondes >= limiteDeTemps)
                {
                    grille.Stop();
                    monChrono.stop();
                }
            }
        };

        ActionListener refresh = new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                RefreshScore();
            }
        };

		/* instanciation du timer */
	    monChrono = new Timer(1000, tache_recurrente);
        var refreshChrono = new Timer(50, refresh);
        refreshChrono.start();

        this.pack();
        this.revalidate();
    }

    public void RefreshScore()
    {
        if (grille.IsStarted())
        {
            if (!monChrono.isRunning())
            {
                nbSecondes = 0;
                monChrono.start();
            }
            score = grille.GetScore();
            scoreLabel.setText("Score : " + score);
            repaint();
        }
        else
        {
            scoreLabel.setText("Score : " + score);
            timerLabel.setText("Nouvelle partie? Cliquez sur VERT pour une partie facile, BLEU pour moyen, ROUGE pour dur...");
        }
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelGrille = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PanelGrilleLayout = new javax.swing.GroupLayout(PanelGrille);
        PanelGrille.setLayout(PanelGrilleLayout);
        PanelGrilleLayout.setHorizontalGroup(
            PanelGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelGrilleLayout.setVerticalGroup(
            PanelGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        getContentPane().add(PanelGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipaleSpeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipaleSpeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipaleSpeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipaleSpeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                var window =  new FenetrePrincipaleSpeed(3,10);
                window.setSize(600,650);
                window.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGrille;
    // End of variables declaration//GEN-END:variables
}
