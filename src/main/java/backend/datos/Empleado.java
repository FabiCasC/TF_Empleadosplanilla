/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.datos;

public class Empleado {
    private String dni;
    private String nombre;
    private int edad;
    private double sueldoBasico;
    private double descuentoSeguro;
    private double horasExtras;
    private double descuentoTardanza;
    private double sueldoFinal;

    // Constructor
    public Empleado(String dni, String nombre, int edad, double sueldoBasico) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldoBasico = sueldoBasico;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public double getSueldoFinal() { return sueldoFinal; }

    public void calcularSueldoFinal() {
        sueldoFinal = sueldoBasico + horasExtras - descuentoSeguro - descuentoTardanza;
    }
}

