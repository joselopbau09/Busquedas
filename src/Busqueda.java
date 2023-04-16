// Java implementation of recursive Binary Search
public class Busqueda {

	private Procesador procesador;

	private String[] texto;

	public Busqueda(String[] texto){
		this.procesador =  new Procesador();
		this.texto = texto;
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
		String fragmentoTexto = "";
		for (int i = inicio; i < fin; i++) {
			fragmentoTexto += texto[i] + " ";
		}

		return fragmentoTexto;
	}

	public int busquedaBinaria(int arr[], int izquierda, int derecha, int x){
		if (derecha >= izquierda) {
			int mitad = izquierda + (derecha - izquierda) / 2;

			// If the element is present at the
			// mitaddle itself
			if (arr[mitad] == x)
				return mitad;

			// If element is smaller than mitad, then
			// it can only be present in left subarray
			if (arr[mitad] > x)
				return busquedaBinaria(arr, izquierda, mitad - 1, x);

			// Else the element can only be present
			// in right subarray
			return busquedaBinaria(arr, mitad + 1, derecha, x);
		}

		// We reach here when element is not present
		// in array
		return -1;
	}
	/* 
	public static void main(String args[])
	{
		Busqueda ob = new Busqueda();
		int arr[] = { 2, 3, 4, 10, 40 };
		int n = arr.length;
		int x = 10;
		int result = ob.busquedaBinaria(arr, 0, n - 1, x);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index "
							+ result);
	}*/
}

