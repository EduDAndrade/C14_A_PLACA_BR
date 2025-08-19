package br.inatel.validador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlateValidator validator = new PlateValidator();

        System.out.println("Informe a placa:");
        String placa = sc.nextLine();

        if (validator.isValid(placa)) {
            System.out.println("Placa válida!");
        } else {
            System.out.println("Placa inválida!");
        }

        sc.close();
    }
}