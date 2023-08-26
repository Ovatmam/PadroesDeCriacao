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
    
   // factory determina qual vai ser o tipo de lista da instancia.
   public colecao Colecao_Factory(Boolean tamanho_conhecido, String ordem, Boolean repetidos) {
       instancia = get_instance();

       if (repetidos == true) {
           if (ordem.equalsIgnoreCase("insert")) {
               if (tamanho_conhecido == true) {
                   instancia.lista = new LinkedList<>();
                   return instancia;
               } else {
                   instancia.lista = new ArrayList<>();
                   return instancia;
               }

           } else {
               System.out.println("Erro");
               return instancia;
           }
       } else {
           if (ordem.equalsIgnoreCase("N/A")) {
               instancia.lista = new HashSet<>();
               return instancia;
           } else if (ordem.equalsIgnoreCase("natural")) {
               instancia.lista = new TreeSet<>();
               return instancia;
           } else {
               System.out.println("Erro");
               return instancia;
           }
       }

   }

}