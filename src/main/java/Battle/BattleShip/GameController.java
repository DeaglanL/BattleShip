package Battle.BattleShip;

import java.util.Scanner;

public class GameController {

	Scanner sc = new Scanner(System.in);
	
	Boolean gameRunning = false; 
	boolean someonesWon = false; 
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
				p1Board.printBoard();
				numberOfBoats = (int) Math.ceil((a * 0.35f));
				p1Boats = numberOfBoats; 
				p2Boats = numberOfBoats;
				boardSet = true; 
			}
			
			
		}
		
		while(!p1BoatsPlaced)
		{
			//phase two player one ship place
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
		
		Deaglan.safeSleep(2000);
		Deaglan.consoleClear();
		while(!p2BoatsPlaced)
		{
			//phase three player two ship place
			Deaglan.consoleClear();
			p2Board.printBoard();
			System.out.println(Deaglan.ANSI_BLACK_BACKGROUND + Deaglan.ANSI_WHITE + "PLAYER 2");
			System.out.println("You have " + p2Boats + " left to place. This boat is " + (p2Boats + 1) + " long");
			System.out.println("Please enter a the cordinate you would like to place your board at and its compass direction (E.G. 0,0,n)");
			String input = sc.nextLine();
			String[] cords = input.split(",");
			if(Deaglan.intTryParse(cords[0]) && Deaglan.intTryParse(cords[1]))
			{
				if(p2Board.placeBoat(Integer.parseInt(cords[0]), Integer.parseInt(cords[1]), new Ship((p2Boats + 1), cords[2].toLowerCase().charAt(0))))
				{
				p2Boats--;
				
				if(p2Boats < 1)
				{
					p2BoatsPlaced = true;
				}
				}
			}
		}
	 
		Deaglan.safeSleep(2000);
		Deaglan.consoleClear();
		while (!someonesWon)
		{
			//Phase four shooting 
			
			//p1 turn
			boolean shot = false; 
			int shotCount = 0; 
			//p1 print board; 
			System.out.println(Deaglan.ANSI_BLACK_BACKGROUND + Deaglan.ANSI_WHITE + "PLAYER 1");
			System.out.println("Boards");
			p2Board.printHitBoard();
			p1Board.printBoard();
			//p1 Shoot
			while(!shot)
			{
			System.out.println("Enter cordinate you want to shoot");
			String input = sc.nextLine();
			String[] cords = input.split(",");
			if(Deaglan.intTryParse(cords[0]) && Deaglan.intTryParse(cords[1]))
			{
				if(p2Board.shoot(Integer.parseInt(cords[0]), Integer.parseInt(cords[1])))
				{
					shotCount++;
					if(shotCount == 2) 
					{
					  shot = true; 
					}
				}
			}
			}
			
			
			shot = false; 
			if(p2Board.lost())
			{
				System.out.println(Deaglan.ANSI_BLACK_BACKGROUND + Deaglan.ANSI_WHITE + "PLAYER 1 WINS :D");
				shot = true; 
				gameRunning = true;
				someonesWon = true;
			}
			else
			{
			Deaglan.safeSleep(2000);
			Deaglan.consoleClear();
			
			//p2 turn
			shot = false; 
			
			//p2 print board; 
			System.out.println(Deaglan.ANSI_BLACK_BACKGROUND + Deaglan.ANSI_WHITE + "PLAYER 2");
			System.out.println("Boards");
			p1Board.printHitBoard();
			p2Board.printBoard();
			}
			//p2 shoot
			while(!shot)
			{
			System.out.println("Enter cordinate you want to shoot");
			String input = sc.nextLine();
			String[] cords = input.split(",");
			if(Deaglan.intTryParse(cords[0]) && Deaglan.intTryParse(cords[1]))
			{
				shotCount++;
				if(shotCount == 2) 
				{
				  shot = true; 
				}
			}
			}
			
			if(p1Board.lost())
			{
				System.out.println(Deaglan.ANSI_BLACK_BACKGROUND + Deaglan.ANSI_WHITE + "PLAYER 2 WINS :D");
				shot = true; 
				gameRunning = true;
				someonesWon = true;
			}
		}
		
		System.out.println(Deaglan.ANSI_WHITE_BACKGROUND + Deaglan.ANSI_PURPLE + "-----------------Game Over-------------------");
		gameRunning = true; 
		
		
		
	}
	}
	
	
	
	
}
