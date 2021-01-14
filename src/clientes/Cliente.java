package clientes;

public class Cliente {

	private int dni, celular, id;
	private String nombre, apellido, email, direccion;
	public Cliente() {
		
	}
	public Cliente(int dni, int celular, String nombre, String apellido, String email, String direccion) {
		this.dni = dni;
		this.celular = celular;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", celular=" + celular + ", id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", email=" + email + ", direccion=" + direccion + "]";
	}
	
	
	
}
