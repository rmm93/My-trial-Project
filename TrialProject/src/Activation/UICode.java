/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activation;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Integer.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Raoum
 */
public class UICode extends JFrame{
    private JButton btn1;
    private JButton btn2;
    private JLabel lbl,lbl1;
    private JPanel pan1;
    private static final String host="jdbc:mysql://localhost:3306/",userName="root",password=""; 

    public UICode(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,150);
        setTitle("Insert random numbers");
        btn1= new JButton("Enter");
        btn2= new JButton("Cancel");
        lbl= new JLabel("Please input a number from 0 to 99");
        lbl1= new JLabel();
        pan1= new JPanel();
        Container holder = getContentPane();
        holder.setLayout( new GridLayout(4,1));
        holder.add(lbl);
        holder.add(pan1);
        holder.add(lbl1);
        pan1.setLayout(new FlowLayout ());
        pan1.add(btn1);
        pan1.add(btn2);
        
        ButtonAction BTA= new ButtonAction();
        btn1.addActionListener(BTA);
        btn2.addActionListener(BTA);
        
    }//constructor
    
    private class ButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        // Section_ 7 you are required to add the code of the listener event object 
            Object pressedButton= e.getSource();
            if(pressedButton.equals(btn1)){
                try{
                    new com.mysql.jdbc.Driver();
                    Connection con= DriverManager.getConnection(host, userName, password);
                    Statement st = con.createStatement();
                    int inpNum=0; String inp= "";
                    for (int x=0;x<100;x++){
                        inp=JOptionPane.showInputDialog("Please input a number from 0 to 99");
                        if (inp== null){break;}
                        inpNum=parseInt(inp);
                        if (inpNum<0 || inpNum>99){
                            JOptionPane.showMessageDialog(null, "Please input a number from 0 to 99", "alert", JOptionPane.ERROR_MESSAGE);
                            x--;
                            continue;
                        }
                        st.execute("UPDATE trialprojectdb.addednumbers SET enteredNums="+ inpNum+" where indx= "+x);
                        lbl1.setText("You have entered "+ (x+1)+ " numbers, you have "+(100-(x+1))+" remaining");
                    }
                }//try
                catch (Exception ae){
                    JOptionPane.showMessageDialog(null, ae.getMessage(), "alert",JOptionPane.ERROR_MESSAGE);
                }//catch
            }//if
            
            if(pressedButton.equals(btn2)){
                System.exit(0);}//if
        }// action performed
    }//Button Action
    public static void main(String [] args)   {
       UICode welcomeFrame= new UICode();
       welcomeFrame.setVisible(true);
   } 
}
