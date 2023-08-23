import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class App {

    public static void main(String[]args){
    Collection x = colecao.Colecao_Factory(true,"insert",true);
    colecao y = colecao.get_instance();
    System.out.println(x instanceof LinkedList);
    System.out.println(y.lista instanceof LinkedList);
    }
}
