/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activation;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Long.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

/**
 * this class creates a window for user name and pass input, now we need to 
 * compare it with the actual user name and pass from the database
 * 
 * @author Raoum
 */
public class UserAndPass extends JFrame{
    
    public StringsFun sf; 
    private JButton btn;
    private JButton btn1;
    private JLabel lbl;
    private JLabel lbl1;
    private JTextField tf;
    private JTextField tf1;
    private JPanel pan1;
    private JPanel pan2;
        

    
    public UserAndPass(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,150);
        setTitle("Activation Number Generator");
        sf = new StringsFun();
        btn= new JButton("Ok");
        btn1= new JButton("cancel");
        lbl= new JLabel("UserName: ");
        lbl1= new JLabel("Password: ");
        tf= new JTextField ("root",15);
        tf1= new JTextField ("",15);
        pan1= new JPanel();
        pan2= new JPanel();
        Container holder = getContentPane();
        holder.setLayout( new GridLayout(2,1));
        holder.add(pan1);        
        holder.add(pan2);        
        pan1.setLayout(new GridLayout(4,1));
        pan2.setLayout(new FlowLayout ());
        pan1.add(lbl);
        pan1.add(tf);
        pan1.add(lbl1);
        pan1.add(tf1);
        pan2.add(btn);
        pan2.add(btn1);
        
    }
    
        private class ButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        // Section_ 7 you are required to add the code of the listener event object 
            Object pressedButton= e.getSource();
            if(pressedButton.equals(btn)){
                sf.setUserN(tf.getText());
                sf.setPass(tf1.getText());
            }
            if(pressedButton.equals(btn1)){
                tf.setText("root");
                tf1.setText("");
            }
        }
    }
}
