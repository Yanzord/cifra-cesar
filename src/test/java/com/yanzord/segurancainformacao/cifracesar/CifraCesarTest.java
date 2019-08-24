package com.yanzord.segurancainformacao.cifracesar;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CifraCesarTest {

    @Test
    public void deveCriptografarMensagem() {
        CifraCesar cifraCesar = new CifraCesar();
        assertEquals("EDQDQD", cifraCesar.criptografarTexto("Banana!"));
    }

}
