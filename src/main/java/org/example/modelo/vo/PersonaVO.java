package org.example.modelo.vo;

public class PersonaVO {

    private String documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String email;

    public PersonaVO() {
    }

    public PersonaVO(String documento, String nombre, String apellido, String telefono, String direccion, String email) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return "Documento: " + documento + "\n" +
                "Nombre: " + getNombreCompleto() + "\n" +
                "Teléfono: " + telefono + "\n" +
                "Dirección: " + direccion + "\n" +
                "Email: " + email + "\n";
    }
}
