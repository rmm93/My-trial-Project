/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Raoum
 */
public class MainAdjusted {
    protected static long [] timeHolder= new long [160];
    public static void main(String [] args){
        int laps2=0;
        while (laps2 < 160){        
        long num= ElapsedTime();
        timeHolder[laps2]=num;
        laps2++;}//while
    }//main
    protected static long ElapsedTime(){
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss:SSS a zzz");
        Date timeStart,endTime;
        //int laps2=0;
        //while (laps2 <= 100){
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
        return elapsed%66;
        //laps2++;   }//while
    }//elapsed time    
}
