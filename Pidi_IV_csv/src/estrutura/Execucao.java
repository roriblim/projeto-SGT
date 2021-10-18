package estrutura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;



/* SGT (Sistema de Gerenciamento de talentos) versão 2.7 (agosto de 2021)
 * Disciplina: Projeto de Integração Dirigida e Interdisciplinar
 * */

public class Execucao extends DefConstantes {


	public static void main(String[] args) 
	{
				  
		  //leitura do arquivo .csv com dados dos servidores
		  Scanner scann = new Scanner(System.in);
		  System.out.println("Por favor informe o caminho do arquivo a ser lido que contenha os dados dos servidores. "
		  		+ "\nO caminho deve conter também o nome do arquivo e a extensão. \nOBS.: O caminho do arquivo não deve conter espaços. Exemplo: C:\\Users\\Fulano\\servidores.csv.");
	
		
		  String path = scann.next();
		 
		  Orgao mjsp = new Orgao();
		  
		  mjsp.setServidores(leCSVServidores(path,dicSetores));
		  
		  String opcao = "1";
		 Proposta p1=null;
		 int resultadoprop=1;
		 System.out.println("\nBem vindo(a) ao SGT (SISTEMA DE GERENCIAMENTO DE TALENTOS) versão 2.7!\n");
		//-----------------MENU GERAL---------------------
		do 
		{	
			System.out.println("----------------Menu SGT 2.7----------------");
			System.out.println("Digite uma opção!");
			System.out.println("1. Dados de Servidores");
			System.out.println("2. Setores");
			System.out.println("3. Servidores por Setor");
			System.out.println("4. Servidores por área de interesse");
			System.out.println("5. Servidores nomeados e não alocados");
			System.out.println("6. Nova proposta");
			System.out.println("7. Proposta em análise");
			System.out.println("8. Executar proposta");
			System.out.println("9. ICT (Índice de correspondência de talentos)");
			System.out.println("10. Executar alocação independente");
			System.out.println("11. Ajuda");
			System.out.println("12. Gravar arquivo");
			System.out.println("Outro valor: sair");
			opcao = scann.next();
			switch(opcao) 
			{
			case "1": 
				{System.out.println(mjsp.mostraServidoresDados(dicAreas));break;}
			case "2": 
				{System.out.println(mjsp.mostraSetores(dicAreas, dicSetores));break;}
			case "3": 	
				{System.out.println("Digite o nome do setor desejado com a sigla em maiúsculas. \nExemplo: ASJUR"); 
					String escolhaStr = scann.next();
					try
					{
						Setor escolhaSetSet = dicSetores.get(escolhaStr);
						System.out.println(mjsp.mostraServidoresSetor(escolhaSetSet));break;
					}
					catch(Exception e)
					{
						System.out.println("Error: "+ e.getMessage());
						break;
					}
				}
			case "4":
				{
				System.out.println("Escolha a área de interesse, conforme as opções a seguir.");
				System.out.println("1. Engenharia Elétrica \n2. Tecnologia da Informação \n3. Comunicação \n4. Finanças"
						+ "\n5. Contabilidade \n6. Relações Pessoais \n7. Medicina \n8. Psicologia \n9. Arquivologia"
						+ "\n10. Fiscalização e Auditoria \n11. Economia \n12. Direito \n13. Geral/sem área/não declarada");
				String escolhaStr = scann.next();
				
				try
					{
					System.out.println(mjsp.mostraServidoresArea(escolhaStr,dicAreas));	break;
					}
				catch(Exception e)
					{
					System.out.println("Error: "+ e.getMessage());
					break;					
					}
				}
			case "5":
				{mjsp.mostraServSemSetor(dicAreas);	break;}
			case "6":
				{
				try {
					System.out.println("Os servidores disponíveis para lotação são:");
					mjsp.mostraServSemSetor(dicAreas);
					System.out.println("Digite o índice do servidor desejado para lotação.");
					String escolhaStr = scann.next();
					int index = Integer.parseInt(escolhaStr);
				
					System.out.println("Esta é a atual situação de setores no órgão:");
					System.out.println(mjsp.mostraSetores(dicAreas, dicSetores));
					System.out.println("Digite em caixa alta a sigla do setor que deseja que tenha a lotação aumentada ao final do procedimento.\nExemplo: ASJUR");
					escolhaStr = scann.next();
					Setor set=null;
					try {
					set=dicSetores.get(escolhaStr);
					}
					catch(Exception e)
					{
						System.out.println("Error: "+ e.getMessage());
						break;
					}
					String opcaoprop="T";
					
				
					p1 = new Proposta(mjsp.getServidores().get(index),set);
					do {
						resultadoprop=mjsp.geraProposta(p1,dicSetores);
						
						if (resultadoprop==0) {opcaoprop="S";}
						else {
							p1.mostraProposta();
							System.out.println(  mjsp.leProposta(p1));
							System.out.println("Deseja tentar novamente, ou esta proposta é satisfatória?\nDigite: \nT - Tentar novamente \nS - É satisfatória/Menu Principal");
							opcaoprop = scann.next();
							}
						}while(opcaoprop.equals("T"));
					}
				catch(Exception e)
					{
						System.out.println("Error: "+ e.getMessage());
						break;
			    	//System.exit(0);
					}
				break;	
				}
			case "7":
				{
				if (p1==null)
					{
					System.out.println("Não há propostas em aberto. Utilize o item 7 do Menu para gerar a proposta.");
					}
				else
					{
					try   
					  	{
						p1.mostraProposta();
					    System.out.println(  mjsp.leProposta(p1));
					  	}
					catch(Exception e)
						{
						System.out.println("Error: "+ e.getMessage());
						break;
						}
					}
				break;
				}
			case "8":
				{
				if (p1==null)
					{
					System.out.println("Não há propostas em aberto para executar. Utilize o item 7 do Menu para gerar a proposta.");
					}
				else
					{
					p1.mostraProposta();
					System.out.println(mjsp.leProposta(p1));
					if(resultadoprop==0)
						{
						System.out.println("Erro na execução.");
						}
					else
						{
						System.out.println("Tem certeza de que deseja executar essa proposta? Digite:\nS - SIM\nN - NÃO");
						String escolhaStr = scann.next();
						if (escolhaStr.equals("S")||escolhaStr.equals("s"))
							{
							System.out.println(mjsp.executaProposta(p1));
							p1=null;
							}
						
						}
					
					}
				break;
				}
			case "9":
				{
					mjsp.calculaICT(); break;
				}
			case "10":
				{
				System.out.println("Os servidores disponíveis para lotação são:");
				mjsp.mostraServSemSetor(dicAreas);
				System.out.println("Digite o índice do servidor desejado para lotação.");
				String escolhaStr = scann.next();
				Setor set=null;
				int index = 0;
				try 
					{
					index = Integer.parseInt(escolhaStr);	
					System.out.println("Esta é a atual situação de setores no órgão:");
					System.out.println(mjsp.mostraSetores(dicAreas, dicSetores));
					System.out.println("Digite em caixa alta a sigla do setor em que deseja realizar a ALOCAÇÃO FORÇADA (SEM PROPOSTA).\nExemplo: ASJUR");
					escolhaStr = scann.next();
					set=dicSetores.get(escolhaStr);
					}
				catch(Exception e)
					{
					System.out.println("Error: "+ e.getMessage());
					break;
					}
				try 
					{
						if ((set.getNome()!=(nomeVago))&&(mjsp.getServidores().get(index).getSetor().getNome()==nomeVago))	
						{
							System.out.println("Tem certeza de que deseja executar essa ALOCAÇÃO FORÇADA? Digite:\nS - SIM\nN - NÃO");
							escolhaStr = scann.next();
							if (escolhaStr.equals("S")||escolhaStr.equals("s"))
								{
								mjsp.getServidores().get(index).alocar(set);
								System.out.println("Alocação feita com sucesso!");
								}
						}
						else
						{
							if (set.getNome().equals(nomeVago))
							{
								System.out.println("Não é possível alocar no setor Sem setor.");
							}
							if (mjsp.getServidores().get(index).getSetor().getNome()!=nomeVago)
							{
								System.out.println("Não foi possível alocar o servidor "+ mjsp.getServidores().get(index).getNome()+ " no setor "+set.getNome() +", pois já está lotado no setor "+mjsp.getServidores().get(index).getSetor().getNome());
							}
						}
					}
				catch(Exception e)
					{
						System.out.println("Error: "+ e.getMessage());
						break;
					}
				break;
				}	
			case "11":
				{
				System.out.println("=========== SGT 2.0 - AJUDA =========== \n"
						+ "Menu: \n"
						+ "1. Dados de servidores:\n      Nessa opção é possível consultar os servidores do órgão MJSP e suas respectivas lotações, área de interesse e antiguidade.\n\n"
						+ "2. Setores:\n       Nessa opção é possível consultar todos os setores que o órgão possui.\n\n"
						+ "3. Servidores por Setor:\n       Nessa opção é possível consultar os servidores de um determinado setor do órgão MJSP.\n\n"
						+ "4. Servidores por área de interesse:\n       Nessa opção é possível consultar todos os servidores do órgão que tenham interesse/domínio em determinada área do conhecimento.\n\n"
						+ "5. Servidores nomeados e não alocados:\n       Nessa opção é possível verificar os servidores nomeados que ainda não estão alocados dentro MJSP, ou seja os servidores disponíveis.\n\n"
						+ "6. Nova proposta:\n       Nessa opção é possível solicitar uma nova proposta de alocação para um servidor não alocado. \nO usuário deve colocar como entradas: o servidor a ser lotado e o setor final que deseja que aumente sua lotação em uma unidade, ainda que o setor e o servidor sejam de áreas diversas.\n\n"
						+ "7. Proposta em análise:\n       Nessa opção é possível verificar a proposta de alocação que está em análise.\n\n"
						+ "8. Executar proposta:\n       Nessa opção é possível executar uma proposta de alocação. Ao confirmar a execução, a proposta em análise é zerada.\n\n"
						+ "9. ICT (Índice de correspondência de talentos):\n       Calcula o ICT (Índice de correspondência de talentos) no órgão. Em regra, ao fazer alocações seguindo as propostas sugeridas, o ICT deve sempre aumentar ou, no mínimo, se manter (caso em que não houver setor compatível à área do servidor a ser lotado).\n"
						+ "Esse índice mede a porcentagem de servidores já lotados cuja área de interesse tem compatibilidade com a área de lotação.\n\n"
						+ "10. Executar alocação independente:\n       Nessa opção é possível realizar uma alocação 'forçada', ou seja, alocar um servidor em determinada área, independente de "
						+ "sua área de interesse ou independente da lotação máxima do órgão.\n\n"
						+ "11. Ajuda:\n       Explicação sobre as opções disponíveis no Menu.\n\n"
						+ "Outro:\n        Caso digite outra opção, o programa será automaticamente fechado.\n\n"
						); 
				}
			case "12":
			{
			System.out.println("Digite o nome do arquivo que deseja gravar (com o caminho completo). Exemplo: C:\\Users\\Fulano\\servidores.csv"); 
			String escolhaStr = scann.next();
			gravaCSVServidores(escolhaStr, mjsp.getServidores());
			System.out.println("Arquivo gravado com sucesso!");
			
			}
				//OBS.: SUGESTÃO PARA O FUTURO: FAZER UMA OUTRA OPÇÃO PARA GRAVAR UM ARQUIVO NOVO COM AS ALTERAÇÕES FEITAS
			default: ; //não faz nada e sai 
			}
		}while (opcao.equals("1")||opcao.equals("2")||opcao.equals("3")||opcao.equals("4")||opcao.equals("5")||opcao.equals("6")||opcao.equals("7")||opcao.equals("8")||opcao.equals("9")||opcao.equals("10")||opcao.equals("11")||opcao.equals("12"));
	scann.close();
	}
		  //-----------------FIM DO MENU GERAL---------------------
		  //-----------------------------------------------
			
	//o seguinte método é responsável por ler um arquivo CSV de servidores e gerar por meio dele objetos servidores e setores.
	public static ArrayList<Servidor> leCSVServidores(String path, Map<String,Setor> dicSet)
	{
		
		ArrayList<Servidor> servidores = new ArrayList<Servidor>() ;
		
		
	     try (BufferedReader br = new BufferedReader(new FileReader(path))){
	    	
	    	
	    	 String line = br.readLine(); //essa primeira linha serão os nomes das colunas. portanto, ler de novo:
	    	 line = br.readLine();
	    	 String[] attributes = line.split(";");
	    	 
	    	 while (line!=null) {
	    		 //System.out.println(line);
	    		 attributes = line.split(";");
	    		 Servidor a = new Servidor(attributes);
	    		 a.alocar(dicSet.get(attributes[3]));
	    
	    		
	    		 servidores.add(a);
	    		 line = br.readLine();
	    		 
	    	 }
	     }
	     catch(IOException e)
	     {
	    	 System.out.println("Error: "+ e.getMessage());
	    	 System.exit(0);
	     }
	     
	    // System.out.println(servidores);
	     System.out.println("Arquivo lido com sucesso!");
	     return servidores;
	     
	}
	
	
	public static void gravaCSVServidores(String path, ArrayList<Servidor> servidores)
	{
		String linha = "nome;matricula;data de Lotacao;setor;area;disponivel";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			
			bw.write(linha);
			
			for (Servidor u:servidores)
			{
				bw.newLine();
				linha = u.servidorLinha();
				bw.write(linha);
				
			}
			
		}
		catch(IOException e)
		{
			System.out.println("Error: "+ e.getMessage());
	    	 System.exit(0);
		}
		
	
	}
	
	

}
