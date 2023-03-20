package PadroesDeProjetoComJava.PadroesGofCriacao.GoFestruturais;

public class Exemplo6 {
    
}
/*
public class ElementoQuimico {
private String simbolo;
private String nome;

public ElementoQuimico(String simbolo, String nome) {
this.simbolo = simbolo;
this.nome = nome;
}
// getters e setters omitidos
}

public abstract class Substancia {
private String nome;
public Substancia(String nome) {
this.nome = nome;
}
// getters e setters omitidos
}

public class SubstanciaSimples extends Substancia {
private int atomos;
private ElementoQuimico elemento;

public SubstanciaSimples(String nome, ElementoQuimico elemento, int atomos) {
super(nome);
this.atomos = atomos;
this.elemento = elemento;
}
// getters e setters omitidos
}

public class SubstanciaComposta extends Substancia {
// Conjunto de elementos químicos e respectivas quantidades de átomos
private Map<ElementoQuimico, Integer> composicao;

public SubstanciaComposta(String nome, Map<ElementoQuimico, Integer> composicao) {
super(nome);
this.composicao = composicao;
}

// getters e setters omitidos
} 
*/

/*
public class Exemplo {
public static void main(String[] args) {
SubstanciaSimples s1 = new SubstanciaSimples("Oxigênio",
new ElementoQuimico("O", "Oxigênio"), 2);
SubstanciaSimples s2 = new SubstanciaSimples("Ozônio",
new ElementoQuimico("O", "Oxigênio"), 3);

Map<ElementoQuimico, Integer> composicaoAgua = new HashMap<>();
composicaoAgua.put(new ElementoQuimico("H", "Hidrogênio"), 2);
composicaoAgua.put(new ElementoQuimico("O", "Oxigênio"), 1);

SubstanciaComposta s3 = new SubstanciaComposta("Agua", composicaoAgua);
}
} 
*/

//padrão flyweight
public class ElementoQuimicoFactory {
private Map<String, ElementoQuimico> elementos;

public ElementoQuimico criarElemento(String simbolo, String nome) {
ElementoQuimico elemento = elementos.get(simbolo);
if (elemento == null) {
elemento = new ElementoQuimico(simbolo, nome);
elementos.put(simbolo, elemento);
}
return elemento;
}
}

public class ElementoQuimico {
private String simbolo;
private String nome;

ElementoQuimico(String simbolo, String nome) {
this.simbolo = simbolo;
this.nome = nome;
}
// getters e setters omitidos
}

public class ElementoQuimicoFactory {
private Map<String, ElementoQuimico> elementos;

public ElementoQuimico criarElemento(String simbolo, String nome) {
ElementoQuimico elemento = elementos.get(simbolo);
if (elemento == null) {
elemento = new ElementoQuimico(simbolo, nome);
elementos.put(simbolo, elemento);
}
return elemento;
}
}

public class ElementoQuimico {
private String simbolo;
private String nome;

ElementoQuimico(String simbolo, String nome) {
this.simbolo = simbolo;
this.nome = nome;
}
// getters e setters omitidos
}

public class Exemplo {
public static void main(String[] args) {
ElementoQuimicoFactory factory = new ElementoQuimicoFactory();
SubstanciaSimples s1 = new SubstanciaSimples("Oxigênio",
factory.criarElemento("O", "Oxigênio"), 2);
SubstanciaSimples s2 = new SubstanciaSimples("Ozônio",
factory.criarElemento("O", "Oxigênio"), 3);

Map<ElementoQuimico, Integer> composicaoAgua = new HashMap<>();
composicaoAgua.put(factory.criarElemento("H", "Hidrogenio"), 2);
composicaoAgua.put(factory.criarElemento("O", "Oxigênio"), 1);

SubstanciaComposta s3 = new SubstanciaComposta("Agua", composicaoAgua);
}
}