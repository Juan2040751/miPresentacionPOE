package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton miFoto,miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private Titulos titulo;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    private Escucha escucha;

    //metodos
    public GUI_Presentacion(){
        initGUI();

        this.setTitle("Mi Presentacion");
        this.setSize(600,540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //layout
        escucha = new Escucha();

        titulo = new Titulos("Hola soy Juan Jose, oprime los botones para conocer mas sobre mi",Color.BLACK );
        this.add(titulo, BorderLayout.NORTH);

        panelDatos= new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco mas de mi...",
                TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Calibri",Font.BOLD ,20), Color.BLACK));

        this.add(panelDatos,BorderLayout.CENTER);

        miFoto= new JButton("Este soy yo");
        miFoto.addActionListener(escucha);
        miHobby= new JButton("Este es mi hobby");
        miHobby.addActionListener(escucha);
        misExpectativas= new JButton("Creo que");
        misExpectativas.addActionListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones,BorderLayout.SOUTH);

        labelImagen= new JLabel();
        textoExpectativas= new JTextArea(3,12);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    private class Escucha implements ActionListener {
        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e) {
            panelDatos.removeAll();
            if (e.getSource() == miFoto) {
                image = new ImageIcon(getClass().getResource("/recursos/yoImag.jpg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }else{
                if(e.getSource() == miHobby){
                    image = new ImageIcon(getClass().getResource("/recursos/hobby.jpg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }else{
                    if(e.getSource() ==misExpectativas){
                        textoExpectativas.setText("Actualmente no se programar orientado eventos. \n"+
                                                  "aunque es algo que me llama mucho la atencion, sobretodo lo que tiene UI.\n" +
                                                  "Disfrutare esta asignatura, espero aprender mucho.");
                        textoExpectativas.setBackground(Color.GRAY);
                        textoExpectativas.setForeground(Color.WHITE);
                        textoExpectativas.setFont(new Font(Font.DIALOG,Font.ITALIC,16));
                        textoExpectativas.setOpaque(true);
                        panelDatos.add(textoExpectativas);
                    }
                }
            }
            revalidate();
            repaint();
        }
    }
}
