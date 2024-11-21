/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

import backend.datos.Empleado;
import backend.logica.Calculos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private List<Empleado> empleados;

    public VentanaPrincipal() {
        empleados = new ArrayList<>(); // Aquí se cargarán los empleados.
        inicializarUI();
    }

    private void inicializarUI() {
        setTitle("Gestión de Empleados");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Botón para mostrar empleados
        JButton btnMostrar = new JButton("Mostrar Empleados");
        btnMostrar.addActionListener(e -> mostrarEmpleados());

        // Agregar botones al panel
        panel.add(btnMostrar);

        // Agregar panel a la ventana
        add(panel);
    }

    private void mostrarEmpleados() {
        StringBuilder datos = new StringBuilder("Empleados:\n");
        for (Empleado e : empleados) {
            datos.append(e.getNombre()).append(" - ").append(e.getSueldoFinal()).append("\n");
        }
        JOptionPane.showMessageDialog(this, datos.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}

