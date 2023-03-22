/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
//import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
/**
 *
 * @author Dell
 */
public  class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    Login(){
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        JLabel user = new JLabel("UserName");
        
         username = new JTextField();
        username.setBounds(150,20,100,20);
        add(username);
        user.setBounds(40,20,100,20);
        add(user);
        
        JLabel pass = new JLabel("Password");
        
          password = new JPasswordField();
        password.setBounds(150,70,100,20);
        add(password);
        pass.setBounds(40,70,100,20);
        add(pass);
        
         login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
         cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(350,10,200,200);
        
        
        
        setBounds(500,200,600,300);
        setVisible(true);
    
}
    
    
   
    public static void main(String[] Args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(e.getSource() == login){
            String user = username.getText();
            String paswd = password.getText();
            
            
            try{
                
                Conn c = new Conn();
                
                String query = "select * from login where username =  '"+user+"' and password =  '"
                        +paswd+"' ";
               ResultSet r = c.s.executeQuery(query);
               
               
               if(r.next()){
                   setVisible(false);
                   new Dashboard();
                   
               }else{
                   JOptionPane.showMessageDialog(null,"Invalid username or password");
                   setVisible(false);
               }
               
            
            }catch(Exception ee){
                ee.printStackTrace();
                
            }
        }
        else if(e.getSource() == cancel){
            setVisible(false);
        }
         //throw new UnsupportedOperationException("Not supported yet.");
        
    }
}
