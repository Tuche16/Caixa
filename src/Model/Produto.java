/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Persistencia.Banco;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;

/**
 *
 * @author Pedro
 */
public class Produto {
    
    private Banco banco = new Banco();
    /**
     * @return the banco
     */
    public Banco getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
    public void alterarProduto(int codigo,String nome, int idFornecedor,float valorUnit,float quantidade,String tipo,String descricao){
        this.getBanco().conectarAoBanco();
        String query = "UPDATE produto SET nome = '"+nome+"',idFornecedor = "+idFornecedor+", valorUnit = "+valorUnit+", quantidade = "+quantidade+""
                + ", tipo = '"+tipo+"', descricao = '"+descricao+"' WHERE idproduto = "+codigo+";";
        this.getBanco().query(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public void removerProduto(int codigo){
        this.getBanco().conectarAoBanco();
        String query = "DELETE FROM produto WHERE idproduto = "+codigo+";";
        this.getBanco().query(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public void adicionarProduto(String nome, int idFornecedor, float preco, float quantidade, String tipo, String descricao,FileInputStream fis){
        this.getBanco().conectarAoBanco();
        String query = "INSERT INTO produto (nome, idFornecedor, valorUnit, quantidade, entrada, tipo, descricao, imagem) VALUES ('"+nome+"',"+idFornecedor+","+preco+","+quantidade+",NOW(),'"+tipo+"','"+descricao+"','"+fis+"');";
        this.getBanco().query(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public ResultSet listarProdutos(){
        this.getBanco().conectarAoBanco();
        String query = "SELECT * FROM produto;";
        return this.getBanco().consulta(query);
        //this.getBanco().desconectarDoBanco();
    }
    
    public ResultSet buscarProduto(String nome, int codigo){
        this.getBanco().conectarAoBanco();
        String query;
        if(!nome.equals("null")){
            query = "SELECT * FROM produto WHERE nome LIKE '"+nome+"%';";
        }
        else{
            query = "SELECT * FROM produto WHERE idproduto = "+codigo+";";
        }
        return this.getBanco().consulta(query);
        //this.getBanco().desconectarDoBanco();
    }
    
}
