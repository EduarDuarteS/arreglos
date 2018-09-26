package ProgInventario;

import java.util.Date;

public class Persona {
    // VARIABLES PARA USAR EN LA CLASE
    private String nombres;
    private String apellidos;
    private String identificacion;
    private Date fechaNacimiento;
    private String direccion;
    private String cursoFromacion;
    private int numeroVisitante;
    // CONSTRUCTOR POR DEFECTO DE LA CLASE
    public Persona() {
    }
    // CONSTRUCTOR PERSONALIZADO DE LA CLASE
    public Persona(String nombres, String apellidos, String identificacion, Date fechaNacimiento, String direccion,
                   String cursoFromacion, int numeroVisitante) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.cursoFromacion = cursoFromacion;
        this.numeroVisitante = numeroVisitante;
    }
    // METODOS PARA EL COMPORTAMIENTO Y ACCESO A LOS DATOS DEL OBJETO
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCursoFromacion() {
        return cursoFromacion;
    }

    public void setCursoFromacion(String cursoFromacion) {
        this.cursoFromacion = cursoFromacion;
    }

    public int getNumeroVisitante() {
        return numeroVisitante;
    }

    public void setNumeroVisitante(int numeroVisitante) {
        this.numeroVisitante = numeroVisitante;
    }
}
