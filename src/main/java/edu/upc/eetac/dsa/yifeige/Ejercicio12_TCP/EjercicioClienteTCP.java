package edu.upc.eetac.dsa.yifeige.Ejercicio12_TCP;
import java.io.*;
import java.net.*;
public class EjercicioClienteTCP 
{
    public static void main( String[] args )
    {
        String Hostname="127.0.0.1";
        int PortNumber=7001;
       try
       {
    	   Socket TimeSocket =new Socket(Hostname,PortNumber);
    	   System.out.print("Bienvenido has conectado al servidor de hora\n");
    	   
    	   PrintWriter escritor=new PrintWriter(TimeSocket.getOutputStream(),true);
    	   BufferedReader lector=new BufferedReader(new InputStreamReader(TimeSocket.getInputStream()));
    	   
    	   BufferedReader lector_usuario=new BufferedReader(new InputStreamReader(System.in));
    	   System.out.println("Por favor tecla 0 para obtener la hora actual");
    	   int opcion=Integer.parseInt(lector_usuario.readLine());
    	   
    	   if(opcion==0)
    	   {
    		   escritor.println(opcion);
    		   String line = lector.readLine();
    		   System.out.print("La hora actual es:" + line);
    		   System.out.print("Gracias por usar el servicio\n");
    		   System.exit(1);
    	   }
    	   else
    	   {
    		   System.out.print("error! cerramos la connexion\n");
    		   System.exit(1);
    	   }
       }
       catch(UnknownHostException e)
       {
    	   System.err.println("No se conoce el nombre del host" + "hostName");
           System.exit(1);
       }
       catch (IOException e) 
       {
           System.err.println("No se puede obtener ningun I/O por la connexion" +"hostName");
           System.exit(1);
       } 
       
    }
}
