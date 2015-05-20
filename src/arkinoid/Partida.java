
package arkinoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static javafx.application.Platform.exit;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Partida extends JPanel implements ActionListener{
    private Timer timer;
    private int pPosX,pPosY,pDirX,pDirY,pRadio;
    public  int rPosX,rPosY,rDirX, rLargo, rAncho;
    private int ancho=630;
    private int largo=800;
    private boolean fin= false;
    private String sPuntos = "0"; 
    private long puntos = 0;
    private Cristal [][] Cristales; 
    
    public Partida(){
        pPosX = 30;
        pPosY = 30;
        pDirX = pPosX % 10 + 1; 
        pDirY = pPosY % 15 + 1;
        pRadio = 10;
        setBackground(Color.black); 
        setDoubleBuffered(true);
        setSize(ancho,largo);
        timer = new Timer(5,this);
        timer.start();
        rPosX = 100;
        rPosY = 700;
        rLargo = 100;
        rAncho = 20;
        
        
    }
    public Partida (int pPosX,int pPosY, int pRadio){
        this.pPosX = pPosX;
        this.pPosY = pPosY;
        this.pDirX = pPosX % 10 + 1; 
        this.pDirY = pPosY % 15 + 1;
         setSize(ancho,largo);
         setBackground(Color.black); 
        timer = new Timer(5,this);
        timer.start();
    }
    @Override
    public void paint(Graphics g){
        
        super.paint(g);
       
  
        ImageIcon nave= new ImageIcon(getClass().getResource("img/nave.png")); 
      //  ImageIcon ImageFondo= new ImageIcon(getClass().getResource("img/culos2_3.jpg")); 
        ImageIcon ImageFondo= new ImageIcon(getClass().getResource("img/espacio2.jpg")); 
        ImageIcon BarraIzq= new ImageIcon(getClass().getResource("img/barraLateralIzq.jpg")); 
        ImageIcon BarraDere= new ImageIcon(getClass().getResource("img/barraLateralDere.jpg")); 
        ImageIcon BarraSup= new ImageIcon(getClass().getResource("img/barraSup2.jpg")); 
        ImageIcon BolaRoja= new ImageIcon(getClass().getResource("img/bolaRoja.png")); 
        ImageIcon GameOver= new ImageIcon(getClass().getResource("img/GameOver.png")); 
      
        g.drawImage(ImageFondo.getImage(), 0, 0, ancho, largo, null);
        g.drawImage(BarraIzq.getImage(), 0, 0, null);
        g.drawImage(BarraDere.getImage(), 615, 0, null);
        g.drawImage(BarraSup.getImage(), 15, 0,615,15, null);
        crearNivel(g);
        g.setColor(Color.blue);
        //g.fillOval(pPosX-pRadio, pPosY-pRadio, pRadio*2, pRadio*2);
         g.drawImage(BolaRoja.getImage(), pPosX, pPosY, pRadio*2, pRadio*2, null);
        g.setColor(Color.green);
       // g.fillRect(rPosX, rPosY, rLargo,rAncho);
         g.drawImage(nave.getImage(), rPosX, rPosY, rLargo, rAncho, null);
        g.setColor(Color.red);
        g.drawString(sPuntos,550,30);
        Toolkit.getDefaultToolkit().sync();
        if (fin){
          //g.drawString("GAME OVER",250,400);
             g.setColor(Color.gray);
             g.drawImage(GameOver.getImage(), 0, 0, ancho, largo, null);   
             g.create(250, 500, 100, 0x28);
                }   
         
        g.dispose();
    }

    public Partida(Timer timer, int pPosX, int pPosY, int pDirX, int pDirY, int pRadio) {
        this.timer = timer;
        this.pPosX = pPosX;
        this.pPosY = pPosY;
        this.pDirX = pDirX;
        this.pDirY = pDirY;
        this.pRadio = pRadio;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        pPosX+=pDirX;
        pPosY+=pDirY;
        //Controlo que cuando toca el borde, cambie de direccion
        if ((pPosX-pRadio) <= 10)
        pDirX*= -1;
        else if ((pPosX+(pRadio)) >= ancho-20)
        pDirX*= -1;
       //controlo cuando toca la barra superior o cuando se va por el fondo 
        if ((pPosY-(pRadio)) <= 15)
        pDirY*= -1;
        else if ((pPosY+pRadio) >= largo){
         
          fin = true;
        }
        bolaGolpeaBarra();         
      
        repaint();
    }
    
    void puntuar(int p){
        puntos = puntos + p;
        sPuntos = Long.toString(puntos);
    }
    void bolaGolpeaBarra(){
        if ((pPosX+(2*pRadio)) <= rPosX+rLargo) 
           if ((pPosX+(2*pRadio)) >= rPosX) 
                if ((pPosY+(2*pRadio)) <= rPosY+rAncho)
                    if ((pPosY+(2*pRadio)) >= rPosY)
                    {    
                         puntuar(100);
                         pDirX*= 1;
                         pDirY*= -1;
                     } 
    }
    /*
     void bolaGolpeaCristal(){
        if ((cristalRojo.+(2*pRadio)) <= rPosX+rLargo) 
           if ((pPosX+(2*pRadio)) >= rPosX) 
                if ((pPosY+(2*pRadio)) <= rPosY+rAncho)
                    if ((pPosY+(2*pRadio)) >= rPosY)
                    {    
                         puntuar(100);
                         pDirX*= 1;
                         pDirY*= -1;
                     } 
    }
    */
  Object crearNivel(Graphics g){
       
      int x;
      int i=0;
       int filas = 2;
        int columnas = 12;
      
      for(int fila = 0 ; fila < filas ; fila++ ){
            x=15;
            for(int columna = 0 ; columna < columnas ; columna++ ){
                Cristales = new Cristal[ filas ][ columnas ];
                Cristales[fila][columna] = new Cristal(x,100,20,50,1,"CR");
                g.drawImage(Cristales[fila][columna].getImageCristal().getImage(), x, 100,
                            Cristales[fila][columna].getLongitud(), Cristales[fila][columna].getAncho(), this);
                x=x+50; 
            }
                     
      }
         return Cristales;
  }
  
}

