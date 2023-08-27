public class Personagem {
    private int visibilidade;
    private int poder;
    private int vidas;

    private Personagem(int vis, int pow, int vida) {
        // visibilidade [0,10], poder [0;100] e vidas [0,5].
        if(vis < 0 || vis > 10 ||
           pow < 0 || pow > 100 ||
           vida < 0 || vida > 5) 
            {
                System.out.println("Atributos inválidos, personagem não criado.");
                this.visibilidade = -1;
                this.poder = -1;
                this.vidas = -1;
                return;
            }
        this.visibilidade = vis;
        this.poder = pow;
        this.vidas = vida;
    }

    /*
     * 60% normais:    visibilidade = 10, poder = 50 e vidas = 3.
     * 15% poderosos:  visibilidade = 10, vidas = 3 e o poder é ajustado na hora da criação.
     * 15% sortudos:   poder = 50, vidas = 3 e a visibilidade é ajustada na hora da criação.
     * 10% ultimos:    têm os três parâmetros configurados na hora da criação.
     */

    public static Personagem normal() {
        return new Personagem(10, 50, 3);
    }

    public static Personagem poderoso(int poder) {
        return new Personagem(10, poder, 3);
    }

    public static Personagem sortudo(int visibilidade) {
        return new Personagem(visibilidade, 50, 3);
    }

    public static Personagem escolher(int vis, int pow, int vida) {
        return new Personagem(vis, pow, vida);
    }

    public String toString() {
        return "Personagem[vis:" + visibilidade + "; poder:" + poder + "; vidas:" + vidas + "]\n";
    }
}