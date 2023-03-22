/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import com.mysql.cj.protocol.Resultset;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import  net.proteanit.sql.*;
/**
 *
 * @author Dell
 */
public class Room extends JFrame implements ActionListener{
    JButton back;
    JTable table;
    
    Room(){
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel rn = new JLabel("Room Number");
        rn.setBounds(10,10,100,20);
        add(rn);
        
         JLabel cn = new JLabel("Availability");
        cn.setBounds(120,10,100,20);
        add(cn);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);
        
         JLabel l4 = new JLabel("Price");
        l4.setBounds(340,10,100,20);
        add(l4);
        
         JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(445,10,100,20);
        add(l5);
        
        
        
        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try{
            
            Conn c= new Conn();
          ResultSet rs= c.s.executeQuery("select * from room");
          table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);
        
        
        setBounds(200,100,1050,600);
        setVisible(true);
        
    }
    
    
    public static void main(String[] args){
        
        new Room();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
