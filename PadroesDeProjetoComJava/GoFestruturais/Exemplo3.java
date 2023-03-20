package PadroesDeProjetoComJava.GoFestruturais;

public class Exemplo3 {
}

/*
 public class EncryptedFileWriter extends FileWriter {
 public EncryptedFileWriter(File file) throws IOException {
 super(file);
 }
 
 public void write(String text) throws IOException {
 String encryptedText = encrypt(text);
 super.write(encryptedText); // comanda a gravação em disco via FileWriter
 }
 
 private String encrypt(String text) {
 String result = text;
 // aqui estaria o código para encriptar o texto
 return result;
 }
 }
 */

 /*
  public class CompressedFileWriter extends FileWriter {
  StringBuilder buffer = new StringBuilder();
  
  public CompressedFileWriter(File file) throws IOException {
  super(file);
  }
  public void write(String text) throws IOException {
  buffer.append(text);
  }
  public void close() throws IOException {
  // compacta o conteúdo no instante em que o arquivo vai ser fechado
  char[] compressedBuffer = compress(buffer.toString());
  super.write(compressedBuffer); // comanda a gravação em disco via FileWriter
  super.close();
  }
  private char[] compress(String buffer) {
  // algoritmo de compressão implementado aqui
  // retorna resultado da compressão em um array
  }
  }
  */

  //solução padrão decorator
  public class BufferedWriter extends Writer{
  private Writer out; // elemento que está sendo decorado
  char[] buffer; // área de escrita temporária em memória
  int count; // número de caracteres ocupados na área de escrita temporária
  
  public BufferedWriter(Writer out) throws IOException {
  this.out = out;
  buffer = new char[4096]; // cria uma área temporária de 4K
  }
  public void write(char[] buf, int offset, int len) throws IOException {
  if (count + len > buffer.length) { // se a área a ser escrita não couber mais no buffer
  localFlush(); // descarrega área para disco
  } else {
  System.arraycopy(buf, offset, buffer, count, len); // salva na área temporária
  count += len; // incrementa espaço ocupado
  if (count == buffer.length) // chegou no limite da área temporária?
  localFlush(); // descarrega área para disco
  }
  }
  
  public void flush() throws IOException {
  localFlush();
  out.flush();
  }
  
  protected void localFlush() throws IOException {
  if (buffer.length > 0)
  out.write(buffer, 0, count); // chama operação write do componente decorado
  }
}


