# automacaoTxT-java

## Introdução

O projeto **automacaoTxT** tem como objetivo exemplificar o processo de integração de uma automação comercial com o PayGo Windows.  
Este projeto foi desenvolvido utilizando o **NetBeans IDE 25**.

## Getting Started

### Pré-requisitos

Para rodar este projeto, você precisará de:

- Java 24
- Criar a pasta `"COMPROVANTE"` no diretório `C:\`
- Configuração do arquivo `pom.xml` com os seguintes parâmetros:

```xml
<configuration>
    <source>24</source>
    <target>24</target>
    <compilerArgs>
        <arg>--enable-preview</arg>
    </compilerArgs>
</configuration>
```

### Instalação
Siga os passos abaixo para instalar o projeto:
1. Clone o repositório:
```bash
   git clone <URL_DO_REPOSITORIO>
```

### Como Usar
Para executar o programa:
1. No campo "VALOR TOTAL (003-000)", insira o valor da venda para a operação de venda simples.
2. Verifique os dados utilizados com base na documentação e corrija qualquer campo problemático:  
   [Documentação Web](https://paygodev.readme.io/docs/detalhamento-dos-campos)
3. Use os seguintes botões para realizar as respectivas ações:
   - **VENDA**: Realiza uma venda simples, onde o usúario informa apenas o valor.
   - **PRÉ-SELEÇÃO DE PARÂMETROS**: Abre uma nova janela onde é possível pré-selecionar cada parâmetro da requisição.
   - **EFETUAR TRANSAÇÃO**: Envia a requisição com os parâmetros previamente selecionados.
   - **HISTÓRICO DE VENDAS**: Abre um bloco de notas contendo todos os comprovantes das vendas realizadas no dia.
4. Os botões "VENDA" e "PRÉ-SELEÇÃO DE PARÂMETROS" são desabilitados ao clicar no botão de "PRÉ-SELEÇÃO DE PARÂMETROS". Para reabilitá-los, conclua a requisição de pré-seleção ou feche a janela correspondente.
