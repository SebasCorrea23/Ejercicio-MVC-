package EjemploIMC.VIsta;


import EjemploIMC.Controlador.Coordinador;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Coordinador miCoordinador;
    private JButton btnRegistrar;
    private JButton btnConsultarPersona;
    private JButton btnConsultarLista;


    /**
     * Create the frame.
     */
    public VentanaPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 470, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);
        setLocationRelativeTo(null);

        iniciarComponentes();


    }


    private void iniciarComponentes() {
        JLabel lblSistemaGestionUsuarios = new JLabel("SISTEMA IMC Y GESTION USUARIOS");
        lblSistemaGestionUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
        lblSistemaGestionUsuarios.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
        lblSistemaGestionUsuarios.setForeground(Color.ORANGE);
        lblSistemaGestionUsuarios.setBounds(33, 6, 388, 30);
        contentPane.add(lblSistemaGestionUsuarios);

        Border bordeNaranja = BorderFactory.createLineBorder(Color.ORANGE, 2);

        JTextArea txtrEstaAplicacinPermite = new JTextArea();
        txtrEstaAplicacinPermite.setText("Esta aplicación tiene como proposito registrar poblacion y a la vez calcular el IMC (Indice de Masa Corporal) \nEl proceso de funcionamiento consta de registrar los datos de un individuo, posteriormente consultarlo individualmente o en la lista.");
        txtrEstaAplicacinPermite.setColumns(5);
        txtrEstaAplicacinPermite.setBackground(Color.darkGray);
        txtrEstaAplicacinPermite.setForeground(Color.ORANGE);
        txtrEstaAplicacinPermite.setBorder(bordeNaranja);
        txtrEstaAplicacinPermite.setBounds(20, 48, 410, 127);
        contentPane.add(txtrEstaAplicacinPermite);

        btnRegistrar = new JButton("Registrar Persona");
        btnRegistrar.setBounds(100, 220, 250, 29);
        btnRegistrar.setBackground(Color.ORANGE);
        btnRegistrar.setForeground(Color.BLACK);
        btnRegistrar.setBorder(bordeNaranja);
        btnRegistrar.addActionListener(this);
        contentPane.add(btnRegistrar);

        btnConsultarPersona = new JButton("Consultar Persona");
        btnConsultarPersona.setBounds(100, 280, 250, 29);
        btnConsultarPersona.addActionListener(this);
        btnConsultarPersona.setBackground(Color.ORANGE);
        btnConsultarPersona.setForeground(Color.BLACK);
        btnConsultarPersona.setBorder(bordeNaranja);
        contentPane.add(btnConsultarPersona);

        btnConsultarLista = new JButton("Consultar Lista de Personas");
        btnConsultarLista.addActionListener(this);
        btnConsultarLista.setBounds(100, 340, 250, 29);
        btnConsultarLista.setForeground(Color.BLACK);
        btnConsultarLista.setBackground(Color.ORANGE);
        btnConsultarLista.setBorder(bordeNaranja);
        contentPane.add(btnConsultarLista);
    }


    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador=miCoordinador;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnRegistrar) {
            miCoordinador.setVentanaRegistro();
        }else if (e.getSource()==btnConsultarPersona) {
            miCoordinador.setVentanaConsultaIndividual();
        }else if (e.getSource()==btnConsultarLista) {
            miCoordinador.setVentanaConsultarLista();
        }
    }
}
