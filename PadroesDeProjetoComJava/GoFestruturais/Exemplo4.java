package PadroesDeProjetoComJava.GoFestruturais;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exemplo4 {
public static void main(String[] args) {
try (FileWriter writer = new FileWriter("app. log");
BufferedWriter bw = new BufferedWriter(writer); // writer é o objeto base
PrintWriter pw = new PrintWriter(bw)) { // bw é o objeto base

pw.println("Exemplo de uso do decorator");

} catch (IOException e) {
System.err.format("IOException: %s%n", e);
}
}
}

