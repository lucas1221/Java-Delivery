
public class Pessoa {
	private String nome;
	private String cpf;
	private String endereco;
        //private boolean eh_cliente;

    //public boolean getEh_cliente() {
      //  return eh_cliente;
    //}

    //public void setEh_cliente(boolean eh_cliente) {
    //    this.eh_cliente = eh_cliente;
    //}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Pessoa(String nome, String cpf, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
                //this.eh_cliente = eh_cliente;
	}
	
	
}
