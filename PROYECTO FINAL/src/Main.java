import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class Empleado {
    // Atributos
    private final String dni;
    private final String nombreCompleto;
    private final int edad;
    private final double sueldoBasico;
    private final String seguro;
    private final int horasExtras;
    private final int tardanzas;
    private double sueldoFinal;
    // Constructor
    public Empleado(String dni, String nombreCompleto, int edad, double sueldoBasico, String seguro, int horasExtras, int tardanzas) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.sueldoBasico = sueldoBasico;
        this.seguro = seguro;
        this.horasExtras = horasExtras;
        this.tardanzas = tardanzas;
        calcularSueldoFinal();
    }
    public String getDni() { return dni; }
    public String getNombreCompleto() { return nombreCompleto; }
    public int getEdad() { return edad; }
    public double getSueldoBasico() { return sueldoBasico; }
    public String getSeguro() { return seguro; }
    public int getHorasExtras() { return horasExtras; }
    public int getTardanzas() { return tardanzas; }
    public double getSueldoFinal() { return sueldoFinal; }
    public void calcularSueldoFinal() {
        double descuentoSeguro = seguro.equals("AFP") ? 0.10 : 0.08;
        double pagoHorasExtras = horasExtras * 20.0;
        double descuentoTardanzas = tardanzas * 0.5;

        sueldoFinal = sueldoBasico - (sueldoBasico * descuentoSeguro) + pagoHorasExtras - descuentoTardanzas;
    }
    public String toString() {
        return "Empleado{" +
                "DNI='" + dni + '\'' +
                ", Nombre Completo='" + nombreCompleto + '\'' +
                ", Edad=" + edad +
                ", Sueldo Básico=" + String.format("%.2f", sueldoBasico) +
                ", Seguro='" + seguro + '\'' +
                ", Horas Extras=" + horasExtras +
                ", Tardanzas=" + tardanzas + " minutos" +
                ", Sueldo Final=" + String.format("%.2f", sueldoFinal) +
                '}';
    }
}
class Planilla {
    private final ArrayList<Empleado> empleados;

    public Planilla() {
        this.empleados = new ArrayList<>();
    }
    public void inicializarDatos() {
        Random random = new Random();
        List<String> nombresDisponibles = new ArrayList<>(List.of(
                "Carlos", "María", "Juan", "Ana", "Luis", "Sofía", "Pedro", "Lucía",
                "Miguel", "Clara", "Javier", "Valeria", "Andrés", "Camila", "Ricardo",
                "Daniela", "Felipe", "Mariana", "Diego", "Alejandra"
        ));
        List<String> apellidosDisponibles = new ArrayList<>(List.of(
                "García", "Martínez", "Rodríguez", "López", "González", "Pérez",
                "Fernández", "Chávez", "Vargas", "Rojas", "Torres", "Castro",
                "Flores", "Reyes", "Herrera", "Ramos", "Romero", "Cruz",
                "Morales", "Ortega"
        ));
        while (!nombresDisponibles.isEmpty() && !apellidosDisponibles.isEmpty() && empleados.size() < 20) {
            String nombre = nombresDisponibles.remove(random.nextInt(nombresDisponibles.size()));
            String apellido = apellidosDisponibles.remove(random.nextInt(apellidosDisponibles.size()));
            String nombreCompleto = nombre + " " + apellido;
            String dni = String.format("%08d", random.nextInt(100000000));
            int edad = random.nextInt(43) + 18; // Edad entre 18 y 60
            double sueldoBasico = 1000 + (2000 * random.nextDouble()); // Sueldo básico entre 1000 y 3000
            String seguro = random.nextBoolean() ? "AFP" : "SNP";
            int horasExtras = random.nextInt(11); // Horas extras entre 0 y 10
            int tardanzas = random.nextInt(121); // Tardanzas entre 0 y 120 minutos
            empleados.add(new Empleado(dni, nombreCompleto, edad, sueldoBasico, seguro, horasExtras, tardanzas));
        }
    }
    public void calcularSueldos() {
        for (Empleado empleado : empleados) {
            empleado.calcularSueldoFinal();
        }
    }
    public Empleado obtenerEmpleadoConMenorSueldo() {
        Empleado menor = empleados.get(0);
        for (Empleado empleado : empleados) {
            if (empleado.getSueldoFinal() < menor.getSueldoFinal()) {
                menor = empleado;
            }
        }
        return menor;
    }
    public Empleado obtenerEmpleadoConMayorSueldo() {
        Empleado mayor = empleados.get(0);
        for (Empleado empleado : empleados) {
            if (empleado.getSueldoFinal() > mayor.getSueldoFinal()) {
                mayor = empleado;
            }
        }
        return mayor;
    }
    public double calcularPromedioSueldos() {
        double suma = 0.0;
        for (Empleado empleado : empleados) {
            suma += empleado.getSueldoFinal();
        }
        return suma / empleados.size();
    }
    public void mostrarListaCompleta() {
        // Imprimir encabezados
        System.out.printf("%-10s %-25s %-5s %-12s %-8s %-12s %-10s %-12s\n",
                "DNI", "Nombre Completo", "Edad", "Sueldo Básico", "Seguro",
                "Horas Extras", "Tardanzas", "Sueldo Final");
        System.out.println("=".repeat(100)); // Separador

        // Imprimir cada empleado
        for (Empleado empleado : empleados) {
            System.out.printf("%-10s %-25s %-5d %-12.2f %-8s %-12d %-10d %-12.2f\n",
                    empleado.getDni(),
                    empleado.getNombreCompleto(),
                    empleado.getEdad(),
                    empleado.getSueldoBasico(),
                    empleado.getSeguro(),
                    empleado.getHorasExtras(),
                    empleado.getTardanzas(),
                    empleado.getSueldoFinal());
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Planilla planilla = new Planilla();

        // Inicializar y calcular datos
        planilla.inicializarDatos();

        // Mostrar resultados
        System.out.println("Empleado con menor sueldo:");
        System.out.println(planilla.obtenerEmpleadoConMenorSueldo());

        System.out.println("\nEmpleado con mayor sueldo:");
        System.out.println(planilla.obtenerEmpleadoConMayorSueldo());

        System.out.println("\nPromedio de sueldos finales:");
        System.out.printf("%.2f\n", planilla.calcularPromedioSueldos());

        System.out.println("\nLista completa de empleados:");
        planilla.mostrarListaCompleta();
    }
}