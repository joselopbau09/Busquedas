
public class Prueba {

    public static void main(String[] args) {

        Lector lectorTexto = new Lector("../LoR.txt");
        String[] palabrasTexto = lectorTexto.getPalabras(); 
        Busqueda ob = new Busqueda(palabrasTexto);
        int n = palabrasTexto.length;
        
        System.out.println("Busqueda del primer error: ");                
        String resultado1 = ob.busquedaBinaria(palabrasTexto, 0, n - 1, 1);
        System.out.println("Busqueda del segundo error: ");                
        String resultado2 = ob.busquedaBinaria(palabrasTexto, 0, n - 1, 2);
        System.out.println("Busqueda del tercer error: ");                
        String resultado3 = ob.busquedaBinaria(palabrasTexto, 0, n - 1, 3);
        System.out.println("Por último las palabras que causan error son: " + resultado1 + "," + resultado2 + "," + resultado3);    
    
    }    
}
