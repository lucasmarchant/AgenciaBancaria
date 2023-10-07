package br.com.banco.agenciabancaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {

        contasBancarias  = new ArrayList<Conta>();

        operacoes();

    }


    public static void operacoes(){

        System.out.println("--------------------------------------------------");
        System.out.println("-----------Bem vindo a nossa Agência--------------");
        System.out.println("--------------------------------------------------");
        System.out.println("****Selecione uma operação que deseja realizar****");
        System.out.println("--------------------------------------------------");
        System.out.println("|  Opção 1 - Criar conta  |");
        System.out.println("|  Opção 2 - Depositar  |");
        System.out.println("|  Opção 3 - Sacar  |");
        System.out.println("|  Opção 4 - Transferir  |");
        System.out.println("|  Opção 5 - Listar contas  |");
        System.out.println("|  Opção 6 - Sair  |");

        int operacao = scanner.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por usar nossa Agência!");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }

    }



    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = scanner.next();

        System.out.println("\nCPF: ");
        String cpf = scanner.next();

        System.out.println("\nEmail: ");
        String email = scanner.next();


        Pessoa pessoa = new Pessoa(nome,cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);

        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();

    }

    public static Conta encontrarConta (int numeroConta) {

        Conta conta = null;

        if (contasBancarias.size() > 0){
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }return conta;
    }


    public static void depositar() {

        System.out.println("Qual o número da conta: ");
        int numeroConta = scanner.nextInt();


        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = scanner.nextDouble();
            conta.depositar(valorDeposito);
        }else {
            System.out.println("A conta para depósito não foi encontrada! ");
        }
        operacoes();
    }


    public static void sacar() {


        System.out.println("Qual o número da conta: ");
        int numeroConta = scanner.nextInt();


        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = scanner.nextDouble();
            conta.sacar(valorSaque);
        }else {
            System.out.println("A conta não foi encontrada! ");
        }
        operacoes();

    }


    public static void transferir(){

        System.out.println("Número da conta do remetente: ");
        int numeroContaRemetente = scanner.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Qual o número da conta do destinatário?");
            int numeroContaDestinatario = scanner.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {

                System.out.println("Qual o valor da transferência?");
                Double valor = scanner.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            }
        }else {
            System.out.println("Conta para transferência não foi encontrada! ");
        }
        operacoes();

    }


    public static void listarContas(){

        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                System.out.println(c);
            }
        }else {
            System.out.println("Não há contas cadastradas! ");
        }
        operacoes();
    }



}
