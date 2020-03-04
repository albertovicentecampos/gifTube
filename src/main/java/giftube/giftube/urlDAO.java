/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Pacalor
 */
@ApplicationScoped
public class urlDAO {
    private Map<String, String> links;

    public urlDAO() {
        this.links = new HashMap<String, String>();
        links.put("Homer Gasolina Gratis","https://media.giphy.com/media/W79wfYWCTWidO/source.gif");
        links.put("Johnny Bravo Aburrido","https://media.giphy.com/media/4SjlyrGuMvxxS/source.gif");
        links.put("CR7 Calmando","https://media.giphy.com/media/yeXb4sjQLw5QA/source.gif");
        links.put("CR7 mas menos","https://media.giphy.com/media/12WxFiMHBUl1RK/source.gif");
        links.put("Vinicius Bailando","https://media.giphy.com/media/3o6fIPsLQ8iKAgwsU0/giphy.gif");
        links.put("Gatos","https://media.giphy.com/media/gl8ymnpv4Sqha/source.gif");
        links.put("Tanque haciendo Drift","https://media.giphy.com/media/l41YgmUasxscF1J7i/source.gif");
        links.put("Homer Estudiando","https://media.giphy.com/media/Svvb6KYEHjZoA/source.gif");
    }
    
    public String busca(String nombre){
        return links.get(nombre);
    }
    
    
}
