
package habitaciones;

public class habitacionSuper extends habitacion {

    public habitacionSuper(int capacidad, int piso, int num, double precio) {
        super(capacidad,piso,num,precio);
        this.setTipoDeHabitacion("Super");
    }
    @Override
     public String toString(){
        String cadena = super.toString();
        cadena += "\nTipo de habitacion: " + this.getTipoDeHabitacion();
        return cadena;
    }   
}
