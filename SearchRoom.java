/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import com.mysql.cj.protocol.Resultset;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import  net.proteanit.sql.*;
/**
 *
 * @author Dell
 */
public class SearchRoom extends JFrame implements ActionListener{
    JButton back, submit;
    JTable table;
    JComboBox bedtype;
    JCheckBox available;
    SearchRoom(){
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
       JLabel text = new JLabel("Search For Rooms");
       text.setFont(new Font("Tahoma",Font.PLAIN,20));
       text.setBounds(400,30,200,30);
       add(text);
        
       JLabel lblbed = new JLabel("Bed Type");
       lblbed.setBounds(50,100,100,20);
       add(lblbed);
       
       bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
       bedtype.setBounds(150,100,150,25);
       bedtype.setBackground(Color.white);
       add(bedtype);
       
       available = new JCheckBox("Only Display Available");
       available.setBounds(650,100,150,25);
       available.setBackground(Color.white);
       add(available);
              //available = new JCheckBox("Only Display Available");
              
              
       
       
        JLabel rn = new JLabel("Room Number");
        rn.setBounds(50,160,100,20);
        add(rn);
        
         JLabel cn = new JLabel("Availability");
        cn.setBounds(220,160,100,20);
        add(cn);
        
        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(420,160,100,20);
        add(l3);
        
         JLabel l4 = new JLabel("Price");
        l4.setBounds(650,160,100,20);
        add(l4);
        
         JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(840,160,100,20);
        add(l5);
        
        
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
            
            Conn c= new Conn();
          ResultSet rs= c.s.executeQuery("select * from room");
          table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        
        
        
        
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);
        
        
        setBounds(200,100,1000,600);
        setVisible(true);
        
    }
    
    
    public static void main(String[] args){
        
        new SearchRoom();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==submit){
            try{
                String query1 = "select * from room where bed_type = '"+bedtype.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' and  bed_type = '"+bedtype.getSelectedItem()+"'"; 
            
                Conn conn  = new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                    
                    
                }else {
                    rs = conn.s.executeQuery(query1);
                }
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }
            
            catch(Exception ae){
                ae.printStackTrace();
            }
            
        }else
        {
        setVisible(false);
        new Reception();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
