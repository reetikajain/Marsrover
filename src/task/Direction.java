package task;

class Direction {
	
	
	String str;
	Position Boun;
	MarsRover mr;
	Character ch;
	Direction(Position B,String s,MarsRover mr,Character ch)
	{
		str=s;
		Boun =B;
		this.mr=mr;
		ch=Character.toUpperCase(ch);
		this.ch=ch;
		
	}
	
	public boolean checkDir()
	{
		if(ch=='E'||ch=='W'||ch=='N'||ch=='S')
		{
			return true;
		}
		return false;
	}
	public char getDirection()
	{
		return ch;
	}
	
	public void evaluate()
	{	
		String var;
		var=str.toUpperCase();
        String dir="LRM";
        Integer i;
        Integer len=var.length();
        for( i=0;i<len;i++)
        {
           if( dir.indexOf(var.charAt(i))==-1)

           {
               System.out.println("Invalid instruction");
               break;
           }
           
        }
	
	
	if(i==len)
    { int x,y,flag=0;
    int j;
        String rightdir="ESWN";
        String leftdir="ENWS";

        for( j=0;j<var.length();j++)
        {
        	flag=0;
            if(var.charAt(j)=='M')
            {
             switch(ch)
             {
                 case 'E':x=mr.R.getx();
        		  		  x=x+1;
        		          flag=mr.rovercheck(Boun.getx(),x);
        		          if(flag==1)
                	      mr.R.setx(x);
                          break;
                 case 'W':x=mr.R.getx();
		  		  		  x=x-1;
		  		  		  flag=mr.rovercheck(Boun.getx(),x);
		                   if(flag==1)
		                  mr.R.setx(x);
                          break;
                 case 'N':y=mr.R.gety();
		  		  		  y=y+1;
		  		  		  flag=mr.rovercheck(Boun.gety(),y);
		  		  		  if(flag==1)
		  		  		  mr.R.sety(y);
		  		  		  break;
                 case 'S':y=mr.R.gety();
		  		  		  y=y-1;
		                  flag=mr.rovercheck(Boun.gety(),y);
		                  if(flag==1)
		                  mr.R.sety(y);
		                  break;	  


             	}
               if(flag==0)
               {
            	   System.out.println("Cannot make next move");
            	   System.out.println(mr.name+ ":"+mr.R.getx()+" "+mr.R.gety()+" "+ch);
            	   break;
               }
               
               
            }
            else if(var.charAt(j)=='L')
            {
                Integer next=leftdir.indexOf(ch);
                if(next==3)
                {
                    next=0;
                }
                else
                {
                    next=next+1;
                }

                ch= leftdir.charAt(next);
                //System.out.println(direction);
            }
            else
            {
                Integer next=rightdir.indexOf(ch);
                if(next==3)
                {
                    next=0;
                }
                else
                {
                    next=next+1;
                }

                ch= rightdir.charAt(next);
               // System.out.println(direction);
            }
        }
        if(j==var.length())
        {
        	mr.display(ch);
        }
    }


}
}
