package PadroesDeProjetoComJava;

import java.util.HashMap;

public abstract class DecoderFactory {
    private static HashMap<String, DecoderFactory> factoryMap;

    static {
        factoryMap = new HashMap<>();
        factoryMap.put(“X”, XMLDecoderFactory.getInstance());
        factoryMap.put(“Y”, CSVDecoderFactory.getInstance());
        factoryMap.put(“Z”, TextoLivreDecoderFactory.getInstance());
    }

    public static DecoderFactory getInstance(String origem) {
        return factoryMap.get(origem);
    }

    public abstract RegistrarClienteDecoder createRegistrarClienteDecoder();
    public abstract RegistrarContaDecoder createRegistrarContaDecoder();
}

public class XMLDecoderFactory extends DecoderFactory {
    private static DecoderFactory factory = null;
    private XMLDecoderFactory() {
}
    public static DecoderFactory getFactory() {
        if (factory == null)
            factory = new XMLDecoderFactory();
        return factory;
    }
    public abstract RegistrarClienteDecoder createRegistrarClienteDecoder() {
        return new RegistrarClienteXMLDecoder();
    }
    public abstract RegistrarContaDecoder createRegistrarContaDecoder() {
        return new RegistrarContaXMLDecoder();
    }
}
