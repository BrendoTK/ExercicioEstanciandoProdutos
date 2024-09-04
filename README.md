# Instanciando Produtos

Para tornar o processo de instanciação da classe `Produto` mais fácil e claro, dado que há dependências entre diferentes atributos e alguns atributos são obrigatórios, o padrão de projeto mais apropriado é o **Builder**. Esse padrão permite a construção de um objeto de forma incremental e flexível, garantindo que todos os requisitos sejam atendidos antes da criação final do objeto. Vamos detalhar por que o padrão Builder é adequado e como ele foi implementado na classe `Produto`.

# Justificativa para o Uso do Padrão Builder

## 1. Gerenciamento de Atributos Obrigatórios e Opcionais

O padrão Builder facilita a definição de atributos obrigatórios e opcionais. Ele permite a construção do objeto passo a passo, assegurando que todos os atributos obrigatórios sejam fornecidos e possibilitando a configuração dos atributos opcionais de forma clara.

## 2. Validações e Regras de Negócio

O padrão Builder pode incorporar validações e regras de negócio durante o processo de construção. Isso é importante para garantir que o objeto criado atenda a todas as regras definidas, como evitar a definição de um modelo sem uma marca e garantir que a data da última atualização não seja anterior à data de cadastro.

## 3. Imutabilidade e Consistência

O padrão Builder ajuda a manter a imutabilidade dos objetos, uma vez que a construção do objeto é realizada em um estado intermediário até que todos os requisitos sejam atendidos. Isso ajuda a garantir a consistência e a integridade dos dados.

# Implementação do Padrão Builder

A classe `Produto` foi implementada utilizando o padrão Builder da seguinte maneira:

## Classe `Produto`

- A classe `Produto` define um construtor padrão usando a anotação `@Builder` do Lombok, que facilita a criação do objeto `Produto` com atributos definidos pelo usuário.
- O construtor customizado foi mantido para realizar validações adicionais, garantindo que todos os requisitos de negócio sejam atendidos. No entanto, o padrão Builder cuida da construção e da validação de atributos durante o processo de construção.

## Classe `Principal`

- A classe `Principal` demonstra a utilização do padrão Builder para criar instâncias de `Produto`, mostrando como os objetos podem ser criados de forma flexível e clara com o Builder, e como as exceções são tratadas.
