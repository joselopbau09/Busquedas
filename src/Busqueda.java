// Java implementation of recursive Binary Search
public class Busqueda {

	private Procesador procesador;

	private String[] palabras;

	public Busqueda(String[] palabras){
		this.procesador =  new Procesador();
		this.palabras = palabras;
	}

	public boolean selecionaCaso(int opcion, String texto){
		boolean seEncunetra;	
		switch (opcion) {
			case 1:
				seEncunetra = this.procesador.procesado1(texto);	
				break;
			case 2:
				seEncunetra = this.procesador.procesado2(texto);
				break;
			default:
				seEncunetra = this.procesador.procesado3(texto);
				break;
		}
		return seEncunetra;
	}

	public String generaCadena(int inicio, int fin) {
		String texto = "";
		for (int i = inicio; i < fin; i++) {
			texto += palabras[i] + " ";
		}

		return texto;
	}

	public int busquedaBinaria(String palabras[], int izquierda, int derecha, int caso){
		String cadena;
		if (derecha >= izquierda) {
			int mitad = izquierda + (derecha - izquierda) / 2;

			if (selecionaCaso(caso, palabras[mitad]))
				return mitad;

			cadena = generaCadena(izquierda, mitad - 1);
			if (selecionaCaso(caso, cadena))
				return busquedaBinaria(palabras, izquierda, mitad - 1, caso);

			return busquedaBinaria(palabras, mitad + 1, derecha, caso);
		}

		return -1;
	}
	
	public static void main(String args[]) {
		Lector lectorTexto = new Lector("../LoR.txt");
		String[] arr = lectorTexto.getPalabras(); 
		Busqueda ob = new Busqueda(arr);
		int n = arr.length;
       		
		int result = ob.busquedaBinaria(arr, 0, n - 1, 3);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index "
							+ result);
	}
}

