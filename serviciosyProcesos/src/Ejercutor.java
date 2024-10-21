import java.util.concurrent.locks.ReentrantLock;
public class Ejercutor implements Runnable {
    private String nombre ;
    private static ReentrantLock cerrojo = new ReentrantLock();
    public Ejercutor(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void run (){

        //ejercutar un contadorPrincipal que se incremente mil veces
        //muestre por pantalla cada 10 incrementos el valor del contador principal
        Contador miContador = new Contador();

        for (int i = 0; i < 1000; i++) {
            cerrojo.lock();
        Contador.incrementarContadorPrincipal();
        cerrojo.unlock();
        miContador.incrementarContadortIndividual();    
        if(miContador.getContadortIndividual()%10==0){
            cerrojo.lock();
            System.out.println("El ejecutor: "+this.nombre+" Ha incrementado el valor principal hasta: "+Contador.getContadorPrincipal()
            +" y su contador individual es : "+miContador.getContadortIndividual());
            cerrojo.unlock();
        }
            
        }
    }
    
}
