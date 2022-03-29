
public class Entregador extends Pessoa
{
	private String carteiradeTrabalho;
	
	public Entregador(String nome, String cpf, String endereco, String carteiradeTrabalho)
	{
		super(nome, cpf, endereco); 
		this.setCarteiraDeTrabalho(carteiradeTrabalho);
		
	}

	public String getCarteiraDeTrabalho() {
		return carteiradeTrabalho;
	}

	public void setCarteiraDeTrabalho(String carteiradeTrabalho) {
		this.carteiradeTrabalho = carteiradeTrabalho;
	}	
}
