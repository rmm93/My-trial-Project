/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activation;

/**
 * this class creates an object for holding both username and password
 * @author Raoum
 */
public class StringsFun {
    private String userN;
    private String pass;
    
    public String getUserN(){return userN;}
    public void setUserN(String n){userN=n;}
    public String getPass(){return pass;}
    public void setPass(String n){pass=n;}
    
    public StringsFun(){
        userN="root";
        pass="";
    }
}
