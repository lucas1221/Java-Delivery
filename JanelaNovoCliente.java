/*Essa Janela adiciona um novo Cliente a lista de Clientes*/
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
 
public class JanelaNovoCliente extends JFrame implements ActionListener
{
    private JTextField tfNome;
    private JLabel lNome;
        
    private JTextField tfCpf;
    private JLabel lCpf;
     
    private JTextField tfEndereco;
    private JLabel lEndereco;
     
    private JButton btLimpar;
    private JButton btCadastrar;
     
    private Container container;
     
    private List<Pessoa> listaDePessoas;
 
    public JanelaNovoCliente(List<Pessoa> listaDePessoas)
    {
        this.listaDePessoas = listaDePessoas;
 
        this.setLayout(new FlowLayout());
        this.pack();
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setVisible(true);
        this.setTitle("Novo Cliente");
        this.setSize(520,520);
               
        tfNome = new JTextField(44);
        tfCpf = new JTextField(44);
        tfEndereco = new JTextField(44);

        lNome = new JLabel("Nome: ");
        lCpf = new JLabel("CPF: ");
        lEndereco = new JLabel("Endereço: ");
         
         
        btLimpar = new JButton("Limpar");
        btLimpar.addActionListener(this);
 
        btCadastrar = new JButton("Cadastrar");
        btCadastrar.addActionListener(this);
 
        container = this.getContentPane(); 
        container.add(lNome);
        container.add(tfNome);
        container.add(lCpf);
        container.add(tfCpf);
        container.add(lEndereco);
        container.add(tfEndereco);
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
     
     
      private void limpar()
        {
            tfNome.setText("");
            tfCpf.setText("");
            tfEndereco.setText("");
        }
      
      //Essa função é a responsável por adicionar um novo cliente à uma lista de
      //clientes. Ela valida CPF e os demais campos.
      private void validar()
      {
    	String t1 = tfNome.getText();
  	String t2 = tfCpf.getText();
  	String t3 = tfEndereco.getText();
  		    		  
    	  if(t1.equals("") || t2.equals("") || t3.equals(""))
    		  JOptionPane.showMessageDialog(this, "Dados Incompletos!");
    	  
    	  
    	  	else
      		{    	  		
    	  		if(!RoverNumber.isCPF(t2))
                        {
          			JOptionPane.showMessageDialog(this, "Cpf não é válido!");
                                return;
                        }

                        if(!RoverNumber.ehString(t1))
                        {    
          			JOptionPane.showMessageDialog(this, "Nome não é válido!");
                                return;
                        }        

    	  		else
    	  		{    	  		    	  		
                            if(!RoverNumber.verificaCPFlista(t2))
                                        JOptionPane.showMessageDialog(this, "Esse CPF já existe!");
                            else
                            {
    	  			Cliente novo = new Cliente(tfNome.getText(), tfCpf.getText(), tfEndereco.getText());
          			SistemaEntrega.listaDePessoas.add(novo);
          			JOptionPane.showMessageDialog(this, "Cliente cadastado com sucesso!");
          			limpar();
                            }    
    	  		}
      		}  
    	  
      }
 }
         
