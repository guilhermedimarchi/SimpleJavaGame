/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Guilherme
 */
public abstract class Base {
    
    private int x;
    private int y;
    private Color c;
    private int velocidade;
    private int altura;
    private int largura;
    private int dirX;
    private int dirY;
    private Rectangle retangulo;
    
    public Base(int x, int y, Color c, int velocidade,int largura, int altura )
    {  
        this.dirX=1;
        this.dirY=1;
        this.x = x;
        this.y = y;
        this.c = c;
        this.altura = altura;
        this.largura = largura;
        this.velocidade = velocidade;    
        retangulo = new Rectangle(getX(),getY(),largura,altura);
    }
    public void moverRetangulo()
    {
        retangulo.setLocation(getX(),getY());
    }    
    public boolean checaColisao(Rectangle retangulo)
    {
        return this.getRetangulo().intersects(retangulo);       
    }
    /*    
            public Rectangle getBounds(){
                    return new Rectangle(getX(), getY(),getTamanho(),getTamanho());
            }

      */  
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
        moverRetangulo();
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
        moverRetangulo();
    }
    public Color getC() {
        return c;
    }
    public void setC(Color c) {
        this.c = c;
    }
    public int getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    public int getDirX() {
        return dirX;
    }
    public void setDirX(int dirX) {
        this.dirX = dirX;
    }
    public int getDirY() {
        return dirY;
    }
    public void setDirY(int dirY) {
        this.dirY = dirY;
    }
    public Rectangle getRetangulo() {
        return retangulo;
    }
    public void setRetangulo(Rectangle retangulo) {
        this.retangulo = retangulo;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public int getLargura() {
        return largura;
    }
    public void setLargura(int largura) {
        this.largura = largura;
    }
}
