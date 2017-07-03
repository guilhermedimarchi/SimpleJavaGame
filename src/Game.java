
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme
 */
public class Game {
    
    int largura,altura;
    Raquete r;
    int velocidadeBolinha = 3;
    int vidas = 5;
    int velocidadeRaquete=1;
    int comprimentoRaquete = 20;
    int larguraRaquete=20;
    int velocidadeTiro = 3;
    int comprimentoTiro = 2;
    int larguraTiro = 15;
    int municao = 10;
    int respawn = 0;
    int velocidadeInimigo = 7;
    boolean reiniciar = false;
    ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>();
    ArrayList<Inimigo> inimigosDestruidos = new ArrayList<Inimigo>();
    Bordas bordaInferior;
    Bordas bordaSuperior;
    int pontuacao;
     
    public Game(int largura, int altura)
    {
        this.largura = largura;
        this.altura = altura;
        r = new Raquete(100,100,Color.BLACK,velocidadeRaquete,comprimentoRaquete,larguraRaquete,velocidadeTiro,comprimentoTiro,larguraTiro,municao);
        bordaSuperior = new Bordas(0,30,Color.BLUE,0,largura,30);
        bordaInferior = new Bordas(0,altura-30,Color.BLUE,0,largura,30);
        criaInimigo();
        pontuacao=0;
    }
    public void init()
    {
        r = new Raquete(100,100,Color.BLACK,velocidadeRaquete,comprimentoRaquete,larguraRaquete,velocidadeTiro,comprimentoTiro,larguraTiro,municao);
        bordaSuperior = new Bordas(0,30,Color.BLUE,0,largura,30);
        bordaInferior = new Bordas(0,altura-30,Color.BLUE,0,largura,30);
        criaInimigo();
        pontuacao=0; 
    }
    
    public void criaInimigo()
    {
        respawn = 0 ;
        for(int i = 0; i< (Math.random()*5);i++)
        {
            inimigos.add(new Inimigo(largura, (int)(Math.random()*altura), Color.red, (int)(Math.random()*velocidadeInimigo), (int)(Math.random()*300),30 ));
        }   
    }
    
    public void moveInimigos()
    {
        for(Inimigo i: inimigos)
        {
            i.setX(i.getX()-i.getVelocidade());
            
        }
    }
     public void limpaTela(Graphics bg) {
        
        bg.setColor(Color.GREEN);
        bg.fillRect(0, 0, largura, altura);
            
    }
     public void reiniciar()
     {
         if(reiniciar)
            {
                reiniciar = false;
                inimigos.removeAll(inimigos);
                inimigosDestruidos.removeAll(inimigos);
                init();
            }
     }
    
}
