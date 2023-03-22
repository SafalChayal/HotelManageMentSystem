/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import com.mysql.cj.protocol.Resultset;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel text,lblid,lblnumber,lblname,lblgender,lblcountry,lblroom,lbltime,checkintime,lbldeposit,image;
    JComboBox comboId;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JButton add,back;
    
    AddCustomer(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
         text = new JLabel("New Customer Form");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        lblid = new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);
        
        String options[] = {"Aadhar Card","Passport","Driving License","Voter ID","Ration Card"};
        
        comboId = new JComboBox(options);
        comboId.setBounds(200,80,150,25);
        comboId.setBackground(Color.white);
        add(comboId);
        
        lblnumber = new JLabel("Number");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber);
        
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        tfnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(tfnumber);
        
        lblname = new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);
        
         tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        tfname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(tfname);
        
         lblgender = new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(200,200,65,25);
        rmale.setBackground(Color.white);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(270,200,100,25);
        rfemale.setBackground(Color.white);
        add(rfemale);
        
        lblcountry = new JLabel("Country");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);
        
         tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        tfcountry.setBackground(Color.white);
        add(tfcountry);
        
        lblroom = new JLabel("Room Number");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);
        
        lbltime  = new JLabel("CheckIn Time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);
                
         
         Date date = new Date();
         checkintime = new JLabel(""+date);
         checkintime.setBounds(200,320,150,20);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
        add(checkintime);
         
        lbldeposit  = new JLabel("Deposit");
        lbldeposit.setBounds(35,360,150,20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);
        
         tfdeposit  = new JTextField();
        tfdeposit.setBounds(200,360,150,20);
        tfdeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(tfdeposit);
        
        
        croom = new Choice();
        
        try{
            
            Conn conn = new Conn();
            String query = "select * from room where availablity = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
            
            
        }catch(Exception re){
            re.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);
        
        
        add = new JButton("Add");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(50,410,120,30);
        add.addActionListener(this);
        add(add);
        
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        setBounds(350,170,800,550);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        
        new AddCustomer();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            String id = (String) comboId.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            
            if(rmale.isSelected()){
                gender = "Male";
            }
            else if(rfemale.isSelected()){
                gender ="Female";
            }
            
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();
            
            try{
                
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availablity =  'Occupied' where roomnumber='"+room+"'";
           
                Conn conn = new Conn();
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                setVisible(false);
                new Reception();
            
            }catch(Exception ee2){
                ee2.printStackTrace();
                
            }
            
            
        }else if(ae.getSource()==back){
            setVisible(false);
                new Reception();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
