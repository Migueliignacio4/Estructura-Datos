public class main {
    public static void main(String[] args) {

        piladinamica pd = new piladinamica("Pila Dinamica");

        pd.mostrar();
        pd.apilar(6);
        pd.apilar(7);

        pd.mostrar();

        System.out.println("////aqui se desapila<<<<<<<<<"); 
        pd.desapilar(); //Elimina el dato de la cima
        pd.mostrar();
    }
    
}
