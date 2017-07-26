package Battle.BattleShip;

import java.util.HashMap;

public class Board {

	/*
	 * s = sea
	 * b = boat
	 * d = ded boat
	 * 
	 */
	
	HashMap<String, Character> boardState = new HashMap<String, Character>();
	
	public Board(int x , int y)
	{
		for (int i = 0; i < x; i++)
		{
			for (int j = 0; i < y; j++)
			{
				boardState.put(convertToKey(i , j), 's');
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
			break;
		case 's':
			break;
		case 'w':
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

		String cord = "";
		cord += x; 
		cord += y;
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
	
	
}
