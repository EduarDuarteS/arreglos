package ProgInventario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioProd {

    static JFrame frame;
    private JLabel LblLimite, LblCantidadVisitantes, nombreJLab, apellidosJLab, txtIdJLab, fechaNacimientoJLab, direccionJLab, programaFormacionJLab;
    private JTextField nombreJTF, apellidosJTF, txtIdJTF, fechaNacimientoJTF, direccionJTF, programaFormacionJTF;
    private JButton BtnGuardar, BtnLimpiar, BtnVerListaPersonas;
    private int widthFrame, heightFrame;

    private JPanel panel;


    public FormularioProd() {
        frame = new JFrame("Comercializadora OliVanders");
        //inicializar las variables de ancho y alto de frame
        widthFrame = 450;
        heightFrame = 370;
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
        JLabel JLTitulo= new JLabel("Ingrese El Producto", JLabel.CENTER);
        JLTitulo.setBounds(0, 10, widthFrame, 20);
        JLTitulo.setForeground(Color.BLUE);
        JLTitulo.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(JLTitulo);
        
        //Se agregan los labels para solicitar info
        int posX = 20, posY = 60, width = 200, height = 25;
        nombreJLab = crearLabel("Nombres:", posX, posY, 100, 25);
        apellidosJLab = crearLabel("Apellidos:", posX, posY += 30, width, height);
        txtIdJLab = crearLabel("Identificación:", posX, posY += 30, width, height);
        fechaNacimientoJLab = crearLabel("Fecha de nacimiento:", posX, posY += 30, width, height);
        direccionJLab = crearLabel("Dirección:", posX, posY += 30, width, height);
        programaFormacionJLab = crearLabel("Prog. de formación:", posX, posY += 30, width, height);
        
        //Se agregan los campos para ingresar los datos
        posY= 60;
        nombreJTF=crearJTextF(posY);
        apellidosJTF =crearJTextF(posY+=30); 
        txtIdJTF=crearJTextF(posY+=30); 
        fechaNacimientoJTF=crearJTextF(posY+=30);
        direccionJTF=crearJTextF(posY+=30);
        programaFormacionJTF=crearJTextF(posY+=30);
        
        //Se agregan los botones
        width=90;
        BtnGuardar= crearButton("Guardar",posX+=10, posY+=50, width, height);
        BtnLimpiar= crearButton("Limpiar",posX+=15+width, posY, width, height);
        BtnVerListaPersonas= crearButton("Ver lista de personas",posX+=15+width, posY, width=170, height);
        
        //Se agregan los label que indican la cantida de registos
        crearLabel("Se han registrado: ", widthFrame-220, posY+= 30, width, height);
        LblCantidadVisitantes = crearLabel("0", widthFrame-90, posY, width, height);                     
        LblLimite = crearLabel("", widthFrame-75, posY , width, height);
        


    }

    public void dispose() {
        frame.dispose();
    }

    public JFrame getRootPane() {
        return frame;
    }

    public void setVisible(boolean visi) {
    }

    public JLabel crearLabel(String label, int posX, int posY, int width, int height) {
        JLabel lab = new JLabel(label);
        lab.setBounds(posX, posY, width, height);
        lab.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(lab);
        return lab;
    }
    public JButton crearButton(String label,int x, int y, int largo, int alto) {
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

    public void setNombreJLab(JLabel nombreJLab) {
        this.nombreJLab = nombreJLab;
    }

    public JLabel getNombreJLab() {
        return nombreJLab;
    }

    public void setLblCantidadVisitantes(JLabel LblCantidadVisitantes) {
        this.LblCantidadVisitantes = LblCantidadVisitantes;
    }

    public JLabel getLblCantidadVisitantes() {
        return LblCantidadVisitantes;
    }

    public void setApellidosJLab(JLabel apellidosJLab) {
        this.apellidosJLab = apellidosJLab;
    }

    public JLabel getApellidosJLab() {
        return apellidosJLab;
    }

    public void setTxtIdJLab(JLabel txtIdJLab) {
        this.txtIdJLab = txtIdJLab;
    }

    public JLabel getTxtIdJLab() {
        return txtIdJLab;
    }

    public void setFechaNacimientoJLab(JLabel fechaNacimientoJLab) {
        this.fechaNacimientoJLab = fechaNacimientoJLab;
    }

    public JLabel getFechaNacimientoJLab() {
        return fechaNacimientoJLab;
    }

    public void setDireccionJLab(JLabel direccionJLab) {
        this.direccionJLab = direccionJLab;
    }

    public JLabel getDireccionJLab() {
        return direccionJLab;
    }

    public void setProgramaFormacionJLab(JLabel programaFormacionJLab) {
        this.programaFormacionJLab = programaFormacionJLab;
    }

    public JLabel getProgramaFormacionJLab() {
        return programaFormacionJLab;
    }

    public void setNombreJTF(JTextField nombreJTF) {
        this.nombreJTF = nombreJTF;
    }

    public JTextField getNombreJTF() {
        return nombreJTF;
    }

    public void setApellidosJTF(JTextField apellidosJTF) {
        this.apellidosJTF = apellidosJTF;
    }

    public JTextField getApellidosJTF() {
        return apellidosJTF;
    }

    public void setTxtIdJTF(JTextField txtIdJTF) {
        this.txtIdJTF = txtIdJTF;
    }

    public JTextField getTxtIdJTF() {
        return txtIdJTF;
    }

    public void setFechaNacimientoJTF(JTextField fechaNacimientoJTF) {
        this.fechaNacimientoJTF = fechaNacimientoJTF;
    }

    public JTextField getFechaNacimientoJTF() {
        return fechaNacimientoJTF;
    }

    public void setDireccionJTF(JTextField direccionJTF) {
        this.direccionJTF = direccionJTF;
    }

    public JTextField getDireccionJTF() {
        return direccionJTF;
    }

    public void setProgramaFormacionJTF(JTextField programaFormacionJTF) {
        this.programaFormacionJTF = programaFormacionJTF;
    }

    public JTextField getProgramaFormacionJTF() {
        return programaFormacionJTF;
    }


    public void setBtnGuardar(JButton BtnGuardar) {
        this.BtnGuardar = BtnGuardar;
    }

    public JButton getBtnGuardar() {
        return BtnGuardar;
    }

    public void setBtnLimpiar(JButton BtnLimpiar) {
        this.BtnLimpiar = BtnLimpiar;
    }

    public JButton getBtnLimpiar() {
        return BtnLimpiar;
    }

    public void setBtnVerListaPersonas(JButton BtnVerListaPersonas) {
        this.BtnVerListaPersonas = BtnVerListaPersonas;
    }

    public JButton getBtnVerListaPersonas() {
        return BtnVerListaPersonas;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setLblLimite(JLabel LblLimite) {
        this.LblLimite = LblLimite;
    }

    public JLabel getLblLimite() {
        return LblLimite;
    }
}
