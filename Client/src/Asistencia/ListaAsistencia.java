package Asistencia;

import javax.swing.JOptionPane;

public class ListaAsistencia {
    public static void main(String[] args) {
        int cantidadAsistentes = 0;
        cantidadAsistentes =
            Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos asistentes desea registrar?",
                                                         "Registro de asistencia", JOptionPane.QUESTION_MESSAGE));
        if (cantidadAsistentes < 0) {
            cantidadAsistentes = 4;
        }
        Control control = new Control(cantidadAsistentes);
        control.iniciar();
    }
}
