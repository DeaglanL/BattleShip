package Battle.BattleShip;

import java.util.Scanner;

public class GameController {

	Scanner sc = new Scanner(System.in);
	
	Boolean gameRunning = false; 
	Boolean p1BoatsPlaced = false;
	Boolean p2BoatsPlaced = false;
	Board b;
	Board p1Board;
	Board p2Board; 
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
				p1Board = new Board(a,a);
				p2Board = new Board(a,a);
				p1Board.printBoard(9, 9);
				numberOfBoats = (int) Math.ceil((a * 0.35f));
				p1Boats = numberOfBoats; 
				p2Boats = numberOfBoats;
				boardSet = true; 
			}
			
			
		}
		
		while(!p1BoatsPlaced)
		{
			System.out.println(Deaglan.ANSI_BLACK_BACKGROUND + Deaglan.ANSI_WHITE + "PLAYER 1");
			System.out.println("You have " + p1Boats + " left to place. This boat is " + (p1Boats + 1) + " long");
			System.out.println("Please enter a the cordinate you would like to place your board at and its compass direction (E.G. 0,0,n)");
			String input = sc.nextLine();
			String[] cords = input.split(",");
			if(Deaglan.intTryParse(cords[0]) && Deaglan.intTryParse(cords[1]))
			{
				if(p1Board.placeBoat(Integer.parseInt(cords[0]), Integer.parseInt(cords[1]), new Ship((p1Boats + 1), cords[2].toLowerCase().charAt(0))))
				{
				p1Boats--;
				
				if(p1Boats < 1)
				{
					p1BoatsPlaced = true;
				}
				}
			}
		}
		
		while(!p2BoatsPlaced)
		{
			System.out.println(Deaglan.ANSI_BLACK_BACKGROUND + Deaglan.ANSI_WHITE + "PLAYER 2");
			System.out.println("You have " + p2Boats + " left to place. This boat is " + (p2Boats + 1) + " long");
			System.out.println("Please enter a the cordinate you would like to place your board at and its compass direction (E.G. 0,0,n)");
			String input = sc.nextLine();
			String[] cords = input.split(",");
			if(Deaglan.intTryParse(cords[0]) && Deaglan.intTryParse(cords[1]))
			{
				if(p2Board.placeBoat(Integer.parseInt(cords[0]), Integer.parseInt(cords[1]), new Ship((p1Boats + 1), cords[2].toLowerCase().charAt(0))))
				{
				p2Boats--;
				
				if(p2Boats < 1)
				{
					p2BoatsPlaced = true;
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
