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
public class Inicializacao {
    private Banco banco=new Banco();
    private ResultSet rst;
    
    public Inicializacao(String usuario){
        vendaUsuario(usuario);
    }
    
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

    /**
     * @return the rst
     */
    public ResultSet getRst() {
        return rst;
    }

    /**
     * @param rst the rst to set
     */
    public void setRst(ResultSet rst) {
        this.rst = rst;
    }
    
    public ResultSet vendaUsuario(String usuario){
        this.getBanco().conectarAoBanco();
        String query = "SELECT count(idVenda) FROM venda WHERE date(data) = date(NOW()) AND idVenda >= 0 ORDER BY idVenda DESC LIMIT 1;";
        this.setRst(this.getBanco().consulta(query));
        //this.getBanco().desconectarDoBanco();
        return this.getRst();
    }
}
