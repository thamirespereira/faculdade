package PadroesDeProjetoComJava.PadroesGofCriacao.GoFestruturais;

public class Exemplo5 {
    
}
/*
public class ServicoMensagem {
public void apagar(Object elemento) {
if (elemento instanceof Mensagem)
apagarMensagem((Mensagem) elemento);
else if (elemento instanceof Pasta)
apagarPasta((Pasta) elemento);
}
private void apagarMensagem(Mensagem mensagem) {
// lógica para apagar a mensagem
}
private void apagarPasta(Pasta pasta) {
// lógica para apagar a pasta
// que replicaria a lógica condicional da operação apagar
// pois uma pasta pode conter mensagens e pastas
}
} 
*/

//solução do padrão composite
public abstract class Elemento {
public void adicionar(Elemento elem) { }
public void remover(Elemento elem) { }
public abstract void apagar();
public abstract void criptografar();
}

public class Mensagem extends Elemento {
public void apagar() {
// lógica para apagar a mensagem
}
public void criptografar() {
// lógica para criptografar a mensagem
}
}

public class Pasta extends Elemento {
private List filhos = new ArrayList<>();
public void adicionar(Elemento elem) {
filhos.add(elem);
}
public void remover(Elemento elem) {
filhos.remove(elem);
}
public void apagar() {
for (Elemento elemento : filhos) // apaga todos os filhos
elemento.apagar();
// lógica adicional para apagar a pasta
}
public void criptografar() {
for (Elemento elemento : filhos) // criptografa todos os filhos
elemento.criptografar();
// lógica adicional para criptografar a pasta
}
public class ServicoMensagem {
public void apagar(Elemento elemento) {
// código adicional de tratamento da requisição ficaria aqui
elemento.apagar(); // apaga o elemento: pode ser uma mensagem ou uma pasta
}
public void criptografar(Elemento elemento) {
// código adicional de tratamento da requisição ficaria aqui
elemento.criptografar(); // criptografa o elemento: pode ser uma mensagem ou uma pasta
}
}
}