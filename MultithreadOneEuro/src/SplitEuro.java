public class SplitEuro {
	
    public static void main(String[] args)  {
    	System.out.println(String.format("Splitting euro"));
    	
    	int amount=100;
    	int mincoins=999999999;
    	
    	int eur2=0;
    	int eur1=0;
    	int ct50=0;
    	int ct20=0;
    	int ct10=0;
    	int ct5=0;
    	int ct2=0;
    	int ct1=0;
    	
        amount = Integer.parseInt(args[0]);

    	int maxeur2=0;
    	int maxeur1=0;
    	int maxct50=0;
    	int maxct20=0;
    	int maxct10=0;
    	int maxct5=0;
    	int maxct2=0;
    	int maxct1=0;
    	
    	int mineur2=0;
    	int mineur1=0;
    	int minct50=0;
    	int minct20=0;
    	int minct10=0;
    	int minct5=0;
    	int minct2=0;
    	int minct1=0;

    	int change = 0;
    	
    	long startTime = System.nanoTime();

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
    								//System.out.println(String.format("%s coins divided over %sx2EUR %sx1EUR %sx50ct %sx20ct %sx10ct %sx5ct %sx2ct %sx1ct",coins,eur2,eur1,ct50,ct20,ct10,ct5,ct2,ct1));
    								change++;
    							}
    						}
    			    			
    					}
    		    			
    				}
    	    				
    			}
    		}
    	}
    	
    	long endTime = System.nanoTime();
    	long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
    	System.out.println(String.format("\ncalculation lasted %sms\n\n",duration/1000000));
    	
    	System.out.println(String.format("\n %s number of possible change for %s cent, with min %s coins",change,amount,mincoins));
    	System.out.println(String.format("%s coins divided over %sx2EUR %sx1EUR %sx50ct %sx20ct %sx10ct %sx5ct %sx2ct %sx1ct",mincoins,mineur2,mineur1,minct50,minct20,minct10,minct5,minct2,minct1));
    	
    }

}
