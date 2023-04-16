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

	public String busquedaBinaria(String palabras[], int izquierda, int derecha, int caso){
		String cadenaIzq, cadenaDer;
		if (derecha >= izquierda) {
			int mitad = izquierda + (derecha - izquierda) / 2;

			if (selecionaCaso(caso, palabras[mitad])) {
				System.out.println("\tEl error es:" + palabras[mitad] + "\n");
				return  palabras[mitad];
			}
			cadenaIzq = generaCadena(izquierda, mitad - 1);
			if (selecionaCaso(caso, cadenaIzq)) {
				System.out.println("Se realiza la busqueda sobre la siguiente subsecuencia: " + cadenaIzq);
				return busquedaBinaria(palabras, izquierda, mitad - 1, caso);
			} else {	
				cadenaDer = generaCadena(mitad + 1, derecha + 1);
				System.out.println("Se realiza la busqueda sobre la siguiente subsecuencia: " + cadenaDer);
				return busquedaBinaria(palabras, mitad + 1, derecha, caso);
			}	
		}
		return "";
	}	
}