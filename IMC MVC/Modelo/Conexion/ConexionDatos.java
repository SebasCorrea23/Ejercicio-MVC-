package EjemploIMC.Modelo.Conexion;

import EjemploIMC.Controlador.Coordinador;
import EjemploIMC.Modelo.dto.PersonaDTO;

import java.util.ArrayList;
import java.util.HashMap;

public class ConexionDatos {
    private Coordinador miCoordinador;
    private HashMap<String, PersonaDTO> baseDatos;

    public ConexionDatos() {
        this.baseDatos = new HashMap<>();
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    // Guardar una persona en el HashMap
    public boolean guardarPersona(PersonaDTO persona) {
        try {
            baseDatos.put(persona.getDocumento(), persona);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Buscar una persona por documento
    public PersonaDTO buscarPersona(String documento) {
        return baseDatos.get(documento);
    }

    // Obtener todas las personas
    public ArrayList<PersonaDTO> obtenerTodasLasPersonas() {
        return new ArrayList<>(baseDatos.values());
    }

    // Verificar si existe una persona
    public boolean existePersona(String documento) {
        return baseDatos.containsKey(documento);
    }

    // Actualizar una persona
    public boolean actualizarPersona(PersonaDTO persona) {
        if (baseDatos.containsKey(persona.getDocumento())) {
            baseDatos.put(persona.getDocumento(), persona);
            return true;
        }
        return false;
    }

    // Eliminar una persona
    public boolean eliminarPersona(String documento) {
        return baseDatos.remove(documento) != null;
    }

    // Obtener el número total de personas registradas
    public int getTotalPersonas() {
        return baseDatos.size();
    }

    // Limpiar toda la base de datos
    public void limpiarBaseDatos() {
        baseDatos.clear();
    }
}
