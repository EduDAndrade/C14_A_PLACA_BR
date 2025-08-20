package br.inatel.validador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlateValidator validator = new PlateValidator();

        System.out.println("Informe a placa:");
        String placa = sc.nextLine().toUpperCase();

        String valid;

        if (validator.isValid(placa)) {
            valid = "Placa válida!";
        } else {
            valid = "Placa inválida!";
        }

        System.out.println(valid);

        HistoryManager.writeHistory(placa, valid);

        sc.close();
    }
}