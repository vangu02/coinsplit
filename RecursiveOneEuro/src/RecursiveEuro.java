import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RecursiveEuro {
	
	public static int ctvalue[] = new int[10];	
	public static int maxct[] = new int[10];
	public static int ct[] = new int[10];
//	public static int coin[] = new int[10];
	public static int amount=100;
	public static int mincoins=999999999;
	public static int change = 0;
	
	
	private static void split(int coin, int rest)
	{

		/*

    	ct1 = amount - eur2*200 - eur1*100 - ct50*50 - ct20*20 - ct10*10 - ct5*5 -ct2*2;
        int coins = ct1+ct2+ct5+ct10+ct20+ct50+eur1+eur2;

	    System.out.println(String.format("%s coins divided over %sx2EUR %sx1EUR %sx50ct %sx20ct %sx10ct %sx5ct %sx2ct %sx1ct",coins,eur2,eur1,ct50,ct20,ct10,ct5,ct2,ct1));
	    change++;

	 */
		maxct[coin] = rest / ctvalue[coin];
		for (ct[coin]=0;ct [coin]<=maxct[coin];ct[coin]++)
		{
			rest = rest - ct[coin]*ctvalue[coin]; 
			if (coin>0)
			{
				split(--coin,rest);
			}
			else
			{
				ct[0]=rest;
			    System.out.println(String.format("coins divided over %sx2EUR %sx1EUR %sx50ct %sx20ct %sx10ct %sx5ct %sx2ct %sx1ct",ct[7],ct[6],ct[5],ct[4],ct[3],ct[2],ct[1],ct[0]));
			    ++coin;
				change++;
			}
		}
	}
	
    public static void main(String[] args)  {
    	System.out.println(String.format("Splitting euro"));
   		ctvalue[0]=1;
   		ctvalue[1]=2;
   		ctvalue[2]=5;
   		ctvalue[3]=10;
   		ctvalue[4]=20;
   		ctvalue[5]=50;
   		ctvalue[6]=100;
   		ctvalue[7]=200;
   		
   		for (int i=0;i<8;i++)
   		{
   			maxct[i]=0;
   			ct[i]=0;
   		}
        amount = Integer.parseInt(args[0]);
    	int change = 0;
    	
    	long startTime = System.nanoTime();
    	
    	split(7, amount);
    	
    	/*
    	maxeur2 = amount / 200;
    	for (eur2=0; eur2<=maxeur2; eur2++)
    	{
    		maxeur1 = (amount - eur2*200) / 100;
    		for (eur1=0; eur1<=maxeur1; eur1++)
    		{
    			maxct50= (amount - eur2*200 - eur1*100) / 50;
    			for (ct50=0; ct50<=maxct50; ct50++)
    			{
    				maxct20= (amount - eur2*200 - eur1*100 - ct50*50) / 20;
    				for (ct20=0; ct20<=maxct20; ct20++)
    				{
    					maxct10= (amount - eur2*200 - eur1*100 - ct50*50 - ct20*20) / 10;
    					for (ct10=0; ct10<=maxct10; ct10++)
    					{
    						maxct5= (amount - eur2*200 - eur1*100 - ct50*50 - ct20*20 - ct10*10) / 5;
    						for (ct5=0; ct5<=maxct5; ct5++)
    						{
    							maxct2= (amount - eur2*200 - eur1*100 - ct50*50 - ct20*20 - ct10*10 - ct5*5) / 2;
    							for (ct2=0; ct2<=maxct2; ct2++)
    							{
    								ct1 = amount - eur2*200 - eur1*100 - ct50*50 - ct20*20 - ct10*10 - ct5*5 -ct2*2;
        							// maxct2= (amount - eur2*200 - eur1*100 - ct50*50 - ct20*20 - ct10*10 - ct5*5) / 2;
        							//for (ct1=0; ct1<=maxct1; ct1++)
        							//{
        							//	if (eur2*200 + eur1*100 + ct50*50 + ct20*20 + ct10*10 + ct5*5 + ct2*2 + ct1==amount)
        							//	{
        									int coins = ct1+ct2+ct5+ct10+ct20+ct50+eur1+eur2;
        									if (coins<mincoins) 
        									{
        										mincoins=coins;
        										mineur2 = eur2;
        										mineur1 = eur1;
        										minct1 = ct1;
        										minct2 = ct2;
	    										minct5 = ct5;
	    										minct10 = ct10;
	    										minct20 = ct20;
	    										minct50 = ct50;
	    									}
	    								System.out.println(String.format("%s coins divided over %sx2EUR %sx1EUR %sx50ct %sx20ct %sx10ct %sx5ct %sx2ct %sx1ct",coins,eur2,eur1,ct50,ct20,ct10,ct5,ct2,ct1));
	    								change++;
        							//	}
        							//}
    							}
    						}
    			    			
    					}
    		    			
    				}
    	    				
    			}
    		}
    	}
    	*/
    	long endTime = System.nanoTime();
    	long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
    	System.out.println(String.format("\ncalculation lasted %sms\n\n",duration/1000000));
    	
    	System.out.println(String.format("\n %s number of possible change for %s cent, with min %s coins",change,amount,mincoins));
    	//System.out.println(String.format("%s coins divided over %sx2EUR %sx1EUR %sx50ct %sx20ct %sx10ct %sx5ct %sx2ct %sx1ct",mincoins,mineur2,mineur1,minct50,minct20,minct10,minct5,minct2,minct1));
    	
    }

}
