import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        double limite = 0;
        while (limite <= 0) {
            System.out.print("Digite o limite do cartão: ");
            limite = leitura.nextDouble();

            if (limite <= 0){
                System.out.println("O limite do cartão não pode ser 0 ou negativo. Tente novamente!");
            }
        }

        Cartao cartao = new Cartao(limite);

        int escolha = 1;
        while (escolha == 1){
            System.out.print("Digite a descrição da compra: ");
            leitura.nextLine(); //Necessário para ler string com espaço
            String descricao = leitura.nextLine();

            double valor = 0;
            while (valor <= 0) {
                System.out.print("Digite o valor da compra: ");
                valor = leitura.nextDouble();

                if (valor <= 0) {
                    System.out.println("Valor incorreto, tente novamente!");
                }
            }

            Compra compra = new Compra(valor, descricao);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada){
                System.out.println("Compra realizada!");
                System.out.print("Digite 0 para sair ou 1 para continuar: ");
                escolha = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente para a compra");
                System.out.println("Saldo do cartão: R$" + cartao.getSaldo());
                System.out.print("Digite 0 para sair ou 1 para fazer outra compra: ");
                escolha = leitura.nextInt();
            }
        }

        System.out.println("\n-------------------------------------------------");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + ": R$" + c.getValor());
        }
        System.out.println("-------------------------------------------------\n");
        System.out.println("Saldo do cartão: R$" + cartao.getSaldo());
    }

}
