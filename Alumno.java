package PracticaClase;
import java.io.Serializable;
import java.time.LocalDate;

public class Alumno implements Serializable{
    //atributos 
    private int exp;
    private String nombre;
    private double nota;
    private LocalDate ingreso;
    //constructores 

    public Alumno() {
    }

    public Alumno(int exp, String nombre, double nota, LocalDate ingreso) {
        this.exp = exp;
        this.nombre = nombre;
        this.nota = nota;
        this.ingreso = ingreso;
    }
    
    //getters y setters 

    public int getExp() {
        return exp;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public LocalDate getIngreso() {
        return ingreso;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(double nota) {
        this.nota = nota;
        
        
    }

    public void setIngreso(LocalDate ingreso) {
        this.ingreso = ingreso;
    }
    
    //toString 

    @Override
    public String toString() {
        return "Alumno{" + "exp=" + exp + ", nombre=" + nombre + ", nota=" + nota + ", ingreso=" + ingreso + '}';
    }
    
}
