/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Fornecedor;
import java.sql.ResultSet;
/**
 *
 * @author Pedro
 */
public class FornecedorController {

    private Fornecedor fornecedor = new Fornecedor();
    
    /**
     * @return the produto
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param produto the produto to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public void alterarFornecedor(int codigo,String razaoSocial,String cnpj,String endereco,String tel,String outros){
        this.getFornecedor().alterarFornecedor(codigo, razaoSocial, cnpj, endereco, tel, outros);
    }
    
    public void removerFornecedor(int codigo){
        this.getFornecedor().removerFornecedor(codigo);
    }
    
    public void adicionarFornecedor(String razaoSocial, String cnpj, String endereco, String tel, String outros){
        this.getFornecedor().adicionarFornecedor(razaoSocial, cnpj, endereco, tel, outros);
    }
    
    public ResultSet listarFornecedores(){
        return this.getFornecedor().listarFornecedores();
    }
    
    public boolean cnpjExistente(String cnpj){
        return this.getFornecedor().cnpjExistente(cnpj);
    }
    
    public ResultSet buscarFornecedor(String razaoSocial, int codigo){
        return this.getFornecedor().buscarFornecedor(razaoSocial, codigo);
    }
    
}
