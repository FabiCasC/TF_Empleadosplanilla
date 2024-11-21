/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.logica;

import backend.datos.Empleado;
import java.util.List;

public class Calculos {

    public static double calcularPromedioSueldos(List<Empleado> empleados) {
        double suma = 0;
        for (Empleado e : empleados) {
            suma += e.getSueldoFinal();
        }
        return suma / empleados.size();
    }

    public static Empleado obtenerMayorSueldo(List<Empleado> empleados) {
        Empleado mayor = empleados.get(0);
        for (Empleado e : empleados) {
            if (e.getSueldoFinal() > mayor.getSueldoFinal()) {
                mayor = e;
            }
        }
        return mayor;
    }

    public static Empleado obtenerMenorSueldo(List<Empleado> empleados) {
        Empleado menor = empleados.get(0);
        for (Empleado e : empleados) {
            if (e.getSueldoFinal() < menor.getSueldoFinal()) {
                menor = e;
            }
        }
        return menor;
    }
}

