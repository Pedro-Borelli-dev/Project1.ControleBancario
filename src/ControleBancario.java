import java.util.Scanner;

public class ControleBancario {
    public static void main(String[] args) {
        String nome = "Pedro Borelli";
        String tipoConta = "Conta Corrente";
        double saldo = 1599.99;
        int opcao = 0;

        System.out.println("******************************");
        System.out.println("\nNome do cliente: " + nome);
        System.out.println("Tipo conta: " + tipoConta);
        System.out.printf("Saldo atual: %.2f%n", saldo);
        System.out.println("\n******************************");

        String menu = """
                ** Digite sua opção **
                1- Consultar saldo
                2- Transferir valor
                3- Receber valor
                4- Sair
                """;

        Scanner leitura = new Scanner(System.in);

        while (opcao != 4) {
            System.out.println(menu);
            if (leitura.hasNextInt()) {
                opcao = leitura.nextInt();
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                leitura.next(); // Limpa a entrada inválida
                continue;
            }

            switch (opcao) {
                case 1 -> System.out.printf("O saldo atualizado é: %.2f%n", saldo);
                case 2 -> {
                    System.out.println("Qual o valor que deseja transferir: ");
                    if (leitura.hasNextDouble()) {
                        double valor = leitura.nextDouble();
                        if (valor > saldo) {
                            System.out.println("Não há saldo suficiente.");
                        } else {
                            saldo -= valor;
                            System.out.printf("Saldo atualizado: %.2f%n", saldo);
                        }
                    } else {
                        System.out.println("Entrada inválida. Digite um valor numérico.");
                        leitura.next(); // Limpa a entrada inválida
                    }
                }
                case 3 -> {
                    System.out.println("Qual o valor recebido: ");
                    if (leitura.hasNextDouble()) {
                        double valor = leitura.nextDouble();
                        saldo += valor;
                        System.out.printf("Saldo atualizado: %.2f%n", saldo);
                    } else {
                        System.out.println("Entrada inválida. Digite um valor numérico.");
                        leitura.next(); // Limpa a entrada inválida
                    }
                }
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        leitura.close();
    }
}


