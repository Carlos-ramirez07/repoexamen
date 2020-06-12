package examenes;

import java.io.*;
import java.util.Random;

public class Examen {

    public static void main(String[] args) {
    
       Random Spwaner = new Random();
       
       PilaExamen ListaMadera=new PilaExamen();
       PilaExamen ListaResina=new PilaExamen();
       PilaExamen ListaHilo=new PilaExamen();
      
       int mesaHerramineta=0,bastonHerramineta=0,cuerdaHerramineta=0,canaHerramienta=0,barcoHerramineta=0;
       int madera=0,hilo=0,resina=0,baston=0,cuerda=0,cana=0; 
       int maderaAcumulada=0,hiloAcumulada=0,resinaAcumulada=0;
        
   for(int i=1;i<=30;i++){
       System.out.println("- Dia "+ i + "." );
          try{
             int x=Spwaner.nextInt(3);
                if(x==0){
                   System.out.println("***Encontraste una madera: ");
                   ListaMadera.ApilacionP(x);
                   madera++;
                   maderaAcumulada++;
                }else if(x == 1){
                   System.out.println("*Creaste un hilo: ");
                   ListaHilo.ApilacionP(x);
                   hilo++;
                   hiloAcumulada++;
                }else if(x == 2){
                   System.out.println("*Creaste una resina: ");
                   ListaResina.ApilacionP(x);
                   resina++;
                   resinaAcumulada++;
                }if(madera == 4){
                    ListaMadera.SacarP();
                    ListaMadera.SacarP();
                    ListaMadera.SacarP();
                    ListaMadera.SacarP();
                    madera = madera - 4;
                    mesaHerramineta++;
                    System.out.println("*Creaste una mesa.");
                }if(mesaHerramineta == 1 && madera == 2){
                    ListaMadera.SacarP();
                    ListaMadera.SacarP();
                    madera = madera - 2;
                    baston++;
                    mesaHerramineta++;
                    System.out.println("*Creaste un baston.");
                }if(mesaHerramineta == 1){
                    if(hilo>= 4 && resina>= 1){
                        ListaHilo.SacarP();
                        ListaHilo.SacarP();
                        ListaHilo.SacarP();
                        ListaHilo.SacarP();
             ///////////listaR.EliminarAlInicio();/////////////
                        hilo = hilo - 4;
                        resina = resina - 1;
                        cuerda++;
                        cuerdaHerramineta++;
                        System.out.println("*Creaste una cuerda.");
                        }
                }if(mesaHerramineta == 1){
                   if(cuerda >=1 && baston >= 1){
                        cuerda = cuerda - 1;
                        baston = baston - 1;
                        cana++;
                        canaHerramienta++;
                        System.out.println("*Creaste una caña.");
                        }
                }if (mesaHerramineta == 1 && cana >= 1)
                  {
                  cana=cana -1;
                  barcoHerramineta++;
                  System.out.println("*Creaste un barco.");
                  }
              }catch(DesbordamientoPila err){
                  System.out.println(err.getMessage());
              }catch (SubdesPilas er){
                  System.out.println(er.getMessage());
              }
           }
   
         System.out.println();
         System.out.println(" *** Resultados: *** ");
         System.out.println("Madera: "+""+maderaAcumulada);
         System.out.println("Resina: "+""+resinaAcumulada);
         System.out.println(" "+" "+"Hilo: "+""+hiloAcumulada);
         System.out.println();
         
         System.out.println("Herramiento obtenida:");
         System.out.println(" * Caña..."+""+canaHerramienta);
         System.out.println(" * Mesa..."+""+mesaHerramineta);
         System.out.println(" * Baston..."+""+bastonHerramineta);
         System.out.println(" * Cuerda..."+""+cuerdaHerramineta);
         System.out.println(" * Barco..."+""+barcoHerramineta);
            System.out.println("- - -");

    }
}
    

