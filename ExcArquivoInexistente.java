/*Tratamento de exceção no qual este Código responsável por dizer que Arquivo de leitura não existe*/
public class ExcArquivoInexistente extends Exception 
{
	public ExcArquivoInexistente () 
	{
		super("Arquivo Inexistente!");
	}
}