import java.util.ArrayList;
import java.util.LinkedList;

public class App {

    public static void main(String[]args){
    colecao x = colecao.Colecao_Factory(true,"insert",true);
    System.out.println(x.lista instanceof LinkedList);
    }
}
