/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Persistencia.Banco;
import java.sql.ResultSet;

/**
 *
 * @author Pedro
 */
public class Usuario {
    
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
    
    public void alterarUsuario(int codigo,String nome,String usuario,String senha,String permissao,String observacao){
        this.getBanco().conectarAoBanco();
        int permissaoAlt;
        if(permissao=="Administrador"){
            permissaoAlt=1;
        }
        else{
            permissaoAlt=0;
        }
        String query = "UPDATE usuario SET nomeCompleto = '"+nome+"', usuario = '"+usuario+"', senha = '"+senha+"'"
                + ", permissao = '"+permissaoAlt+"', observacao = '"+observacao+"' WHERE idusuario = "+codigo+";";
        this.getBanco().query(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public void removerUsuario(int codigo){
        this.getBanco().conectarAoBanco();
        String query = "DELETE FROM usuario WHERE idusuario = "+codigo+";";
        this.getBanco().query(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public void adicionarUsuario(String nome, String usuario, String senha, String permissao, String observacao){
        this.getBanco().conectarAoBanco();
        int permissaoAdd;
        if(permissao.equals("Administrador")){
           permissaoAdd=1;
        }
        else{
            permissaoAdd=0;
        }
        String query = "INSERT INTO usuario (nomeCompleto, usuario, senha, permissao, observacao, dataCadastro) VALUES ('"+nome+"','"+usuario+"','"+senha+"','"+permissaoAdd+"','"+observacao+"',"+"NOW());";
        this.getBanco().query(query);
        this.getBanco().desconectarDoBanco();
    }
    
    public ResultSet listarUsuarios(){
        this.getBanco().conectarAoBanco();
        String query = "SELECT * FROM usuario;";
        return this.getBanco().consulta(query);
        //this.getBanco().desconectarDoBanco();
    }
    
    public ResultSet buscarUsuario(String nome, int codigo){
        this.getBanco().conectarAoBanco();
        String query;
        if(!nome.equals("null")){
            query = "SELECT * FROM usuario WHERE nomeCompleto LIKE '"+nome+"%';";
        }
        else{
            query = "SELECT * FROM usuario WHERE idusuario = "+codigo+";";
        }
        return this.getBanco().consulta(query);
        //this.getBanco().desconectarDoBanco();
    }
    
}
