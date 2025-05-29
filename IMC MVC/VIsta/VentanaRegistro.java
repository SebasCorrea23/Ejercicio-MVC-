package EjemploIMC.VIsta;

import EjemploIMC.Controlador.Coordinador;
import EjemploIMC.Modelo.dto.PersonaDTO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistro extends JDialog implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Coordinador miCoordinador;
    private JTextField txtDocumento;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JButton btnRegistrar;
    private JButton btnCancelar;

    public VentanaRegistro(VentanaPrincipal parent, boolean modal) {
        super(parent, modal);
        setTitle("Registro de Persona");
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);



        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JLabel lblTitulo = new JLabel("REGISTRO DE PERSONA");
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

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 110, 100, 25);
        lblNombre.setForeground(Color.ORANGE);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(160, 110, 200, 25);
        txtNombre.setBackground(Color.darkGray);
        txtNombre.setForeground(Color.ORANGE);
        txtNombre.setBorder(bordeNaranja);
        contentPane.add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(50, 150, 100, 25);
        lblEdad.setForeground(Color.ORANGE);
        contentPane.add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(160, 150, 200, 25);
        txtEdad.setBackground(Color.darkGray);
        txtEdad.setForeground(Color.ORANGE);
        txtEdad.setBorder(bordeNaranja);
        contentPane.add(txtEdad);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setBounds(50, 190, 100, 25);
        lblPeso.setForeground(Color.ORANGE);
        contentPane.add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(160, 190, 200, 25);
        txtPeso.setBackground(Color.darkGray);
        txtPeso.setForeground(Color.ORANGE);
        txtPeso.setBorder(bordeNaranja);
        contentPane.add(txtPeso);

        JLabel lblAltura = new JLabel("Altura (m):");
        lblAltura.setBounds(50, 230, 100, 25);
        lblAltura.setForeground(Color.ORANGE);
        contentPane.add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(160, 230, 200, 25);
        txtAltura.setBackground(Color.darkGray);
        txtAltura.setForeground(Color.ORANGE);
        txtAltura.setBorder(bordeNaranja);
        contentPane.add(txtAltura);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(100, 290, 100, 30);
        btnRegistrar.setForeground(Color.BLACK);
        btnRegistrar.setBackground(Color.ORANGE);
        btnRegistrar.setBorder(bordeNaranja);
        btnRegistrar.addActionListener(this);
        contentPane.add(btnRegistrar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(250, 290, 100, 30);
        btnCancelar.setBackground(Color.ORANGE);
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBorder(bordeNaranja);
        btnCancelar.addActionListener(this);
        contentPane.add(btnCancelar);
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    private void limpiarCampos() {
        txtDocumento.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtPeso.setText("");
        txtAltura.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            try {
                String documento = txtDocumento.getText().trim();
                String nombre = txtNombre.getText().trim();
                int edad = Integer.parseInt(txtEdad.getText().trim());
                double peso = Double.parseDouble(txtPeso.getText().trim());
                double altura = Double.parseDouble(txtAltura.getText().trim());

                PersonaDTO persona = new PersonaDTO(documento, nombre, edad, peso, altura);
                String resultado = miCoordinador.registrarPersona(persona);

                JOptionPane.showMessageDialog(this, resultado);

                if (resultado.contains("exitosamente")) {
                    limpiarCampos();
                    this.setVisible(false);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Verifique que los datos numéricos estén correctos");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage());
            }
        } else if (e.getSource() == btnCancelar) {
            limpiarCampos();
            this.setVisible(false);
        }
    }
}
