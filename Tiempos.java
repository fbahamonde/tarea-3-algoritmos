import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.io.IOException;

public class Tiempos {


public static void main( String[] args) throws IOException
{
	File file = new File("tiempo.txt");
	FileWriter fw = new FileWriter(file.getAbsoluteFile());
	BufferedWriter bw = new BufferedWriter(fw);
	String titulo = ("Tiempo ON2 ONlogN ON"); //titulo
	bw.write(titulo);
	bw.newLine();
	
	for(int i= 1; i<=10;i++) //arreglo largo i*10000
	{
		int[] arreglo= new int[i*10000];
		double[] tiempos= tiempo(arreglo); 
		String content = (i*10000)+" "+ tiempos[0]+" "+tiempos[1] +" "+tiempos[2];
		bw.write(content);
		bw.newLine();
	}
	bw.close();
}
	
public static double[] tiempo(int[] arreglo){
	double[] tiempos= new double[3];  
	double promedio3 = 0;
	long promedio2=0;
	long promedio1=0;
	ON on = new ON();
	ON2 on2 = new ON2();
	ONlogN onlogn = new ONlogN();
	for(int m=0;m<10; m++)// realiza la operación 10 veces para sacar el promedio
	{
		for(int j= 0; j<arreglo.length;j++)// crea valores random para el arreglo
		{
			Random r = new Random();
			arreglo[j]= r.nextInt(2000)-1000; // valores entre -1000 y 1000
		
		}
		
		double start3 = System.currentTimeMillis();
		on.SumaSubMax(arreglo); // ON
		double end3 = System.currentTimeMillis();
		promedio3 +=  end3-start3;
		
		int n=arreglo.length;
		long start2 = System.currentTimeMillis();
		onlogn.SumaSubMax(arreglo,n);//ONlogN
		long end2 = System.currentTimeMillis();
		promedio2 +=  end2-start2;
		
		long start1 = System.currentTimeMillis();
		on2.SumaSubMax(arreglo);//ON2
		long end1 = System.currentTimeMillis();
		promedio1 +=  end1-start1;
		
	}
			double prom3= promedio3/10;
			long prom2= promedio2/10;
			long prom1= promedio1/10;
			tiempos[0]= prom1;
			tiempos[1]= prom2;
			tiempos[2]= prom3;
			return tiempos;
		}

	
}