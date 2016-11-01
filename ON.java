import java.io.IOException;
import java.util.Scanner;

public class ON {

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
                    System.out.println (Integer.toString(r[0])+","+Integer.toString(r[1]));
        	}
        }
            
	 public static int[] SumaSubMax(int[]arreglo){
		 
		 int inicio = 0;		
		 int fin = 0;			
		 int iniciomax = 0;		
		 int suma = 0;			
		 int sumamax = 0;		
		 for(int i=0; i<arreglo.length; i++){	// for para recorrer la secuencia (Orden N)
			 
			 suma = suma+arreglo[i];			//suma elementos del arreglo
			 if(suma>sumamax){					// caso 1
				 
				 sumamax= suma;
				 fin=i;
				 iniciomax= inicio;	
			 }		
			 if(suma==sumamax && fin-iniciomax>i-inicio){	//caso 2 
				 
				 fin=i;
				 iniciomax=inicio;
			 }	
			 else if(suma<=0){					// caso 3 
				 
				 suma= 0;
				 inicio= i+1;
			 }}
		 int[] subarr= new int[2];				// salida
		 subarr[0]= iniciomax;
		 subarr[1]= fin;
		 return subarr;
		 }


}