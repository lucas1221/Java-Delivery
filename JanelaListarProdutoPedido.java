/*Essa janela apenas lista as informações de todos os produtos de certo
pedido cadastrados no sistema.
*/
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JanelaListarProdutoPedido extends JFrame
{    
    private JPanel painelFundo; 
    private JTable tabela; 
    private JScrollPane barraRolagem;
    private DefaultTableModel modelo = new DefaultTableModel(); 
    private int i;

    public JanelaListarProdutoPedido (int i) {
        super("Lista de Produtos do Pedido");
        this.i = i;
	criaJTable(i);
	criaJanela(i);
    }

    
    public void criaJanela(int i) { 
              
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel(); 
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem); 
        getContentPane().add(painelFundo);
        setSize(600,600); 
        setVisible(true);         
    } 
     
    private void criaJTable(int i) { 
        tabela = new JTable(modelo);
        modelo.addColumn("Código"); 
        modelo.addColumn("Descricao");
        modelo.addColumn("Quantidade Pedida");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100); 
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100); 
        pesquisar(modelo, i);
         
    } 
     
   

    public static void pesquisar(DefaultTableModel modelo, int i) 
    {          
        modelo.setNumRows(0);
        for (int j = 0; j < SistemaEntrega.listaDePedidos.get(i).getListinha().size(); j++) 
        {            
            modelo.addRow(new Object[]{ SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).getCodigo(), SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).getDescricao(), SistemaEntrega.listaDePedidos.get(i).getListinha().get(j).getUnidade_Estoque()}); 
        } 
        
       
    }   
 
}
