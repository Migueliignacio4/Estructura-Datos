public class Listasimple {
    private String nombre;
    private Nodo primero;
    private Nodo ultimo;

    public Listasimple(String nombre){
        this.nombre = nombre;
        this.primero = null;
        this.ultimo = null;

    }

    public boolean esVacio(){
        return this.primero == null;
    }

    public void insertar(int dato){
        
    }
}
