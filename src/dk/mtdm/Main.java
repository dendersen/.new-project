package dk.mtdm;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean done = false;
    boolean finish = false;

    while(true){
      while(true){
      try{
        System.out.print("please input keyword: ");
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");

        for(String keyWord : inputs){
          switch (keyWord) {
            case "debt":
            System.out.println("");
            Debt.main(args);
            done = true;
            break;
            
            case "stop":
            System.out.println("stopping program )-:");
            finish = true;
            break;
            
            default:
            break;
          }
          if(done || finish)
          break;
        }
        if(done || finish)
          System.out.println("operation done (-:");
          done = false;
        break;
      }
      catch (NoSuchElementException ex){
        System.out.println("no keywords found");
        break;
      }
    }
  }
  }
}
