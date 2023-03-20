/*
// Solução de pagamentos do fornecedor XPTO
public class PagXPTO {
public void pagarCartaoVisa (DadosCartao cartao, BigDecimal valor);
public void pagarCartaoMastercard (DadosCartao cartao, BigDecimal valor);
}
// Solução de pagamentos do fornecedor ABC
public class ABCPagamentos {
public void pagarEmCartaoCredito (String numeroCartao, String nome, String CVV, String
validade, BigDecimal valor);
} 
*/

/*
public class ServicoPagamento {
// o parâmetro nomeBroker define a API a ser chamada: XPTO ou ABC
public void pagarCartaoCredito (String nomeBroker, CartaoCredito cartao, BigDecimal valor) {
if (“XPTO”.equals(nomeBroker)) {
pagarCartaoXPTO(cartao, valor);
} else if (“ABC”.equals(nomeBroker)) {
pagarCartaoABC(cartao, valor);
}
}

// chamada à API de pagamento do fornecedor XPTO
private void pagarCartaoXPTO(CartaoCredito cartao, BigDecimal valor) {
PagXPTO brokerPagamento = new PagXPTO();
// converte o parâmetro cartao para a estrutura requerida pela API
DadosCartao dadosCartao = converterCartao(cartao);
// com base no número do cartão, define a função da API a ser chamada
if (isCartaoVisa(cartao)) {
brokerPagamento.pagarCartaoVisa(dadosCartao, valor);
} else {
brokerPagamento.pagarCartaoMastercard(dadosCartao, valor);
}
}

// chamada à API de pagamento do fornecedor ABC
private void pagarCartaoABC(CartaoCredito cartao, BigDecimal valor) {
ABCPagamentos brokerPagamento = new ABCPagamentos();
brokerPagamento.pagarEmCartaoCredito(cartao.numero(), cartao.nome(),
cartao.cvv(), cartao.validade(), valor);
}
} 
*/

//solução adapter
public class Ex1ServicoPagamento {
// o parâmetro BrokerPagamento é um objeto (adapter) que implementa a interface genérica
// BrokerPagamento
public void pagarCartaoCredito (BrokerPagamento broker, CartaoCredito cartao,
BigDecimal valor) {
broker.pagarCartaoCredito(cartao, valor);
}
}

public class BrokerXPTOAdapter implements BrokerPagamento {
public void pagarCartaoCredito(CartaoCredito cartao, BigDecimal valor) {
PagXPTO brokerPagamento = new PagXPTO();
DadosCartao dadosCartao = converterCartao(cartao);
if (isCartaoVisa(cartao)) {
brokerPagamento.pagarCartaoVisa(dadosCartao, valor);
} else {
brokerPagamento.pagarCartaoMastercard(dadosCartao, valor);
}
}
}

public class BrokerABCAdapter implements BrokerPagamento {
public void pagarCartaoCredito(CartaoCredito cartao, BigDecimal valor) {
ABCPagamentos brokerPagamento = new ABCPagamentos();
brokerPagamento.pagarEmCartaoCredito(cartao.numero(), cartao.nome(),
cartao.cvv(), cartao.validade(), valor);
}
}