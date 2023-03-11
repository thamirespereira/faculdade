package PadroesDeProjetoComJava;

import PadroesDeProjetoComJava.PadroesGofCriacao.RegistrarClienteXMLDecoder;

public class ServicoIntegracao {
        /*public void registrarCliente (String textoMsg, String origem) {
            RegistrarClienteDecoder msgDecoder = null;
            
            if (“X”.equals(origem)) {
                msgDecoder = new RegistrarClienteXMLDecoder();
            } else if ("Y".equals(origem)) {
                msgDecoder = new RegistrarClienteCSVDecoder();
            } else if ("Z".equals(origem)) {
                msgDecoder = new RegistrarClienteTextoFixoDecoder();
            }
            MsgRegistrarCliente msg = msgDecoder.decode(textoMsg);
            ...
            // código para o tratamento da mensagem recebida
            }
            
            public void registrarConta (String textoMsg, String origem) {
                RegistrarContaDecoder msgDecoder = null;
            
            if (“X”.equals(origem)) {
                msgDecoder = new RegistrarContaXMLDecoder();
            } else if ("Y".equals(origem)) {
                msgDecoder = new RegistrarContaCSVDecoder();
            } else if ("Z".equals(origem)) {
                msgDecoder = new RegistrarContaTextoFixoDecoder();
            }
            MsgRegistrarConta msg = msgDecoder.decode(textoMsg);
            ...
            // código para o tratamento da mensagem recebida
            }
            ... // operações para recepção e tratamento das demais mensagens
         
         */
    
        public void registrarCliente (String textoMsg, String origem) {
            DecoderFactory decoderFactory = DecoderFactory.fabricaParaOrigem(origem);
            RegistrarClienteDecoder msgDecoder = decoderFactory.createRegistrarClienteDecoder();
            MsgRegistrarCliente msg = msgDecoder.decode(textoMsg);
            ...
            // código para tratamento da mensagem MsgRegistrarCliente
        }
            
        public void registrarConta (String textoMsg, String origem) {
            DecoderFactory decoderFactory = DecoderFactory.fabricaParaOrigem(origem);
            RegistrarContaDecoder msgDecoder = decoderFactory.createRegistrarContaDecoder();
            MsgRegistrarConta msg = msgDecoder.decode(textoMsg);
            
            // código para tratamento da mensagem MsgRegistrarConta
            }
            
            // código para demais mensagens
        
        }
        public abstract class DecoderFactory {
            public abstract RegistrarClienteDecoder createRegistrarClienteDecoder();
            public abstract RegistrarContaDecoder createRegistrarContaDecoder();
        
            public static DecoderFactory fabricaParaOrigem(String origem) {
                if (“X”.equals(origem)) {
                    return new XMLDecoderFactory();
                } else if ("Y".equals(origem)) {
                    return new CSVDecoderFactory();
                } else if ("Z".equals(origem)) {
                    return new TextoFixoDecoderFactory();
                }
            }
        }
        
        public class XMLDecoderFactory extends DecoderFactory {
            public RegistrarClienteDecoder createRegistrarClienteDecoder() {
                return new RegistrarClienteXMLDecoder();
             }
            public RegistrarContaDecoder createRegistrarContaDecoder() {
                return new RegistrarContaXMLDecoder();
            }
        }
        
        public class CSVDecoderFactory extends DecoderFactory {
            public RegistrarClienteDecoder createRegistrarClienteDecoder() {
                return new RegistrarClienteCSVDecoder();
            }
            public RegistrarContaDecoder createRegistrarContaDecoder() {
                return new RegistrarContaCSVDecoder();
            }
        }
    
    
