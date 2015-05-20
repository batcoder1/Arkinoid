/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkinoid;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;
/**
 *
 * @author wooltar
 */
public class Escenario extends JFrame implements KeyListener {
     Partida p =new Partida();
     public Escenario(){
       
     
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(630,800);
        setResizable(false);
        setTitle("Arkinoid");
        setVisible(true);
        
       
        add(p);
        //add(new Pelota(50,50,30));
   
 
    }
     
   
        @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
     if (e.getKeyCode()==KeyEvent.VK_RIGHT){
         System.out.println("presionamos derecha");
        
         p.rPosX = p.rPosX + 20;
        
      }
     if (e.getKeyCode()==KeyEvent.VK_LEFT)
      {
           System.out.println("presionamos  izq");
        p.rPosX = p.rPosX - 20;
      }    }

    @Override
    public void keyReleased(KeyEvent e) {
        
      if (KeyEvent.VK_LEFT==e.getKeyCode() | e.VK_LEFT==e.getKeyCode()){
       p.rPosX = p.rPosX;
       
       }
    }
}
