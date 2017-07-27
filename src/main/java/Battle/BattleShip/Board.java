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
				       printBoard();
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
				       printBoard();
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
				       printBoard();
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
				       printBoard();
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
	
	public void printBoard()
	{
		System.out.print(Deaglan.ANSI_RESET);
		for(int j = col; j >= 0; j--)
		{
			for(int i = 0; i <= row; i++)
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
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println();
			System.out.print(Deaglan.ANSI_RESET);
		}
		
	}
	
	public void printHitBoard()
	{
		System.out.print(Deaglan.ANSI_RESET);
		for(int j = col; j >= 0; j--)
		{
			for(int i = 0; i <= row; i++)
			{
				if(boardState.get(convertToKey(i,j)) == 's')
				{
					System.out.print(Deaglan.ANSI_CYAN + "s");
				}
				else if(boardState.get(convertToKey(i,j)) == 'b')
				{
					System.out.print(Deaglan.ANSI_CYAN + "s");
				}
				else if(boardState.get(convertToKey(i,j)) == 'h')
				{
					System.out.print(Deaglan.ANSI_YELLOW + "h");
				}
				System.out.print(" ");
			}
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
			System.out.print(Deaglan.ANSI_RESET);
		}
		
	}
	
	public boolean shoot(int x, int y)
	{
		if(checkSpaceExists(x,y))
		{
			System.out.println();
			System.out.println("Shooting " + x +","+y);
			
			if(boardState.get(convertToKey(x,y)) == 's')
			{
				System.out.println("Miss !");
				return true;
			}
			else if(boardState.get(convertToKey(x,y)) == 'b')
			{
				setSpaceStatus(x,y, 'h');
				System.out.println("");
				System.out.println("Hit !");
				System.out.println(" ");
			    
			    return true;
			}
			else if(boardState.get(convertToKey(x,y)) == 'h')
			{
				System.out.println("You already hit this boat");
				return true;
			}
			else
			{
				System.out.println("Error");
				return false;
			}
				
		}
		else
		{
			System.out.println("Invalid corodinate");
			return false;
		}
	}
	
	public void printBoardCords()
	{
		for(int j = col; j >= 0; j--)
		{
			for(int i = 0; i <= row; i++)
			{
				System.out.print(Integer.toString(i)+Integer.toString(j));
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	
}
