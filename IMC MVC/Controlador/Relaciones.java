package EjemploIMC.Controlador;

import EjemploIMC.Modelo.Conexion.ConexionDatos;
import EjemploIMC.Modelo.Dao.PersonaDao;
import EjemploIMC.Modelo.Logica.LogicaIMC;
import EjemploIMC.VIsta.VentanaConsularIndividual;
import EjemploIMC.VIsta.VentanaConsultaLista;
import EjemploIMC.VIsta.VentanaPrincipal;
import EjemploIMC.VIsta.VentanaRegistro;

public class Relaciones {
    public Relaciones() {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        VentanaRegistro ventanaRegistro = new VentanaRegistro(ventanaPrincipal, true);
        VentanaConsularIndividual ventanaConsultaIndividual = new VentanaConsularIndividual();
        VentanaConsultaLista ventanaConsultarLista = new VentanaConsultaLista();
        LogicaIMC misProcesos = new LogicaIMC();
        PersonaDao miPersonaDAO = new PersonaDao();
        ConexionDatos miConexionBD = new ConexionDatos();
        Coordinador miCoordinador = new Coordinador();

        // Establecer relación entre PersonaDao y ConexionDatos
        miPersonaDAO.setConexionDatos(miConexionBD);

        // Se establecen las relaciones entre clases
        ventanaPrincipal.setCoordinador(miCoordinador);
        ventanaRegistro.setCoordinador(miCoordinador);
        ventanaConsultaIndividual.setCoordinador(miCoordinador);
        ventanaConsultarLista.setCoordinador(miCoordinador);
        miPersonaDAO.setCoordinador(miCoordinador);
        miConexionBD.setCoordinador(miCoordinador);
        misProcesos.setCoordinador(miCoordinador);

        // Se establecen relaciones con la clase coordinador
        miCoordinador.setVentanaPrincipal(ventanaPrincipal);
        miCoordinador.setVentanaRegistro(ventanaRegistro);
        miCoordinador.setVentanaConsultaIndividual(ventanaConsultaIndividual);
        miCoordinador.setVentanaConsultarLista(ventanaConsultarLista);
        miCoordinador.setProcesos(misProcesos);
        miCoordinador.setMiPersonaDAO(miPersonaDAO);
        miCoordinador.setMiConexionBD(miConexionBD);

        // Mostrar ventana principal
        miCoordinador.mostrarVentanaPrincipal();
    }
}