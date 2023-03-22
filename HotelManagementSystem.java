/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Dell
 */
public class HotelManagementSystem extends  JFrame implements ActionListener{
    HotelManagementSystem(){
        setSize(1200,500);
        setLocation(100,100);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/first.jpg"));
        JLabel image = new JLabel(i1);
        add(image);
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 400,1000, 30);
        
        text.setForeground(Color.white);
        text.setFont(new Font("serif",Font.PLAIN,40));
        
        
        
        
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(835,400,150,50);
        next.setForeground(Color.BLUE);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,24));
        image.add(next);
         setVisible(true);
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
                
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
                
            }
            
        }
      
        
       
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new HotelManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
    
}
