package com.yanzord.segurancainformacao.cifracesar;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CifraCesarTest {

    private CifraCesar cifraCesar = new CifraCesar();

    @Test
    public void deveCriptografarMensagem() {
        assertEquals("EDQDQD", cifraCesar.criptografarTexto("Banana!"));
        assertEquals("ABC", cifraCesar.criptografarTexto("Xyz"));
    }

    @Test
    public void deveRetornarStringVaziaSeReceberSomenteCaracteresEspeciais() {
        assertEquals("", cifraCesar.criptografarTexto("!#!$!$%%%$#&     "));
    }

    @Test
    public void deveDescriptografarMensagem() {
        assertEquals("BANANA", cifraCesar.descriptografarTexto("EDQDQD"));
        assertEquals("XYZ", cifraCesar.descriptografarTexto("ABC"));
    }

}
