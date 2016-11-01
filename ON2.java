import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;
public class ON2
{
    public static void main(String[] args) throws IOException //leer desde la entrada standar
    {
        Scanner in = new Scanner(System.in); //
                while (in.hasNextLine())
        {
                	String line = in.nextLine();   
                    String[] nums = line.split(" ");
                    int largo= nums.length;
                    int [] vector= new int [largo];
                    
                    
                    for(int i = 0; i < largo; i++)
                	{
                    	vector[i]= Integer.parseInt(nums[i]);
                		}
                    int [] r= SumaSubMax(vector);                 
                    System.out.println (Integer.toString(r[1])+","+Integer.toString(r[2]));

        	}
        }
     

public static int[] SumaSubMax(int[] secuencia){
	int[] a=new int[3];
	
	a[0] = secuencia[0]; // primer valor
	a[1] = 0; // i mejor
	a[2] = 0; // j mejor
	
	for(int i=0; i<secuencia.length; ++i){		// primer for (orden N)
		int thisSum = 0;
		for(int j=i; j<secuencia.length; ++j){ //segundo for (orden 2N)
			thisSum += secuencia[j];

            if(thisSum==a[0] && j-i< a[2]-a[1])
            {
                a[1]= i;
                a[2]= j;                  
            }

			if(thisSum > a[0]){	
				a[0] = thisSum;
				a[1] = i;
				a[2] = j;
			}
		}
	}
	return a;}
    
}
