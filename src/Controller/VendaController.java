/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Venda;
import java.sql.ResultSet;
import java.util.Date;
/**
 *
 * @author Pedro
 */
public class VendaController {
    private Venda venda= new Venda();
    /**
     * @return the venda
     */
    public Venda getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    
    public ResultSet consultarProduto(String produto, float quantidade){
        return this.getVenda().consultarProduto(produto,quantidade);
    }
    
    public void voltarEstoque(String nomeProduto, float quantidade){
        this.venda.voltarEstoque(nomeProduto, quantidade);
    }
    
    public void voltarListaEstoque(String[] produto, float[] quantidade){
        this.venda.voltarListaEstoque(produto, quantidade);
    }
    
    public ResultSet autoComplete(String texto){
        return this.getVenda().autoComplete(texto);
    }
    
    public void finalizarVenda(String[] produto,float[] quantidade, float[] precoUnit, float desconto, float precoTotal, String pagamento, String cliente, String funcionario){
        this.getVenda().finalizarVenda(produto,quantidade,precoUnit, desconto, precoTotal, pagamento, cliente, funcionario);
    }
    
}
