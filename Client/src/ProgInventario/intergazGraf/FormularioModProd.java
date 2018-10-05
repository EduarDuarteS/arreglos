package ProgInventario.intergazGraf;

import ProgInventario.entitys.Producto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioModProd {
 

    static JFrame frame;
    private JLabel LblLimite, LblCantidadProductos, numIdentJLab, nombProductoJLab, numSerieJLab, valorJLab, nombProveedorJLab;
    private JTextField numIdentJTF, nombProductoJTF, numSerieJTF, valorJTF, nomProveeJTF;
    private JButton  BtnLimpiar, BtnModificar;
    private int widthFrame, heightFrame;
    private Producto prodMod;

    private JPanel panel;


    public FormularioModProd(Producto prodMod) {
        this.prodMod=prodMod;
        frame = new JFrame("Comercializadora OliVanders");
        //inicializar las variables de ancho y alto de frame
        widthFrame = 470;
        heightFrame = 340;
        frame.setSize(widthFrame, heightFrame);


        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        //Solicitar cantidad de vendedores
        grafRegAsist();


        frame.setVisible(true);
    }

    public void setIconImage(Image img) {
        frame.setIconImage(img);
    }

    private void grafRegAsist() {
        //Se agrega el titulo
        JLabel JLTitulo = new JLabel("Modifique El Producto", JLabel.CENTER);
        JLTitulo.setBounds(0, 10, widthFrame, 20);
        JLTitulo.setForeground(Color.BLUE);
        JLTitulo.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(JLTitulo);

        //Se agregan los labels para solicitar info
        int posX = 20, posY = 60, width = 200, height = 25;
        numIdentJLab = crearLabel("Num de Identifiación:", posX, posY, width, 25);
        nombProductoJLab = crearLabel("Nombre del producto:", posX, posY += 30, width, height);
        numSerieJLab = crearLabel("Num de Serie:", posX, posY += 30, width, height);
        valorJLab = crearLabel("Valor del producto:", posX, posY += 30, width, height);
        nombProveedorJLab = crearLabel("Nombre del proveedor:", posX, posY += 30, width, height);

        //Se agregan los campos para ingresar los datos
        posY = 60;
        numIdentJTF = crearJTextF(posY);
        numIdentJTF.setEditable(false);
        numIdentJTF.setText(""+prodMod.getNumIdentif());
        nombProductoJTF = crearJTextF(posY += 30);
        nombProductoJTF.setText(prodMod.getNomb());
        numSerieJTF = crearJTextF(posY += 30);
        numSerieJTF.setText(""+prodMod.getNumSerie());
        valorJTF = crearJTextF(posY += 30);
        valorJTF.setText(""+prodMod.getValor());
        nomProveeJTF = crearJTextF(posY += 30);
        nomProveeJTF.setText(prodMod.getNombProv());


        //Se agregan los botones
        width = 90;
       
        BtnLimpiar = crearButton("Limpiar", posX += 80 + width, posY+60, width, height); 
        BtnModificar = crearButton("Modificar", posX += 10 + width, posY+60, width, height);

    }

    public void dispose() {
        frame.dispose();
    }

    public JFrame getRootPane() {
        return frame;
    }

    public void setVisible(boolean visi) {
        frame.setVisible(true);
    }

    public JLabel crearLabel(String label, int posX, int posY, int width, int height) {
        JLabel lab = new JLabel(label);
        lab.setBounds(posX, posY, width, height);
        lab.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(lab);
        return lab;
    }

    public JButton crearButton(String label, int x, int y, int largo, int alto) {
        JButton botton = new JButton(label);
        botton.setBounds(x, y, largo, alto);
        panel.add(botton);
        return botton;
    }

    public JTextField crearJTextF(int posY) {
        int posX = 180;
        JTextField jtfIn = new JTextField("");
        jtfIn.setBounds(posX, posY, 250, 25);
        panel.add(jtfIn);
        return jtfIn;
    }

    public static void setFrame(JFrame frame) {
        FormularioProd.frame = frame;
    }

    public static JFrame getFrame() {
        return frame;
    }


    public void setLblLimite(JLabel LblLimite) {
        this.LblLimite = LblLimite;
    }

    public JLabel getLblLimite() {
        return LblLimite;
    }

    public void setLblCantidadProductos(JLabel LblCantidadProductos) {
        this.LblCantidadProductos = LblCantidadProductos;
    }

    public JLabel getLblCantidadProductos() {
        return LblCantidadProductos;
    }

    public void setNumIdentJLab(JLabel numIdentJLab) {
        this.numIdentJLab = numIdentJLab;
    }

    public JLabel getNumIdentJLab() {
        return numIdentJLab;
    }

    public void setNombProductoJLab(JLabel nombProductoJLab) {
        this.nombProductoJLab = nombProductoJLab;
    }

    public JLabel getNombProductoJLab() {
        return nombProductoJLab;
    }

    public void setNumSerieJLab(JLabel numSerieJLab) {
        this.numSerieJLab = numSerieJLab;
    }

    public JLabel getNumSerieJLab() {
        return numSerieJLab;
    }

    public void setValorJLab(JLabel valorJLab) {
        this.valorJLab = valorJLab;
    }

    public JLabel getValorJLab() {
        return valorJLab;
    }

    public void setNombProveedorJLab(JLabel nombProveedorJLab) {
        this.nombProveedorJLab = nombProveedorJLab;
    }

    public JLabel getNombProveedorJLab() {
        return nombProveedorJLab;
    }

    public void setNumIdentJTF(JTextField numIdentJTF) {
        this.numIdentJTF = numIdentJTF;
    }

    public JTextField getNumIdentJTF() {
        return numIdentJTF;
    }

    public void setNombProductoJTF(JTextField nombProductoJTF) {
        this.nombProductoJTF = nombProductoJTF;
    }

    public JTextField getNombProductoJTF() {
        return nombProductoJTF;
    }

    public void setNumSerieJTF(JTextField numSerieJTF) {
        this.numSerieJTF = numSerieJTF;
    }

    public JTextField getNumSerieJTF() {
        return numSerieJTF;
    }

    public void setValorJTF(JTextField valorJTF) {
        this.valorJTF = valorJTF;
    }

    public JTextField getValorJTF() {
        return valorJTF;
    }

    public void setNomProveeJTF(JTextField nomProveeJTF) {
        this.nomProveeJTF = nomProveeJTF;
    }

    public JTextField getNomProveeJTF() {
        return nomProveeJTF;
    }

    public void setBtnLimpiar(JButton BtnLimpiar) {
        this.BtnLimpiar = BtnLimpiar;
    }

    public JButton getBtnLimpiar() {
        return BtnLimpiar;
    }


    public void setBtnModificar(JButton BtnModificar) {
        this.BtnModificar = BtnModificar;
    }

    public JButton getBtnModificar() {
        return BtnModificar;
    }

    public void setWidthFrame(int widthFrame) {
        this.widthFrame = widthFrame;
    }

    public int getWidthFrame() {
        return widthFrame;
    }

    public void setHeightFrame(int heightFrame) {
        this.heightFrame = heightFrame;
    }

    public int getHeightFrame() {
        return heightFrame;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }
}
