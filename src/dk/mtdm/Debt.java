package dk.mtdm;

import java.text.NumberFormat;
import java.util.Scanner;

public class Debt {
  public static void main(String[] args) {
    final Byte PERCENT = 100;
    final byte MONTHS_IN_YEAR = 12;
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    try (Scanner scanner = new Scanner(System.in)) {
      Float loan;
      Float intrest;
      Float time;

      while(true){
        try{
          System.out.print("loan amount: ");

          loan = scanner.nextFloat();
          if(loan > 0)
          break;
          System.out.println("loan must be more then 0 Dkk");
        }catch (java.util.InputMismatchException ex){
          System.out.println("please input a number. ");
          String incorrect = scanner.nextLine();
          System.out.println("the found input was: \"" + incorrect + "\" which is not a number");
        }
      }
      while(true){
        try{
          System.out.print("yearly intrest on loan: ");
          intrest = scanner.nextFloat()/PERCENT;
          if(intrest <= 50 && intrest > 0)
          break;
          if(intrest < 0)
          System.out.println("yearly intrest must be more than 0%");
          else
          System.out.println("yearly intrest cannot be more than 50%");
        }catch (java.util.InputMismatchException ex){
          System.out.println("please input a number. ");
          String incorrect = scanner.nextLine();
          System.out.println("the found input was: \"" + incorrect + "\" which is not a number");
        }
      }
      while(true){
        try {
          System.out.print("payment period (in years): ");
          time = scanner.nextFloat();
          if(time > 0)
          break;
          System.out.println("payment period must be at least 1 year");
        }catch (java.util.InputMismatchException ex){
          System.out.println("please input a number. ");
          String incorrect = scanner.nextLine();
          System.out.println("the found input was: \"" + incorrect + "\" which is not a number");
        }
      }
      System.out.println("\n");
      Float monthlyPay = (float)Math.pow(1 + intrest, time);
      monthlyPay *= loan;
      monthlyPay /= (time*MONTHS_IN_YEAR);
      String result = currency.format(monthlyPay);
      System.out.println("you have to pay: " + result + " per month");
      Float totalPay = monthlyPay * time * MONTHS_IN_YEAR;
      result = currency.format(totalPay);
      System.out.println("total amount to pay: " + result);
      result = currency.format(totalPay-loan);
      System.out.println("amount payed over loan: " + result);
    }
  }
}
