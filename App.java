import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class App {

    public static void main(String[]args){
        colecao y = colecao.get_instance();
        y.Colecao_Factory(true, "insert", true);
        System.out.println(y.lista instanceof LinkedList);
        colecao x = colecao.get_instance();
        System.out.println(x.lista instanceof LinkedList);
    }
}
