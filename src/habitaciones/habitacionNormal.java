
package habitaciones;

public class habitacionNormal extends habitacion {
    
    public habitacionNormal(){
        
    }
    public habitacionNormal(int capacidad, int piso, int num, double precio){
        super(capacidad, piso,num, precio);
        this.setTipoDeHabitacion("Normal");
    }

    @Override
    public String toString(){
        String cadena = super.toString();
        cadena += "\nTipo de habitacion: " + this.getTipoDeHabitacion();
        return cadena;
    }

    
}
