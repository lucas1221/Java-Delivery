import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerProdutos
{
      public LerProdutos()  {
             try   {
                 BufferedReader in = new BufferedReader(new FileReader("C:/Users/Samsung/Documents/NetBeansProjects/Delivery/src/produtos.txt"));
                 int codigo;
                 String descricao;
                 int estoque;

                 while (in.ready()) {

                    codigo = Integer.valueOf(in.readLine());
                    descricao = in.readLine();
                    estoque = Integer.valueOf(in.readLine());

                    Produto novo = new Produto(codigo ,descricao , estoque);
                    SistemaEntrega.listaDeProdutos.add(novo);


            }

}
    catch (IOException e)
    {
         e.printStackTrace();
    }       
        
          
             
    }
}
