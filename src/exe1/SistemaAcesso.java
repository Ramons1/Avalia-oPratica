package exe1;

import java.util.ArrayList;

public class SistemaAcesso {
    private ArrayList<Usuario> usuariosCadastrados;
    private Usuario usuarioLogado;

    public SistemaAcesso() {
        this.usuariosCadastrados = new ArrayList<>();
        // Adicionando alguns usuários para exemplo
        usuariosCadastrados.add(new Usuario("admin", "senha123", Perfil.ADMINISTRADOR));
        usuariosCadastrados.add(new Usuario("editor", "senha456", Perfil.EDITOR));
        usuariosCadastrados.add(new Usuario("leitor", "senha789", Perfil.LEITOR));
    }

    public void adicionarUsuario(Usuario novoUsuario) {
        // Verificação simples para evitar duplicatas pelo nome de usuário
        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.getNomeUsuario().equals(novoUsuario.getNomeUsuario())) {
                System.out.println("Erro: Usuário com o nome " + novoUsuario.getNomeUsuario() + " já existe.");
                return;
            }
        }
        usuariosCadastrados.add(novoUsuario);
        System.out.println("Usuário " + novoUsuario.getNomeUsuario() + " adicionado com sucesso!");
    }

    public boolean autenticar(String nomeUsuario, String senha) {
        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.getNomeUsuario().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                this.usuarioLogado = usuario;
                System.out.println("Usuário " + nomeUsuario + " autenticado com sucesso!");
                return true;
            }
        }
        System.out.println("Falha na autenticação. Usuário ou senha incorretos.");
        return false;
    }

    public boolean temPermissao(Perfil perfilNecessario) {
        if (usuarioLogado == null) {
            System.out.println("Nenhum usuário logado.");
            return false;
        }
        
        switch (usuarioLogado.getPerfil()) {
            case ADMINISTRADOR:
                // Administrador tem permissão para tudo
                return true;
            case EDITOR:
                // Editor tem permissão de EDITOR e LEITOR
                return perfilNecessario == Perfil.EDITOR || perfilNecessario == Perfil.LEITOR;
            case LEITOR:
                // Leitor só tem permissão de LEITOR
                return perfilNecessario == Perfil.LEITOR;
        }
        return false;
    }

    public void fazerLogout() {
        this.usuarioLogado = null;
        System.out.println("Logout realizado.");
    }
}