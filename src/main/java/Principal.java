import org.example.Produto;
import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        try {
            // Criando uma instância de Produto com o padrão Builder
            Produto produto = Produto.builder()
                    .id(1L)
                    .codigoEan("1234567890123")
                    .descricao("Produto Exemplo")
                    .marca("Marca Exemplo")
                    .modelo("Modelo Exemplo")
                    .preco(199.99)
                    .categoria("Categoria Exemplo")
                    .dataUltimaAtualizacao(LocalDate.now())
                    .urlFoto("http://example.com/foto.jpg")
                    .build();

            // Exibindo informações do produto
            System.out.println(produto);

            // Criando uma instância de Produto com estoque padrão
            Produto produtoComEstoquePadrao = Produto.builder()
                    .id(2L)
                    .codigoEan("9876543210987")
                    .descricao("Produto com Estoque Padrão")
                    .marca("Outra Marca")
                    .preco(299.99)
                    .categoria("Categoria Padrão")  // Adicionado o atributo obrigatório
                    .build();

            // Exibindo informações do produto com estoque padrão
            System.out.println(produtoComEstoquePadrao);

            // Tentando criar um produto com data de atualização anterior à data de cadastro
            Produto produtoComDataInvalida = Produto.builder()
                    .id(3L)
                    .codigoEan("1112223334445")
                    .descricao("Produto com Data Inválida")
                    .marca("Marca Inválida")
                    .preco(399.99)
                    .dataUltimaAtualizacao(LocalDate.of(2022, 1, 1))  // Isso vai lançar uma exceção
                    .build();

        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar produto: " + e.getMessage());
        }
    }
}
