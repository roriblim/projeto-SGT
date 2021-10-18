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



/* SGT (Sistema de Gerenciamento de talentos) vers�o 2.7 (agosto de 2021)
 * Disciplina: Projeto de Integra��o Dirigida e Interdisciplinar
 * */

public class Execucao extends DefConstantes {


	public static void main(String[] args) 
	{
				  
		  //leitura do arquivo .csv com dados dos servidores
		  Scanner scann = new Scanner(System.in);
		  System.out.println("Por favor informe o caminho do arquivo a ser lido que contenha os dados dos servidores. "
		  		+ "\nO caminho deve conter tamb�m o nome do arquivo e a extens�o. \nOBS.: O caminho do arquivo n�o deve conter espa�os. Exemplo: C:\\Users\\Fulano\\servidores.csv.");
	
		
		  String path = scann.next();
		 
		  Orgao mjsp = new Orgao();
		  
		  mjsp.setServidores(leCSVServidores(path,dicSetores));
		  
		  String opcao = "1";
		 Proposta p1=null;
		 int resultadoprop=1;
		 System.out.println("\nBem vindo(a) ao SGT (SISTEMA DE GERENCIAMENTO DE TALENTOS) vers�o 2.7!\n");
		//-----------------MENU GERAL---------------------
		do 
		{	
			System.out.println("----------------Menu SGT 2.7----------------");
			System.out.println("Digite uma op��o!");
			System.out.println("1. Dados de Servidores");
			System.out.println("2. Setores");
			System.out.println("3. Servidores por Setor");
			System.out.println("4. Servidores por �rea de interesse");
			System.out.println("5. Servidores nomeados e n�o alocados");
			System.out.println("6. Nova proposta");
			System.out.println("7. Proposta em an�lise");
			System.out.println("8. Executar proposta");
			System.out.println("9. ICT (�ndice de correspond�ncia de talentos)");
			System.out.println("10. Executar aloca��o independente");
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
				{System.out.println("Digite o nome do setor desejado com a sigla em mai�sculas. \nExemplo: ASJUR"); 
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
				System.out.println("Escolha a �rea de interesse, conforme as op��es a seguir.");
				System.out.println("1. Engenharia El�trica \n2. Tecnologia da Informa��o \n3. Comunica��o \n4. Finan�as"
						+ "\n5. Contabilidade \n6. Rela��es Pessoais \n7. Medicina \n8. Psicologia \n9. Arquivologia"
						+ "\n10. Fiscaliza��o e Auditoria \n11. Economia \n12. Direito \n13. Geral/sem �rea/n�o declarada");
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
					System.out.println("Os servidores dispon�veis para lota��o s�o:");
					mjsp.mostraServSemSetor(dicAreas);
					System.out.println("Digite o �ndice do servidor desejado para lota��o.");
					String escolhaStr = scann.next();
					int index = Integer.parseInt(escolhaStr);
				
					System.out.println("Esta � a atual situa��o de setores no �rg�o:");
					System.out.println(mjsp.mostraSetores(dicAreas, dicSetores));
					System.out.println("Digite em caixa alta a sigla do setor que deseja que tenha a lota��o aumentada ao final do procedimento.\nExemplo: ASJUR");
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
							System.out.println("Deseja tentar novamente, ou esta proposta � satisfat�ria?\nDigite: \nT - Tentar novamente \nS - � satisfat�ria/Menu Principal");
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
					System.out.println("N�o h� propostas em aberto. Utilize o item 7 do Menu para gerar a proposta.");
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
					System.out.println("N�o h� propostas em aberto para executar. Utilize o item 7 do Menu para gerar a proposta.");
					}
				else
					{
					p1.mostraProposta();
					System.out.println(mjsp.leProposta(p1));
					if(resultadoprop==0)
						{
						System.out.println("Erro na execu��o.");
						}
					else
						{
						System.out.println("Tem certeza de que deseja executar essa proposta? Digite:\nS - SIM\nN - N�O");
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
				System.out.println("Os servidores dispon�veis para lota��o s�o:");
				mjsp.mostraServSemSetor(dicAreas);
				System.out.println("Digite o �ndice do servidor desejado para lota��o.");
				String escolhaStr = scann.next();
				Setor set=null;
				int index = 0;
				try 
					{
					index = Integer.parseInt(escolhaStr);	
					System.out.println("Esta � a atual situa��o de setores no �rg�o:");
					System.out.println(mjsp.mostraSetores(dicAreas, dicSetores));
					System.out.println("Digite em caixa alta a sigla do setor em que deseja realizar a ALOCA��O FOR�ADA (SEM PROPOSTA).\nExemplo: ASJUR");
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
							System.out.println("Tem certeza de que deseja executar essa ALOCA��O FOR�ADA? Digite:\nS - SIM\nN - N�O");
							escolhaStr = scann.next();
							if (escolhaStr.equals("S")||escolhaStr.equals("s"))
								{
								mjsp.getServidores().get(index).alocar(set);
								System.out.println("Aloca��o feita com sucesso!");
								}
						}
						else
						{
							if (set.getNome().equals(nomeVago))
							{
								System.out.println("N�o � poss�vel alocar no setor Sem setor.");
							}
							if (mjsp.getServidores().get(index).getSetor().getNome()!=nomeVago)
							{
								System.out.println("N�o foi poss�vel alocar o servidor "+ mjsp.getServidores().get(index).getNome()+ " no setor "+set.getNome() +", pois j� est� lotado no setor "+mjsp.getServidores().get(index).getSetor().getNome());
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
						+ "1. Dados de servidores:\n      Nessa op��o � poss�vel consultar os servidores do �rg�o MJSP e suas respectivas lota��es, �rea de interesse e antiguidade.\n\n"
						+ "2. Setores:\n       Nessa op��o � poss�vel consultar todos os setores que o �rg�o possui.\n\n"
						+ "3. Servidores por Setor:\n       Nessa op��o � poss�vel consultar os servidores de um determinado setor do �rg�o MJSP.\n\n"
						+ "4. Servidores por �rea de interesse:\n       Nessa op��o � poss�vel consultar todos os servidores do �rg�o que tenham interesse/dom�nio em determinada �rea do conhecimento.\n\n"
						+ "5. Servidores nomeados e n�o alocados:\n       Nessa op��o � poss�vel verificar os servidores nomeados que ainda n�o est�o alocados dentro MJSP, ou seja os servidores dispon�veis.\n\n"
						+ "6. Nova proposta:\n       Nessa op��o � poss�vel solicitar uma nova proposta de aloca��o para um servidor n�o alocado. \nO usu�rio deve colocar como entradas: o servidor a ser lotado e o setor final que deseja que aumente sua lota��o em uma unidade, ainda que o setor e o servidor sejam de �reas diversas.\n\n"
						+ "7. Proposta em an�lise:\n       Nessa op��o � poss�vel verificar a proposta de aloca��o que est� em an�lise.\n\n"
						+ "8. Executar proposta:\n       Nessa op��o � poss�vel executar uma proposta de aloca��o. Ao confirmar a execu��o, a proposta em an�lise � zerada.\n\n"
						+ "9. ICT (�ndice de correspond�ncia de talentos):\n       Calcula o ICT (�ndice de correspond�ncia de talentos) no �rg�o. Em regra, ao fazer aloca��es seguindo as propostas sugeridas, o ICT deve sempre aumentar ou, no m�nimo, se manter (caso em que n�o houver setor compat�vel � �rea do servidor a ser lotado).\n"
						+ "Esse �ndice mede a porcentagem de servidores j� lotados cuja �rea de interesse tem compatibilidade com a �rea de lota��o.\n\n"
						+ "10. Executar aloca��o independente:\n       Nessa op��o � poss�vel realizar uma aloca��o 'for�ada', ou seja, alocar um servidor em determinada �rea, independente de "
						+ "sua �rea de interesse ou independente da lota��o m�xima do �rg�o.\n\n"
						+ "11. Ajuda:\n       Explica��o sobre as op��es dispon�veis no Menu.\n\n"
						+ "Outro:\n        Caso digite outra op��o, o programa ser� automaticamente fechado.\n\n"
						); 
				}
			case "12":
			{
			System.out.println("Digite o nome do arquivo que deseja gravar (com o caminho completo). Exemplo: C:\\Users\\Fulano\\servidores.csv"); 
			String escolhaStr = scann.next();
			gravaCSVServidores(escolhaStr, mjsp.getServidores());
			System.out.println("Arquivo gravado com sucesso!");
			
			}
				//OBS.: SUGEST�O PARA O FUTURO: FAZER UMA OUTRA OP��O PARA GRAVAR UM ARQUIVO NOVO COM AS ALTERA��ES FEITAS
			default: ; //n�o faz nada e sai 
			}
		}while (opcao.equals("1")||opcao.equals("2")||opcao.equals("3")||opcao.equals("4")||opcao.equals("5")||opcao.equals("6")||opcao.equals("7")||opcao.equals("8")||opcao.equals("9")||opcao.equals("10")||opcao.equals("11")||opcao.equals("12"));
	scann.close();
	}
		  //-----------------FIM DO MENU GERAL---------------------
		  //-----------------------------------------------
			
	//o seguinte m�todo � respons�vel por ler um arquivo CSV de servidores e gerar por meio dele objetos servidores e setores.
	public static ArrayList<Servidor> leCSVServidores(String path, Map<String,Setor> dicSet)
	{
		
		ArrayList<Servidor> servidores = new ArrayList<Servidor>() ;
		
		
	     try (BufferedReader br = new BufferedReader(new FileReader(path))){
	    	
	    	
	    	 String line = br.readLine(); //essa primeira linha ser�o os nomes das colunas. portanto, ler de novo:
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
