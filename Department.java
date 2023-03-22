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
public class Department extends JFrame implements ActionListener{
    JButton back;
    JTable table;
    
    Department(){
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
       
        
       
        
        JLabel rn = new JLabel("Department");
        rn.setBounds(180,10,100,20);
        add(rn);
        
         JLabel cn = new JLabel("Budget");
        cn.setBounds(420,10,100,20);
        add(cn);
        
       
        
        
        
        
        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        
        try{
            
            Conn c= new Conn();
          ResultSet rs= c.s.executeQuery("select * from department");
          table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);
        
        
        setBounds(400,200,700,480);
        setVisible(true);
        
    }
    
    
    public static void main(String[] args){
        
        new Department();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
