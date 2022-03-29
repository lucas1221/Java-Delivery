/*Essa janela apenas lista as informações de todos os clientes
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
 
public class JanelaListarCliente extends JFrame {
    private JPanel painelFundo; 
    private JTable tabela; 
    private JScrollPane barraRolagem;
    private DefaultTableModel modelo = new DefaultTableModel(); 
    private List<Pessoa> listaDePessoas;

  public JanelaListarCliente() {
	super("Dados dos Clientes");
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
       
        modelo.addColumn("Nome"); 
        modelo.addColumn("Cpf");
        modelo.addColumn("Endereco"); 
       
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100); 
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100); 
        
        pesquisar(modelo);
         
    } 
     
    public static void pesquisar(DefaultTableModel modelo) 
    {        
        modelo.setNumRows(0);
        for (int i = 0; i < SistemaEntrega.listaDePessoas.size(); i++) 
        {
            if(SistemaEntrega.listaDePessoas.get(i) instanceof Cliente)
                modelo.addRow(new Object[]{ SistemaEntrega.listaDePessoas.get(i).getNome(), SistemaEntrega.listaDePessoas.get(i).getCpf(), SistemaEntrega.listaDePessoas.get(i).getEndereco()}); 
        } 
    }
}
