import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerEntregadores
{
      public LerEntregadores()  {
             try   {
                 BufferedReader in = new BufferedReader(new FileReader("C:/Users/Samsung/Documents/NetBeansProjects/Delivery/src/entregadores.txt"));
                 String nome;
                 String cpf;
                 String endereco;
                 String carteira;

                 while (in.ready()) {

                    nome = in.readLine();
                    cpf = in.readLine();
                    endereco = in.readLine();
                    carteira = in.readLine();

                    Entregador novo = new Entregador(nome , cpf , endereco , carteira);
                    SistemaEntrega.listaDePessoas.add(novo);


            }

}
    catch (IOException e)
    {
          e.printStackTrace();
    }

    }
}



