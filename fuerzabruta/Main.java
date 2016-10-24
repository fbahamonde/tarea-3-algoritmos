import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in); //
                while (in.hasNextLine())
        {
            String line = in.nextLine(); 
            String[] parametros = line.split(" "); //
            int largo =parametros.length;
            int[] subse=new int[largo];
            int maxSum = Integer.parseInt(parametros[0]);
            	
        
            String maxsec="0";
            for(int i=0; i<largo; i++)
            {  
            	String sec="";
                int thisSum = 0;
              for(int j=i; j<largo; j++)
             { 
                 thisSum += Integer.parseInt(parametros[j]);
                 sec=sec+ j + "";
               if (thisSum > maxSum){
                 maxSum = thisSum;
               	 maxsec=sec.substring(0,1) +"," + sec.substring(sec.length()-1,sec.length());
               	 } maxsec=maxsec.substring(0,1)+","+ maxsec.substring(maxsec.length()-1, maxsec.length());}
            }   showint(maxSum);
            System.out.print(maxsec);
       System.out.println();

        }
    } 

    public static void showint(int A){
                 System.out.print(A + " ");
            System.out.println();
       } 
}