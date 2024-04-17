public class piladinamica {
    private Nodo cima;
    private String nombre;

    public piladinamica(String nombre){
        this.cima = null;
        this.nombre = nombre;
    }

    public boolean esVacio(){
        return this.cima == null;
    }

    public void apilar(int dato){
        Nodo nuevo = new Nodo(dato);
        Nodo aux;

        if(esVacio()){
            this.cima = nuevo;
        }else{
            aux = this.cima;
            this.cima = nuevo;
            this.cima.enlazar(aux);
        }
    }

    public void desapilar(){
        Nodo aux;
        if(esVacio()){
            System.out.println("La pila esta vacia");
        }else{
            aux = this.cima;
            this.cima = this.cima.getSiguiente();
            aux.enlazar(null);
        }
    }

    public void mostrar(){
        Nodo aux;
        if(esVacio()){
            System.out.println("La Pila esta vacia");
        }else{
            aux=this.cima;
            while(aux != null){
                System.out.println(aux.getDato());
                aux = aux.getSiguiente();
            }
        }
    }
}
