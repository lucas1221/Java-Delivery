/*
Nessa classe se encontra todas as verificações:
Se CPF é válido (ou seja, só tem dígitos) e se ele já não existe na lista;
Se Código de Pedido e Produto são válidos (ou seja, só tem dígitos) e se eles já não existem na lista;
Se número da Carteira de Trabalho é válido (ou seja, só tem dígitos) e se ele já não existe na lista;
*/
import java.util.InputMismatchException; 
public class RoverNumber {       
    
     
     public static boolean existeCliente(String Cliente)
     {
         for(int i = 0; i < SistemaEntrega.listaDePessoas.size(); i ++)
         {
             if(SistemaEntrega.listaDePessoas.get(i).getNome().equals(Cliente))
                 return true;                         
         }
          
         return false; 
     }   
      
      public static boolean existeEntregador(String Entregador)
     {
         for(int i = 0; i < SistemaEntrega.listaDePessoas.size(); i ++)
         {
             if(SistemaEntrega.listaDePessoas.get(i).getNome().equals(Entregador))
                 return true;                         
         }
          
         return false; 
     }   
      
       
      public static boolean ehInteiro(String s) {    
        // cria um array de char    
        char[] c = s.toCharArray();    
        boolean caractere = false;    
  
        for (int i = 0; !caractere && i <  c.length; i++) {   
            // verifica se o char não é um dígito    
            if (!Character.isDigit(c[i]))
                 caractere = true;                                            
        }  
                if(caractere == false)
                    return true;
                 
         
                else
                    return false;
    }     
       
       
      public static boolean ehDouble(String s) {    
        // cria um array de char    
        char[] c = s.toCharArray();    
        boolean caractere = false;    
  
        for (int i = 0; !caractere && i <  c.length; i++) {   
            // verifica se o char não é um dígito ou não é um ponto    
            if (!Character.isDigit(c[i]) && c[i] != '.')
                 caractere = true;                                            
        }  
                if(caractere == false)
                    return true;
                 
         
                else
                    return false;
    }     
       
       public static boolean ehString(String s) {    
        // cria um array de char    
        char[] c = s.toCharArray();    
        boolean numero = false;    
  
        for (int i = 0; !numero && i <  c.length; i++) {   
            // verifica se o char não é um dígito    
            if (Character.isDigit(c[i]))
                 numero = true;                                            
        }  
                if(numero == false)
                    return true;
                 
         
                else
                    return false;
    }     
     
       
      public static boolean isCPF(String CPF) { 
        // considera-se erro CPF's formados por uma sequencia de numeros iguais 
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11)) 
            return(false); 
        char dig10, dig11; 
        int sm, i, r, num, peso; // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
            try { // Calculo do 1o. Digito Verificador 
                sm = 0; 
                peso = 10; 
                for (i=0; i<9; i++) { 
                // converte o i-esimo caractere do CPF em um numero: 
                    // por exemplo, transforma o caractere '0' no inteiro 0 
                    // (48 eh a posicao de '0' na tabela ASCII) 
                    num = (int)(CPF.charAt(i) - 48); 
                    sm = sm + (num * peso); peso = peso - 1;
                } 
                r = 11 - (sm % 11); 
                    if ((r == 10) || (r == 11)) 
                        dig10 = '0'; 
                     
                    else dig10 = (char)(r + 48); // converte no respectivo caractere numerico 
                    // Calculo do 2o. Digito Verificador 
                    sm = 0; 
                    peso = 11; 
                        for(i=0; i<10; i++) { 
                            num = (int)(CPF.charAt(i) - 48); 
                            sm = sm + (num * peso); 
                            peso = peso - 1; 
                        } 
                         
                        r = 11 - (sm % 11); 
                         
                        if ((r == 10) || (r == 11)) 
                            dig11 = '0'; 
                        else dig11 = (char)(r + 48); // Verifica se os digitos calculados conferem com os digitos informados. 
                         
                        if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) 
                            return(true); 
                         
                        else return(false); 
                         
                    } 
            catch (InputMismatchException erro) { 
                return(false); 
                } 
            } 
     
    public static String imprimeCPF(String CPF) { 
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
    
    public static boolean verificaCPFlista(String CPF)
		{
			boolean existe = false;
			for(int i = 0; !existe && i < SistemaEntrega.listaDePessoas.size(); i++)
			{
				if((SistemaEntrega.listaDePessoas.get(i).getCpf()).equals(CPF))
				{
					existe = true;
				}
			}
                        
			if(existe == true)
				return false;

			else
				return true;
		}
    
     public static boolean verificaCarteiralista(String Carteira)
		{
			boolean existe = false;
			for(int i = 0; !existe && i < SistemaEntrega.listaDePessoas.size(); i++)
			{
                            if(SistemaEntrega.listaDePessoas.get(i) instanceof Entregador)
                            {    
				if(((Entregador)SistemaEntrega.listaDePessoas.get(i)).getCarteiraDeTrabalho().equals(Carteira))
				{
					existe = true;
				}
                            }    
			}
                       
			if(existe == true)
				return false;

			else
				return true;
		}
     
     public static boolean verificaCodProdutolista(int CodigoProduto)
		{
			boolean existe = false;
			for(int i = 0; !existe && i < SistemaEntrega.listaDeProdutos.size(); i++)
			{
				if(CodigoProduto == (SistemaEntrega.listaDeProdutos.get(i).getCodigo()))
				{
					existe = true;
				}
			}
                        
			if(existe == true)
				return false;

			else
				return true;
		}
     
      public static boolean verificaCodPedidolista(int CodigoPedido)
		{
			boolean existe = false;
			for(int i = 0; !existe && i < SistemaEntrega.listaDePedidos.size(); i++)
			{
				if(CodigoPedido == (SistemaEntrega.listaDePedidos.get(i).getCodigo_pedido()))
				{
					existe = true;
				}
			}
                        
			if(existe == true)
				return false;

			else
				return true;
		}
 
}