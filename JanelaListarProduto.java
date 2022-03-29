/*Essa janela apenas lista as informações de todos os produtos
cadastrados no sistema.
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
 
public class JanelaListarProduto extends JFrame {
    private JPanel painelFundo; 
    private JTable tabela; 
    private JScrollPane barraRolagem;
    private DefaultTableModel modelo = new DefaultTableModel(); 
    private List<Produto> listaDeProdutos;

  public JanelaListarProduto() {
	super("Lista de Produtos");
	criaJTable();
	criaJanela();
}

    
    public void criaJanela() { 
        
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel(); 
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem); 
        getContentPane().add(painelFundo);
        setSize(600,600); 
        setVisible(true);
         
    } 
     
    private void criaJTable() { 
        tabela = new JTable(modelo);
        modelo.addColumn("Código"); 
        modelo.addColumn("Descricao");
        modelo.addColumn("Unidades no Estoque"); 
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100); 
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100); 
        pesquisar(modelo);
         
    } 
     
    public static void pesquisar(DefaultTableModel modelo) 
    { 
        modelo.setNumRows(0);
        for (int i = 0; i < SistemaEntrega.listaDeProdutos.size(); i++) 
        {
            modelo.addRow(new Object[]{ SistemaEntrega.listaDeProdutos.get(i).getCodigo(), SistemaEntrega.listaDeProdutos.get(i).getDescricao(), SistemaEntrega.listaDeProdutos.get(i).getUnidade_Estoque()}); 
        } 
    }
}




