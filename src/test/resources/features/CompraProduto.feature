#language:pt

  Funcionalidade: teste de compra Magazine Luiza
    Cenario: chegar a ultima etapa de compra
      Dado que esteja na pagina inicial "https://www.amazon.com.br/"
      E clicar em pesquisa para pegar produto
      E adicionar ele ao carrinho
      Quando estiver no carrinho acrescentar e retirar produto/quantidade
      E clicar em finalizar a conta indo para a tela de acesso
      E criar conta usando email
      E concluir as etapas de criacao
      E endereco de entrega
      E dados do cartao
      Entao verifica se chegou na etapa final da compra
