
package habitaciones;

public class habitacionDeluxe extends habitacion{
    
    public habitacionDeluxe(){
        
    }

    public habitacionDeluxe(int capacidad, int piso, int num, double precio) {
        super(capacidad,piso,num,precio);
        this.setTipoDeHabitacion("Deluxe");
    }
    @Override
    public String toString(){
        String cadena = super.toString();
        cadena += "\nTipo de habitacion: " + this.getTipoDeHabitacion();
        return cadena;
    }
}
