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
		switch(s.dir)
		{
		case 'n':
			//check if space at end of placement exists
			//check spaces are unoccupied
			//place ship
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
	
}
