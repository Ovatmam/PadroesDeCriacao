

public class Conta {
    public enum Categoria {
        NORMAL, ADVANCED, PREMIUM
    };

    // Atributo que conta quantos dias a conta tem.
    private int diasDaConta = 0;
    // Atributos principais da conta, nome, numero e tipo
    private String nomeCorrentista;
    private int numeroConta;
    private Categoria categoriaInicial;

    // Atributos do saldo Livre
    private int saldoLivre; // O saldo
    private double taxaSaldoNegativo; // Quanto é cobrado se esta negativo
    private int saldoMinimoLivre; // Quanto negativo pode ficar

    // Atributos do saldo remunerado
    private int salAplicacao; // O saldo
    private double taxaRemuneracao; // a taxa de remuneracao

    // Classe Interna Builder
    public static class Builder {
        // Padrão da classe
        private String nomeCorrentista;
        private int numeroConta;
        private Categoria categoriaInicial = Categoria.NORMAL;
        private int saldoLivreInicial = 0;
        private int saldoMinimoLivre = -100;
        private double taxaSaldoNegativo = 0;
        private int salAplicacaoInicial = 0;
        private double taxaRemuneracao = 0;

        public Builder(String nomeCorrentista, int numeroConta) {
            this.nomeCorrentista = nomeCorrentista;
            this.numeroConta = numeroConta;
        }

        // Metodo que altera categoria
        public Builder categoriaInicial(Conta.Categoria categoria) {
            // seta a categoria
            this.categoriaInicial = categoria;
            // dependendo do tipo de conta, ajusta as taxas
            if (categoria == Conta.Categoria.NORMAL) { // provavelmente não precisaria deste, pois é o padrão
                this.taxaRemuneracao = 0;
                this.taxaSaldoNegativo = 0;
                this.saldoMinimoLivre = -100;
            }

            if (categoria == Conta.Categoria.ADVANCED) { // caso a conta seja advanced
                this.taxaRemuneracao = 1;
                this.taxaSaldoNegativo = 10;
                this.saldoMinimoLivre = -200;
            }
            if (categoria == Conta.Categoria.PREMIUM) { // caso a conta seja premium
                this.taxaRemuneracao = 5;
                this.taxaSaldoNegativo = 5;
                this.saldoMinimoLivre = -500;
            }
            return this;
        }

        // Metodo que altera o saldo livre
        public Builder saldoLivreInicial(int saldoLivreInicial) { // muda o saldo livre inicial da conta
            this.saldoLivreInicial = saldoLivreInicial;
            return this;
        }

        // metodo que altera saldo investido
        public Builder salAplicaoInicial(int salAplicacaoInicial) { // muda o saldo remunerado inicial
            this.salAplicacaoInicial = salAplicacaoInicial;
            return this;
        }

        // metodo que cria e retorna a conta
        public Conta build() {
            return new Conta(this);
        }
    }

    // Construtor geral liga builder com a conta
    private Conta(Builder builder) {
        this.nomeCorrentista = builder.nomeCorrentista;
        this.numeroConta = builder.numeroConta;

        this.categoriaInicial = builder.categoriaInicial;
        this.saldoLivre = builder.saldoLivreInicial;
        this.taxaSaldoNegativo = builder.taxaSaldoNegativo;
        this.saldoMinimoLivre = builder.saldoMinimoLivre;
        this.salAplicacao = builder.salAplicacaoInicial;
        this.taxaRemuneracao = builder.taxaRemuneracao;
    }

    @Override
    public String toString() {
        return "Conta: " + numeroConta +
                "\n\tDados:" +
                "\n\tnomeCorrentista = " + nomeCorrentista +
                "\n\ttipoConta = " + categoriaInicial +
                "\n\ttempoDaConta = " + diasDaConta +
                "\n" +
                "\n\tSaldos:" +
                "\n\tsaldoLivre = " + saldoLivre +
                "\n\tsaldoRemunerado = " + salAplicacao +
                "\n" +
                "\n\tTaxas e mínimo:" +
                "\n\ttaxaSaldoNegativo = " + taxaSaldoNegativo +
                "\n\ttaxaRemuneracao = " + taxaRemuneracao +
                "\n\tsaldoMinimoLivre = " + saldoMinimoLivre;
    }

    public void retirarLivre(int valorRetirada) {
        if (saldoLivre - valorRetirada >= saldoMinimoLivre) {
            saldoLivre -= valorRetirada;
            System.out.println("Retirado com sucesso. Saldo atual conta " + numeroConta + " = " + saldoLivre);
        } else {
            System.out.println("Não foi possível realizar a retirada");
        }
    }

    public void depositarLivre(int valorDeposito) {
        saldoLivre += valorDeposito;
        System.out.println(
                "Deposito realizado com sucesso, novo saldo livre da conta " + numeroConta + " = " + saldoLivre);
    }

    public void depositarRemunerado(int valorDeposito) {
        salAplicacao += valorDeposito;
        System.out.println(
                "Deposito realizado com sucesso, novo saldo remunerado da conta " + numeroConta + " = " + salAplicacao);
    }

    public void transferirLivreRemunerado(int valorTransferido) {
        // testa se tem esse valor a ser transferido e pula os dias.
        if (valorTransferido <= salAplicacao) {
            saldoLivre += valorTransferido;
            salAplicacao -= valorTransferido;
            // pula dois dias para realizar a transferencia
            pularDia();
            pularDia();

            System.out.println("Transferencia realizada com sucesso na conta " + numeroConta);
        } else {
            System.out.println("Não foi possível realizar a transferencia, valor invalido");
        }
    }

    public void pularDia() {
        // se tiver dinheiro na conta de remuneracao, deposita a taxa de remuneracao
        if (salAplicacao > 0) {
            salAplicacao += taxaRemuneracao;
        }
        // se tiver negativo na conta livre, cobra a taxa
        if (saldoLivre < 0) {
            saldoLivre -= taxaSaldoNegativo;
        }
        // adiciona um dia na conta
        diasDaConta++;

    }

}
