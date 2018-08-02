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
import java.sql.*;
import java.util.*;

public class DBclass {
    private static final String host="jdbc:mysql://localhost:3306/",userName="root",password=""; 
    public static void main(String [] args){        
        try{
//          Class.forName("com.mysql.jdbc.Driver").newInstance();  
            
            new com.mysql.jdbc.Driver();
            
            Connection con= DriverManager.getConnection(host, userName, password);
            Statement st = con.createStatement();
            ResultSet rs =  st.executeQuery("select * from trialprojectdb.symbolnumbers"); 
            ElapsedTime();
            for (int x=0;x<100;x++){st.execute("UPDATE trialprojectdb.addednumbers SET enteredNums="+ (99-x)+" where indx= "+x);}

            //input options
            int inpNum=0;
            Scanner inp= new Scanner (System.in);
            System.out.println("Please input \"Generate\" to generate Activation Code or \"Insert\" to enter numbers for addition");
            String option = inp.next();
            if (option.equals("Insert")){
                for (int x=0;x<100;x++){
                    System.out.println("Please input a number from 0 to 99");
                    inpNum= inp.nextInt();
                    if (inpNum<0 || inpNum>99){
                    System.out.println("Alert: Please input a number from 0 to 99");
                    x--;
                    continue;
                    }
                    st.execute("UPDATE trialprojectdb.addednumbers SET enteredNums="+ inpNum+" where indx= "+x);
                    System.out.println("You have entered "+ (x+1)+ " numbers, you have "+(100-(x+1))+" remaining");
                }
            }//if
            /*generate the number database*/
            Random r = new Random();
            int rand; 
            ResultSet rand1;
            long num2Table=0; 
            System.out.println("How many numbers would you like to generate?");
            long serial=0, genNum= inp.nextLong();
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
            serial=1000001+l;
            st.execute("INSERT INTO trialprojectdb.activationnumber (ActivationCode) VALUES ('"+code+"')");
            } //
            
        }catch(Exception err){
            System.out.println( err.getMessage( ) );
        }
    }
}
