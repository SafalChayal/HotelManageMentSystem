/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class AddRooms extends JFrame implements ActionListener {
    
     JLabel lblroom,lblavailable,lblbed,lblprice,lblclean;
     JTextField tfroom,tfprice;
    JButton add,cancel;
    JComboBox bedcombo;
    JComboBox cleancombo,availablecombo;
    
    AddRooms(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);

        add(heading);
        
        lblroom = new JLabel("Room Number");
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroom.setBounds(60,80,120,30);

        add(lblroom);
        
         tfroom = new JTextField();
        tfroom.setBounds(200,80,120,30);
        add(tfroom);
       
        lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);
        
        String availableoptions[] = {"Available","Occupied"};
        
         availablecombo = new JComboBox(availableoptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);
       
      lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);
        
        String cleanoptions[] = {"Clean","Dirty"};
        
        cleancombo = new JComboBox(cleanoptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);
        
        
         lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);

        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200,230,120,30);
        add(tfprice);
        
          lblbed = new JLabel("Bed Type");
        lblbed.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblbed.setBounds(60,280,120,30);
        add(lblbed);
        
        String bedoptions[] = {"Single Bed","Double Bed"};
        
        bedcombo = new JComboBox(bedoptions);
        bedcombo.setBounds(200,280,150,30);
        bedcombo.setBackground(Color.white);
        add(bedcombo);
        
         add = new JButton("Add Room");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
         cancel = new JButton("Cancel Room");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(210,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(450,60,400,300);
        add(image);
        
        
        setBounds(330,200,940,470);
        setVisible(true);
        
    }
    public static void main(String args[]){
         new AddRooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==add){
            
            String roomnumber = tfroom.getText();
            String availablity = (String) availablecombo.getSelectedItem();
            String cleaning_status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String bed_type = (String) bedcombo.getSelectedItem();
            
            try{
                Conn conn =  new Conn();
                
                String query = "insert into room values('"+roomnumber+"','"+availablity+"','"+cleaning_status+"','"+price+"','"+bed_type+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
            }
            catch(Exception ee){
                ee.printStackTrace();
            }
            
        }
        else{
            setVisible(false);
        }
        


// throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
