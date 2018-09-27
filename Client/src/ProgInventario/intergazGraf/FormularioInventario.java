package ProgInventario.intergazGraf;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioInventario {
    static JFrame frame;
    private JButton BtnAddProductos, BtnVerExistenciasProd;
    private int widthFrame, heightFrame;

    private JPanel panel;

    public FormularioInventario() {
        frame = new JFrame("Comercializadora OliVanders");
        //inicializar las variables de ancho y alto de frame
        widthFrame = 470;
        heightFrame = 340;
        frame.setSize(widthFrame, heightFrame);


        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        //Solicitar cantidad de vendedores
        grafPrincipal();


        frame.setVisible(true);
    }

    public void grafPrincipal() {
        //Se agrega el titulo
        JLabel JLTitulo = new JLabel("Abministrar Productos Comercializadora OliVanders", JLabel.CENTER);
        JLTitulo.setBounds(0, 10, widthFrame, 20);
        JLTitulo.setForeground(Color.BLUE);
        JLTitulo.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(JLTitulo);

        //Preguntar que acción desea realizar
        int width = 200, posX = widthFrame - widthFrame / 2 - width / 2, posY = 130, height = 25;
        JLabel lab = new JLabel("¿Que acción desea realizar?");
        lab.setBounds(posX, posY, width, height);
        lab.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(lab);

        //Agregar botones de opciones
        width = 160;
        BtnVerExistenciasProd = crearButton("Ver Productos", posX -= 60, posY += 50, width, height);
        BtnAddProductos = crearButton("Agregar Productos", posX += width + 10, posY, width, height);

    }

    public void setVisible(boolean visi) {
        frame.setVisible(visi);
    }

    public void dispose() {
        frame.dispose();
    }

    public JFrame getRootPane() {
        return frame;
    }

    public JButton crearButton(String label, int x, int y, int largo, int alto) {
        JButton botton = new JButton(label);
        botton.setBounds(x, y, largo, alto);
        panel.add(botton);
        return botton;
    }

    public void setBtnAddProductos(JButton BtnAddProductos) {
        this.BtnAddProductos = BtnAddProductos;
    }

    public JButton getBtnAddProductos() {
        return BtnAddProductos;
    }

    public void setBtnVerExistenciasProd(JButton BtnVerExistenciasProd) {
        this.BtnVerExistenciasProd = BtnVerExistenciasProd;
    }

    public JButton getBtnVerExistenciasProd() {
        return BtnVerExistenciasProd;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }
}
