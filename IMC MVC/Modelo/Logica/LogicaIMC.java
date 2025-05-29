package EjemploIMC.Modelo.Logica;

import EjemploIMC.Controlador.Coordinador;
import EjemploIMC.Modelo.dto.PersonaDTO;

public class LogicaIMC {
    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public double calcularIMC(PersonaDTO persona) {
        if (persona.getAltura() <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor a 0");
        }
        return persona.getPeso() / (persona.getAltura() * persona.getAltura());
    }

    public String clasificarIMC(double imc) {
        if (imc<18){
            return  "Tiene Anorexia";
        }else if (imc>=18 && imc<20){
            return  "Tiene Delgadez";
        }else if (imc>=20 && imc<20){
            return  "Tiene Normalidad";
        }else if (imc>=27 && imc<30) {
            return  "Tiene Obsidad (Grado 1)";
        }else if (imc>=30 && imc<35) {
            return  "Tiene Obsidad (Grado 2)";
        }else if (imc>=35 && imc<40) {
            return  "Tiene Obsidad (Grado 3)";
        } else {
            return  "Tiene Obsidad Morbida";
        }
    }

    public String obtenerRecomendacion(double imc) {
        if (imc < 18.5) {
            return "Se recomienda aumentar de peso de manera saludable consultando a un nutricionista.";
        } else if (imc >= 18.5 && imc < 25) {
            return "Su peso es normal. Mantenga una dieta equilibrada y ejercicio regular.";
        } else if (imc >= 25 && imc < 30) {
            return "Se recomienda reducir peso mediante dieta balanceada y ejercicio.";
        } else if (imc >= 30) {
            return "Se recomienda consultar con un médico para un plan de reducción de peso.";
        }
        return "";
    }
}
