package Model;
import Controller.VendaController;
import Persistencia.Banco;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Pedro
 */
public class Venda {
    private Banco banco=new Banco();
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
    
    public ResultSet consultarProduto(String produto,float quantidade){
        this.getBanco().conectarAoBanco();
        String query = "SELECT * FROM produto WHERE nome='"+produto+"';";
        this.setRst(this.getBanco().consulta(query));
        try{
            String baixaEstoque = "UPDATE produto SET quantidade = quantidade - "+quantidade+" WHERE idProduto = "+this.getRst().getInt("idProduto")+";";
            this.getBanco().query(baixaEstoque);
        }
        catch(Exception e){}
        //this.getBanco().desconectarDoBanco();
        return this.getRst();
    }
    
    public void voltarEstoque(String nomeProduto, float quantidade){
        this.getBanco().conectarAoBanco();
        String query = "SELECT * FROM produto WHERE nome='"+nomeProduto+"';";
        this.setRst(this.getBanco().consulta(query));
        try{
            String voltarEstoque = "UPDATE produto SET quantidade = quantidade + "+quantidade+" WHERE idProduto = "+this.getRst().getInt("idProduto")+";";
            this.getBanco().query(voltarEstoque);
        }
        catch(Exception e){}
    }
    
    public void voltarListaEstoque(String[] produto, float[] quantidade){
        this.getBanco().conectarAoBanco();
        for(int i=0; i<produto.length;i++){
            String query = "SELECT idProduto FROM produto WHERE nome='"+produto[i]+"'";
            try{
                this.setRst(this.getBanco().consulta(query));
                String voltarEstoque = "UPDATE produto SET quantidade = quantidade + "+quantidade[i]+" WHERE idProduto = "+this.getRst().getInt("idProduto")+";";
                this.getBanco().query(voltarEstoque);
            }
            catch(Exception e){}
        }
    }
    
    public ResultSet autoComplete(String texto){
        this.getBanco().conectarAoBanco();
        String query = "SELECT nome FROM produto WHERE nome LIKE '"+texto+"%';";
        this.setRst(this.getBanco().consulta(query));
        
        return this.getRst();
    }
    
    public void finalizarVenda(String[] produto,float[] quantidade, float[] precoUnit, float desconto, float precoTotal, String pagamento, String cliente, String funcionario){
        this.getBanco().desconectarDoBanco();
        this.getBanco().conectarAoBanco();
        int[] idProduto = new int[produto.length];
        for(int i=0; i<produto.length;i++){
            String query = "SELECT idProduto FROM produto WHERE nome='"+produto[i]+"'";
            try{
                this.setRst(this.getBanco().consulta(query));
                idProduto[i]=this.getRst().getInt("idProduto");
            }
            catch(Exception e){}
        }
        
        String query="SELECT idVenda FROM venda WHERE idVenda >= 0 ORDER BY idVenda DESC LIMIT 1";
        try{
            this.setRst(this.getBanco().consulta(query));
            int idVenda=this.getRst().getInt("idVenda");
            idVenda++;
            
            for(int i=0; i<produto.length;i++){
                String inserir = "INSERT INTO venda (idVenda,idProduto,quantidade,precoUnit,data,desconto,precoTotalVenda,pagamento,cliente, funcionario) VALUES ("+idVenda+","+idProduto[i]+","+quantidade[i]+","+precoUnit[i]+",NOW(),"+desconto+","+precoTotal+",'"+pagamento+"','"+cliente+"','"+funcionario+"');"; 
                this.getBanco().query(inserir); 
            }
        }
        catch(Exception e){}

        this.getBanco().desconectarDoBanco();
    }
}
