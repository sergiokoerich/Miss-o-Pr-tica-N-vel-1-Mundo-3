

import model.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        while (true) {
            System.out.println("================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("================================");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    incluirPessoa(scanner, repoFisica, repoJuridica);
                    break;
                case 2:
                    alterarPessoa(scanner, repoFisica, repoJuridica);
                    break;
                case 3:
                    excluirPessoa(scanner, repoFisica, repoJuridica);
                    break;
                case 4:
                    buscarPessoaPorId(scanner, repoFisica, repoJuridica);
                    break;
                case 5:
                    exibirTodos(scanner, repoFisica, repoJuridica);
                    break;
                case 6:
                    persistirDados(scanner, repoFisica, repoJuridica);
                    break;
                case 7:
                    recuperarDados(scanner, repoFisica, repoJuridica);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    private static void incluirPessoa(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Tipo de Pessoa (1 - Física, 2 - Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.println("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        if (tipo == 1) {
            System.out.println("CPF: ");
            String cpf = scanner.nextLine();

            System.out.println("Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
            repoFisica.inserir(pf);
        } else if (tipo == 2) {
            System.out.println("CNPJ: ");
            String cnpj = scanner.nextLine();

            PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
            repoJuridica.inserir(pj);
        } else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void alterarPessoa(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Tipo de Pessoa (1 - Física, 2 - Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.println("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        if (tipo == 1) {
            System.out.println("CPF: ");
            String cpf = scanner.nextLine();

            System.out.println("Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
            repoFisica.alterar(pf);
        } else if (tipo == 2) {
            System.out.println("CNPJ: ");
            String cnpj = scanner.nextLine();

            PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
            repoJuridica.alterar(pj);
        } else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void excluirPessoa(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Tipo de Pessoa (1 - Física, 2 - Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.println("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        if (tipo == 1) {
            repoFisica.excluir(id);
        } else if (tipo == 2) {
            repoJuridica.excluir(id);
        } else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void buscarPessoaPorId(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Tipo de Pessoa (1 - Física, 2 - Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.println("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        if (tipo == 1) {
            PessoaFisica pf = repoFisica.obter(id);
            if (pf != null) {
                pf.exibir();
            } else {
                System.out.println("Pessoa Física não encontrada!");
            }
        } else if (tipo == 2) {
            PessoaJuridica pj = repoJuridica.obter(id);
            if (pj != null) {
                pj.exibir();
            } else {
                System.out.println("Pessoa Jurídica não encontrada!");
            }
        } else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Tipo de Pessoa (1 - Física, 2 - Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        if (tipo == 1) {
            for (PessoaFisica pf : repoFisica.obterTodos()) {
                pf.exibir();
            }
        } else if (tipo == 2) {
            for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                pj.exibir();
            }
        } else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void persistirDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Tipo de Pessoa (1 - Física, 2 - Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.println("Nome do arquivo: ");
        String nomeArquivo = scanner.nextLine();

        try {
            if (tipo == 1) {
                repoFisica.persistir(nomeArquivo);
            } else if (tipo == 2) {
                repoJuridica.persistir(nomeArquivo);
            } else {
                System.out.println("Tipo inválido!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void recuperarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Tipo de Pessoa (1 - Física, 2 - Jurídica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.println("Nome do arquivo: ");
        String nomeArquivo = scanner.nextLine();

        try {
            if (tipo == 1) {
                repoFisica.recuperar(nomeArquivo);
            } else if (tipo == 2) {
                repoJuridica.recuperar(nomeArquivo);
            } else {
                System.out.println("Tipo inválido!");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
