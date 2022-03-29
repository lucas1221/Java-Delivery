/*Essa Janela adiciona um novo Produto a lista de Produtos*/
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
public class JanelaNovoProduto extends JFrame implements ActionListener
{
    private JTextField tfcodigo;
    private JLabel lcodigo;
     
    private JTextField tfdescricao;
    private JLabel ldescricao;
     
    private JTextField tfunidade_estoque;
    private JLabel lunidade_estoque;  
     
    private JButton btLimpar;
    private JButton btCadastrar;
     
    private Container container;
     
    private List<Produto> listaDeProdutos;
 
    public JanelaNovoProduto(List<Produto> listaDeProdutos)
    {
        this.listaDeProdutos = listaDeProdutos;
 
        this.setLayout(new FlowLayout());
        this.pack();
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setTitle("Novo Produto");
        this.setSize(500,500);
         
        tfcodigo = new JTextField(35);
        tfdescricao = new JTextField(33);
        tfunidade_estoque = new JTextField(39);
       
         
        lcodigo = new JLabel("Código: ");
        ldescricao = new JLabel("Descricão: ");
        lunidade_estoque = new JLabel("Quantidade no Estoque: ");
       
         
        btLimpar = new JButton("Limpar");
        btLimpar.addActionListener(this);
 
        btCadastrar = new JButton("Cadastrar");
        btCadastrar.addActionListener(this);
 
         
        container = this.getContentPane(); 
        container.add(lcodigo);
        container.add(tfcodigo);
        container.add(ldescricao);
        container.add(tfdescricao);
        container.add(lunidade_estoque);
        container.add(tfunidade_estoque);
        container.add(btLimpar);
        container.add(btCadastrar);      
    }
    
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btCadastrar)
        {
            validar();
 
        } 
         
          else if (e.getSource() == btLimpar)
                limpar();
    }
     
     //limpa campos de texto
      private void limpar()
        {
            tfcodigo.setText("");
            tfdescricao.setText("");
            tfunidade_estoque.setText("");
            
        }
      
      //Essa função é a responsável por adicionar um novo produtos à uma lista de
      //produtos. Ela valida código e os demais campos. 
      private void validar()
      {
    	  String t1 =  tfdescricao.getText();
    	  String code =  tfcodigo.getText();
    	  String quantity =  tfunidade_estoque.getText();
		  
    	  if(t1.equals("") || code.equals("") || quantity.equals(""))
    			JOptionPane.showMessageDialog(this, "Dados Incompletos!");
    	  
    	  else
    	  {
              if(!RoverNumber.verificaCodProdutolista(Integer.valueOf(tfcodigo.getText())))
                  	JOptionPane.showMessageDialog(this, "Esse Código já Existe!");
              
              else
              {
    		  	int codigo = Integer.valueOf(tfcodigo.getText());
    		  	int quantidade = Integer.valueOf(tfunidade_estoque.getText());    		  
    		  	Produto novo = new Produto(codigo, t1, quantidade);
    		  	SistemaEntrega.listaDeProdutos.add(novo);
    		  	JOptionPane.showMessageDialog(this, "Produto cadastado com sucesso!");
    		  	limpar();
              }          
    	  }
      }
   
          
}