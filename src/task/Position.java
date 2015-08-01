package task;

import java.util.Scanner;

public class Position {
	
	int x;
	int y;
	
	public void input()
	{
		System.out.println("enter the co-ordinates");
		Scanner s=new Scanner(System.in);
		x=s.nextInt();
		y=s.nextInt();
	}
	public void setx(int x)
	{
		this.x=x;
	
	}
	public void sety(int y)
	{
		this.y=y;
	
	}
	
	public int getx()
	{
		return x;
		
	}
	
	public int gety()
	{
		return y;
		
	}
	public int boundaryCheck(Position B, MarsRover mr)
	{
		if(B.x>=mr.R.x && B.y >=mr.R.y)
		{
			return 1;
		}
		
			return 0;
		
	}
	
	

	
}
