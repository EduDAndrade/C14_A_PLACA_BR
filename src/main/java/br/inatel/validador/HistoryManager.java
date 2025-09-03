package br.inatel.validador;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class HistoryManager {

    public static void writeHistory(String placa, String valid){
        String caminho = "history.txt";
        String linha = placa;

        Path path = Paths.get(placa);

        try {
            Files.write(path, Arrays.asList(linha),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
