/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Reception extends JFrame implements ActionListener{
    JButton logout,roomStatus,newCustomer,Rooms,pickup , Department, update,AllEmployees, managerInfo, Customers, searchRooms, Checkout ;
    Reception(){
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        
        newCustomer = new JButton("New Customer Form");   
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.black);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        Rooms = new JButton("Rooms");   
        Rooms.setBounds(10,70,200,30);
        Rooms.setBackground(Color.black);
        Rooms.setForeground(Color.white);
        Rooms.addActionListener(this);
        add(Rooms);
        
        
        Department = new JButton("Department");   
        Department.setBounds(10,110,200,30);
        Department.setBackground(Color.black);
        Department.setForeground(Color.white);
        Department.addActionListener(this);
        add(Department);
        
          AllEmployees = new JButton("All Employees");   
        AllEmployees.setBounds(10,150,200,30);
        AllEmployees.setBackground(Color.black);
        AllEmployees.setForeground(Color.white);
        AllEmployees.addActionListener(this);
        add(AllEmployees);
        
         Customers = new JButton("Customer Info");   
        Customers.setBounds(10,190,200,30);
        Customers.setBackground(Color.black);
        Customers.setForeground(Color.white);
        Customers.addActionListener(this);
        add(Customers);
        
         managerInfo = new JButton("Manager Info");   
        managerInfo.setBounds(10,230,200,30);
        managerInfo.setBackground(Color.black);
        managerInfo.setForeground(Color.white);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        
          Checkout = new JButton("CheckOut");   
        Checkout.setBounds(10,270,200,30);
        Checkout.setBackground(Color.black);
        Checkout.setForeground(Color.white);
        Checkout.addActionListener(this);
        add(Checkout);
        
        
         update = new JButton("Update Status");   
        update.setBounds(10,310,200,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
         roomStatus = new JButton("Update Room Status");   
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setBackground(Color.black);
        roomStatus.setForeground(Color.white);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
         pickup = new JButton("Pickup Service");   
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
       pickup.addActionListener(this);
        add(pickup);
        
         searchRooms = new JButton("Search Room");   
        searchRooms.setBounds(10,430,200,30);
        searchRooms.setBackground(Color.black);
        searchRooms.setForeground(Color.white);
        searchRooms.addActionListener(this);
        searchRooms.addActionListener(this);
        add(searchRooms);
        
         logout = new JButton("Logout");   
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        
        setBounds(350,150,800,570);
        setVisible(true);
        
    }
    public static void main(String[] args){
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==newCustomer){
        setVisible(false);
        new AddCustomer();
       
        
        
    }   else if(e.getSource()==Rooms){
        setVisible(false);
        new Room();
        
    }
    else if(e.getSource()==Department){
        setVisible(false);
        new Department();
    }
    else if(e.getSource()==AllEmployees){
        setVisible(false);
    new EmployeeInfo();
    }
    else if(e.getSource()==managerInfo){
        setVisible(false);
        new ManagerInfo();
    }
    else if(e.getSource()==Customers){
        setVisible(false);
        new CustomerInfo();
    }
    else if(e.getSource()==searchRooms){
        setVisible(false);
        new SearchRoom();
        
    }
    else if(e.getSource()==Checkout){
      Checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOut check;
				try {
					check = new CheckOut();
					check.setVisible(true);
                                        setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
      
       
    }
    else if(e.getSource()==update){
        update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				UpdateCheck update = new UpdateCheck();
				update.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
        
        
    }
    else if(e.getSource()==pickup){
        pickup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Pickup pick = new Pickup();
				pick.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
        
    }
    else if(e.getSource()==roomStatus){
        
       roomStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					UpdateRoom room = new UpdateRoom();
					room.setVisible(true);
                                        setVisible(false);
				}catch(Exception s)
				{
					s.printStackTrace();
				}
			}
		});
    }
    else if(e.getSource()==logout){
        
        logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
                                    new Login().setVisible(true);
                                    setVisible(false);
                                    
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
    }
// throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
