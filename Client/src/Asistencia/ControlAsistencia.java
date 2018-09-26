package Asistencia;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Asistencia.Formulario;

public class ControlAsistencia implements ActionListener {
    private Formulario formulario;
    private Persona persona;
    private int contador;
    private int cantidad;
    private String listaPersonas;
    private Persona[] arregloPersonas;

    public ControlAsistencia(int cantidad) {
        this.contador = 0;
        this.cantidad = cantidad;
        this.arregloPersonas = new Persona[this.cantidad];
        this.formulario = new Formulario();
        this.formulario.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
        this.formulario
            .getBtnGuardar()
            .addActionListener(this);
        this.formulario
            .getBtnLimpiar()
            .addActionListener(this);
        this.formulario
            .getBtnVerListaPersonas()
            .addActionListener(this);
        this.formulario
            .getLblLimite()
            .setText("de " + cantidad);
    }

    public void iniciar() {
        if (formulario == null) {
            formulario = new Formulario();
            formulario.setVisible(true);
        } else {
            formulario.setVisible(true);
        }
    }

    public Persona obtenerPersona() {
        contador++;
        formulario.getLblCantidadVisitantes().setText(String.valueOf(contador));
        persona = new Persona();
        persona.setNombres(formulario.getNombreJTF().getText());
        persona.setApellidos(formulario.getApellidosJTF().getText());

        persona.setIdentificacion(formulario.getTxtIdJLab().getText());
        //persona.setFechaNacimiento(new Date(formulario.getFechaNacimientoJTF().getText()));
        persona.setDireccion(formulario.getDireccionJTF().getText());
        persona.setCursoFromacion(formulario.getProgramaFormacionJTF().getText());
        persona.setNumeroVisitante(contador);
        return persona;
    }

    public void limpiar() {
        formulario.getNombreJTF().setText("");
        formulario.getApellidosJTF().setText("");
        formulario.getTxtIdJTF().setText("");
        formulario.getFechaNacimientoJTF().setText("");
        formulario.getDireccionJTF().setText("");
        formulario.getProgramaFormacionJTF().setText("");
    }

    public void listarPersonas() {
        listaPersonas = "";
        for (Persona p : arregloPersonas) {
            if (p != null) {
                listaPersonas +=
                    p.getNombres() + " " + p.getApellidos() + " con identificación: " + p.getIdentificacion() +
                    ", es el visitante " + p.getNumeroVisitante() + "\n";
            }
        }

        if (listaPersonas == "") {
            JOptionPane.showMessageDialog(formulario.getRootPane(), "No hay asistentes en la lista para mostrar.",
                                          "Listado de personas", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(formulario.getRootPane(), listaPersonas, "Listado de personas",
                                          JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void verificar() {
        if (contador == cantidad) {
            JOptionPane.showMessageDialog(formulario.getRootPane(), "Se han registrado todos los asistentes",
                                          "Ha finalizado", JOptionPane.WARNING_MESSAGE);
            listarPersonas();
            formulario.dispose();
            formulario = null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formulario.getBtnGuardar()) {
            arregloPersonas[contador] = obtenerPersona();
            limpiar();
            verificar();
        } else if (e.getSource() == formulario.getBtnLimpiar()) {
            limpiar();
        } else if (e.getSource() == formulario.getBtnVerListaPersonas()) {
            listarPersonas();

        }
    }
}