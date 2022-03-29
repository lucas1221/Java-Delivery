/*Essa Janela adiciona um novo Entregador a lista de Entregadores*/
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

public class JanelaNovoEntregador extends JFrame implements ActionListener
{
	private JTextField tfNome;
	private JLabel lNome;
	
	private JTextField tfCpf;
	private JLabel lCpf;
	
	private JTextField tfEndereco;
	private JLabel lEndereco;
	
	
	private JTextField tfCarteiradeTrabalho;
	private JLabel lCarteiradeTrabalho;
	
	private JButton btLimpar;
	private JButton btCadastrar;
	
	private Container container;
	
	private List<Pessoa> listaDePessoas;

	public JanelaNovoEntregador(List<Pessoa> listaDePessoas)
	{
		this.listaDePessoas = listaDePessoas;

		this.setLayout(new FlowLayout());
		this.pack();
		this.setResizable(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setTitle("Novo Entregador");
		this.setSize(480,480);	
		
		tfNome = new JTextField(40);
		tfCpf = new JTextField(40);
		tfEndereco = new JTextField(40);
		tfCarteiradeTrabalho = new JTextField(40);
		
		lNome = new JLabel("Nome: ");
		lCpf = new JLabel("CPF: ");
		lEndereco = new JLabel("Endereço: ");
		lCarteiradeTrabalho = new JLabel("Carteira de Trabalho: ");
		
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
		container.add(lCarteiradeTrabalho);
		container.add(tfCarteiradeTrabalho);
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
	        tfCarteiradeTrabalho.setText("");
	    }
	  
          //Essa função é a responsável por adicionar um novo entregador à uma lista de
         //entregadores. Ela valida CPF e os demais campos.
	  private void validar()
	  {
		  
		  String t1 = tfNome.getText();
  		  String t2 = tfCpf.getText();
  		  String t3 = tfEndereco.getText();
  		  String t4 = tfCarteiradeTrabalho.getText();
  		  
    	  if(t1.equals("") || t2.equals("") || t3.equals("") || t4.equals(""))
    	  {
    		  JOptionPane.showMessageDialog(this, "Dados Incompletos!");
    		  return;
    	  }
    	  
    	  else{    		  
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

                                if(!RoverNumber.ehInteiro(t4))
                                {
                                    JOptionPane.showMessageDialog(this, "Número de Carteira de Trabalho não é válido!");
                                    return;
                                }    
		  
	  			else
	  			{
                                    if(!RoverNumber.verificaCPFlista(t2))
                                        JOptionPane.showMessageDialog(this, "Esse CPF já existe!");
                                    
                                    else
                                    {
	  				Entregador novo = new Entregador(tfNome.getText(), tfCpf.getText(), tfEndereco.getText(), tfCarteiradeTrabalho.getText());
					SistemaEntrega.listaDePessoas.add(novo);
					JOptionPane.showMessageDialog(this, "Entregador cadastado com sucesso!");
					limpar();
                                    }    
                                }
    	  }
		  
		  
	  }
  
	     
}