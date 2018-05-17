/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Inicializacao;
/**
 *
 * @author Pedro
 */
public class InicializacaoController {
    public Inicializacao inicializacao;
    
    public InicializacaoController(String usuario){
        inicializacao = new Inicializacao(usuario);
    }
    
}
