
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme
 */
public class frmJogo extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form frmJogo
     */
    
    Game game;
    boolean gameover = false;
    
    public frmJogo() {
        this.setExtendedState(MAXIMIZED_BOTH);  
        initComponents();
        game  = new Game(getWidth(),getHeight());
        createBufferStrategy(2);
       // game  = new Game(getWidth(),getHeight());
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 900));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       
            //game.r.direcaoBarra(-1,getWidth());
        if(evt.getKeyCode() == KeyEvent.VK_SPACE)
            game.r.setSobe(true);
            //game.r.direcaoBarra(1,getWidth());
        if(evt.getKeyCode() == KeyEvent.VK_M)
            game.r.atira();
        
        if(evt.getKeyCode() == KeyEvent.VK_R)
        { 
            game.reiniciar = true;
            gameover = false;
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_SPACE)
            game.r.setSobe(false);
            //game.r.direcaoBarra(-1,getWidth());
       
    }//GEN-LAST:event_formKeyReleased

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
            java.util.logging.Logger.getLogger(frmJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
          Graphics g;
          
            //int timer = 0;
                 
            while(true)
            {
                game.reiniciar();
                if(!gameover)
                {    
                    
                    //CRIA FUNDO BRANCO
                    g = getBufferStrategy().getDrawGraphics();
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, getWidth(), getHeight());

                    //RENDERIZA E CONTROLA RAQUETE
                    g.setColor(Color.BLACK);
                    game.r.direcaoBarra(getHeight(),getWidth());
                    g.fillRect(game.r.getX(), game.r.getY(), game.r.getLargura(), game.r.getAltura());


                    //RENDERIZA TIROS
                    for(Tiro t : game.r.tiros)
                    {
                        g.fillRect(t.getX(), t.getY(), t.getLargura(), t.getAltura());
                        t.setX(t.getX()+ t.getVelocidade());
                    }

                     //RENDERIZA BORDAS
                     g.setColor(Color.BLUE);
                    g.fillRect(game.bordaInferior.getX(),game.bordaInferior.getY(),game.bordaInferior.getLargura(),game.bordaInferior.getAltura());
                    g.fillRect(game.bordaSuperior.getX(),game.bordaSuperior.getY(),game.bordaSuperior.getLargura(),game.bordaSuperior.getAltura());


                    //RENDERIZA E CONTROLA INIMIGOS
                    g.setColor(Color.red);
                    for(Inimigo i : game.inimigos)
                    {
                        g.fillRect(i.getX(), i.getY(), i.getLargura(), i.getAltura());
                    }
                    game.moveInimigos();
                    game.respawn++;
                    if(game.respawn>=100)  
                        game.criaInimigo();

                    //RENDERIZA PONTUACAO
                    g.setColor(Color.BLACK);
                    g.drawString("Pontos: "+game.pontuacao, 50, 50);
                    game.pontuacao++;


                    //CHECA COLISOES
                    if(game.r.checaColisao(game.bordaInferior.getRetangulo()))
                    {
                         game.limpaTela(g);
                        g.setColor(Color.BLACK);
                        g.drawString("GAME OVER", 300, 300);
                        g.drawString("APERTE R PARA REINICIAR", 400, 300);
                        gameover=true;
                    }
                    if(game.r.checaColisao(game.bordaSuperior.getRetangulo()))
                    {
                        game.limpaTela(g);
                        g.setColor(Color.BLACK);
                        g.drawString("GAME OVER", 300, 300);
                        g.drawString("APERTE R PARA REINICIAR", 400, 300);
                        gameover=true;
                    }

                    boolean excluirInimigo = false;
                    for(Inimigo i: game.inimigos)
                    {
                        if(i.checaColisao(game.r.getRetangulo()))
                        {

                             game.limpaTela(g);
                             g.setColor(Color.BLACK);
                             g.drawString("GAME OVER", 300, 300);
                             g.drawString("APERTE R PARA REINICIAR", 400, 300);
                             gameover=true;
                        }
                        for(Tiro t : game.r.tiros)
                       {
                             if(t.checaColisao(i.getRetangulo()))
                            {
                                 game.inimigosDestruidos.add(i);
                                 excluirInimigo=true;
                            }
                       }
                    }
                     if(excluirInimigo)
                    {
                        game.inimigos.removeAll(game.inimigosDestruidos);
                        game.r.tiros.removeAll(game.r.tirosDestruidos);
                    }



                    g.dispose();
                    getBufferStrategy().show();
                      try {
                          Thread.sleep(5);
                      } catch (InterruptedException ex) {
                          Logger.getLogger(frmJogo.class.getName()).log(Level.SEVERE, null, ex);
                      }
                }
                else
                {
                    game.reiniciar = true;
                }
            }
    }
}
