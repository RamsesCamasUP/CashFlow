package Model;

public class Subcategoria {
    private int id;
    private String Nombre;
    private int idCategoria;
    private String categoria;

    public Subcategoria(int id, String nombre, int idCategoria) {
        this.id = id;
        Nombre = nombre;
        this.idCategoria = idCategoria;
    }

    public Subcategoria(String nombre, int idCategoria) {
        Nombre = nombre;
        this.idCategoria = idCategoria;
    }

    public Subcategoria(int id, String nombre, int idCategoria, String categoria) {
        this.id = id;
        Nombre = nombre;
        this.idCategoria = idCategoria;
        this.categoria = categoria;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Subcategoria{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", idCategoria=" + idCategoria +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
