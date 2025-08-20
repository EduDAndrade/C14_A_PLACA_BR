package br.inatel.validador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlateValidator validator = new PlateValidator();

        System.out.println("Informe a placa:");
        String placa = sc.nextLine().toUpperCase();

        String valido;

        if (validator.isValid(placa)) {
            valido = "Placa válida!";
        } else {
            valido = "Placa inválida!";
        }

        System.out.println(valido);

        HistoryManager.writeHistory(placa, valido);

        sc.close();
    }
}