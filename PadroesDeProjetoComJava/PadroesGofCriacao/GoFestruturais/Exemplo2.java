public class Exemplo2{

}
//padrão bridge
public class TextArea extends TextComponent {
public void insert (String str, int pos) {
insertText (str, pos);
}
public void insertText (String str, int pos) {
// insere o texto na posição indicada
String tmp1 = getText().substring(0, pos);
String tmp2 = getText().substring(pos, getText().length());
// chama o método setText da superclasse para atualizar o novo conteúdo
setText (tmp1 + str + tmp2);
// obtém o elemento peer associado específico de plataforma
TextAreaPeer peer = (TextAreaPeer) super.getPeer();
// chama a operação do componente peer para renderizar o texto na plataforma alvo
if (peer != null) {
peer.insert(str, pos);
}
}
}

// classe TextArea na plataforma alvo Windows
public class WTextAreaPeer implements TextAreaPeer {
public void insert(String text, int pos) {
replaceRange(text, pos, pos);
}

// código nativo específico da plataforma Windows
public native void replaceRange(String text, int start, int end);
}