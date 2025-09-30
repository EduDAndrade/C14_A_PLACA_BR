package br.inatel.validador;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class HistoryManagerTest {

    // ========== CASOS POSITIVOS (4 testes) ==========

    @Test
    public void testeEscritaHistoricoPlacaValida() throws IOException {
        // Fixture
        String placa = "ABC1D23";
        String mensagem = "Placa válida!";

        // Execução
        HistoryManager.writeHistory(placa, mensagem);

        // Verificação
        Path caminhoArquivo = Paths.get("history.txt");
        assertTrue(Files.exists(caminhoArquivo));

        List<String> linhas = Files.readAllLines(caminhoArquivo);
        assertFalse(linhas.isEmpty());
    }

    @Test
    public void testeEscritaHistoricoPlacaInvalida() throws IOException {
        // Fixture
        String placa = "ABC123";
        String mensagem = "Placa inválida!";

        // Execução
        HistoryManager.writeHistory(placa, mensagem);

        // Verificação
        Path caminhoArquivo = Paths.get("history.txt");
        List<String> linhas = Files.readAllLines(caminhoArquivo);

        boolean contemLinha = false;
        for (String linha : linhas) {
            if (linha.contains("ABC123 -> Placa inválida!")) {
                contemLinha = true;
                break;
            }
        }
        assertTrue(contemLinha);
    }

    @Test
    public void testeCriacaoArquivo() {
        // Fixture
        String placa = "TEST123";
        String mensagem = "Teste criacao";

        // Execução
        HistoryManager.writeHistory(placa, mensagem);

        // Verificação
        Path caminhoArquivo = Paths.get("history.txt");
        assertTrue(Files.exists(caminhoArquivo));
    }

    @Test
    public void testeFormatacaoCorreta() throws IOException {
        // Fixture
        String placa = "XYZ9A88";
        String mensagem = "Formato teste";

        // Execução
        HistoryManager.writeHistory(placa, mensagem);

        // Verificação
        Path caminhoArquivo = Paths.get("history.txt");
        List<String> linhas = Files.readAllLines(caminhoArquivo);

        boolean formatoCorreto = false;
        for (String linha : linhas) {
            if (linha.contains("XYZ9A88 -> Formato teste")) {
                formatoCorreto = true;
                break;
            }
        }
        assertTrue(formatoCorreto);
    }

    // ========== CASOS NEGATIVOS (2 testes) ==========

    @Test
    public void testeEscritaComStringsVazias() {
        // Fixture
        String placa = "";
        String mensagem = "";

        // Execução - não deve lançar exceção
        HistoryManager.writeHistory(placa, mensagem);

        // Verificação
        Path caminhoArquivo = Paths.get("history.txt");
        assertTrue(Files.exists(caminhoArquivo));
    }

    @Test
    public void testeEscritaComCaracteresEspeciais() {
        // Fixture
        String placa = "ABC@123";
        String mensagem = "Teste especial";

        // Execução - não deve lançar exceção
        HistoryManager.writeHistory(placa, mensagem);

        // Verificação
        Path caminhoArquivo = Paths.get("history.txt");
        assertTrue(Files.exists(caminhoArquivo));
    }
}