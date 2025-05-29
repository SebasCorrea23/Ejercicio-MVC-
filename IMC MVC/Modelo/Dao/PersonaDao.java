package EjemploIMC.Modelo.Dao;

import EjemploIMC.Controlador.Coordinador;
import EjemploIMC.Modelo.Conexion.ConexionDatos;
import EjemploIMC.Modelo.dto.PersonaDTO;

import java.util.ArrayList;

public class PersonaDao {
    private ArrayList<PersonaDTO> listaPersonas = new ArrayList<>();

    public void registrarPersona(PersonaDTO persona) {
        listaPersonas.add(persona);
    }

    public PersonaDTO buscarPersona(String documento) {
        for (PersonaDTO persona : listaPersonas) {
            if (persona.getDocumento().equals(documento)) {
                return persona;
            }
        }
        return null;
    }

    public boolean actualizarPersona(PersonaDTO personaActualizada) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            PersonaDTO actual = listaPersonas.get(i);
            if (actual.getDocumento().equals(personaActualizada.getDocumento())) {
                listaPersonas.set(i, personaActualizada);
                return true;
            }
        }
        return false;
    }

    public ArrayList<PersonaDTO> consultarListaPersonas() {
        return listaPersonas;
    }

    public void setConexionDatos(ConexionDatos miConexionBD) {
    }

    public void setCoordinador(Coordinador miCoordinador) {
    }
}
