package edu.unimagdalena.parqueoapp;

public class Locales {

    private int id;
    private String nombre;
    private String direccion;
    private double longitud,latitud;
    private String propetario;
    private int costo;
    private String horario;
    private int cupo;
    private String imagenurl;

    @Override
    public String toString() {
        return "Locales{" + "id=" + id + ", nombre='" + nombre + '\'' + ", direccion='" + direccion + '\'' + ", longitud=" + longitud + ", latitud=" + latitud + ", propetario='" + propetario + '\'' + ", costo=" + costo + ", horario='" + horario + '\'' + ", cupo=" + cupo + ", imagenurl='" + imagenurl + '\'' + '}';
    }

    public Locales(int id, String nombre, String direccion, double longitud, double latitud, String propetario, int costo, String horario, int cupo, String imagenurl) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.propetario = propetario;
        this.costo = costo;
        this.horario = horario;
        this.cupo = cupo;
        this.imagenurl = imagenurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String getPropetario() {
        return propetario;
    }

    public void setPropetario(String propetario) {
        this.propetario = propetario;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getImagenurl() {
        return imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }
}