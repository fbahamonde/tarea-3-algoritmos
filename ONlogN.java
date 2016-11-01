import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class ONlogN {
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
                    int [] r= SumaSubMax(vector,largo);                 
                    System.out.println (Integer.toString(r[0])+","+Integer.toString(r[1]));
        	}
        }
             
    public static int[] SumaSubMax( int[] arreglo, int n)
    {	
    	int[] arr = new int[3];
        int init=0;
        int fin= n-1;
        
        if(n==1)
        {
        	arr[0] = init;
            arr[1] = fin;
            arr[2] = arreglo[0];
            return arr; //caso base
           
        }
        int m= n/2;
        int[] izq =SumaSubMax(arreglo,m);
        int izquierda= izq[2];
        int[] arreglo2= Arrays.copyOfRange(arreglo, m, arreglo.length);
        int[] der= SumaSubMax(arreglo2, n-m);
        int derecha= der[2];
        int sumaizquierda=0, sumaderecha = 0, suma= 0;
        int fini=m-1;
    	int initd= m;
    	int initi=0;
    	int find=n;
        
        for ( int i=m-1; i>=0; i--)
        {
            suma+=arreglo[i];
            if(suma>= sumaizquierda)
            {
                initi=i;

            }
            sumaizquierda= Math.max(sumaizquierda, suma);
            
        }
        suma=0;
        for ( int i=m; i<n; i++)
        {
            suma+=arreglo[i];
            if(suma>=sumaderecha)
            {
            	find= i;

            }
            sumaderecha= Math.max(sumaderecha, suma);
            
        }
        if (derecha>=sumaderecha+sumaizquierda){
        	init=initd;
        	fin=find;
        	
        }
        else if (izquierda>=sumaderecha+sumaizquierda){
        	fin=fini;
        	init=initi;
        }
        else{
        	fin=find;
        	init=initi;
        }
        
        int resultado= Math.max(derecha, izquierda);
        int max = Math.max(resultado, sumaderecha+sumaizquierda);
        arr[0] = init;
        arr[1] = fin;
        arr[2] = max;
        return arr;
    }
}