import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerClientes
{
      public LerClientes()  {
             try   {
                 BufferedReader in = new BufferedReader(new FileReader("C:/Users/Samsung/Documents/NetBeansProjects/Delivery/src/clientes.txt"));
                 String nome;
                 String cpf;
                 String endereco;

                 while (in.ready()) {

                    nome = in.readLine();
                    cpf = in.readLine();
                    endereco = in.readLine();

                    Cliente novo = new Cliente(nome , cpf , endereco);
                    SistemaEntrega.listaDePessoas.add(novo);


            }

}
    catch (IOException e)
    {
          e.printStackTrace();
    }

    }
}



