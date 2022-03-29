public class Produto {
    private int codigo;
    private String descricao;
    private int unidade_estoque;
     
     
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getUnidade_Estoque() {
        return unidade_estoque;
    }
    public void setUnidade_Estoque(int unidade_estoque) {
        this.unidade_estoque = unidade_estoque;
    }
     
    public Produto(int codigo, String descricao, int unidade_estoque) {
        this.codigo = codigo;       
        this.descricao = descricao;
        this.unidade_estoque = unidade_estoque;
    }
     
     
}