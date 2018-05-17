package Persistencia;
import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author Pedro
 */
public class Banco {
    private Connection connection;
    private Statement stmt;
    private ResultSet rst;
    private String query;
    
    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return the stmt
     */
    public Statement getStmt() {
        return stmt;
    }

    /**
     * @param stmt the stmt to set
     */
    public void setStmt(Statement stmt) {
        this.stmt = stmt;
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

    /**
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
    }
    
    public Banco(){
        this.setConnection(null);
        this.setStmt(null);
    }
    
    public boolean conectarAoBanco(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.setConnection((Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/caixa","root",""));
            return true;
        }
        catch(Exception e){
            System.err.println(e);
        }
        return false;
    }
    
    public boolean desconectarDoBanco(){
        try{
            this.getConnection().close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean query(String query){
        try{
            this.setStmt(this.getConnection().createStatement());
            this.setQuery(query);
            stmt.executeUpdate(query);
            return true;
        }
        catch(Exception e){
            System.err.println(e);
            return false;
        }
    }
    
    public ResultSet consulta(String consulta){
        try{
            this.setStmt(this.getConnection().createStatement());
            query = consulta;
            rst = stmt.executeQuery(query);
            rst.next();
            return rst;
        }
        catch(Exception e){
            return null;
        }
    }
    
}
