/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activation;

/**
 *
 * @author Raoum
 */
import static Activation.MainAdjusted.*;
import java.awt.*;
import java.awt.event.*; 
import static java.lang.Long.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Finalized extends JFrame{
    
    private JButton btn1;
    private JButton btn2;
    private JLabel lbl;
    private JPanel pan1;
    private JPanel pan2;
    private static final String host="jdbc:mysql://localhost:3306/"; 
    private String userName="root",password="";
    public Finalized(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,150);
        setTitle("Activation Number Generator");
        btn1= new JButton("Generate");
        btn2= new JButton("Input Numbers");
        lbl= new JLabel("Welcome to the Activation number Generator");
        pan1= new JPanel();
        pan2= new JPanel();
        Container holder = getContentPane();
        holder.setLayout( new GridLayout(2,1));
        holder.add(pan1);        
        holder.add(pan2);        
        pan1.setLayout(new FlowLayout ());
        pan2.setLayout(new FlowLayout ());
        pan1.add(lbl);
        pan2.add(btn1);
        pan2.add(btn2);
        
        Finalized.ButtonAction BTA= new Finalized.ButtonAction();
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
                    ElapsedTime();
                    Connection con= DriverManager.getConnection(host, userName, password);
                    Random r = new Random();
                    Statement st = con.createStatement();
                    int rand; 
                    ResultSet rand1,rs;
                    long num2Table=0; 
                    long genNum= parseLong(JOptionPane.showInputDialog("How many numbers would you like to generate?"));
                    for (long l=0;l<=genNum;l++){
                    String code="";
                        for (int i=0;i<16;i++){
                            rand = 1+r.nextInt(99);
                            rand1= st.executeQuery("SELECT enteredNums FROM trialprojectdb.addednumbers WHERE indx = "+rand);
                            rand1.next();
                            num2Table= (timeHolder[i] + rand1.getInt("enteredNums"))%66;
                            rs=st.executeQuery("SELECT char_Symbol FROM trialprojectdb.symbolnumbers WHERE char_ID = "+num2Table);
                            rs.next();
                            code += rs.getString("char_Symbol");
                            if(i>0 && i%3==0){code+= " ";}
                        }
                    st.execute("INSERT INTO trialprojectdb.activationnumber (ActivationCode) VALUES ('"+code+"')");
                    }
                    JOptionPane.showMessageDialog(null, "Done!");
                }
                catch(Exception err){
                    JOptionPane.showMessageDialog(null,err.getMessage( ),"Alert",JOptionPane.ERROR_MESSAGE);}
            }//if
            
            if(pressedButton.equals(btn2)){
                UICode welcomeFrame= new UICode();
                welcomeFrame.setVisible(true);                
            }//if
        }// action performed
    }//Button Action
    
    
    public static void main(String [] args){        
        //StringsFun sf = new StringsFun();
        UserAndPass strFrame= new UserAndPass();
        strFrame.setVisible(true);
        
        /*Finalized welcomeFrame= new Finalized();
        welcomeFrame.setVisible(true);*/
    }
}
