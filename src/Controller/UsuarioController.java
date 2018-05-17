/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Usuario;
import java.sql.ResultSet;
/**
 *
 * @author Pedro
 */
public class UsuarioController {

    private Usuario usuario = new Usuario();
    
    /**
     * @return the produto
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param produto the produto to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void alterarUsuario(int codigo,String razaoSocial,String cnpj,String endereco,String tel,String outros){
        this.getUsuario().alterarUsuario(codigo, razaoSocial, cnpj, endereco, tel, outros);
    }
    
    public void removerUsuario(int codigo){
        this.getUsuario().removerUsuario(codigo);
    }
    
    public void adicionarUsuario(String razaoSocial, String cnpj, String endereco, String tel, String outros){
        this.getUsuario().adicionarUsuario(razaoSocial, cnpj, endereco, tel, outros);
    }
    
    public ResultSet listarUsuarios(){
        return this.getUsuario().listarUsuarios();
    }
    
    public ResultSet buscarUsuario(String razaoSocial, int codigo){
        return this.getUsuario().buscarUsuario(razaoSocial, codigo);
    }
    
}
