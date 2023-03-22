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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class AddEmployees extends JFrame implements ActionListener{
    
    JTextField newText,newText1 ,newText3,newText4, newText5,newText6;
    JLabel labelname,labelAge,labelGender,labelJob,labelSalary,labelPhone,labelEmail,AAdhar;
   JRadioButton rb,rb1;
   JButton jb;
   JComboBox cbjob;
    ButtonGroup bg;
    AddEmployees(){
        setLayout(null);
        
         labelname = new JLabel("Name");
        labelname.setBounds(60,30,120,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,17));
        
        add(labelname);
        
         newText = new JTextField();
        newText.setBounds(200,30,150,30);
        add(newText);
        
         labelAge = new JLabel("Age");
        labelAge.setBounds(60,80,120,30);
        labelAge.setFont(new Font("Tahoma",Font.PLAIN,17));
        
        add(labelAge);
        
          newText1 = new JTextField();
        newText1.setBounds(200,80,150,30);
        add(newText1);
        
        
         labelGender = new JLabel("Gender");
        labelGender.setBounds(60,130,120,30);
        labelGender.setFont(new Font("Tahoma",Font.PLAIN,17));
        
        add(labelGender);
        
         rb = new JRadioButton("Male");
        rb.setBounds(200,130,70,30);
        rb.setFont(new Font("Tahoma",Font.PLAIN,14));
        rb.setBackground(Color.white);
        add(rb);
        
        rb1 = new JRadioButton("Female");
        rb1.setBounds(280,130,70,30);
        rb1.setFont(new Font("Tahoma",Font.PLAIN,14));
        rb1.setBackground(Color.white);
        add(rb1);
        
        bg = new ButtonGroup();
        bg.add(rb);
        bg.add(rb1);
        
         labelJob = new JLabel("Job");
        labelJob.setBounds(60,180,120,30);
        labelJob.setFont(new Font("Tahoma",Font.PLAIN,17));
        
        add(labelJob);
        
        String str [] = {"Front Desk Workers","Porters","Housekeeping","Kitchen Staff","Room Service","Chef","Waiter/Waitress","Manager","Accountant"};
        
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.white);
        add(cbjob);
        
        
         labelSalary = new JLabel("Salary");
        labelSalary.setBounds(60,230,120,30);
        labelSalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        
        add(labelSalary);
        
          newText3 = new JTextField();
        newText3.setBounds(200,230,150,30);
        add(newText3);
        
        labelPhone = new JLabel("Phone");
        labelPhone.setBounds(60,280,120,30);
        labelPhone.setFont(new Font("Tahoma",Font.PLAIN,17));
        
        add(labelPhone);
        
         newText4= new JTextField();
        newText4.setBounds(200,280,150,30);
        add(newText4);
        
        
        
          labelEmail = new JLabel("Email");
        labelEmail.setBounds(60,320,120,30);
        labelEmail.setFont(new Font("Tahoma",Font.PLAIN,17));
        
        add(labelEmail);
        
          newText5= new JTextField();
        newText5.setBounds(200,320,150,30);
        add(newText5);
        
        AAdhar = new JLabel("AADHAR");
        AAdhar.setBounds(60,380,120,30);
        AAdhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        
        add(AAdhar);
        
          newText6= new JTextField();
        newText6.setBounds(200,380,150,30);
        add(newText6);
        
        
         jb = new JButton("Submit");
        jb.setBackground(Color.white);
        jb.setForeground(Color.black);
        jb.setBounds(200,430,150,30);
        jb.addActionListener(this);
        add(jb);
        
        ImageIcon ni = new ImageIcon(ClassLoader.getSystemResource("icon/tenth.jpg"));
       Image n2 = ni.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(n2);
       
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);
        
    }
    public static void main(String[] args){
        new AddEmployees();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String name = newText.getText();
        String age = newText1.getText();
        String salary = newText3.getText();
        String phone = newText4.getText();
        String email = newText5.getText();
        String aadhar = newText6.getText();
        
        String gender=null;
        
        if(rb.isSelected()){
            gender = "Male";
        }else if(rb1.isSelected()){
            gender = "Female";
        }
        
        String job = (String) cbjob.getSelectedItem();
        
        try{
            Conn conn = new Conn();
            
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee Added Successfully");
            
            setVisible(false);
            
        }catch(Exception ee){
            ee.printStackTrace();
        }
    
    }
}
