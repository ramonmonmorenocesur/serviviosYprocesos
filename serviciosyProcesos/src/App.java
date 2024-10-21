public class App {
   public static void main(String[] args) {
    //principal
   Thread hilo1 = new Thread(new Ejercutor("ejecutor1"));
   Thread hilo2 = new Thread(new Ejercutor("ejecutor2"));
   Thread hilo3 = new Thread(new Ejercutor("ejecutor3"));
   hilo1.start();
   hilo2.start();
   hilo3.start();

   try {
    hilo1.join();
       hilo2.join();
       hilo3.join();
} catch (InterruptedException e) {
    // TODO Auto-generated catch block
    System.out.println(e.getMessage());;
}

   System.out.println("Al terminar contador principal vale: "+Contador.getContadorPrincipal());
   }

    }

