package cat.copernic.kyt3c.fitnessreference;

public class Entrenamiento {

    private String Nombre, Descripcion;

    public Entrenamiento(String nombre, String descripcion){
        setNombre(descripcion);
        setDescripcion(descripcion);

    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

}
