package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;


public class Cramer implements ActionListener {
    static int[] arreglo;
    static JTextField resultadoText;
    static JFrame frame;
    private JPanel panel;
    private JTextField xUnoText, posText;
    private JLabel[][] matrizLabel;
    private JTextField [][] matrizJTextField;
    private JButton agregarBtn, borrarBtn, limpiarBtn, consulArregloBtn, calPromBtn;

    public Cramer() {
        super();
        frame = new JFrame("Matrices Cramer");
        frame.setSize(320, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Cramer cramer = new Cramer();

        Scanner guardar = new Scanner(System.in);
        int x1, x2, x3, y1, y2, y3, z1, z2, z3, r1, r2, r3, d, dx, dy, dz, x, y, z; //declaracion en variables
        System.out.print("\n Ecuaciones lineales de 3 X 3");
        System.out.print("\n Resueltas por el metodo de cramer");
        System.out.print("\n X1:");
        x1 = guardar.nextInt();
        System.out.print("\n Y1:");
        y1 = guardar.nextInt();
        System.out.print("\n Z1:");
        z1 = guardar.nextInt();
        System.out.print("\n R1:");
        r1 = guardar.nextInt();
        System.out.print("\n X2:");
        x2 = guardar.nextInt();
        System.out.print("\n Y2:");
        y2 = guardar.nextInt();
        System.out.print("\n Z2:");
        z2 = guardar.nextInt();
        System.out.print("\n R2:");
        r2 = guardar.nextInt();
        System.out.print("\n X3:");
        x3 = guardar.nextInt();
        System.out.print("\n Y3:");
        y3 = guardar.nextInt();
        System.out.print("\n Z3:");
        z3 = guardar.nextInt();
        System.out.print("\n R3:");
        r3 = guardar.nextInt();
        d = (x1 * y2 * z3) + (y1 * z2 * x3) + (z1 * x2 * y3) - (z1 * y2 * x3) - (x1 * z2 * y3) - (y1 * x2 * z3);
        x = (r1 * y2 * z3) + (y1 * z2 * r3) + (z1 * r2 * y3) - (z1 * y2 * r3) - (r1 * z2 * y3) - (y1 * r2 * z3);
        y = (x1 * r2 * z3) + (r1 * z2 * x3) + (z1 * x2 * r3) - (z1 * r2 * x3) - (x1 * z2 * r3) - (r1 * x2 * z3);
        z = (x1 * y2 * r3) + (y1 * r2 * x3) + (r1 * x2 * y3) - (r1 * y2 * x3) - (x1 * r2 * y3) - (y1 * x2 * r3);
        dx = x / d;
        dy = y / d;
        dz = z / d;
        System.out.print("\n El resultado por el metod de cramer es:");
        System.out.print("\n " + x1 + " X " + y1 + " Y " + z1 + " Z = " + r1);
        System.out.print("\n " + x2 + " X " + y2 + " Y " + z2 + " Z = " + r2);
        System.out.print("\n " + x3 + " X " + y3 + " Y " + z3 + " Z = " + r3);
        System.out.print("\n El valor de la determinante es:" + d);
        System.out.print("\n El valor de la determinante de X:" + dx);
        System.out.print("\n El valor de la determinante de Y:" + dy);
        System.out.print("\n El valor de la determinante de Z:" + dz);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Implement this method
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        crearLabelMatriz();
        crearJTextFieldMatriz();

        /*
        resultadoText = new JTextField(2);
        resultadoText.setBounds(110, 25, 640, 25);
        resultadoText.setEditable(false);
        panel.add(resultadoText);

        /Se crean los botones y se ponen a la escucha
        crearButton(10, 80, 140, 25, agregarBtn, "Agregar Dato");
        crearButton(160, 80, 140, 25, borrarBtn, "Borrar Dato");
        crearButton(310, 80, 140, 25, limpiarBtn, "Limpiar Arreglo");
        crearButton(460, 80, 140, 25, consulArregloBtn, "Consultar Arreglo");
        crearButton(610, 80, 140, 25, calPromBtn, "Calcular Promedio");
*/
    }
    
    public void crearJTextFieldMatriz() {

        matrizJTextField = new JTextField[3][4];
        int row = 1;
        int posY = 30;

        for (JTextField[] label : matrizJTextField) {
            int itera = 1;
            int posX = 70;
            for (JTextField lab : label) {
                switch (itera) {
                case 1:
                    crearLabel("x", row, posX, posY, lab);
                    break;
                case 2:
                    crearLabel("y", row, posX, posY, lab);
                    break;
                case 3:
                    crearLabel("z", row, posX, posY, lab);
                    break;
                case 4:
                    crearLabel("R", row, posX, posY, lab);
                    break;
                }
                itera += 1;
                posX += 60;

            }
            row += 1;
            posY += 30;
        }
    }

    public void crearLabelMatriz() {
        //x1,y1,z1,R1
        /*
        JLabel xUnoLabel, yUnoLabel, zUnoLabel, rUnoLabel;
        JLabel xDosLabel, yDosLabel, zDosLabel, rDosLabel;
        JLabel xTresLabel, yTresLabel, zTresLabel, rTresLabel;
        */

        matrizLabel = new JLabel[3][4];
        int row = 1;
        int posY = 30;

        for (JLabel[] label : matrizLabel) {
            int itera = 1;
            int posX = 50;
            for (JLabel lab : label) {
                switch (itera) {
                case 1:
                    crearLabel("x", row, posX, posY, lab);
                    break;
                case 2:
                    crearLabel("y", row, posX, posY, lab);
                    break;
                case 3:
                    crearLabel("z", row, posX, posY, lab);
                    break;
                case 4:
                    crearLabel("R", row, posX, posY, lab);
                    break;
                }
                itera += 1;
                posX += 60;

            }
            row += 1;
            posY += 30;
        }
    }

    public void crearLabel(String label, int row, int posX, int posY, JLabel lab) {
        lab = new JLabel(label + row);
        lab.setBounds(posX, posY, 30, 25);
        panel.add(lab);
    }
    public void crearLabel(String label, int row, int posX, int posY, JTextField lab) {
        lab = new JTextField("0");
        lab.setBounds(posX, posY, 30, 25);
        panel.add(lab);
    }

    public void crearButton(int x, int y, int largo, int alto, JButton botton, String label) {
        botton = new JButton(label);
        botton.setBounds(x, y, largo, alto);
        botton.addActionListener(this);
        panel.add(botton);
    }
}
