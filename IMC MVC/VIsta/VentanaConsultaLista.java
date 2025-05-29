package EjemploIMC.VIsta;

import EjemploIMC.Controlador.Coordinador;
import EjemploIMC.Modelo.dto.PersonaDTO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaConsultaLista extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Coordinador miCoordinador;
    private JTextArea txtAreaResultado;
    private JButton btnCerrar;

    // Constructor sin parámetros (como en tu código original)
    public VentanaConsultaLista() {
        setTitle("Consulta Lista de Personas");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 453, 380);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    public void consultarListaPersonas() {
        ArrayList<PersonaDTO> listaPersonas = miCoordinador.consultarListaPersonas();
        String msj = "";

        if (listaPersonas.size() > 0) {
            msj = "LISTA DE PERSONAS REGISTRADAS:\n\n";
            for (PersonaDTO personaDTO : listaPersonas) {
                msj += "Documento: " + personaDTO.getDocumento() + "\n" +
                        "Nombre: " + personaDTO.getNombre() + "\n" +
                        "Edad: " + personaDTO.getEdad() + " años\n" +
                        "Peso: " + personaDTO.getPeso() + " kg\n" +
                        "Altura: " + personaDTO.getAltura() + " m\n" +
                        "IMC: " + String.format("%.2f", personaDTO.getImc()) + "\n" +
                        "Clasificación: " + personaDTO.getClasificacion() + "\n" +
                        "----------------------------------------\n\n";
            }
        } else {
            msj = "NO HAY PERSONAS REGISTRADAS";
        }

        txtAreaResultado.setText(msj);
    }

    private void iniciarComponentes() {
        JLabel lblSistemaGestionUsuarios = new JLabel("CONSULTA LISTA PERSONAS");
        lblSistemaGestionUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
        lblSistemaGestionUsuarios.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblSistemaGestionUsuarios.setBounds(33, 6, 388, 30);
        lblSistemaGestionUsuarios.setForeground(Color.ORANGE);
        contentPane.add(lblSistemaGestionUsuarios);

        Border bordeNaranja = BorderFactory.createLineBorder(Color.ORANGE, 2);

        txtAreaResultado = new JTextArea();
        txtAreaResultado.setBackground(Color.darkGray);
        txtAreaResultado.setForeground(Color.ORANGE);
        txtAreaResultado.setBorder(bordeNaranja);
        txtAreaResultado.setEditable(false);
        txtAreaResultado.setColumns(5);
        txtAreaResultado.setLineWrap(true);
        txtAreaResultado.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
        scrollPane.setBounds(21, 48, 410, 210);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(175, 270, 100, 30);
        btnCerrar.setForeground(Color.BLACK);
        btnCerrar.setBackground(Color.ORANGE);
        btnCerrar.setBorder(bordeNaranja);
        btnCerrar.addActionListener(this);
        contentPane.add(btnCerrar);
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCerrar) {
            this.setVisible(false);
        }
    }
}