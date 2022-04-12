/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.saiyansimv1x5;


import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;



public class SSxGame extends SSxMain {
    Scanner input = new Scanner(System.in);
    int righton;
    int missed;
    int defended;
    
    public SSxGame(){
        righton = 0;
        missed = 0;
        defended = 0;

    }
    
    public String Ulaz(){
        String ime2 = "Toriyama";
        System.out.println("------DOBRODOŠAO U SAIYAN SIMULATOR v1.0------");
        Scanner input = new Scanner(System.in);
        System.out.println("---Unesi ime svoga figthera---");
        String ime = input.nextLine();
        return ime;
    
    }
    
    public void Ulaz2(SSxSaiyans fighter1, SSxSaiyans fighter2, String ime2) throws InterruptedException{
        System.out.println("---"+fighter1.ime+"---");
        fighter1.IspisiPocetak();
        System.out.println("---"+ime2+"---");
        fighter2.IspisiPocetak();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Borba započinje! Prvi koji uspije skinuti sav HP od drugog igrača pobjeđuje!");
        TimeUnit.SECONDS.sleep(2);
    }

    
    
    
    public int PNstart(){
        int PNstarting = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        System.out.println("Unesi broj 1 ili broj 2:");
        String Odabir = input.nextLine();
        int OdabirInt = Integer.valueOf(Odabir);
        if (PNstarting == OdabirInt ){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public void Rezultati(){
    
    
    }

        
    
}
    
    