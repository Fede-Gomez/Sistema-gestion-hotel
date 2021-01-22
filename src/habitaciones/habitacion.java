
package habitaciones;
public class habitacion {

    private int capacidad, piso, numero;
    private double precio;
    private String tipoDeHabitacion,disponible;

    public habitacion(){
        
    } 
    public habitacion(int capacidad, int piso, int numero, double precio){
        this.capacidad = capacidad;
        this.piso = piso;
        this.numero = numero;
        this.precio = precio;
    }
    public int getCapacidad() {
        return this.capacidad;
    }
    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }
    public int getPiso() {
        return this.piso;
    }
    public void setPiso(short piso) {
        this.piso = piso;
    }
    public int getNumero() {
        return this.numero;
    }
    public void setNumero(short numero) {
        this.numero = numero;
    }
    public double getPrecio() {
        return this.precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getTipoDeHabitacion() {
        return this.tipoDeHabitacion;
    }
    public void setTipoDeHabitacion(String tipoDeHabitacion) {
        this.tipoDeHabitacion = tipoDeHabitacion;
    }

    public String getDisponible() {
		return disponible;
	}
	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	@Override
    public String toString(){
        String cadena = "";
        cadena += "\nNumero: " + this.numero;
        cadena += "\npiso: " + this.piso;
        cadena += "\nCapacidad: " + this.capacidad;
        cadena += "\nPrecio: " + this.precio;
        cadena += "\nDisponible: " + this.disponible;
        return cadena;
    } 
    
    
}
