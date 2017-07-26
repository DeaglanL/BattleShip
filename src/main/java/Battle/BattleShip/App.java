package Battle.BattleShip;

import org.fusesource.jansi.AnsiConsole;

public class App 
{
    public static void main( String[] args )
    {
       System.out.println(Deaglan.ANSI_RESET + "start");
       Board b = new Board(9,9);
       System.out.println("Board created");
       b.placeBoat(0, 0, new Ship(5,'n'));
       b.placeBoat(5, 5, new Ship(4,'e'));
       b.placeBoat(9, 9, new Ship(4,'s'));
       b.placeBoat(4, 9, new Ship(4,'w'));;
       b.shoot(4, 9);
       b.shoot(4, 9);
       b.shoot(1, 9);
       b.shoot(2, 9);
       b.shoot(3, 9);
       b.shoot(0, 9);
       
  
       
    }
}
