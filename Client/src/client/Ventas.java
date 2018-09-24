package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ventas implements ActionListener {

    static JFrame frame;
    private JLabel cantVendLB, nombreVend, priTri, segTri, terTri, cuarTri, tituloJL;
    private JTextField catVendT,salPromJTF;
    private JButton nextBtn;
    private int posX, posY, width, height, widthFrame, heightFrame, numVen;
    private JTextField[] nombresJTF;
    private JTextField[][] promVenJTF;
    private Double[] promVentasDouble;

    private JPanel panel;

    public Ventas() {
        super();
        frame = new JFrame("Promedio Ventas");
        //inicializar las variables de ancho y alto de frame
        widthFrame = 460;
        heightFrame = 300;
        frame.setSize(widthFrame, heightFrame);


        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        //Solicitar cantidad de vendedores
        grafCantVend();


        frame.setVisible(true);
    }

    private void grafCantVend() {

        crearLabelTitulo("Por Favor Ingrese La Cantidad De Vendedores", cantVendLB);
        int posX = 110, posY = 100, widthX = 170, height = 25;
        cantVendLB = crearLabel("Cantidad de vendedores: ", posX, posY, widthX, height, cantVendLB);
        catVendT = new JTextField("1");
        catVendT.setBounds(posX + widthX, posY, 20, height);
        panel.add(catVendT);
        crearButton(150, 150, 100, height, nextBtn, "Siguiente");
    }


    public static void main(String[] args) {
        new Ventas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Siguiente")) {
            numVen = Integer.parseInt(catVendT.getText());
            grafIngresarVendedores(numVen);
        }
        if (e.getActionCommand().equals("Calcular")) {
            cargarVentasIngresadas();
            mostrarPromedios();
        }

    }

    private void mostrarPromedios() {
        frame.setSize(widthFrame - 100, heightFrame - 70 + numVen * 30);
        tituloJL.setBounds(0, 10, widthFrame - 100, 20);
        priTri.setText("Promedio");
        priTri.setBounds(250, 40, 100, height);
        segTri.setVisible(false);
        terTri.setVisible(false);
        cuarTri.setVisible(false);
        nextBtn.setVisible(false);

        for (int r = 0; r < numVen; r++) {
            promVenJTF[r][0].setEnabled(false);
            nombresJTF[r].setEnabled(false);
            promVenJTF[r][0].setText(promVentasDouble[r].toString());
            for (int c = 1; c < 4; c++) {
                promVenJTF[r][c].setVisible(false);
            }
        }
        //Promedio de todos los vendedores
        if (numVen > 1) {
            segTri = crearLabelTitulo("promedio de los " + numVen + " Vendedores", segTri);
            tituloJL.setText("Promedios Por Vendedor");
        } else {
            segTri = crearLabelTitulo("Promedio Del Unico Vendedor", segTri);
            tituloJL.setText("Promedio Del Vendedor");
        }
        segTri.setBounds(0, heightFrame - 220 + numVen * 30, widthFrame - 100, 25);        
        salPromJTF=crearJTextF((widthFrame - 100)/2-10, (heightFrame - 220 + numVen * 30)+40, salPromJTF);
        Double promTotal = 0.0;
        for(Double promIndividual: promVentasDouble)
            promTotal +=promIndividual;
        promTotal /= numVen;
        salPromJTF.setText(promTotal.toString());
        salPromJTF.setEnabled(false);
    }

    private void grafIngresarVendedores(int numVendedores) {
        limpiarFrame(numVendedores);
        posX = 10;
        posY = 40;
        width = 30;
        height = 25;

        tituloJL = crearLabelTitulo("Por favor ingrese los datos de los vendedores y sus ventas", tituloJL);


        nombreVend = crearLabel("Nombre del Vendedor", posX, posY, 200, height, nombreVend);
        posX += 40 + 200;
        priTri = crearLabel("1er", posX, posY, width, height, priTri);
        posX += 20 + width;
        segTri = crearLabel("2do", posX, posY, width, height, segTri);
        posX += 20 + width;
        terTri = crearLabel("3er", posX, posY, width, height, terTri);
        posX += 20 + width;
        cuarTri = crearLabel("4to", posX, posY, width, height, cuarTri);


        //Se crean los JTF de entrada de nombres y promedios por vendedor
        nombresJTF = new JTextField[numVendedores];
        promVenJTF = new JTextField[numVendedores][4];
        promVentasDouble = new Double[numVendedores];
        int posYIni = 70, posXIni;
        for (int r = 0; r < numVendedores; r++) {
            posXIni = 250;
            nombresJTF[r] = crearJTextFiNomb(10, posYIni, nombresJTF[r]);
            for (int c = 0; c < 4; c++) {
                promVenJTF[r][c] = crearJTextF(posXIni, posYIni, promVenJTF[r][c]);
                posXIni += 50;
            }
            posYIni += 30;
        }
        nextBtn = crearButton(180, posYIni + 10, 100, 25, nextBtn, "Calcular");
    }

    private void cargarVentasIngresadas() {
        int col = 0;
        for (JTextField[] promVenRow : promVenJTF) {
            promVentasDouble[col] = 0.0;
            for (JTextField promVenCol : promVenRow) {
                promVentasDouble[col] += limpiarVarEnt(promVenCol.getText());
            }
            promVentasDouble[col] = promVentasDouble[col] / 4;
            col += 1;
        }
    }

    private void limpiarFrame(int numVende) {
        frame.setSize(widthFrame, 160 + numVende * 30);
        panel.removeAll();
    }

    public JButton crearButton(int x, int y, int largo, int alto, JButton botton, String label) {
        botton = new JButton(label);
        botton.setBounds(x, y, largo, alto);
        botton.addActionListener(this);
        panel.add(botton);
        return botton;
    }

    public JLabel crearLabel(String label, int posX, int posY, int width, int height, JLabel lab) {
        lab = new JLabel(label);
        lab.setBounds(posX, posY, width, height);
        lab.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(lab);
        return lab;
    }

    public JLabel crearLabelTitulo(String titulo, JLabel JLTitulo) {
        JLTitulo = new JLabel(titulo, JLabel.CENTER);
        JLTitulo.setBounds(0, 10, widthFrame, 20);
        JLTitulo.setForeground(Color.BLUE);
        JLTitulo.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(JLTitulo);
        return JLTitulo;
    }

    public JTextField crearJTextF(int posX, int posY, JTextField jtfIn) {
        jtfIn = new JTextField("0");
        jtfIn.setBounds(posX, posY, width, height);
        panel.add(jtfIn);
        return jtfIn;
    }

    public JTextField crearJTextFiNomb(int posX, int posY, JTextField jtfIn) {

        jtfIn = new JTextField("");
        jtfIn.setBounds(posX, posY, 230, height);
        panel.add(jtfIn);
        return jtfIn;
    }

    public Double limpiarVarEnt(String varLimp) {
        //se eliminan todos los caracteres q no sean numericos
        varLimp = varLimp.replaceAll("[^\\digit]", "");
        return Double.parseDouble(varLimp);
    }
}
