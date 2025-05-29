package EjemploIMC.VIsta;

import EjemploIMC.Controlador.Coordinador;
import EjemploIMC.Modelo.dto.PersonaDTO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsularIndividual extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Coordinador miCoordinador;
    private JTextField txtDocumento;
    private JButton btnConsultar;
    private JButton btnCerrar;
    private JTextArea txtAreaResultado;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtEstatura;
    private JTextField txtPeso;
    private JButton btnActualizar;


    public VentanaConsularIndividual() {
        setTitle("Consulta Individual de Persona");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 450, 420);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JLabel lblTitulo = new JLabel("CONSULTA INDIVIDUAL DE PERSONA");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        lblTitulo.setBounds(50, 20, 350, 30);
        lblTitulo.setForeground(Color.ORANGE);
        contentPane.add(lblTitulo);

        Border bordeNaranja = BorderFactory.createLineBorder(Color.ORANGE, 2);

        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(50, 70, 100, 25);
        lblDocumento.setForeground(Color.ORANGE);
        contentPane.add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(160, 70, 200, 25);
        txtDocumento.setBackground(Color.darkGray);
        txtDocumento.setForeground(Color.ORANGE);
        txtDocumento.setBorder(bordeNaranja);
        contentPane.add(txtDocumento);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(160, 110, 100, 30);
        btnConsultar.addActionListener(this);
        btnConsultar.setBackground(Color.ORANGE);
        btnConsultar.setForeground(Color.BLACK);
        btnConsultar.setBorder(bordeNaranja);
        contentPane.add(btnConsultar);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 160, 100, 25);
        lblNombre.setForeground(Color.ORANGE);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(160, 160, 200, 25);
        txtNombre.setBackground(Color.DARK_GRAY);
        txtNombre.setForeground(Color.ORANGE);
        txtNombre.setBorder(bordeNaranja);
        contentPane.add(txtNombre);


        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(50, 200, 100, 25);
        lblEdad.setForeground(Color.ORANGE);
        contentPane.add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(160, 200, 200, 25);
        txtEdad.setBackground(Color.DARK_GRAY);
        txtEdad.setForeground(Color.ORANGE);
        txtEdad.setBorder(bordeNaranja);
        contentPane.add(txtEdad);


        JLabel lblEstatura = new JLabel("Estatura:");
        lblEstatura.setBounds(50, 240, 100, 25);
        lblEstatura.setForeground(Color.ORANGE);
        contentPane.add(lblEstatura);

        txtEstatura = new JTextField();
        txtEstatura.setBounds(160, 240, 200, 25);
        txtEstatura.setBackground(Color.DARK_GRAY);
        txtEstatura.setForeground(Color.ORANGE);
        txtEstatura.setBorder(bordeNaranja);
        contentPane.add(txtEstatura);


        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(50, 280, 100, 25);
        lblPeso.setForeground(Color.ORANGE);
        contentPane.add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(160, 280, 200, 25);
        txtPeso.setBackground(Color.DARK_GRAY);
        txtPeso.setForeground(Color.ORANGE);
        txtPeso.setBorder(bordeNaranja);
        contentPane.add(txtPeso);


        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(160, 330, 120, 30);
        btnActualizar.setBackground(Color.ORANGE);
        btnActualizar.setForeground(Color.BLACK);
        btnActualizar.setBorder(bordeNaranja);
        btnActualizar.addActionListener(this);
        contentPane.add(btnActualizar);

        btnCerrar = new JButton("Limpiar");
        btnCerrar.setBounds(175, 330, 100, 30);
        btnCerrar.addActionListener(this);
        btnCerrar.setForeground(Color.BLACK);
        btnCerrar.setBackground(Color.ORANGE);
        btnCerrar.setBorder(bordeNaranja);
        contentPane.add(btnCerrar);
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    private void consultarPersona() {
        String documento = txtDocumento.getText().trim();

        if (documento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un documento");
            return;
        }

        PersonaDTO persona = miCoordinador.consultarPersona(documento);

        if (persona != null) {
            String resultado = "DATOS DE LA PERSONA:\n\n" +
                    "Documento: " + persona.getDocumento() + "\n" +
                    "Nombre: " + persona.getNombre() + "\n" +
                    "Edad: " + persona.getEdad() + " años\n" +
                    "Peso: " + persona.getPeso() + " kg\n" +
                    "Altura: " + persona.getAltura() + " m\n" +
                    "IMC: " + String.format("%.2f", persona.getImc()) + "\n" +
                    "Clasificación: " + persona.getClasificacion();

            txtAreaResultado.setText(resultado);
        } else {
            txtAreaResultado.setText("No se encontró ninguna persona con el documento: " + documento);
        }
    }

    private void limpiarCampos() {
        txtDocumento.setText("");
        txtAreaResultado.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConsultar) {
            String documento = txtDocumento.getText();
            PersonaDTO persona = miCoordinador.consultarPersona(documento);

            if (persona != null) {
                txtNombre.setText(persona.getNombre());
                txtEdad.setText(String.valueOf(persona.getEdad()));
                txtEstatura.setText(String.valueOf(persona.getAltura()));
                txtPeso.setText(String.valueOf(persona.getPeso()));
            } else {
                mostrarVentanaEmergente("Persona no encontrada", Color.RED, Color.WHITE);
            }
        }

        if (e.getSource() == btnActualizar) {
            PersonaDTO persona = new PersonaDTO();
            persona.setDocumento(txtDocumento.getText());
            persona.setNombre(txtNombre.getText());
            persona.setEdad(Integer.parseInt(txtEdad.getText()));
            persona.setAltura(Double.parseDouble(txtEstatura.getText()));
            persona.setPeso(Double.parseDouble(txtPeso.getText()));

            boolean actualizado = miCoordinador.actualizarPersona(persona);
            if (actualizado) {
                mostrarVentanaEmergente("Persona actualizada exitosamente", Color.GREEN, Color.BLACK);
            } else {
                mostrarVentanaEmergente("Error al actualizar persona", Color.RED, Color.WHITE);
            }
        }

        if (e.getSource() == btnCerrar) {
            this.dispose();
        }
    }

    private void mostrarVentanaEmergente(String mensaje, Color bg, Color fg) {
        UIManager.put("OptionPane.background", bg);
        UIManager.put("Panel.background", bg);
        UIManager.put("OptionPane.messageForeground", fg);
        UIManager.put("OptionPane.messageFont", new Font("Trebuchet MS", Font.BOLD, 14));
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
