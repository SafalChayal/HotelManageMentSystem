/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class CustomerInfo extends JFrame implements ActionListener{
    JButton back;
    JTable table;
    
    CustomerInfo(){
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        
        
        JLabel rn = new JLabel("Document");
        rn.setBounds(40,10,100,20);
        add(rn);
        
         JLabel cn = new JLabel("Number");
        cn.setBounds(170,10,100,20);
        add(cn);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(290,10,100,20);
        add(l3);
        
         JLabel l4 = new JLabel("Gender");
        l4.setBounds(400,10,100,20);
        add(l4);
        
         JLabel l5 = new JLabel("Country");
        l5.setBounds(540,10,100,20);
        add(l5);
        
         JLabel l6 = new JLabel("Room");
        l6.setBounds(670,10,100,20);
        add(l6);
        
         JLabel l7 = new JLabel("CheckInTime");
        l7.setBounds(800,10,100,20);
        add(l7);
        
         JLabel l8 = new JLabel("Deposit");
        l8.setBounds(930,10,100,20);
        add(l8);
        
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        try{
            
            Conn c= new Conn();
          ResultSet rs= c.s.executeQuery("select * from customer ");
          table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);
        
        
        setBounds(200,100,1000,600);
        setVisible(true);
        
    }
    
    
    public static void main(String[] args){
        
        new CustomerInfo();
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

/**
 *
 * @author Dell
 */
