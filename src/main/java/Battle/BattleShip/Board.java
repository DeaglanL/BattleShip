package Battle.BattleShip;

import java.util.HashMap;

public class Board {

	/*
	 * s = sea
	 * b = boat
	 * h = ded boat
	 * 
	 */
	
	int row; 
	int col;
	Character sea = new Character('s');
	
	HashMap<String, Character> boardState = new HashMap<String, Character>();
	
	public Board(int x , int y)
	{
		for(int j = y; j >= 0; j--)
		{
			for(int i = 0; i <= x; i++)
			{
				boardState.put(convertToKey(i , j), sea);
			}
		}
		
		row = x; 
		col = y;
	}
	
	public Boolean placeBoat(int x, int y, Ship s)
	{
		Boolean occupied = false; 
		
		switch(s.dir)
		{
		case 'n':
			//check if space at end of placement exists
			if(checkSpaceExists(x, y+s.length))
			{
				//check spaces are unoccupied
				for(int i = 0; i < s.length; i++)
				{
					if(getSpaceStatus(x, y+i) != 's')
					{
						occupied = true;
						System.out.println("cannot place boat here");
						return false; 
					}
				}
				
				if(!occupied)
				{
					//place ship
					for(int i = 0; i < s.length; i++)
					{
						setSpaceStatus(x, y+i, 'b');
					}
					  System.out.println(" ");
				       System.out.println("added a boat");
				       System.out.println(" ");
				       printBoard(row, col);
				       return true;
				       
				}
				
			}
			else
				System.out.println("cannot place boat here");
			
			return false;
		case 'e':
			//check if space at end of placement exists
			if(checkSpaceExists(x+s.length, y))
			{
				//check spaces are unoccupied
				for(int i = 0; i < s.length; i++)
				{
					if(getSpaceStatus(x+i, y) != 's')
					{
						occupied = true;
						System.out.println("cannot place boat here");
						return false; 
					}
				}
				
				if(!occupied)
				{
					//place ship
					for(int i = 0; i < s.length; i++)
					{
						setSpaceStatus(x+i, y, 'b');
					}
					System.out.println(" ");
				       System.out.println("added a boat");
				       System.out.println(" ");
				       printBoard(row, col);
				       return true;
				}
				
			}
			else
				System.out.println("cannot place boat here");
			return false;
		case 's':
			//check if space at end of placement exists
			if(checkSpaceExists(x, y-s.length))
			{
				//check spaces are unoccupied
				for(int i = 0; i < s.length; i++)
				{
					if(getSpaceStatus(x, y-i) != 's')
					{
						occupied = true;
						System.out.println("cannot place boat here");
						return false; 
					}
				}
				
				if(!occupied)
				{
					//place ship
					for(int i = 0; i < s.length; i++)
					{
						setSpaceStatus(x, y-i, 'b');
					}
					System.out.println(" ");
				       System.out.println("added a boat");
				       System.out.println(" ");
				       printBoard(row, col);
				       return true;
				}
				
			}
			else
				System.out.println("cannot place boat here");
			return false;
		case 'w':
			//check if space at end of placement exists
			if(checkSpaceExists(x-s.length, y))
			{
				//check spaces are unoccupied
				for(int i = 0; i < s.length; i++)
				{
					if(getSpaceStatus(x-i, y) != 's')
					{
						occupied = true;
						System.out.println("cannot place boat here");
						return false;
					}
				}
				
				if(!occupied)
				{
					//place ship
					for(int i = 0; i < s.length; i++)
					{
						setSpaceStatus(x-i, y, 'b');
					}
					System.out.println(" ");
				       System.out.println("added a boat");
				       System.out.println(" ");
				       printBoard(row, col);
				       return true;
				}
				
			}
			else
				System.out.println("cannot place boat here");
			return false;
			default:
				System.out.println("Invalid ship direction");
				return false;
		}
	}
	
	
	public Boolean checkSpaceExists(int x, int y)
	{
		if(boardState.get(convertToKey(x,y)) != null)
		{
			return true;
		}
		else
			return false;
	}
	
	public String convertToKey(int x, int y)
	{

		String cord = Integer.toString(x) + Integer.toString(y);
		return cord; 
	}
	
	public char getSpaceStatus(int x,int y)
	{
		return boardState.get(convertToKey(x,y)); 
	}
	
	public void setSpaceStatus(int x,int y, char status)
	{
		boardState.put(convertToKey(x,y), status);
	}
	
	public void printBoard(int x, int y)
	{
		for(int j = y; j >= 0; j--)
		{
			for(int i = 0; i <= x; i++)
			{
				if(boardState.get(convertToKey(i,j)) == 's')
				{
					System.out.print(Deaglan.ANSI_CYAN + "s");
				}
				else if(boardState.get(convertToKey(i,j)) == 'b')
				{
					System.out.print(Deaglan.ANSI_RED + "b");
				}
				else if(boardState.get(convertToKey(i,j)) == 'h')
				{
					System.out.print(Deaglan.ANSI_YELLOW + "h");
				}
				System.out.print(" ");
			}
			System.out.println();
			System.out.print(Deaglan.ANSI_RESET);
		}
		
	}
	
	public void shoot(int x, int y)
	{
		if(checkSpaceExists(x,y))
		{
			System.out.println();
			System.out.println("Shooting " + x +","+y);
			
			if(boardState.get(convertToKey(x,y)) == 's')
			{
				System.out.println("Miss !");
			}
			else if(boardState.get(convertToKey(x,y)) == 'b')
			{
				setSpaceStatus(x,y, 'h');
				System.out.println("");
				System.out.println("Hit !");
				System.out.println(" ");
			    printBoard(row, col);
			}
			else if(boardState.get(convertToKey(x,y)) == 'h')
			{
				System.out.println("You already hit this boat");
			}
			else
			{
				System.out.println("Error");
			}
				
		}
		else
		{
			System.out.println("Invalid corodinate");
		}
	}
	
	public void printBoardCords(int x, int y)
	{
		for(int j = y; j >= 0; j--)
		{
			for(int i = 0; i <= x; i++)
			{
				System.out.print(Integer.toString(i)+Integer.toString(j));
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	
}
