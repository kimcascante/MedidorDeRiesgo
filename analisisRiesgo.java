package Tareas;
/**
 * Nombre del programa: Medidor de Riesgo
 * Descripcion: Programa que realiza un análisis de riesgo de su cartera de clientes basado en su 
 * la nacionalidad, la actividad económica y si es una figura política o no.
 * Autor: Kimberly
 * Fecha de Creacion: 27/06/2020
 * Modificado por: Kimberly
 * Fecha de Modificacion: 28/06/2020
 */
import java.io.*;
public class analisisRiesgo {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;
    public static void main(String[] args) throws IOException {
        String nombre, nacion, profesion;
        int cedula, politica, edad;
        int riesgoN, riesgoP;
        double notaN, notaP, notaF, porcentaje;
        int altoRiesgo = 0;
        int medianoTotal = 0, altoTotal = 0;
        int suma = 0;
        int cantClientes;
        int mes = 0;
        for (int count = 1; count < 13; count++) {
            out.println("Digite la cantidad de clientes por analizar en el mes " + count);
            cantClientes = Integer.parseInt(in.readLine());
            altoRiesgo = 0;
            for (int countC = 0; countC < cantClientes; countC++) {
                out.println("Digite su nombre");
                nombre = in.readLine();
                out.println("Ingrese su numero de cedula");
                cedula = Integer.parseInt(in.readLine());
                out.println("Ingrese su edad");
                edad = Integer.parseInt(in.readLine());
                out.println("Ingrese su pais de Nacimiento");
                nacion = in.readLine();
                out.println("Digite su profesion");
                profesion = in.readLine();
                out.println("Digite 1 si es una figura politica");
                politica = Integer.parseInt(in.readLine());
                if (politica != 1) {
                    if (nacion.equalsIgnoreCase("Venezuela") || nacion.equalsIgnoreCase("Colombia")
                            || nacion.equalsIgnoreCase("Nicaragua") || nacion.equalsIgnoreCase("Islas Caimán")) {
                        riesgoN = 3;
                    } else if (nacion.equalsIgnoreCase("Argentina") || nacion.equalsIgnoreCase("Brasil")
                            || nacion.equalsIgnoreCase("Rusia") || nacion.equalsIgnoreCase("China")) {
                        riesgoN = 2;
                    } else {
                        riesgoN = 1;
                    }
                } else {
                    riesgoN = 3;
                }
                if (politica != 1) {
                    if (profesion.equalsIgnoreCase("Abogado") || profesion.equalsIgnoreCase("Prestamista")) {
                        riesgoP = 3;
                    } else if (profesion.equalsIgnoreCase("Medico") || profesion.equalsIgnoreCase("Informatico")
                            || profesion.equalsIgnoreCase("Contador")) {
                        riesgoP = 2;
                    } else {
                        riesgoP = 1;
                    }
                } else {
                    riesgoP = 3;
                }
                notaN = riesgoN * 0.3;
                notaP = riesgoP * 0.7;
                notaF = notaN + notaP;
                if (notaF == 1) {
                    out.println(nombre + " | Ced: " + cedula + " | Edad: " + edad + " | es de Bajo Riesgo");
                } else if (notaF > 1 & notaF < 2) {
                    out.println(nombre + " | Ced: " + cedula + " | Edad: " + edad + " | es de Riesgo Medio");
                    medianoTotal = medianoTotal + 1;
                } else if (notaF >= 2 & notaF < 3) {
                    out.println(nombre + " | Ced: " + cedula + " | Edad: " + edad + " | es de Alto Riesgo");
                    altoRiesgo = altoRiesgo + 1;
                    altoTotal = altoTotal + 1;
                }
                if (altoRiesgo > mes) {
                    mes = count;
                } 
                suma = suma + 1;
            }
        }
        porcentaje = (altoTotal*100) / suma;
        out.println(" ");
        out.println("El mes con la mayor cantidad de clientes de alto riesgo es el mes numero " + mes);
        out.println("La cantidad total de clientes de alto riesgo es de " + altoTotal);
        out.println("La cantidad total de clientes de mediano riesgo es de " + medianoTotal);
        out.println("El porcentaje de clientes que son de alto riesgo es de " + porcentaje + " Porciento");
    }
}