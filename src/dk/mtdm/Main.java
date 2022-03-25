package dk.mtdm;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean done = false;
    boolean finish = false;
    String input = "";

    while(true){
      while(true){
      try{
        System.out.print("please input keyword:");
        try{
          input = scanner.nextLine();
        }catch(NoSuchElementException e){
          System.out.println("error... retrying");
          input = scanner.nextLine();
        }
        String[] inputs = input.split(" ");

        for(String keyWord : inputs){
          switch (keyWord) {
            case "debt":
            System.out.println("");
            Debt.main(args);
            done = true;
            break;

            case "chess":
            System.out.println("");
            Chess.main(args);
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
        if(done){
          System.out.println("operation done (-:");
          input = "";
        }
        if (finish)
          System.out.println("operation closed");
          break;
        }
        catch (NoSuchElementException ex){
          System.out.println("error, input failed \nplease restart program");
          System.out.println(ex);
          done = false;
          finish = true;
          break;
        }
      }
      if(finish)
      break;
    }
  }
}
