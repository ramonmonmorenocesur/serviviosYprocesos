import java.util.concurrent.locks.ReentrantLock;
public class Contador {
    private static int contadorPrincipal = 0;
    private int contadortIndividual ;
    private static ReentrantLock cerrojo = new ReentrantLock();

    public void contador(){

        this.contadortIndividual=0;
    }

    public static int getContadorPrincipal() {
        cerrojo.lock();
        int contadorTemporal=contadorPrincipal;
        cerrojo.unlock();
        return contadorTemporal;
    }

    public static void incrementarContadorPrincipal() {
        cerrojo.lock();
         contadorPrincipal++;
         cerrojo.unlock();
    }

    public int getContadortIndividual() {
        return contadortIndividual;
    }

    public void incrementarContadortIndividual() {
        this.contadortIndividual++;
    }
    
}
