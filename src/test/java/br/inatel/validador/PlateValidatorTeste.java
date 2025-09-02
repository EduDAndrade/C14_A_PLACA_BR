package br.inatel.validador;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class PlateValidatorTeste {

    // ========== CASOS POSITIVOS (7 testes) ==========

    @Test
    public void testePlacaMercosulValida() {
        // Fixture - preparação
        PlateValidator validator = new PlateValidator();
        String placa = "ABC1D23";

        // Execução - chamada do metodo testado
        boolean resultado = validator.isValid(placa);

        // Verificação - assert
        assertTrue(resultado);
    }

    @Test
    public void testePlacaComPrimeiraLetraA() {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "AAA1B23";

        // Execução
        boolean resultado = validator.isValid(placa);

        // Verificação
        assertTrue(resultado);
    }

    @Test
    public void testePlacaComUltimaLetraZ() {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "XYZ9Z99";

        // Execução
        boolean resultado = validator.isValid(placa);

        // Verificação
        assertTrue(resultado);
    }

    @Test
    public void testePlacaComNumerosZero() {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "ABC0A00";

        // Execução
        boolean resultado = validator.isValid(placa);

        // Verificação
        assertTrue(resultado);
    }

    @Test
    public void testePlacaRealExemplo1() {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "BRA2E19";

        // Execução
        boolean resultado = validator.isValid(placa);

        // Verificação
        assertTrue(resultado);
    }

    @Test
    public void testePlacaRealExemplo2() {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "SAO1P45";

        // Execução
        boolean resultado = validator.isValid(placa);

        // Verificação
        assertTrue(resultado);
    }

    @Test
    public void testePlacaComLetraMeioZ() {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "BRA2Z19";

        // Execução
        boolean resultado = validator.isValid(placa);

        // Verificação
        assertTrue(resultado);
    }

    // ========== CASOS NEGATIVOS (5 testes) ==========

    @Test
    public void testePlacaVazia() {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "";

        // Execução
        boolean resultado = validator.isValid(placa);

        // Verificação
        assertFalse(resultado);
    }

    @Test
    public void testePlacaPadraoAntigo() {
        // Fixture - padrão brasileiro antigo ABC1234
        PlateValidator validator = new PlateValidator();
        String placa = "ABC1234";

        // Execução
        boolean resultado = validator.isValid(placa);

        // Verificação
        assertFalse(resultado);
    }

    @Test
    public void testePlacaMuitoCurta() {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "ABC1D2";

        // Execução
        boolean resultado = validator.isValid(placa);

        // Verificação
        assertFalse(resultado);
    }

    @Test
    public void testePlacaComLetrasMinusculas() {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "abc1d23";

        // Execução
        boolean resultado = validator.isValid(placa);

        // Verificação
        assertFalse(resultado);
    }

    @Test
    public void testePlacaComCaracteresEspeciais() {
        // Fixture
        PlateValidator validator = new PlateValidator();
        String placa = "AB@1D23";

        // Execução
        boolean resultado = validator.isValid(placa);

        // Verificação
        assertFalse(resultado);
    }
}