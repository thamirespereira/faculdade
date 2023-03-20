package PadroesDeProjetoComJava.GoFestruturais;

public class Exemplo7 {
    
}
/*
public class ModuloCliente {
private ServicoConta session; // referência para o objeto remoto
private static final Class homeClazz = ServicoContaHome.class;

public void executarTransferencia(Transferencia transf) throws ServicoContaException {
try {
ServicoContaHome home = (ServicoContaHome) getHome("ServicoConta", homeClazz);
session = home.create();
session.executarTransferencia(transf); // chamada delegada ao objeto real
} catch (Exception ex) {
throw new ServicoContaException(ex);
}
}
public EJBHome getHome(String name, Class clazz) throws NamingException {
Object objref = context.lookup(name);
EJBHome home = (EJBHome) PortableRemoteObject.narrow(objref, clazz);
return home;
}
}
 */

 //solução proxy
 public interface ServicoContaDelegate {
 void executarTransferencia(Transferencia tranf) throws ServicoContaException;
 }
 
 public class ServicoContaProxyEJB implements ServicoContaDelegate {
 private ServicoConta session; // referência para o objeto remoto
 private static final Class homeClazz = ServicoContaHome.class;
 
 public void executarTransferencia(Transferencia transf) throws ServicoContaException {
 try {
 session = getSession(homeClazz); // conexão com o objeto remoto
 session.executarTransferencia(transf); // chamada delegada ao objeto real
 } catch (Exception ex) {
 throw new ServicoContaException(ex);
 }
 }
 public ServicoConta getSession(Class homeClazz) throws ServicoContaException {
 try {
 ServicoContaHome home = (ServicoContaHome) getHome("ServicoConta", homeClazz);
 session = home.create();
 } catch (Exception ex) {
 throw new ServicoContaException(ex);
 }
 }
 
 public EJBHome getHome(String name, Class clazz) throws NamingException {
 Object objref = context.lookup(name);
 EJBHome home = (EJBHome) PortableRemoteObject.narrow(objref, clazz);
 return home;
 }
 }

 public class ModuloCliente {
 private ServicoContaDelegate servicoConta;
 public ModuloCliente(ServicoContaDelegate servicoConta) {
 this.servicoConta = servicoConta;
 }
 
 public void executarTransferencia(Transferencia transf) {
 try {
 servicoConta.executarTransferencia(transf);
 } catch (ServicoContaException ex) {
 // apresenta mensagem de erro
 }
 }
 }

