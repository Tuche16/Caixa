/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Cliente;
import java.sql.ResultSet;
/**
 *
 * @author Pedro
 */
public class ClienteController {

    private Cliente cliente = new Cliente();
    
    /**
     * @return the produto
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param produto the produto to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void alterarCliente(int codigo,String nome,String cpf,String endereco,String tel,String outros){
        this.getCliente().alterarCliente(codigo, nome, cpf, endereco, tel, outros);
    }
    
    public void removerCliente(int codigo){
        this.getCliente().removerCliente(codigo);
    }
    
    public void adicionarCliente(String nome, String cpf, String endereco, String tel, String outros){
        this.getCliente().adicionarCliente(nome, cpf, endereco, tel, outros);
    }
    
    public ResultSet listarClientes(){
        return this.getCliente().listarClientes();
    }
    
    public boolean cpfExistente(String cpf){
        return this.getCliente().cpfExistente(cpf);
    }
    
    public ResultSet buscarCliente(String nome, int codigo){
        return this.getCliente().buscarCliente(nome, codigo);
    }
    
}
