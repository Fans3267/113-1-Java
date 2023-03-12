/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuSmartTv;
import java.util.Scanner;

/**
 *
 * @author Jorge Arnaldo
 */
public class SmartTv {
    Scanner scan = new Scanner(System.in);
    boolean televisionOn = false;
    int channel = 1;
    int volume = 25;
    
    //Methods are created to manipulate status:
    
    public void turnOnTv(){
        televisionOn = true;
        System.out.println("...Tv is turning On");
        System.out.println("Current channel: " + channel);
        System.out.println("Current Volume: " + volume);
    }
    
    public void turnOffTv(){
        televisionOn = false;
        System.out.println("......Tv turned Off");
    }
    
    public void increaseVolume(){
        volume++;
        System.out.println("+ Volume in:" + volume);
    }
    
    public void reduceVolume(){
        volume--;
        System.out.println("- Volume in:" + volume);
    }
    
    public void increaseChannel(){
        channel++;
        System.out.println("Channel moved to (+): " + channel);
    }
    
    public void reduceChannel(){
        channel--;
        System.out.println("Channel moved to (-): " + channel);
    }
    
    public void changeChannelTo(int newChannel){
        channel = newChannel;
        System.out.println("New Channel: " + channel);
    }
    
//aqui...    
    public void initialize(){
       int menuOption;
       
       do{
           showMenu();
           menuOption = scan.nextInt();
           switchMenu(menuOption);
       }while(menuOption !=6);
   }
   
   public void showMenu(){
       System.out.println("\n\tSELECT OPTION:");
       System.out.println("1. (+) volume. 2. (-) volume.");
       System.out.println("3. (+)channel. 4. (-) channel.");
       System.out.println("5. Change channel to. 6. Turn Off");
   }
   
   public void switchMenu(int menuOption){
       switch(menuOption){
           case  1:
               increaseVolume();
               break;
           case 2:
               reduceVolume();
               break;
           case 3:
               increaseChannel();
               break;
           case 4:
               reduceChannel();
               break;
           case 5:
               System.out.println("New channel: ");
               channel = scan.nextInt();
               changeChannelTo(channel);
               break;
           case 6:
               turnOffTv();
               break;
           default:
               System.out.println("FAILED. Invalid option!");
       }
   }
    
}
