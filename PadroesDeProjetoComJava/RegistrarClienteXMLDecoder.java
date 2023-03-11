package PadroesDeProjetoComJava;

public RegistrarClienteDecoder createRegistrarClienteDecoder() {
    HashMap<String, MsgRegistrarCliente>prototypes;
    prototypes.put(“X”, new MsgRegistrarCliente_X());
    prototypes.put(“Y”, new MsgRegistrarCliente_Y());
    prototypes.put(“Z”, new MsgRegistrarCliente_Z());

    return new RegistrarClienteXMLDecoder(prototypes);
}

public class RegistrarClienteXMLDecoder {
    private HashMap<String, MsgRegistrarCliente> prototypes;

    public RegistrarClienteXMLDecoder(HashMap<String, MsgRegistrarCliente>prototypes) {
        this.prototypes = prototypes;
    }

    public MsgRegistrarCliente decode(String textoMsg, String origem) {
        MsgRegistrarCliente prototype = prototypes.get(origem);

        MsgRegistrarCliente msg = (MsgRegistrarCliente) prototype.clone();

        // … aqui viria o código de decodificação e preenchimento dos atributos
        // do objeto MsgRegistrarCliente
        return msg;
    }
}
//implementação inadequada
/*
public class RegistrarClienteXMLDecoder {
    public MsgRegistrarCliente decode(String textoMsg, String origem) {
        MsgRegistrarCliente msg;
        if (“X”.equals(origem)) {
            msg = new MsgRegistrarCliente_X();
        else if (“Y”.equals(origem)) {
            msg = new MsgRegistrarCliente_Y();
        else if (“Z”.equals(origem)) {
            msg = new MsgRegistrarCliente_Z();
        }
        // … aqui viria o código de decodificação e preenchimento dos atributos
        // do objeto MsgRegistrarCliente
        return msg;
    }
} 
*/
