package dk.mtdm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Chess {
  public static byte[] board = new byte[64];
  // piece values
  // empty = 0;
  // pawn = 1;
  // rook = 2;
  // knight = 3;
  // bishop = 4;
  // queen = 5;
  // king = 6;
  // white = 0; //true
  // black = 8; //false
  public static void main(String[] args) {
    setup();
    String win = "none";
    while(win == "none"){
      System.out.println(boardPrint());
      pieceMovement(true);
      win = "white";
    }
  }
  private static void setup(){
    board[0] = 2;
    board[7] = 2;
    board[1] = 3;
    board[6] = 3;
    board[2] = 4;
    board[5] = 4;
    board[4] = 5;
    board[3] = 6;
    for(byte i = 0; i< 8; i++){
      board[i+8] = 1;
      board[55-i] = 9;
    }

    board[56] = 10;
    board[63] = 10;
    board[57] = 11;
    board[62] = 11;
    board[58] = 12;
    board[61] = 12;
    board[60] = 13;
    board[59] = 14;
  }
  private static String boardPrint(){
    String file = "";
    for(byte line = 0; line < 64; line +=8){
      file += "\n";
      for(byte i = 0; i < 32; i++){
        file += "-";
      }
      file += "\n";
      
      for(byte i = 0; i < 8; i++){
        file += drawPiece(line, i);
      }
    }
    file += "\n";
    for(byte i = 0; i < 32; i++){
      file += "-";
    }
    file += "\n";
    return(file);
  }
  private static String drawPiece(byte line, byte distance) {
  String file = "|";
    
    if(board[distance+line] == 0)
      file += " ";
    else if (board[distance+line] >= 8)
      file += "B";
    else 
      file += "W";
    
    switch (board[distance+line]){
      case 0:
        file += " ";
      break;
      case 1:
      case 9:
        file += "p";
      break;
      case 2:
      case 10:
        file += "R";
      break;
      case 3:
      case 11:
        file += "k";
      break;
      case 4:
      case 12:
        file += "B";
      break;
      case 5:
      case 13:
        file += "Q";
      break;
      case 6:
      case 14:
        file += "K";
      break;
      default:
        file += "E";
    }
    file += "|";
    return file;
  }

  private static void pieceMovement(boolean color) {
    try (Scanner scanner = new Scanner(System.in)) {
      byte position = 0;
      {
        {
          byte horizontal = 0;
          byte vertical = 0;
          while (true){
            try{
            System.out.print("input horizontal possition of piece (right to left): ");
            horizontal = scanner.nextByte();
            if (horizontal > 0 && horizontal < 8)
            break;
            System.out.println("please only use numbers from 1 -> 8");
            } catch (InputMismatchException e){
              System.out.println("please only use numbers from 1 -> 8");
              scanner.nextLine();
            }
          }
          scanner.nextLine();
          while (true){
            try{
              System.out.print("\ninput vetical possition of piece (top to bottom): ");
              vertical = scanner.nextByte();
              if (vertical > 0 && vertical < 8)
              break;
              System.out.println("please only use numbers from 1 -> 8");
            } catch (InputMismatchException e){
              System.out.println("please only use numbers from 1 -> 8");
              scanner.nextLine();
            }
          }
          position = (byte) ((vertical - 1) + (horizontal-1) * 8);
        }
        
        byte piece = board[position];
        boolean correctColor = false;
        if(color){
          if(piece > 7)
          System.out.println("wrong color, current team: white");
          else
          correctColor = true;
        }
        else{
          if(piece < 7)
          System.out.println("wrong color, current team: black");
          else
          correctColor = true;
        }
        if(correctColor)
        System.out.println(boardPrintMove(piece, position, color));
      }
    }
  }
  private static String boardPrintMove(byte moving, byte position, boolean color) {
    String file = "";
    byte moveable[] = new byte[30];
    
    for(byte i = 0; i < 30; i++)
    moveable [i] = -1;
    
    switch(moving){
      case 1:
        byte length = 0;
        if (position + 8 == 0){
          moveable[length] = (byte) (position + 8);
          length++;
          if (position > 7 && position < 16 && color && position+16 == 0 ){
            moveable[length] = (byte) (position+16);
            length++;
          }
        }
        if (position+7 > 8){
          moveable[length] = (byte) (position+7);
          length++;
        }
        if (position+9 > 8){
          moveable[length] = (byte) (position+9);
          length++;
        }
      break;
      case 2:

      break;
      case 3:
      break;
      case 4:
      break;
      case 5:
      break;
      case 6:
      break;
    }
    for (byte line = 0; line < 8; line++){
      file += "\n";
      for(byte i = 0; i < 32; i++){
        file += "-";
      }
      file += "\n";
      for(byte spot = 0; spot < 8; spot++){
        if(checkArray(moveable, (byte) (line*8+spot)))
          file += "\u001B[32m" + drawPiece((byte) (position % 8), (byte) (position - position % 8)) + "\u001B[0m";
        else file += drawPiece(line, spot);
      }

    }
    return(file);
  }

  public static boolean checkArray(byte array[], byte toCheck){
    for(int i = 0; i < array.length; i++){
      System.out.println("i = " + i);
      System.out.println(array[i]);
      if(array[i] == toCheck) return true;
    }
    return(false);
  }
}
