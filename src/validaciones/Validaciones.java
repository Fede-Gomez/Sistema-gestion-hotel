package validaciones;

public class Validaciones {

/*esto verifica que SOLAMENTE tenga numeros (8 numeros en especifico), que NO haya letras y que NO haya espacios*/	
	public static boolean valirdarDNI(String campo) {
		return campo.matches("[^a-zA-Z]\\d{7}+");
	}
	
	
/*esto verifica si el nombre NO tiene numeros, NO tiene espacios y SOLAMENTE tiene letras*/	
	public static boolean validarNombreYApellido(String campo) {
		return campo.matches("\\D\\S[a-zA-ZáéíóúÁÉÍÓÚÑñ]+");
	}
	

/*Esto verifica que hayan letras mayusculas o minusculas con 1 espacio de diferencia y verifica que la altura del domicilio
 * sea entre 1 a 5 digitos*/	
	public static boolean validarDireccion(String campo) {
		return campo.matches("([a-zA-ZáéíóúÁÉÍÓÚÑñ]*\\s)+\\d{0,5}");
	}
	
	
/*esto verifica que SOLAMENTE tenga numeros (11 numeros en especifico), que NO haya letras y que NO haya espacios*/	
	public static boolean validarCelular(String campo) {
		return campo.matches("\\d{10}+[^a-zA-ZáéíóúÁÉÍÓÚÑñ]*");
	}


	/*Esto verifica que comience con un signo letra o numero  despues qe tenga el arroba mas el nombre del dominio */
	public static boolean validarEmail(String campo) {
		return campo.matches("[^@]+@[^@]+\\.[a-zA-ZáéíóúÁÉÍÓÚÑñ]{2,}");
	}
	
	public static boolean validarNumero(String campo) {
		return campo.matches("[^a-zA-Z]*");
	}
}
