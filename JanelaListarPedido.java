/*Essa janela apenas lista as informações de todos os pedidos
cadastrados no sistema.
Porém, as informações de todos os produtos de certo pedido é obtido apenas com 
a JanelaBuscarPedido.java. Aqui são mostrados apenas os nomes dos produtos pedidos
e suas quantidades não são indicadas.
*/
import java.awt.BorderLayout; 
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel; 
 
public class JanelaListarPedido extends JFrame {
    private JPanel painelFundo; 
    private JTable tabela; 
    private JScrollPane barraRolagem;
    private DefaultTableModel modelo = new DefaultTableModel(); 
    private List<Pedido> listaDePedidos;

  public JanelaListarPedido() {
	super("Lista de Pedidos");
	criaJTable();
	criaJanela();
}

    
    public void criaJanela() { 
        
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel(); 
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem); 
        getContentPane().add(painelFundo);
        setSize(1000,620); 
        setVisible(true);
         
    } 
     
    private void criaJTable() { 
        tabela = new JTable(modelo);
        modelo.addColumn("Código do Pedido");
        modelo.addColumn("Produtos");
        modelo.addColumn("Valor"); 
        modelo.addColumn("Troco");
        modelo.addColumn("Status"); 
        modelo.addColumn("Cliente"); 
        modelo.addColumn("Entregador");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100); 
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100); 
        tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
        
        pesquisar(modelo);
         
    } 
     
    public static void pesquisar(DefaultTableModel modelo) 
    { 
        String Produto = ""; //Serve para mostrar o nome dos Produtos pedidos
       
        modelo.setNumRows(0);
        for (int i = 0; i < SistemaEntrega.listaDePedidos.size(); i++) 
        {
            for(int j = 0; j < SistemaEntrega.listaDePedidos.get(i).getListinha().size(); j++)
             {
                    Produto += SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).getDescricao(); 
                    if(j <= SistemaEntrega.listaDePedidos.get(i).getListinha().size()-2)
                        Produto += ", "; 
             }      
                     
                    modelo.addRow(new Object[]{SistemaEntrega.listaDePedidos.get(i).getCodigo_pedido(), Produto, SistemaEntrega.listaDePedidos.get(i).getValor(), SistemaEntrega.listaDePedidos.get(i).getTroco(), SistemaEntrega.listaDePedidos.get(i).getStatus(), SistemaEntrega.listaDePedidos.get(i).getCliente(), SistemaEntrega.listaDePedidos.get(i).getEntregador()}); 
                    Produto = ""; 
                   
        } 
    }
}
