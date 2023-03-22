/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
public class AddDriver extends JFrame implements ActionListener {
    
     JLabel lblroom,lblavailable,lblbed,lblprice,lblclean,lblage,lbllocation;
     JTextField tfname,tfage,tfprice,tfcompany,tfmodel,tflocation;
    JButton add,cancel;
    JComboBox bedcombo;
    JComboBox cleancombo,availablecombo,agecombo,gendercombo;
;
    
    AddDriver(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);

        add(heading);
        
        lblroom = new JLabel("Name");
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroom.setBounds(60,70,120,30);

        add(lblroom);
        
         tfname = new JTextField();
        tfname.setBounds(200,70,120,30);
        add(tfname);
       
       lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblage.setBounds(60,110,120,30);
        add(lblage);
        
          tfage = new JTextField();
        tfage.setBounds(200,110,120,30);
        add(tfage);
       
      lblclean = new JLabel("Gender");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,150,120,30);
        add(lblclean);
        
        String cleanoptions[] = {"Male","Female"};
        
        gendercombo = new JComboBox(cleanoptions);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.white);
        add(gendercombo);
        
        
         lblprice = new JLabel("Car Company");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,190,120,30);

        add(lblprice);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200,190,120,30);
        add(tfcompany);
        
          lblbed = new JLabel("Car Model");
        lblbed.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblbed.setBounds(60,230,120,30);
        add(lblbed);
        
          
        tfmodel = new JTextField();
        tfmodel.setBounds(200,230,120,30);
        add(tfmodel);
        
         lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60,270,120,30);

        add(lblavailable);
        
        
         String driveroptions[] = {"Available","Busy"};
        
        availablecombo = new JComboBox(driveroptions);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);
        
         lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbllocation.setBounds(60,310,120,30);
        add(lbllocation);
        
         tflocation = new JTextField();
        tflocation.setBounds(200,310,120,30);
        add(tflocation);
        
        
        
        
         add = new JButton("Add Driver");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
         cancel = new JButton("Cancel Driver");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(210,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,60,400,300);
        add(image);
        
        
        setBounds(300,200,980,470);
        setVisible(true);
        
    }
    public static void main(String args[]){
         new AddDriver();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==add){
            
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String)gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfmodel.getText();
            String available = (String)availablecombo.getSelectedItem();
            String location = tflocation.getText();
            
            
            try{
                Conn conn =  new Conn();
                
                String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"New Driver has been booked Successfully");
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
