/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author 132173
 */
public class Raquete extends Base {

    ArrayList<Tiro> tiros = new ArrayList<Tiro>();
    ArrayList<Tiro> tirosDestruidos = new ArrayList<Tiro>();
    private boolean sobe=false;
    private int tempoParaAtirar=0;
    private int velocidadeTiro;
    private int comprimentoTiro;
    private int larguraTiro;
    private int municao;
    
    public Raquete(int x, int y, Color c, int velocidade, int largura, int altura, int velocidadeTiro, int comprimentoTiro,int larguraTiro, int municao) {
        super(x, y, c, velocidade, largura, altura);
        this.velocidadeTiro = velocidadeTiro;
        this.comprimentoTiro = comprimentoTiro;
        this.larguraTiro = larguraTiro;
        this.municao = municao;
    }
    //EVENTOS DAS SETAS DO TECLADO
    public void direcaoBarra(int limiteAltura, int limiteLargura)
    {
       if(sobe)
           setY(getY()-(getVelocidade()*2));
       else
           setY(getY()+getVelocidade());
           
    }
    public void atira()
    {
            Tiro t = new Tiro(getX(),getY(),getC(), getVelocidadeTiro(),getLarguraTiro(),getComprimentoTiro());
            tiros.add(t);
    }

    public int getTempoParaAtirar() {
        return tempoParaAtirar;
    }
    public void setTempoParaAtirar(int tempoParaAtirar) {
        this.tempoParaAtirar = tempoParaAtirar;
    }
    public int getVelocidadeTiro() {
        return velocidadeTiro;
    }
    public void setVelocidadeTiro(int velocidadeTiro) {
        this.velocidadeTiro = velocidadeTiro;
    }
    public int getComprimentoTiro() {
        return comprimentoTiro;
    }
    public void setComprimentoTiro(int comprimentoTiro) {
        this.comprimentoTiro = comprimentoTiro;
    }
    public int getLarguraTiro() {
        return larguraTiro;
    }
    public void setLarguraTiro(int larguraTiro) {
        this.larguraTiro = larguraTiro;
    }
    public int getMunicao() {
        return municao;
    }
    public void setMunicao(int municao) {
        this.municao = municao;
    }

    /**
     * @return the sobe
     */
    public boolean isSobe() {
        return sobe;
    }

    /**
     * @param sobe the sobe to set
     */
    public void setSobe(boolean sobe) {
        this.sobe = sobe;
    }
   
    
}
