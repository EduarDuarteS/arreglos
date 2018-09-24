package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class ArregloUnidimensional implements ActionListener {

    static int[] arreglo;
    static JTextField resultadoText;
    static JFrame frame;
    private JPanel panel;
    private JTextField numText, posText;
    private JButton agregarBtn, borrarBtn, limpiarBtn, consulArregloBtn, calPromBtn;
    private static final float RIGHT_ALIGNMENT = 1.0f;

    public ArregloUnidimensional() {
        super();
        frame = new JFrame("ArregloUnidimensional");
        frame.setSize(780, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }


    public static void main(String[] args) {

        //Crear array
        arreglo = new int[10];

        //Cargar interfaz Grafica
        new ArregloUnidimensional();

        //Manejo logica
        cargarArreglo();


    }

    public void myInterfazGrafica() {

    }

    private static void cargarArreglo() {
        arreglo[4] = 3;
        int pos = 0;
        String sal = "     Salida: ";
        for (int arr : arreglo) {
            if (pos < 9)
                sal += "pos[" + pos++ + "]=" + arr + ", ";
            else
                sal += "pos[" + pos++ + "]=" + arr;
        }
        resultadoText.setText(sal);
    }


    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
        case "Agregar Dato":
            agregarAlArreglo(numText.getText(), posText.getText());
            cargarArreglo();
            break;
        case "Borrar Dato":
            borrarDato(posText.getText());
            cargarArreglo();
            break;
        case "Limpiar Arreglo":
            for (int i = 0; i < 10; i++)
                arreglo[i] = 0;
            cargarArreglo();
            break;
        case "Consultar Arreglo":
            cargarArreglo();
            break;
        case "Calcular Promedio":
            resultadoText.setText("El promedio del arreglo es: " + promedio(arreglo));
            break;

        default:
            System.out.println("Boton desconocido");
            break;
        }
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel numLabel = new JLabel("Número");
        numLabel.setBounds(10, 10, 80, 25);
        panel.add(numLabel);

        numText = new JTextField(2);
        numText.setBounds(70, 10, 30, 25);
        panel.add(numText);

        JLabel posLabel = new JLabel("Posición");
        posLabel.setBounds(10, 40, 80, 25);
        panel.add(posLabel);

        posText = new JTextField(2);
        posText.setBounds(70, 40, 30, 25);
        panel.add(posText);

        resultadoText = new JTextField(2);
        resultadoText.setBounds(110, 25, 640, 25);
        resultadoText.setEditable(false);
        panel.add(resultadoText);

        //Se crean los botones y se ponen a la escucha
        crearButton(10, 80, 140, 25, agregarBtn, "Agregar Dato");
        crearButton(160, 80, 140, 25, borrarBtn, "Borrar Dato");
        crearButton(310, 80, 140, 25, limpiarBtn, "Limpiar Arreglo");
        crearButton(460, 80, 140, 25, consulArregloBtn, "Consultar Arreglo");
        crearButton(610, 80, 140, 25, calPromBtn, "Calcular Promedio");

    }

    public void crearButton(int x, int y, int largo, int alto, JButton botton, String label) {
        botton = new JButton(label);
        botton.setBounds(x, y, largo, alto);
        botton.addActionListener(this);
        panel.add(botton);
    }

    public Double promedio(int[] array) {
        Double sal = 0.0;
        for (int arr : array) {
            sal += arr;
        }
        return sal / 10;
    }

    public void agregarAlArreglo(String agregar, String posicion) {
        int[] sal = limpiarVarEnt(agregar, posicion);
        int pos = sal[0];
        int agrega = sal[1];
        //Se valida la posicición q no sea mayor a 10 para evitar el desbordamiento
        if (pos < 11)
            arreglo[pos] = agrega;

    }

    public void borrarDato(String posicion) {
        int[] sal = limpiarVarEnt(posicion);
        int pos = sal[0];

        //Se carga con cero la posición indicada
        arreglo[pos] = 0;

    }

    public int[] limpiarVarEnt(String posicion) {
        int[] sal = limpiarVarEnt("0", posicion);
        return sal;
    }

    public int[] limpiarVarEnt(String agregar, String posicion) {
        int[] sal = new int[2];
        //se eliminan todos los caracteres q no sean numericos
        agregar = agregar.replaceAll("[^\\digit]", "");
        posicion = posicion.replaceAll("[^\\digit]", "");

        //se valida el largo de la posición q no puede superar el valor "10"
        if (posicion.length() > 2)
            posicion = posicion.substring(0, 2);

        //se valida q el numero a añadir al arreglo no sea demasiado largo para un int
        if (agregar.length() > 9)
            agregar = agregar.substring(0, 9);

        //Se realiza la conversion a tipo int
        int agrega = Integer.parseInt(agregar);
        int pos = Integer.parseInt(posicion);

        //Se cargan los valores en vector de salida
        sal[0] = pos;
        sal[1] = agrega;

        return sal;
    }

}
