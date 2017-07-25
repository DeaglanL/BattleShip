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
				String cord = "";
				cord += i; 
				cord += j;
				boardState.put(cord, 's');
			}
		}
	}
	
}
