package br.inatel.validador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlateValidator validator = new PlateValidator();

        System.out.println("Informe a placa:");
        String placa = sc.nextLine().toUpperCase();

        String validasso;

        if (validator.isValid(placa)) {
            validasso = "Placa válida!";
        } else {
            validasso = "Placa inválida!";
        }

        System.out.println(validasso);

        HistoryManager.writeHistory(placa, validasso);

        sc.close();
    }
}