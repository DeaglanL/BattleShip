package Battle.BattleShip;

import java.util.HashMap;

public class Board {

	/*
	 * s = sea
	 * b = boat
	 * d = ded boat
	 * 
	 */
	Character sea = new Character('s');
	
	HashMap<String, Character> boardState = new HashMap<String, Character>();
	
	public Board(int x , int y)
	{
		for (int i = 0; i < x; i++)
		{
			for (int j = 0; j < y; j++)
			{
				boardState.put(convertToKey(i , j), sea);
			}
		}
	}
	
	public void placeBoat(int x, int y, Ship s)
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
						break; 
					}
				}
				
				if(!occupied)
				{
					//place ship
					for(int i = 0; i < s.length; i++)
					{
						setSpaceStatus(x, y+i, 'b');
					}
				}
				
			}
			
			
			break;
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
						break; 
					}
				}
				
				if(!occupied)
				{
					//place ship
					for(int i = 0; i < s.length; i++)
					{
						setSpaceStatus(x+i, y, 'b');
					}
				}
				
			}
			break;
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
						break; 
					}
				}
				
				if(!occupied)
				{
					//place ship
					for(int i = 0; i < s.length; i++)
					{
						setSpaceStatus(x, y-i, 'b');
					}
				}
				
			}
			break;
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
						break; 
					}
				}
				
				if(!occupied)
				{
					//place ship
					for(int i = 0; i < s.length; i++)
					{
						setSpaceStatus(x-i, y, 'b');
					}
				}
				
			}
			break;
			default:
				System.out.println("Invalid ship direction");
				break;
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
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				System.out.print(boardState.get(convertToKey(i,j)));
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
}
