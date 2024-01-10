#language:pt

  Funcionalidade: teste de compra Magazine Luiza
    Cenario: chegar a ultima etapa de compra
      Dado que esteja na pagina inicial "https://www.amazon.com.br/"
      E clicar em pesquisa para pegar produto
      E adicionar ele ao carrinho
      Quando estiver no carrinho acrescentar e retirar produto/quantidade e fechar carrinho
      E criar conta
      Entao verifica se chegou na etapa final da compra
