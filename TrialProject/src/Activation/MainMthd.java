package Activation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raoum
 */

import java.util.*;
import java.text.*;

public class MainMthd {
    public static void main(String [] args){
        ElapsedTime();
    }//main
    protected static void ElapsedTime(){
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss:SSS a zzz");
        Date timeStart,endTime;
        int laps2=0;
        while (laps2 <= 100){
            timeStart= new Date();
            long startInMS= timeStart.getTime();
            double laps=0;
            
            Random r = new Random();
            int num =1+r.nextInt(8);
            while (laps <= num*100000){
                laps+=0.1;
            }//while
            endTime= new Date();
        long endInMS= endTime.getTime();        
        long elapsed= endInMS - startInMS;
        System.out.println("Elapsed Time = " + (elapsed%66)+" ms");
        laps2++;   }//while
    }//elapsed time
}
