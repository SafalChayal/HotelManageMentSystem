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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Dell
 */
public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
       
        setBounds(0,0,1366,768);
        setLayout(null);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
         Image i2 = i1.getImage().getScaledInstance(1366, 768,Image.SCALE_DEFAULT );
         ImageIcon i3 =  new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,1366,768);
         add(image);
         
         
         JLabel text = new JLabel("THE CHAYAL GROUP WELCOMES YOU");
         text.setBounds(370,50,1000,100);
         text.setFont(new Font("TAHOMA",Font.PLAIN,46));
         text.setForeground(Color.WHITE);
         
         image.add(text);
         
         JMenuBar mb = new JMenuBar();
         mb.setBounds(0,0,1366,40);
         image.add(mb);
         
         JMenu hotel = new JMenu("HOTEL MANAGEMENT");
         hotel.setForeground(Color.BLUE);
         mb.add(hotel);
         
         JMenuItem reception = new JMenuItem("Reception");
         reception.addActionListener(this);
         hotel.add(reception);
         
         JMenu admin = new JMenu("ADMIN");
         admin.setForeground(Color.BLUE);
         mb.add(admin);
         
         JMenuItem addempployee = new JMenuItem("Add Employee");
         addempployee.addActionListener(this);
         admin.add(addempployee);
         
         JMenuItem addrooms = new JMenuItem("Add Rooms");
         addrooms.addActionListener(this);
         admin.add(addrooms);
         
         JMenuItem add_drivers = new JMenuItem("Add Drivers");
         add_drivers.addActionListener(this);
         admin.add(add_drivers);
         
        setVisible(true);
        
    }
    
    public static void main(String[] Args){
        new Dashboard();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Add Employee"){
            new AddEmployees();
        }else if(e.getActionCommand()=="Add Rooms"){
            new AddRooms();
        }
        else if(e.getActionCommand()=="Add Drivers"){
            new AddDriver();
        }
        else if(e.getActionCommand()=="Reception"){
            new Reception();
        }
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
