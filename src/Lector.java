
import java.io.*;
import java.util.*;

public class Lector {
    
    private String texto;
    private String[] arregloPalabras;
    
    public Lector(String nombreArchivo) {
        this.arregloPalabras = lectura(nombreArchivo);        
    }

    public String[] lectura(String nombreArchivo){ 
        String cadena = "";
        String palabra = "";
        List<String> palabras = new ArrayList<String>();
        try {
            FileReader archivo = new FileReader(nombreArchivo);

            int i;

            while ((i = archivo.read()) != -1 ) {
                if ((i == 32) || (i == 46) ||(i == 44)) {
                    palabras.add(palabra);
                    palabra = "";
                }
                palabra += (char)i;
                
                cadena += (char)i; 
            }    
        } catch (Exception e) {
            System.out.println(e);
        }

        List<String> punto = new ArrayList<String>();
        punto.add(".");
        punto.add(",");
        palabras.removeAll(punto);

        String [] palabrasArr = new String[palabras.size()];
        palabrasArr = palabras.toArray(palabrasArr);

        this.setTexto(cadena);
        return palabrasArr;
    }

    public String[] getPalabras() {
        return this.arregloPalabras;
    }

    public String getTexto() {
        return this.texto;
    } 
    
    public void setTexto(String texto){
        this.texto = texto;
    }
}