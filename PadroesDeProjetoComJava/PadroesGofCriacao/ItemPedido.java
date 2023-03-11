package PadroesDeProjetoComJava.PadroesGofCriacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.HashSet;

class ItemPedido {
   
    private String produto;
    private int quantidade;
    private int precoUnitarioEmCentavos;

    public ItemPedido(String produto, int quantidade, int valorEmCentavos) {{
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitarioEmCentavos = valorEmCentavos;
    }}
    
    public int valor() {
        return quantidade * precoUnitarioEmCentavos;
    }
        
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPrecoUnitarioEmCentavos() {
        return precoUnitarioEmCentavos;
    }

    public void setPrecoUnitarioEmCentavos(int precoUnitarioEmCentavos) {
        this.precoUnitarioEmCentavos = precoUnitarioEmCentavos;
    }

    //não recomendado
    /*public void removerItensInvalidos(ArrayList<ItemPedido> itens) {
        ArrayIterator<ItemPedido> cursor = new ArrayIterator(itens);
        while (cursor.hasNext()) {
            ItemPedido item = cursor.next();
            if (! isValido(item)) {
                cursor.remove(item);
            }
        }
    }
    public boolean isValido(ItemPedido item) {
        return (item.getQuantidade() > 0 && item.getQuantidade() < 100);
    
    }
    
     */
    //implementação com HashSet
    /*public void removerItensInvalidos(HashSet< ItemPedido> itens) {
        HashSetIterator<ItemPedido> cursor = new HashSetIterator(itens);
        while (cursor.hasNext()) {
            ItemPedido item = cursor.next();
            if (! isValido(item)) {
                cursor.remove(item);
            }
        }
    }
     */

    //alternativa
    /* public void removerItensInvalidos(Collection<ItemPedido> itens) throws Exception {
        Iterator<ItemPedido> cursor = null;
        if (itens instanceof ArrayList)
            cursor = new ArrayIterator((ArrayList) itens);
        else if (itens instanceof HashSet)
            cursor = new HashSetIterator((HashSet) itens);
        
        if (cursor == null)
            throw new Exception("tipo da coleção de itens inválido");
        
        while (cursor.hasNext()) {
            ItemPedido item = cursor.next();
            if (! isValido(item)) {
                cursor.remove(item);
            }
        }
    }
     */
    //Factory Method
     public void removerItensInvalidos(Collection<ItemPedido> itens) {
        Iterator<ItemPedido> iterator = itens.iterator();
        while (iterator.hasNext()) {
            ItemPedido item = iterator.next();
            if (! isValido(item)) {
                itens.remove(item);
                }
            }
        }
       
     }
    
     
    
