/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Consulta;
import java.sql.ResultSet;

/**
 *
 * @author Pedro
 */
public class ConsultaController {

    /**
     * @return the consulta
     */
    public Consulta getConsulta() {
        return consulta;
    }

    /**
     * @param consulta the consulta to set
     */
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    private Consulta consulta=new Consulta();
    public ResultSet login(String usuario,String senha){
        return this.getConsulta().logar(usuario, senha);
    }
    
}
