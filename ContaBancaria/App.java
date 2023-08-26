package ContaBancaria;
import ContaBancaria.Conta.Builder;
import ContaBancaria.Conta.Categoria;

public class App {
        public static void main(String[] args) {
            //Conta criada com atributos padrão, tipo normal e saldos zerados
            Conta contaPadrao = new Conta.Builder("João Alberto",1)
            .build();
        
            //Conta criada do tipo advanced, com saldo livre de 200, e saldo remunerado de 100
            Conta contaAdvanced = new Conta.Builder("Rafaela Garcia", 2)
            .categoriaInicial(Conta.Categoria.ADVANCED)
            .saldoLivreInicial(200)
            .salAplicaoInicial(100)
            .build();

            //Conta criada do tipo premium, aldo livre 1000 e saldo remunerado 2000
            Conta contaPremium = new Conta.Builder("Luisa Moreira", 3)
            .categoriaInicial(Conta.Categoria.PREMIUM)
            .saldoLivreInicial(1000)
            .saldoLivreInicial(2000)
            .build();

            System.out.println(contaPadrao);
            //System.out.println(contaAdvanced);
            //System.out.println(contaPremium);

            contaPadrao.retirarLivre(20);
            contaPadrao.depositarLivre(20);
            contaPadrao.depositarRemunerado(20);
            contaPadrao.transferirLivreRemunerado(10); //pula dois dias de vida da conta
            System.out.println(contaPadrao);



        }
    }

