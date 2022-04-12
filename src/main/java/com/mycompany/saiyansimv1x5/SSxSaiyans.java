/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.saiyansimv1x5;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SSxSaiyans extends SSxMain {
    Scanner input = new Scanner(System.in);
    public int udarac;
    public int blast;
    public float obrana;
    public int stupanjSS;
    public String ime;
    public int ulti;
    public int transhole;


    SSxSaiyans(int udarac,int blast, float obrana, int stupanjSS, String ime) {
        this.udarac = udarac;
        this.blast = blast;
        this.obrana=obrana;
        this.stupanjSS = stupanjSS;
        this.ime = ime;
        ulti = 0;
        transhole = 0;
        
    }
    

    public void IspisiPocetak(){
        System.out.println("Saiyan ima " +obrana+ " HP-a.");
        System.out.println("Saiyan ima udarac sa " +udarac+ " DP-a.");
        System.out.println("Saiyan ima Ki-Blast sa " +blast+ " DP-a.");
        System.out.println("Saiyan je trenutačno u SSJ " +stupanjSS+" formi.");
   
    }

    public void IspisiStats(){
        System.out.println("---> "+ime+" SSJ "+stupanjSS+": "+obrana+" HP, "+udarac+"/"+blast+" DP <---");
   
    }

    public void LevelUp(){
        stupanjSS = stupanjSS + 1;
        udarac = udarac + 15;
        blast = blast + 15;
        ulti = ulti + 1;
        System.out.println("((( "+ime+" je dosegao novu razinu! Super Saiyan " +stupanjSS+" )))");
   
    }
    
    public void NapadUdarcem(){

    }
    public void NapadBlastom(){
    
    }
    public void NapadUlti(){
    
    }
    
    public void UdaracAI(){

    }
    public void BlastAI(){

    }
    public void UltiAI(){
    
    }
    
    public void ProvjeraStanja(){
    
    }
    

}