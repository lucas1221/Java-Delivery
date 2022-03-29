/*Essa janela busca um cliente a partir do CPF digitado e abre
outra janela para atualização ou remoção dos dados deste mesmo
cliente.
*/
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class JanelaBuscarCliente extends JFrame implements ActionListener
{
        private Container janelita;
	private JButton btBuscar;
	private JTextField tfCpf;
	private JLabel lCpf;
	
	public JanelaBuscarCliente()
	{
                this.setLayout(new FlowLayout());
		this.pack();
		this.setResizable(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setVisible(true);
		this.setTitle("Buscar Cliente");
		this.setSize(290,120);
		    
            
                tfCpf = new JTextField(10);		
                lCpf = new JLabel ("Cpf: ");
		
                btBuscar = new JButton ("Buscar");
		btBuscar.addActionListener(this);
		
		
                janelita = this.getContentPane(); 
                janelita.add(lCpf);
                janelita.add(tfCpf);
                janelita.add(btBuscar);                
            }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btBuscar)
		{
                        if(RoverNumber.isCPF(tfCpf.getText()))
                        {
                                buscar(tfCpf.getText());
                        }
                        
                        else
                        {    
                            JOptionPane.showMessageDialog(this, "CPF Inválido!");
                            return;
                        }
		}
	}
	
        //Essa função busca um cliente a partir do CPF digitado e, caso retorne uma busca verdadeira
        //abre uma nova janela para atualização de dados
	private void buscar (String cpf)
	{
		boolean encontrou = false;
                int aux = 0;
		for(int i = 0; !encontrou && i < SistemaEntrega.listaDePessoas.size(); i++)
																	//do lado pq é um static
		{
			if(SistemaEntrega.listaDePessoas.get(i).getCpf().equals(cpf)) 
                        {
                            encontrou = true;
                            aux = i;
                        }	
                        
		}
		
		
		if(!encontrou)
		{
                    JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
                    return;
		}
                
                else
                {
                    JanelaAtualizaCliente n = new JanelaAtualizaCliente(aux);
                }
                    
                    
              
	}
}