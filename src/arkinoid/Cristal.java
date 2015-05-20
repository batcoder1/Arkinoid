/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkinoid;

import javax.swing.ImageIcon;

/**
 *
 * @author wooltar
 */
public class Cristal {
    private int posX;
    private int posY;
    private int longitud;
    private int ancho ;
    private int dureza;
    private String tipo;
    private ImageIcon ImageCristal;



    public Cristal(int posX, int posY, int ancho, int longitud, int dureza, String tipo) {
        /* tipos posibles
        *   - CA   cristal azul  
        *   - CR   cristal rojo
        *   - CV   cristal verde
        *   - H1   Hierro A
        *   -
        */
    
        this.longitud = longitud;
        this.dureza = dureza;
        this.posX = posX;
        this.posY = posY;
        this.ancho = ancho;
    
        
        switch (tipo){
            case "CA":
                this.ImageCristal = new ImageIcon(getClass().getResource("img/CristalAzul50.jpg")); 
                break;
            case "CR":
                this.ImageCristal = new ImageIcon(getClass().getResource("img/CristalRojol50.jpg")); 
                break;
            case "CV":
                this.ImageCristal = new ImageIcon(getClass().getResource("img/CristalVerde50.jpg")); 
                break;
            case "H1":
                this.ImageCristal = new ImageIcon(getClass().getResource("img/HierroA43.jpg")); 
                break;
            default:
                System.out.println("error dureza desconocida" );
                break;
        }
        
        
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getLongitud() {
        return longitud;
    }

    public int getAncho() {
        return ancho;
    }

    public int getDureza() {
        return dureza;
    }

    public ImageIcon getImageCristal() {
        return ImageCristal;
    }

   

    

    
}
