package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Builder
@Getter
@Setter
public class Produto {
    private long id;
    private String codigoEan;
    private String descricao;
    private String marca;
    private String modelo;
    private double preco;
    private final LocalDate dataCadastro = LocalDate.now();
    private LocalDate dataUltimaAtualizacao;
    private int estoque = 0;
    private String categoria;
    private String urlFoto;

    public Produto(long id, String codigoEan, String descricao, String marca, String modelo, double preco, LocalDate dataUltimaAtualizacao, int estoque, String categoria, String urlFoto) {
        if (descricao == null || marca == null || preco <= 0 || estoque < 0 || categoria == null) {
            throw new IllegalArgumentException("Os atributos obrigatórios não podem ser null ou inválidos.");
        }
        if (modelo != null && marca == null) {
            throw new IllegalArgumentException("Modelo não pode ser informado sem a marca.");
        }
        if (dataUltimaAtualizacao != null && dataUltimaAtualizacao.isBefore(dataCadastro)) {
            throw new IllegalArgumentException("Data da última atualização não pode ser anterior à data de cadastro.");
        }
        this.id = id;
        this.codigoEan = codigoEan;
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.dataUltimaAtualizacao = Optional.ofNullable(dataUltimaAtualizacao).orElse(LocalDate.now());
        this.estoque = estoque;
        this.categoria = categoria;
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "CodigoEan: " + codigoEan + "\n" +
                "Descrição: " + descricao + "\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Preço: " + preco + "\n" +
                "Data de Cadastro: " + dataCadastro + "\n" +
                "Data de Última Atualização: " + dataUltimaAtualizacao + "\n" +
                "Estoque: " + estoque + "\n" +
                "Categoria: " + categoria + "\n" +
                "URL da Foto: " + urlFoto;
    }
}
