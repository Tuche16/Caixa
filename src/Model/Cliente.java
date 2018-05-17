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
public class Cliente {
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
    
    public void alterarCliente(int codigo,String nome,String cpf,String endereco,String tel,String outros){
        this.getBanco().conectarAoBanco();
        String query = "UPDATE cliente SET nome = '"+nome+"', cpf = '"+cpf+"', endereco = '"+endereco+"'"
                + ", tel = '"+tel+"', outros = '"+outros+"' WHERE idCliente = "+codigo+";";
        this.getBanco().query(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public void removerCliente(int codigo){
        this.getBanco().conectarAoBanco();
        String query = "DELETE FROM cliente WHERE idCliente = "+codigo+";";
        this.getBanco().query(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public void adicionarCliente(String nome, String cpf, String endereco, String tel, String outros){
        this.getBanco().conectarAoBanco();
        String query = "INSERT INTO cliente (nome, cpf, endereco, tel, dataCadastro, outros) VALUES ('"+nome+"','"+cpf+"','"+endereco+"','"+tel+"',NOW(),'"+outros+"');";
        this.getBanco().query(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public ResultSet listarClientes(){
        this.getBanco().conectarAoBanco();
        String query = "SELECT * FROM cliente;";
        return this.getBanco().consulta(query);
        //this.getBanco().desconectarDoBanco();
    }
    
    public boolean cpfExistente(String cpf){
        this.getBanco().conectarAoBanco();
        String query="SELECT * FROM cliente WHERE cpf='"+cpf+"';";
        this.rst=this.getBanco().consulta(query);
        try{
            rst.last();
            return rst.getRow()>=1;
        }
        catch(SQLException e){}
        
        return false;
    }
    
    public ResultSet buscarCliente(String nome, int codigo){
        this.getBanco().conectarAoBanco();
        String query;
        if(!nome.equals("null")){
            query = "SELECT * FROM cliente WHERE nome LIKE '"+nome+"%';";
        }
        else{
            query = "SELECT * FROM cliente WHERE idCliente = "+codigo+";";
        }
        return this.getBanco().consulta(query);
        //this.getBanco().desconectarDoBanco();
    }
    
}
