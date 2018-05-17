/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Persistencia.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class Fornecedor {
    private ResultSet rst;
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
    
    public void alterarFornecedor(int codigo,String razaoSocial,String cnpj,String endereco,String tel,String outros){
        this.getBanco().conectarAoBanco();
        String query = "UPDATE fornecedor SET razaoSocial = '"+razaoSocial+"', cnpj = '"+cnpj+"', endereco = '"+endereco+"'"
                + ", tel = '"+tel+"', outros = '"+outros+"' WHERE idFornecedor = "+codigo+";";
        this.getBanco().query(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public void removerFornecedor(int codigo){
        this.getBanco().conectarAoBanco();
        String query = "DELETE FROM fornecedor WHERE idFornecedor = "+codigo+";";
        this.getBanco().query(query);
        System.out.println(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public void adicionarFornecedor(String razaoSocial, String cnpj, String endereco, String tel, String outros){
        this.getBanco().conectarAoBanco();
        String query = "INSERT INTO fornecedor (razaoSocial, cnpj, endereco, tel, dataCadastro, outros) VALUES ('"+razaoSocial+"','"+cnpj+"','"+endereco+"','"+tel+"',NOW(),'"+outros+"');";
        this.getBanco().query(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public ResultSet listarFornecedores(){
        this.getBanco().conectarAoBanco();
        String query = "SELECT * FROM fornecedor;";
        return this.getBanco().consulta(query);
        //this.getBanco().desconectarDoBanco();
    }
    
    public boolean cnpjExistente(String cnpj){
        this.getBanco().conectarAoBanco();
        String query="SELECT * FROM fornecedor WHERE cnpj='"+cnpj+"';";
        this.rst=this.getBanco().consulta(query);
        try{
            rst.last();
            return rst.getRow()>=1;
        }
        catch(SQLException e){}
        
        return false;
    }
    
    public ResultSet buscarFornecedor(String razaoSocial, int codigo){
        this.getBanco().conectarAoBanco();
        String query;
        if(!razaoSocial.equals("null")){
            query = "SELECT * FROM fornecedor WHERE razaoSocial LIKE '"+razaoSocial+"%';";
        }
        else{
            query = "SELECT * FROM fornecedor WHERE idFornecedor = "+codigo+";";
        }
        return this.getBanco().consulta(query);
        //this.getBanco().desconectarDoBanco();
    }
    
}
