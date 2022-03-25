package dk.mtdm;

public class Chess {
  public static int[] board = new int[64];
  // piece values
  // empty = 0;
  // pawn = 1;
  // rook = 2;
  // knight = 3;
  // bishop = 4;
  // queen = 5;
  // king = 6;
  // white = 0;
  // black = 8;
  public static void main(String[] args) {
    setup();
    String win = "none";
    while(win == "none"){
      System.out.println(boardPrint());
      win = "white";
    }
  }
  public static void setup(){
    board[0] = 2;
    board[7] = 2;
    board[1] = 3;
    board[6] = 3;
    board[2] = 4;
    board[5] = 4;
    board[4] = 5;
    board[3] = 6;

    board[56] = 10;
    board[63] = 10;
    board[57] = 11;
    board[62] = 11;
    board[58] = 12;
    board[61] = 12;
    board[60] = 13;
    board[59] = 14;
  }
  public static String boardPrint(){
    String file = "";
    for(byte line = 0; line < 64; line +=8){
      file += "\n";
      
      for(byte i = 0; i < 8; i++){
        file += "|";
        
        if(board[i+line] == 0)
          file += " ";
        else if (board[i+line] >= 8)
          file += "B";
        else 
          file += "W";
        
        switch (board[i+line]){
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
      }
    }
    return(file);
  }
}
