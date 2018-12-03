package edu.unimagdalena.parqueoapp;

public class ArrayTab2 {
    private int id;
    private String nombre;
    private String propetario;
    private String horario;
    private String image;
    private double longitud;
    private double latitud;
    private int costo;
    private int cupo;

    public ArrayTab2(int id, String nombre, String propetario, String horario, String image, double longitud, double latitud, int costo, int cupo) {
        this.id = id;
        this.nombre = nombre;
        this.propetario = propetario;
        this.horario = horario;
        this.image = image;
        this.longitud = longitud;
        this.latitud = latitud;
        this.costo = costo;
        this.cupo = cupo;
    }

    @Override
    public String toString() {
        return "ArrayTab2{" + "id=" + id + ", nombre='" + nombre + '\'' + ", propetario='" + propetario + '\'' + ", horario='" + horario + '\'' + ", image='" + image + '\'' + ", longitud=" + longitud + ", latitud=" + latitud + ", costo=" + costo + ", cupo=" + cupo + '}';
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

    public String getPropetario() {
        return propetario;
    }

    public void setPropetario(String propetario) {
        this.propetario = propetario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
}
