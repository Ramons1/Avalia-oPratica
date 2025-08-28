package exe1;

public class Usuario {
    private String nomeUsuario;
    private String senha;
    private Perfil perfil;

    public Usuario(String nomeUsuario, String senha, Perfil perfil) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }
}