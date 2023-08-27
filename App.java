import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class App {

    public static void main(String[]args){
        //TesteEx1();
        //TesteEx2();
        TesteEx3();
    }

    public static void TesteEx1() {
        //Exercício 1
        colecao y = colecao.get_instance();
        y.Colecao_Factory(true, "insert", true);
        System.out.println(y.lista instanceof LinkedList);
        colecao x = colecao.get_instance();
        System.out.println(x.lista instanceof LinkedList);
    }

    public static void TesteEx2() {
        // Conta criada com atributos padrão, tipo normal, saldos e taxas zeradas
        Conta contaPadrao = new Conta.Builder("João Alberto", 1)
                .build();

        // Conta criada do tipo advanced, com saldo livre de 200, e saldo remunerado de
        // 100
        Conta contaAdvanced = new Conta.Builder("Rafaela Garcia", 2)
                .categoriaInicial(Conta.Categoria.ADVANCED)
                .saldoLivreInicial(200)
                .salAplicaoInicial(100)
                .build();

        // Conta criada do tipo premium, saldo livre 1000 e saldo remunerado 2000
        Conta contaPremium = new Conta.Builder("Luisa Moreira", 3)
                .categoriaInicial(Conta.Categoria.PREMIUM)
                .saldoLivreInicial(1000)
                .salAplicaoInicial(2000)
                .build();

        /*
         * Conta Normal - taxas zeradas e minimo de -100 (não ganha nem perde nada)
         * Conta Advanced - taxa remuneracao = 1, taxa negativo = 10, minimo de -200
         * (perde bastante e ganha pouco)
         * Conta Premium - taxa remuneracao = 5, taxa negativo = 5, minimo de 500 (ganha
         * e perde a mesma coisa)
         */

        // Print de exemplos iniciais das 3 contas:
        // System.out.println(contaPadrao);
        // System.out.println(contaAdvanced);
        // System.out.println(contaPremium);

        // Teste com conta do tipo normal
        System.out.println("\nTESTE COM CONTA NORMAL");
        System.out.println("Tenta tirar mais que o valor minimo:");
        contaPadrao.retirarLivre(101);
        System.out.println("Tira exatamente o valor minimo:");
        contaPadrao.retirarLivre(100);
        System.out.println("Deposita no livre e no remunerado(os dois ficam com 100):");
        contaPadrao.depositarLivre(200);
        contaPadrao.depositarRemunerado(100);
        System.out.println("Transfere 50 do remunerado para o livre:");
        contaPadrao.transferirLivreRemunerado(50);
        System.out.println(contaPadrao);

        // Teste de taxas a partir dos dias passando na conta premium
        System.out.println("\nTESTE COM CONTA PREMIUM DE TAXAS");
        System.out.println("Deixa a conta no negativo:");
        contaPremium.retirarLivre(1500);
        System.out.println(contaPremium);
        System.out.println("Pula um dia, negativando 5 no saldo livre e adicionando 5 no saldo remunerado:");
        contaPremium.pularDia();
        System.out.println(contaPremium);
    }

    public static void TesteEx3() {
        System.out.println("Exibindo personagens:");

        Personagem p1 = Personagem.normal();
        System.out.println("Normal: " + p1.toString());

        p1 = Personagem.poderoso(100);
        System.out.println("Poderoso: " + p1.toString());

        p1 = Personagem.sortudo(5);
        System.out.println("Sortudo: " + p1.toString());

        p1 = Personagem.escolher(10, 100, 5);
        System.out.println("Escolher Atributos: " + p1.toString());
    }
}
