import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

class colecao{
    static colecao instancia;
    Collection lista;
    
    private colecao(){
        
    }

    
   public static colecao get_instance(){
    if(instancia == null){
        instancia = new colecao();
        instancia.lista = new ArrayList<>(); //lista por default eh arraylist
    }
    return instancia;
    
   }
    

    public static Collection Colecao_Factory(Boolean tamanho_conhecido,String ordem,Boolean repetidos){
        instancia = get_instance();

        if(ordem.equalsIgnoreCase("insert")){
                if(tamanho_conhecido == true){ 
                    return instancia.lista = new LinkedList<>();
                }
                else{
                    return instancia.lista = new ArrayList<>();
                }
            
        }
        else if(ordem.equalsIgnoreCase("N/A")){
            return instancia.lista = new HashSet<>();
        }
        else if (ordem.equalsIgnoreCase("natural")){
            return instancia.lista = new TreeSet<>();
        }
        else{
            System.out.println("Erro");
            return instancia.lista;
        }
    }


}