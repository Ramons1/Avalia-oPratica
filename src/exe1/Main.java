package exe1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaAcesso sistema = new SistemaAcesso();
        Scanner scanner = new Scanner(System.in);

        // Adicionando alguns usuários para o exemplo
        sistema.adicionarUsuario(new Usuario("usuario1", "senha1", Perfil.LEITOR));
        sistema.adicionarUsuario(new Usuario("usuario2", "senha2", Perfil.EDITOR));
        sistema.adicionarUsuario(new Usuario("usuario3", "senha3", Perfil.ADMINISTRADOR));

        // Bloco de login
        System.out.println("\n--- BEM-VINDO AO SISTEMA DE ACESSO ---");
        System.out.print("Digite o nome de usuário: ");
        String nomeUsuario = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        // Autenticando o usuário
        if (sistema.autenticar(nomeUsuario, senha)) {
            // Verificando permissões após o login
            System.out.println("\n--- VERIFICANDO PERMISSÕES ---");
            System.out.println("Permissão para Ler? " + sistema.temPermissao(Perfil.LEITOR));
            System.out.println("Permissão para Editar? " + sistema.temPermissao(Perfil.EDITOR));
            System.out.println("Permissão de Administrador? " + sistema.temPermissao(Perfil.ADMINISTRADOR));
        }

        scanner.close(); // Fechando o scanner para liberar recursos
    }
}