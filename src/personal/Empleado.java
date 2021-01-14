
package personal;

public class Empleado {
    private String nombre, apellido,cargo,usuario,contrase�a;
    private int DNI, legajo;
    private double sueldo;
    
    public Empleado(){
        
    }

	public Empleado(int legajo, String nombre, String apellido, double sueldo, int dNI, String cargo,String usuario, String contrase�a) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = dNI;
		this.sueldo = sueldo;
		this.cargo = cargo;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}
	public int getLegajo() {
		return legajo;
	}
	
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		this.DNI = dNI;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
    
}
