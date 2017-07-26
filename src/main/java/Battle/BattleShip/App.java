package Battle.BattleShip;

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
     //  b.placeBoat(0, 0, new Ship(5,'n'));
       b.printBoard(9, 9);
       System.out.println("add a boat");
       System.out.println(" ");
       b.placeBoat(0, 8, new Ship(2,'e'));
       b.printBoard(9, 9);
       System.out.println("add a boat");
       System.out.println(" ");
     //  b.placeBoat(3, 5, new Ship(2,'s'));
       b.printBoard(9, 9);
       System.out.println("add a boat");
       System.out.println(" ");
    //   b.placeBoat(9, 9, new Ship(2,'w'));
       b.printBoard(9, 9);
    }
}
