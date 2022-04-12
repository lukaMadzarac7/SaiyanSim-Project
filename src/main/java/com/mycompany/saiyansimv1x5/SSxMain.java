
package com.mycompany.saiyansimv1x5;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SSxMain {
    public static void main(String[] args) throws InterruptedException{
        SSxGame Igra = new SSxGame();
        String ime2 = "Toriyama";
        int NaRedu = 0;
        int grade = 0;
        Scanner input = new Scanner(System.in);  
        String ime = Igra.Ulaz();
        SSxSaiyans fighter1 = new SSxSaiyans(15, 30, 500, 1, ime);
        SSxSaiyans fighter2 = new SSxSaiyans(15, 30, 500, 1, ime2);
        Igra.Ulaz2(fighter1, fighter2, ime2);
        int prviNaredu = Igra.PNstart();
        if (prviNaredu == 0){
            NaRedu = 1;
        }
        else{
            NaRedu = 2;
        }
        
        //U OVOM FOR-U SE ODVIJA IGRA
        for (int i = 1; fighter1.obrana >= 1 && fighter2.obrana >= 1; i++){
            
            if(NaRedu%2==0){ //U OVOM IF-U SE ODVIJAJU SVE RUNDE KORISNIKA
                System.out.println(i+". potez: "+ime+" je na redu!");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Odaberi svoj napad: ");
                System.out.println("1) Udarac");
                System.out.println("2) Ki Blast");
                if (fighter1.ulti >= 1){
                    System.out.println("3) ULTIMATE ATTACK x "+fighter1.ulti);
                    
                    
                }
                String OdabirNapada = input.nextLine();
                int OdabirNapadaInt = Integer.valueOf(OdabirNapada);
                if(OdabirNapadaInt == 1){
                    int HitRand = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                    System.out.println("Odaberi gdje ćeš udariti igrača "+ime2+":");
                    System.out.println("1) Glavu");
                    System.out.println("2) Prsa");
                    System.out.println("3) Ruke");
                    System.out.println("4) Noge");
                    String HitPly = input.nextLine();
                    int HitPlyInt = Integer.valueOf(HitPly);
                    TimeUnit.SECONDS.sleep(1);
                    if (HitRand == HitPlyInt){
                        System.out.println("Uspiješan udarac! "+ime2+" gubi "+fighter1.udarac+" HP-a!");
                        fighter2.obrana = fighter2.obrana - fighter1.udarac;
                        fighter1.transhole = fighter1.transhole + fighter1.udarac;
                        Igra.righton++;
                        
                        
        
                    }
                    else{
                        System.out.println("Obranjen udarac! "+ime2+" gubi "+(fighter1.udarac)/3+" HP-a!");
                        fighter2.obrana = fighter2.obrana - (fighter1.udarac)/3;
                        Igra.missed++;
                    
                    }
                    TimeUnit.SECONDS.sleep(1);
                    if (fighter1.transhole > (fighter1.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter1.transhole = fighter1.blast;
                        fighter1.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                    }
                    if (fighter2.transhole > (fighter2.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter2.transhole = fighter2.blast;
                        fighter2.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                
                    }
                    fighter1.IspisiStats();
                    fighter2.IspisiStats();
                    TimeUnit.SECONDS.sleep(2);
                    
    
                }else if(OdabirNapadaInt == 2){
                    int HitRand = ThreadLocalRandom.current().nextInt(1, 2 + 1);
                    System.out.println("Odaberi gdje ćeš pogoditi igrača "+ime2+":");
                    System.out.println("1) Gornji dio");
                    System.out.println("2) Donji dio");
                    String HitPly = input.nextLine();
                    int HitPlyInt = Integer.valueOf(HitPly);
                    TimeUnit.SECONDS.sleep(1);
                    if (HitRand == HitPlyInt){
                        System.out.println("Uspiješan pogodak! "+ime2+" gubi "+fighter1.blast+" HP-a!");
                        fighter2.obrana = fighter2.obrana - fighter1.blast;
                        fighter1.transhole = fighter1.transhole + fighter1.blast;
                        Igra.righton++;
                    }
                    else{
                        System.out.println("Odbijen i vračen Ki-blast! "+ime+" gubi "+fighter1.blast+" HP-a!");
                        fighter1.obrana = fighter1.obrana - fighter1.blast;
                        Igra.missed++;
                    
                    }
                    TimeUnit.SECONDS.sleep(2);
                    if (fighter1.transhole > (fighter1.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter1.transhole = fighter1.blast;
                        fighter1.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                    }
                    if (fighter2.transhole > (fighter2.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter2.transhole = fighter2.blast;
                        fighter2.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                
                    }
                    fighter1.IspisiStats();
                    fighter2.IspisiStats();
                    TimeUnit.SECONDS.sleep(2);
    
                }
                else if(OdabirNapadaInt ==3 && fighter1.ulti >=1){ //OVDJE SE ODVIJA KORISNIKOV ULTIMATE
                    System.out.println("xXxXxXxX "+ime+" koristi svoj ULTIMATE ATTACK XxXxXxXx");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(ime+": KAAA MEEE HAAAA MEEEEEE....");
                    TimeUnit.SECONDS.sleep(2);
                    fighter1.ulti = fighter1.ulti - 1;
                    if(fighter2.ulti >= 1){
                        fighter2.ulti = fighter2.ulti - 1;
                        Igra.missed++;
                        System.out.println(ime2+": GAAAAALICCK GUUUUUN!");
                        TimeUnit.SECONDS.sleep(2);
                        fighter1.obrana = fighter1.obrana - fighter1.udarac;
                        fighter2.obrana = fighter2.obrana - fighter2.udarac;
                        System.out.println(ime2+" je obranio ULTIMATE od igrača "+ime+"!");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(ime+" gubi "+fighter1.udarac+" HP-a!");
                        System.out.println(ime2+" gubi "+fighter2.udarac+" HP-a!");
                        
                    }
                    else{
                        Igra.righton++;
                        System.out.println(ime+": HAAAAAAAAAAAA!!!");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(ime2+" gubi "+fighter1.blast*2+" HP-a!");
                        fighter2.obrana = fighter2.obrana - fighter1.blast*2;
                    
                    }
                    TimeUnit.SECONDS.sleep(2);
                    if (fighter1.transhole > (fighter1.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter1.transhole = fighter1.blast;
                        fighter1.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                    }
                    if (fighter2.transhole > (fighter2.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter2.transhole = fighter2.blast;
                        fighter2.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                
                    }
                    fighter1.IspisiStats();
                    fighter2.IspisiStats();
                    TimeUnit.SECONDS.sleep(2);
                
                }

                
            }
            else{ //U OVOM SE ELSEU NALAZE SVE RUNDE PROTIVNIKA
                System.out.println(i+". potez: "+ime2+" je na redu!");
                TimeUnit.SECONDS.sleep(2);
                int EnemyAttRand = ThreadLocalRandom.current().nextInt(1, 2 + 1);
                if(fighter2.ulti >= 1 && fighter1.ulti < fighter2.ulti){
                    fighter2.ulti = fighter2.ulti - 1;
                    System.out.println("xXxXxXxX "+ime2+" koristi svoj ULTIMATE ATTACK XxXxXxXx");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(ime2+": NOW YOU ARE DONE! GAAALICK GUUUUUN!!!");
                    if(fighter1.ulti ==0){
                        Igra.missed++;
                        fighter1.obrana = fighter1.obrana - fighter2.blast*2;
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(ime+" gubi "+fighter2.blast*2+" HP-a!");
                    }
                    else{
                        Igra.defended++;
                        fighter1.ulti = fighter1.ulti - 1;
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(ime+": OH, NO YOU WON'T! I'LL USE MY ULTIMATE TOO!!!");
                        fighter1.obrana = fighter1.obrana - fighter1.udarac;
                        fighter2.obrana = fighter2.obrana - fighter2.udarac;
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(ime+" je obranio ULTIMATE od igrača "+ime2+"!");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(ime+" gubi "+fighter1.udarac+" HP-a!");
                        System.out.println(ime2+" gubi "+fighter2.udarac+" HP-a!");
                    
                    
                    }
                    
                    TimeUnit.SECONDS.sleep(2);
                    if (fighter1.transhole > (fighter1.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter1.transhole = fighter1.blast;
                        fighter1.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                    }
                    if (fighter2.transhole > (fighter2.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter2.transhole = fighter2.blast;
                        fighter2.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                
                    }
                    fighter1.IspisiStats();
                    fighter2.IspisiStats();
                    TimeUnit.SECONDS.sleep(2);
                
                }
                else{
                if(EnemyAttRand == 1){
                    int EnemyHitRand = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                    System.out.println(ime2+" napada udarcem!");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Koji od 4 dijela ćeš ostaviti otvoren: ");
                    System.out.println("1) Glavu");
                    System.out.println("2) Prsa");
                    System.out.println("3) Ruke");
                    System.out.println("4) Noge");
                    String DefPly = input.nextLine();
                    int DefPlyInt = Integer.valueOf(DefPly);
                    TimeUnit.SECONDS.sleep(2);
                    if (EnemyHitRand == DefPlyInt){
                        System.out.println("Uspiješan udarac! "+ime+" gubi "+fighter2.udarac+" HP-a!");
                        fighter1.obrana = fighter1.obrana - fighter2.udarac;
                        fighter2.transhole = fighter2.transhole + fighter2.udarac;
                        Igra.missed++;
                    }else{
                        System.out.println("Obranjen udarac! "+ime+" gubi "+(fighter2.udarac)/3+" HP-a!");
                        fighter1.obrana = fighter1.obrana - (fighter2.udarac)/3;
                        Igra.defended++;
                        
                    }
                    if (fighter1.transhole > (fighter1.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter1.transhole = fighter1.blast;
                        fighter1.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                    }
                    if (fighter2.transhole > (fighter2.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter2.transhole = fighter2.blast;
                        fighter2.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                
                    }
                    fighter1.IspisiStats();
                    fighter2.IspisiStats();
                    TimeUnit.SECONDS.sleep(2);
                }else{
                    int EnemyBlRand = ThreadLocalRandom.current().nextInt(1, 2 + 1);
                    System.out.println(ime2+" napada Ki-Blastom!");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Koji ćeš dio ostaviti otvoren: ");
                    System.out.println("1) Gornji dio");
                    System.out.println("2) Donji dio");
                    String DefPly2 = input.nextLine();
                    int DefPlyInt2 = Integer.valueOf(DefPly2);
                    TimeUnit.SECONDS.sleep(1);
                    if (EnemyBlRand == DefPlyInt2){
                        System.out.println("Uspiješan pogodak! "+ime+" gubi "+fighter2.blast+" HP-a!");
                        fighter1.obrana = fighter1.obrana - fighter2.blast;
                        fighter2.transhole = fighter2.transhole + fighter2.blast;
                        Igra.missed++;
        
                    }
                    else{
                        System.out.println("Odbijen i vračen Ki-blast! "+ime2+" gubi "+fighter2.blast+" HP-a!");
                        fighter2.obrana = fighter2.obrana - fighter2.blast;
                        Igra.defended++;
                        //transhole1 = transhole1 + fighter2.blast;
                    
                    }
                    TimeUnit.SECONDS.sleep(2);
                    if (fighter1.transhole > (fighter1.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter1.transhole = fighter1.blast;
                        fighter1.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                    }
                    if (fighter2.transhole > (fighter2.blast)*2){
                        System.out.println("The ground is shaking...");
                        TimeUnit.SECONDS.sleep(2);
                        fighter2.transhole = fighter2.blast;
                        fighter2.LevelUp();
                        TimeUnit.SECONDS.sleep(3);
                
                    }
                
                    fighter1.IspisiStats();
                    fighter2.IspisiStats();
                    TimeUnit.SECONDS.sleep(2);
                }
                }
            }
               
         
        NaRedu = NaRedu + 1;
        }
        TimeUnit.SECONDS.sleep(2);
        int ocjena = ((Igra.righton+Igra.defended)*100)/(Igra.missed+Igra.righton+Igra.defended);
        if (ocjena>0&&ocjena<49){
            grade = 1;
    
        }
        else if(ocjena>=50&&ocjena<60){
            grade = 2;
            
        }
        else if(ocjena>=61&&ocjena<=75){
            grade = 3;
            
        }
        else if(ocjena>=76&&ocjena<=89){
            grade = 4;
            
        }
        else if(ocjena>=90&&ocjena<=100){
            grade = 5;
            
        }
        
        
        
        if(fighter1.obrana <=0){
            System.out.println("");
            System.out.println("");
            System.out.println("------"+ime2+" je pobjedio igrača "+ime+"------");
            System.out.println("");
            System.out.println("Pogođeno: "+Igra.righton);
            System.out.println("");
            System.out.println("Promašeno: "+Igra.missed);
            System.out.println("");
            System.out.println("Obranjeno: "+Igra.defended);
            System.out.println("");
            System.out.println("REZULTAT: "+ocjena+"%");
            System.out.println("OCJENA: "+grade);
            System.out.println("");
            System.out.println("---HVALA NA IGRANJU!---");
            System.out.println("");
        }
        else{
            System.out.println("");
            System.out.println("");
            System.out.println("------"+ime+" je pobjedio igrača "+ime2+"------");
            System.out.println("");
            System.out.println("Pogođeno: "+Igra.righton);
            System.out.println("");
            System.out.println("Promašeno: "+Igra.missed);
            System.out.println("");
            System.out.println("Obranjeno: "+Igra.defended);
            System.out.println("");
            System.out.println("REZULTAT: "+ocjena+"%");
            System.out.println("OCJENA: "+grade);
            System.out.println("");
            System.out.println("---HVALA NA IGRANJU!---");
            System.out.println("");
            
        }

        
        
        
        
        
        
    }
    
}