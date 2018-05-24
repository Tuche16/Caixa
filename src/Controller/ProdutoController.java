/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Produto;
import java.io.FileInputStream;
import java.sql.ResultSet;
/**
 *
 * @author Pedro
 */
public class ProdutoController {

    private Produto produto = new Produto();
    
    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void alterarProduto(int codigo,String nome,int idFornecedor, float valorUnit,float quantidade,String tipo,String descricao){
        this.getProduto().alterarProduto(codigo, nome, idFornecedor, valorUnit, quantidade, tipo, descricao);
    }
    
    public void removerProduto(int codigo){
        this.getProduto().removerProduto(codigo);
    }
    
    public void adicionarProduto(String nome,int idFornecedor, float preco, float quantidade, String tipo, String descricao,FileInputStream fis){
        this.getProduto().adicionarProduto(nome, idFornecedor, preco, quantidade, tipo, descricao,fis);
    }
    
    public ResultSet listarProdutos(){
        return this.getProduto().listarProdutos();
    }
    
    public ResultSet buscarProduto(String nome, int codigo){
        return this.getProduto().buscarProduto(nome, codigo);
    }
    
}
