package Battle.BattleShip;

import org.fusesource.jansi.AnsiConsole;

public class App 
{
    public static void main( String[] args )
    {
       System.out.println("start");
       Board b = new Board(9,9);
       System.out.println("Board created");
       b.printBoard(9, 9);
       System.out.println(" ");
       System.out.println("add a boat");
       System.out.println(" ");
       b.placeBoat(0, 0, new Ship(5,'n'));
       b.printBoard(9, 9);
       System.out.println(" ");
       System.out.println("add a boat");
       System.out.println(" ");
       b.placeBoat(5, 5, new Ship(4,'e'));
       b.printBoard(9, 9);
       System.out.println(" ");
       System.out.println("add a boat");
       System.out.println(" ");
       b.placeBoat(9, 9, new Ship(4,'s'));
       b.printBoard(9, 9);
       System.out.println(" ");
       System.out.println("add a boat");
       System.out.println(" ");
       b.placeBoat(4, 9, new Ship(4,'w'));
       b.printBoard(9, 9);
       
       
  
       
    }
}
