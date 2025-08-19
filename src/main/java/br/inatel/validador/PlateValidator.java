package br.inatel.validador;

import java.util.regex.Pattern;

public class PlateValidator {

    // recebe a placa e retorna se é válida ou não
    public boolean isValid(String plate) {
        // Regex para placas Mercosul AAA1A23
        return plate.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}");
    }
}
