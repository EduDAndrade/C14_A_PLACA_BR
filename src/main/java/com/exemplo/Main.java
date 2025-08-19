package com.exemplo;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    // Regex da placa Mercosul: LLLNLNN (L: letra / N: número)
    private static final String REGEX_PLACA_MERCOSUL = "^[A-Z]{3}[0-9][A-Z][0-9]{2}$";

    public static boolean validarPlaca(String placa) {
        return Pattern.matches(REGEX_PLACA_MERCOSUL, placa.toUpperCase());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe a placa: ");
        String placa = sc.nextLine();

        if (validarPlaca(placa)) {
            System.out.println("Placa válida");
        } else {
            System.out.println("Placa inválida");
        }

        sc.close();
    }
}