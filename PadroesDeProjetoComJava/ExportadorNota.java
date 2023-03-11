package PadroesDeProjetoComJava;

class ExportadorNota {  
    private NotaBuilder builder;
    public ExportadorNotaNegociacao(NotaBuilder builder) {
        this.builder = builder;
    }
    public void exportarNota(NotaNegociacao nota) {
        builder.gerarCabecalho(nota);
        builder.gerarItensNota(nota);
        builder.gerarSumario(nota);
    }
}

    public class ComandoExportarNotaPDF {
        public NotaPDF executar(NotaNegociacao nota) {
            NotaPDFBuilder builder = new NotaPDFBuilder();
            ExportadorNota diretor = new ExportadorNota (builder);
            diretor.exportarNota(nota);
            return builder.obterNotaPDF();
        }
    }
    //implementação não recomendada
/*class ExportadorNota { 
  public byte[] exportarNota(NotaNegociacao nota, String formato) {
    if (“XML”.equals(formato))
        return gerarNotaXML(nota);
    else if (“PDF”.equals(formato))
        return gerarNotaPDF(nota);
    else if (“XLS”.equals(formato))
        return gerarNotaXLS(nota);
    }

private byte[] gerarNotaXML(NotaNegociacao nota) {
    // construir cabeçalho em XML
    // listar os itens da nota em XML
    // gerar sumário em XML
    // retornar conteúdo da nota no formato XML
}

private byte[] gerarNotaPDF(NotaNegociacao nota) {
    // construir cabeçalho em PDF
    // listar os itens da nota em PDF
    // gerar sumário em PDF
    // retornar conteúdo da nota no formato PDF
}

private byte[] gerarNotaXLS(NotaNegociacao nota) {
    // construir cabeçalho em XLS
    // listar os itens da nota em XLS
    // gerar sumário em XLS
    // retornar conteúdo da nota no formato XLS
}
}
 */
  
    