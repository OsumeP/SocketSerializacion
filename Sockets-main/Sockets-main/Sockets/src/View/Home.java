/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Estudiante
 */
public class Home {

/**
 *
 * @author Juan David Patarroyo
 */
    
    Random aleatorio;
    int x;
    int y;
    public static JFrame root;
    public Home(){
    }
    
    
     public void CBDemostracion(){
        root = new JFrame();
        root.setBounds(20, 20, 500, 500);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        root.add(panel);
        
        JButton btnObtener = new JButton("Obtener Mensaje!");
        btnObtener.setBounds(10, 170, 130, 25);
        panel.add(btnObtener);
        
        aleatorio = new Random();
        
        MouseListener mouseListener = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e)  { }
            @Override
            public void mousePressed(MouseEvent e)  { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) {
                    x = aleatorio.nextInt(400);
                    y = aleatorio.nextInt(400);
                    btnObtener.setBounds(x,y,130,25);
            }
            @Override
            public void mouseExited(MouseEvent e) { }
        };
        
        
        JLabel confirmacion = new JLabel("Se ha copiado el mensaje en el portapapeles,");
        confirmacion.setBounds(320, 10, 400, 20);
        confirmacion.setVisible(false);
        panel.add(confirmacion);
        
        JLabel confirmacion2 = new JLabel("pegalo en tu navegador.");
        confirmacion2.setBounds(320, 40, 400, 20);
        confirmacion2.setVisible(false);
        panel.add(confirmacion2);
        ActionListener listenerResultado = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String str = "https://r.mtdv.me/articles/0N46sVZlUF";
                Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection strSel = new StringSelection(str);
                cb.setContents(strSel, null);
                confirmacion.setVisible(true);
                confirmacion2.setVisible(true);
            }
        };
       
        
        btnObtener.addMouseListener(mouseListener);
        btnObtener.addActionListener(listenerResultado);
        
        root.setVisible(true);
    }
}

