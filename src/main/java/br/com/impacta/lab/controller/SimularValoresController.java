package br.com.impacta.lab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simular")
public class SimularValoresController {

	@GetMapping
	public ResponseEntity<String> simularValores(@RequestParam(name="codigoProduto") int codigoProduto,
			@RequestParam(name="codTipoPagamento") int codTipoPagamento) {
		
				//Definição das variáveis que serão utilizadas no final
				String descProduto = "";
				String descCondicaoPagto = "";

				//Definição da variavel para guardar o valor do produto
				double valorProduto = 0;
				
				//Cadeia de if para identificar o produto pelo codigo
				if (codigoProduto == 1) {
					//atribui a desc do produto
					descProduto = "Camisa";
					//atribui valor do produto
					valorProduto = 70.00;
				} else if (codigoProduto == 2) {
					descProduto = "Shorts";
					valorProduto = 57.50;
				} else if (codigoProduto == 3) {
					descProduto = "Meia";
					valorProduto = 9.99;
				}  else if (codigoProduto == 4) {
					descProduto = "Toca";
					valorProduto = 35.00;
				} else {
					descProduto = "Luvas";
					valorProduto = 19.50;
				}

				//Definição da variavel que sera guardado o valor final
				double valorFinal = 0;

				//Cadeia de if para identificar o tipo de pagamento
				if (codTipoPagamento == 1) {
					//Atribui a descrição do tipo de pagamento
					descCondicaoPagto = "A vista no dinheiro com 10% de desconto";

					//Faz o calculo de subtrair 10% do valor do produto para chegar ao valor final
					valorFinal = valorProduto - (10 * valorProduto / 100);
				} else if (codTipoPagamento == 2) {
					//Atribui a descrição do tipo de pagamento
					descCondicaoPagto = "A vista no cartão de crédito com 5% de desconto";

					//Faz o calculo de subtrair 5% do valor do produto para chegar ao valor final
					valorFinal = valorProduto - (5 * valorProduto / 100);
				} else if (codTipoPagamento == 3) {
					//Atribui a descrição do tipo de pagamento
					descCondicaoPagto = "Em duas parcelas sem nenhum desconto";

					//Atribui o valor do produto a variavel valor Final
					valorFinal = valorProduto;
				} else {
					//Atribui a descrição do tipo de pagamento
					descCondicaoPagto = "Em três vezes com 10% de juros";

					//Faz o calculo de somar 10% do valor do produto para chegar ao valor final
					valorFinal = valorProduto + (10 * valorProduto / 100);
				}

				return ResponseEntity.ok(descProduto + " sendo pago " + descCondicaoPagto + " custará " + valorFinal +  " reais");
	}
	
}
