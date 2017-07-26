package Battle.BattleShip;

import java.util.Scanner;

public class GameController {

	Scanner sc = new Scanner(System.in);
	
	Boolean gameRunning = false; 
	Boolean p1BoatsPlaced = false;
	Board b;
	int numberOfBoats;
	int p1Boats;
	int p2Boats;
	public void gameRun() {
	Boolean boardSet = false; 
	while(!gameRunning)
	{
		while(!boardSet)
		{
			//Phase one game setup
			System.out.println("Please enter a board size");
			String input = sc.nextLine();
			
			if(Deaglan.intTryParse(input))
			{
				int a = Integer.parseInt(input);
				b = new Board(a, a);
				b.printBoard(a, a);
				numberOfBoats = (int) Math.ceil((a * 0.35f));
				p1Boats = numberOfBoats; 
				boardSet = true; 
				
				b.printBoardCords(a, a);
			}
			
			
		}
		
		while(!p1BoatsPlaced)
		{
			
			System.out.println("You have " + p1Boats + " left to place. This boat is " + (p1Boats + 1) + " long");
			System.out.println("Please enter a the cordinate you would like to place your board at and its compass direction (E.G. 0,0,n)");
			String input = sc.nextLine();
			String[] cords = input.split(",");
			if(Deaglan.intTryParse(cords[0]) && Deaglan.intTryParse(cords[1]))
			{
				if(b.placeBoat(Integer.parseInt(cords[0]), Integer.parseInt(cords[1]), new Ship((p1Boats + 1), cords[2].toLowerCase().charAt(0))))
				{
				p1Boats--;
				
				if(p1Boats < 1)
				{
					p1BoatsPlaced = true;
				}
				}
			}

			
			
		}
	 
		System.out.println(Deaglan.ANSI_WHITE_BACKGROUND + Deaglan.ANSI_PURPLE + "-----------------Game Over-------------------");
		gameRunning = true; 
		//phase two player one ship place
		//phase three player two ship place
		//
	}
	}
	
	
	
	
}
