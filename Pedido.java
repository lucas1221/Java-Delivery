
import java.util.List;


//import java.util.List;

/*
*
– Um pedido deve ter associado a ele uma lista de produtos, um cliente
(único), um valor do pedido, o valor do troco que deve ser enviado pelo
entregador, o seu status (em andamento ou concluído), e um entregador.
– Um pedido só pode estar vinculado a um cliente;
– Um cliente pode fazer diversos pedidos;
– Um pedido só pode estar vinculado a um entregador;
– Um Entregador pode estar cinculado a diversos pedidos;
*
*
*/

public class Pedido 
{
    //nao sei se será util
    //incluir lista de produtos
    //public static List<Produto> listaDeProdutos;
    // atributos de pedido
    private List<Produto> listinha;
    private double valor; // Valor do Pedido
    private double troco; // Valor do Troco
    private String status; // Status do pedido
    private String cliente; // Cliente único
    private String entregador;
    private int codigo_pedido;

    public int getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(int codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public String getEntregador() {
        return entregador;
    }

    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }
        
    public List<Produto> getListinha() {
        return listinha;
    }

    public void setListinha(List<Produto> listinha) {
        this.listinha = listinha;
    }
    
     
    // getters e setters
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    /****************************************************/
    /*
    *           BEM VINDO AO CONSTRUTOR :D
    *
    /****************************************************/
    
    /**
     * NETBEANS ZOEIRO MANDOU EU CRIAR ISSO PARA N TER ERRO (DAFUQ)
     * @param valor
     * @param troco
     * @param status
     * @param cliente
     */
    public Pedido(double valor, double troco, String status, String cliente, String entregador, List<Produto> listinha, int codigo_pedido) {
        this.listinha = listinha;
        this.valor = valor;
        this.troco = troco;
        this.status = status;
        this.cliente = cliente;
       this.entregador = entregador;
       this.codigo_pedido = codigo_pedido;
    }
    
    
}



