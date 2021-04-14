package Model;

public class Categoria {
    private int id;
    private String Nombre;

    public Categoria(int id, String nombre) {
        this.id = id;
        Nombre = nombre;
    }

    public Categoria(String nombre) {
        Nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }
}
