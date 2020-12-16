package test002;

import org.apache.commons.lang3.StringUtils;


public class Test001 {
	public static void main(String[] args) {
		
		System.out.println(StringUtils.leftPad("1", 2, " "));
//		int a = 5;
//		String str = "" + 5;
//		String str2 = Integer.toString(5);
//		System.out.println(str);
		
		/*

-----------------
     2 단 
-----------------

2 x 1 =  2
2 x 2 =  4
2 x 3 =  6
2 x 4 =  8
2 x 5 = 10
2 x 6 = 12
2 x 7 = 14
2 x 8 = 16
2 x 9 = 18

-----------------
     3 단 
-----------------

3x1=3
3x2=6
3x3=9
3x4=12
3x5=15
3x6=18
3x7=21
3x8=24
3x9=27


		 */
//	    for(int i=2; i<=9; i++) {
//	    	System.out.println( "-----------------");
//	    	 System.out.println( "       "+ i +"단" + "       ");
//	    	 System.out.println( "-----------------");
//	    	for(int j=1; j<=9; j++) {
//	    		int x = i*j;
//	    		if(x < 10) {
//	    			System.out.println(i + " x " + j +" = " + " "+ x);
//	    		} else if(x > 10) {
//	    			System.out.println(i + " x " + j +" = " + x);
//	    		}
//	    	}
//	    	 
//	    }
		
		
		
		
	    for (int i = 2; i <= 9; i++) {
	    	System.out.println();
	    	System.out.println("-----------------");
	    	System.out.println("     "+ i +" 단" + "       ");
	    	System.out.println("-----------------");
	    	System.out.println();
	    	for (int j = 1; j <= 9; j++) {
	    		int result = i * j;
    			System.out.println(i + " x " + j +" = " + StringUtils.leftPad(""+result, 2 , " "));
	    		
	    	}
	    }
		
		
		//System.out.println(StringUtils.leftPad("1", 2, " "));
		
//		
//	    for (int i = 2; i <= 9; i++) {
//	    	System.out.println();
//	    	System.out.println("-----------------");
//	    	System.out.println("     "+ i +" 단" + "       ");
//	    	System.out.println("-----------------");
//	    	System.out.println();
//	    	for (int j = 1; j <= 9; j++) {
//	    		int result = i * j;
////	    		if (result < 10) {
////	    		System.out.println(i + " x " + j +" =" + StringUtils.leftPad( String.valueOf(i), 1 , " " ) + result);
////	    		}
//	    		String x = Integer.toString(i);
//	    		String y = Integer.toString(j);
//	    		String times = Integer.toString(result);
//	    		if (result < 10) {
//	    			System.out.println(StringUtils.leftPad(times, 1 , " "));
//	    		}
////	    		} else if (result >= 10) {
////	    			System.out.println(i + " x " + j +" = " + result);
////	    		}
//	    		
//	    		
//	    	}
//	    }
  
	}
}
