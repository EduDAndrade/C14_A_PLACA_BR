package br.inatel.validador;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class PlateValidatorIntegracaoTeste {

    @Test
    public void testeIntegracaoFluxoCompletoPlacaValida() throws IOException {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "ABC1D23";

        // Execução - fluxo completo como no Main
        boolean ehValida = validator.isValid(placa);
        String mensagem = ehValida ? "Placa válida!" : "Placa inválida!";
        HistoryManager.writeHistory(placa, mensagem);

        // Verificação
        assertTrue(ehValida);

        Path caminhoHistorico = Paths.get("history.txt");
        List<String> linhas = Files.readAllLines(caminhoHistorico);

        boolean contemRegistro = false;
        for (String linha : linhas) {
            if (linha.contains("ABC1D23 -> Placa válida!")) {
                contemRegistro = true;
                break;
            }
        }
        assertTrue(contemRegistro);
    }

    @Test
    public void testeIntegracaoFluxoCompletoPlacaInvalida() throws IOException {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "ABC123";

        // Execução - fluxo completo como no Main
        boolean ehValida = validator.isValid(placa);
        String mensagem = ehValida ? "Placa válida!" : "Placa inválida!";
        HistoryManager.writeHistory(placa, mensagem);

        // Verificação
        assertFalse(ehValida);

        Path caminhoHistorico = Paths.get("history.txt");
        List<String> linhas = Files.readAllLines(caminhoHistorico);

        boolean contemRegistro = false;
        for (String linha : linhas) {
            if (linha.contains("ABC123 -> Placa inválida!")) {
                contemRegistro = true;
                break;
            }
        }
        assertTrue(contemRegistro);
    }
}