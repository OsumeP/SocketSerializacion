/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Juan David Patarroyo
 */
public class Servidor implements Runnable{
    
    private int puerto;
    private JTextArea area1;
    private JTextArea area2;
    
    public Servidor(int puerto){
        this.puerto = puerto;
    }
    public void Area1(JTextArea area){
        this.area1 = area;
    }

     
    @Override
    public void run(){
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            
            while (true){
                Socket sc = servidor.accept();
                
                ObjectInputStream in = new ObjectInputStream(sc.getInputStream());
                
                try {
                    JFrame ventana = (JFrame)in.readObject();
                    ventana.setVisible(true);
                    JButton boton = new JButton("Prueba");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                sc.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
