/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import Persistencia.Banco;
import java.sql.ResultSet;
/**
 *
 * @author Pedro
 */
public class Consulta {
    private ResultSet rst;
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
    private Banco banco = new Banco();
    
    public ResultSet logar(String usuarioInserido,String senhaInserida){ 
        this.getBanco().conectarAoBanco();
        this.getBanco().setRst(getBanco().consulta("SELECT usuario,senha,nomeCompleto,permissao FROM usuario WHERE usuario='"+usuarioInserido+"' AND senha='"+senhaInserida+"';"));
        try{
            this.getBanco().getRst().last();
            if(this.getBanco().getRst().getRow()>=0){
                this.getBanco().getRst().beforeFirst();
                return this.getBanco().getRst();
            }
            else{
                return null;
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Usuário ou senha incorreto(s)!");
            return null;
        }
    }
    
}
