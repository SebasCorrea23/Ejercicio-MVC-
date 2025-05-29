package EjemploIMC.Controlador;

import EjemploIMC.Modelo.Conexion.ConexionDatos;
import EjemploIMC.Modelo.Dao.PersonaDao;
import EjemploIMC.Modelo.Logica.LogicaIMC;
import EjemploIMC.Modelo.dto.PersonaDTO;
import EjemploIMC.VIsta.VentanaConsularIndividual;
import EjemploIMC.VIsta.VentanaConsultaLista;
import EjemploIMC.VIsta.VentanaPrincipal;
import EjemploIMC.VIsta.VentanaRegistro;

import javax.swing.*;
import java.util.ArrayList;

public class Coordinador {
    private VentanaPrincipal ventanaPrincipal;
    private VentanaRegistro ventanaRegistro;
    private LogicaIMC procesos;
    private PersonaDao miPersonaDAO;
    private ConexionDatos miConexionBD;
    private VentanaConsularIndividual ventanaConsultaIndividual;
    private VentanaConsultaLista ventanaConsultarLista;

    // Setters
    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void setVentanaRegistro(VentanaRegistro ventanaRegistro) {
        this.ventanaRegistro = ventanaRegistro;
    }

    public void setProcesos(LogicaIMC procesos) {
        this.procesos = procesos;
    }

    public void setMiPersonaDAO(PersonaDao miPersonaDAO) {
        this.miPersonaDAO = miPersonaDAO;
    }

    public void setMiConexionBD(ConexionDatos miConexionBD) {
        this.miConexionBD = miConexionBD;
    }

    public void setVentanaConsultaIndividual(VentanaConsularIndividual ventanaConsultaIndividual) {
        this.ventanaConsultaIndividual = ventanaConsultaIndividual;
    }

    public void setVentanaConsultarLista(VentanaConsultaLista ventanaConsultarLista) {
        this.ventanaConsultarLista = ventanaConsultarLista;
    }

    // Métodos para mostrar ventanas
    public void mostrarVentanaPrincipal() {
        ventanaPrincipal.setVisible(true);
    }

    public void setVentanaRegistro() {
        mostrarVentanaRegistro();
    }

    public void mostrarVentanaRegistro() {
        ventanaRegistro.setVisible(true);
    }

    public void setVentanaConsultaIndividual() {
        mostrarVentanaConsultaIndividual();
    }

    public void mostrarVentanaConsultaIndividual() {
        ventanaConsultaIndividual.setVisible(true);
    }

    public ArrayList<PersonaDTO> setVentanaConsultarLista() {
        mostrarVentanaConsultarLista();
        return consultarListaPersonas();
    }

    public void mostrarVentanaConsultarLista() {
        ventanaConsultarLista.consultarListaPersonas();
        ventanaConsultarLista.setVisible(true);
    }

    // Métodos de negocio
    public String registrarPersona(PersonaDTO persona) {
        try {
            if (persona.getNombre() == null || persona.getNombre().trim().isEmpty()) {
                return "El nombre es obligatorio";
            }
            if (persona.getDocumento() == null || persona.getDocumento().trim().isEmpty()) {
                return "El documento es obligatorio";
            }
            if (persona.getPeso() <= 0) {
                return "El peso debe ser mayor a 0";
            }
            if (persona.getAltura() <= 0) {
                return "La altura debe ser mayor a 0";
            }
            if (persona.getEdad() <= 0) {
                return "La edad debe ser mayor a 0";
            }

            double imc = procesos.calcularIMC(persona);
            String clasificacion = procesos.clasificarIMC(imc);
            persona.setImc(imc);
            persona.setClasificacion(clasificacion);

            miPersonaDAO.registrarPersona(persona);
            return "Persona registrada exitosamente\nIMC: " + String.format("%.2f", imc) +
                    "\nClasificación: " + clasificacion;
        } catch (Exception e) {
            return "Error al registrar: " + e.getMessage();
        }
    }


    public PersonaDTO consultarPersona(String documento) {
        try {
            return miPersonaDAO.buscarPersona(documento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<PersonaDTO> consultarListaPersonas() {
        try {
            return miPersonaDAO.consultarListaPersonas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar lista: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public String calcularIMC(PersonaDTO persona) {
        try {
            double imc = procesos.calcularIMC(persona);
            String clasificacion = procesos.clasificarIMC(imc);
            return "IMC: " + String.format("%.2f", imc) + "\nClasificación: " + clasificacion;
        } catch (Exception e) {
            return "Error al calcular IMC: " + e.getMessage();
        }
    }

    public boolean actualizarPersona(PersonaDTO persona) {
        return miPersonaDAO.actualizarPersona(persona);
    }
}

