package estrutura;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.HashMap;
import java.util.Map;


public class Orgao extends DefConstantes {
	
	
	private ArrayList<Servidor> servidores;
	
	//m�todo construtor
	public Orgao()
	{
		this.setServidores(new ArrayList<Servidor>());
	}

	//m�todos para adicionar servidores ao �rg�o
	public void adicionaServidor(Servidor se) {
		this.servidores.add(se);
	}
	public void adicionaServidor(Servidor se, Servidor se2) {
		this.servidores.add(se); this.servidores.add(se2);
	}
	public void adicionaServidor(Servidor se, Servidor se2, Servidor se3) {
		this.servidores.add(se); this.servidores.add(se2);this.servidores.add(se3);
	}
	public void adicionaServidor(Servidor se, Servidor se2, Servidor se3, Servidor se4) {
		this.servidores.add(se); this.servidores.add(se2);this.servidores.add(se3);
		this.servidores.add(se4); 
	}
	public void adicionaServidor(Servidor se, Servidor se2, Servidor se3, Servidor se4, Servidor se5) {
		this.servidores.add(se); this.servidores.add(se2);this.servidores.add(se3);
		this.servidores.add(se4); this.servidores.add(se5); 
	}
	public void adicionaServidor(Servidor se, Servidor se2, Servidor se3, Servidor se4, Servidor se5, Servidor se6) {
		this.servidores.add(se); this.servidores.add(se2);this.servidores.add(se3);
		this.servidores.add(se4); this.servidores.add(se5); this.servidores.add(se6); 
	}
	
	
	//------------------------------------------------------
		//M�TODO QUE MOSTRA SERVIDORES DO �RG�O com a �rea de interesse e antiguidade respectivas
		public String mostraServidoresDados(Map<String,String> dic) {
			String lista= "**SERVIDORES DO �RG�O **\n�NDICE--------------NOME-----------------------�REA DE INTERESSE -------- SETOR ATUAL----ANTIGUIDADE ";
			for (Servidor u:servidores)
			{
				String nome = u.getNome();
				String area = dic.get(Integer.toString(u.getArea()));
				String setor = u.getSetor().getNome();
				
				int lenNome = nome.length();
				int lenArea = area.length();
				int lenSetor = setor.length();
				
				int tracoNome = 40-lenNome;
				if (tracoNome<=1) {tracoNome = 2;}
				int tracoArea = 30-lenArea;
				if (tracoArea<=1) {tracoArea = 2;}
				int tracoSetor = 15-lenSetor;
				if (tracoSetor<=1) {tracoSetor = 2;}
				
				lista = lista + "\n  "+this.getServidores().indexOf(u) +"---" +nome + "-".repeat(tracoNome)+area+"-".repeat(tracoArea)+setor+"-".repeat(tracoSetor)+ u.getAntiguidade();
			}
				
			return lista+"\n";
		}

	//------------------------------------------------------
	//M�TODO QUE RETORNA O N�MERO DE SERVIDORES DO �RG�O
	
	public int contaServidores() {
		int q = 0;
	/*	for (Servidor u:servidores)
		{
			q++;
		}
		*/
		q = this.getServidores().size();
		return q;
	}

	//------------------------------------------------------
	//M�TODO QUE INFORMA SE O SETOR DO INPUT TEM ALGU�M LOTADO 
	
	public boolean preenchidonoOrgao(Setor set) {
		boolean existe = false;
		for (Servidor u:servidores)
		{
			if (u.getSetor()==set)
			{
				existe= true;
				return existe;
			}
		}
		return existe;
	}
	
	//------------------------------------------------------
	//M�TODO QUE INFORMA SE O SERVIDOR EXISTE NO �RG�O
	public boolean existenoOrgao(Servidor serv) {
		boolean existe = false;
		for (Servidor u:servidores)
		{
			if (u==serv)
			{
				existe= true;
				return existe;
			}
		}
		return existe;
	}
	
	//GETTER E SETTER DO ARRAYLIST DE SERVIDORES ( O ATRIBUTO DA CLASSE �RG�O)
	public ArrayList<Servidor> getServidores() {
		return servidores;
	}

	public void setServidores(ArrayList<Servidor> servidores) {
		this.servidores = servidores;
	}

	//------------------------------------------------------
	//M�TODO QUE VAI GERAR UMA LISTA DOS SERVIDORES DO �RG�O QUE SEJAM DE DETERMINADA �REA DE CONHECIMENTO/INTERESSE
	public ArrayList<Servidor> listaServArea (String a){
//		este m�todo retornar� uma lista dos servidores do �rg�o de determinada �rea do conhecimento.
		ArrayList<Servidor> listaarea = new ArrayList<Servidor>();
		
		for (Servidor u:servidores)
		{
			if (u.getArea()==Integer.parseInt(a))
			listaarea.add(u);
		}
		return listaarea;
	}

	//------------------------------------------------------
	//M�TODO QUE VAI GERAR UMA LISTA DOS SERVIDORES DO �RG�O QUE SEJAM DE DETERMINADO SETOR
	public ArrayList<Servidor> listaServSetor (Setor se){
//		este m�todo retornar� uma lista dos servidores do �rg�o de determinado setor.
		ArrayList<Servidor> listasetor = new ArrayList<Servidor>();
		
		for (Servidor u:servidores)
		{
			if (u.getSetor()==se)
			listasetor.add(u);
		}
		return listasetor;
	}	
	
	public void mostraServSemSetor(Map<String,String> dicArea) {
//		este m�todo retornar� os servidores nomeados mas sem setor do �rg�o
		ArrayList<Servidor> listasem = this.listaServSemSetor();
		System.out.println("\n--------------------------------");
		System.out.println("SERVIDORES SEM SETOR DO �RG�O: ");
		for (Servidor u:listasem)
		{
			System.out.println(u.getNome()+ "  --- �ndice no �rg�o: "+this.getServidores().indexOf(u)+" --- �REA: "+dicArea.get(Integer.toString(u.getArea()))  +"\n");
			
		}
	}
	//------------------------------------------------------
	//M�TODO QUE VAI GERAR UMA LISTA DOS SERVIDORES DO �RG�O AINDA SEM SETOR
	public ArrayList<Servidor> listaServSemSetor (){
//		este m�todo retornar� uma lista dos servidores sem setor no �rg�o 
		ArrayList<Servidor> listasem = new ArrayList<Servidor>();
		
		for (Servidor u:servidores)
		{
			if (u.getSetor().getNome().equals(nomeVago))
			{listasem.add(u);
			//System.out.println("Sem setor: "+u.getNome()); //Se quiser ver cada um, descomente esta linha.
			}
		}
		return listasem;
	}	
	
	//------------------------------------------------------
	//M�TODO QUE VAI MOSTRAR OS SERVIDORES DO �RG�O QUE S�O DE DETERMINADO SETOR
	public String mostraServidoresSetor(Setor se) {
		String mostra= "**SERVIDORES DO �RG�O DO SETOR "+se.getNome() + "**";
	
		ArrayList<Servidor> listaset = this.listaServSetor(se);
		
		for (Servidor u:listaset)
		{
			mostra = mostra + "\n" +u.getNome();
			
		}

		return mostra +"\n";
	}
	
	//------------------------------------------------------
	//M�TODO QUE VAI MOSTRAR OS SERVIDORES DO �RG�O QUE S�O DE DETERMINADA �REA DO CONHECIMENTO/INTERESSE
	public String mostraServidoresArea(String a, Map<String,String> dic) {
		
		String mostra= "**SERVIDORES DO �RG�O DA �REA "+ dic.get(a) + "**";
		int quant=0;
		
		ArrayList<Servidor> listaArea = this.listaServArea(a);
		
		for (Servidor u:listaArea)
		{
			mostra = mostra + "\n" +u.getNome();
			quant++;
		}
		if (quant==0)
		{
		mostra =mostra+ "\n Nenhum servidor no �rg�o que tenha declarado ser dessa �rea de conhecimento.";
		}
		return mostra +"\n";
	}
	
	//------------------------------------------------------
	//M�TODO QUE VAI MOSTRAR OS SETORES DO �RG�O e suas respectivas lota��es
	public String mostraSetores(Map<String,String> dicArea, Map<String,Setor> dicSet) {
		
		ArrayList<Setor> setores = new ArrayList<Setor>();
		String lista= "**SETORES DO �RG�O**";
		String listasem ="";
		
		for (Servidor u:servidores)
		{
			boolean jatem=false;
			
			for (Setor m:setores)
			{
				if (u.getSetor()==m)
				{
					//se cai aqui, � pq o setor desse servidor u j� foi contabilizado no array
					//entao, nao precisa contar de novo.
					
					jatem=true;
				}
			}
			
			if (jatem==false) 
			{
				setores.add(u.getSetor());
				if (u.getSetor().getNome()!=nomeVago)
				{				lista = lista + "\n" +u.getSetor().getNome() + "  --- LOT. ATUAL: "+u.getSetor().getLotAtual() + " --- LOT. DESEJADA: " +u.getSetor().getLotRef() +" --- �rea: "+dicArea.get(Integer.toString(u.getSetor().getArea())) ; }
				else
				{         listasem = u.getSetor().getNome() + "  --- QUANTIDADE: "+u.getSetor().getLotAtual();         }
			}
		}
		
		for (String u : dicSet.keySet()) 
		{ 
			boolean jatem = false;
			for (Setor m:setores)
			{
				if (m==dicSet.get(u))
				{
					jatem=true;
				}
			}
			if (jatem==false)
			{
				Setor novo = dicSet.get(u);
				setores.add(novo);
				if (novo.getNome()!=nomeVago)
				{				lista = lista + "\n" +novo.getNome() + "  --- LOT. ATUAL: "+novo.getLotAtual() + " --- LOT. DESEJADA: " +novo.getLotRef() +" --- �rea: "+dicArea.get(Integer.toString(novo.getArea())) ; }
				else
				{         listasem = novo.getNome() + "  --- QUANTIDADE: "+ novo.getLotAtual();}
			}
			
			
		}
		lista=lista+ "\n"+listasem+"\n";
	
			
		return lista;
	}
	
	//-----------------------------------------------------
	
public ArrayList<Setor> listaSetores(Map<String,String> dicArea, Map<String,Setor> dicSet) {
		
		ArrayList<Setor> setores = new ArrayList<Setor>();
				
		for (Servidor u:servidores)
		{
			boolean jatem=false;
			
			for (Setor m:setores)
			{
				if (u.getSetor()==m)
				{
					//se cai aqui, � pq o setor desse servidor u j� foi contabilizado no array
					//entao, nao precisa contar de novo.
					
					jatem=true;
				}
			}
			
			if (jatem==false) 
			{
				setores.add(u.getSetor());

			}
		}
		
		for (String u : dicSet.keySet()) 
		{ 
			boolean jatem = false;
			for (Setor m:setores)
			{
				if (m==dicSet.get(u))
				{
					jatem=true;
				}
			}
			if (jatem==false)
			{
				Setor novo = dicSet.get(u);
				setores.add(novo);
				
			}
						
		}
				
		return setores;
	}
	
	
	
	//------------------------------------------------------
	//-------------CORA��O DO PROJETO-----------------------

	//M�TODO QUE VAI SER ACIONADO PELO USU�RIO PARA SUGERIR AS PROPOSTAS DE REALOCA��O DE SERVIDOR, 
	//COM BASE EM UM SERVIDOR NOVO "a" E UMA AN�LISE DA SITUA��O ATUAL DO �RG�O.
	
	public int geraProposta (Proposta p,  Map<String,Setor> dicSet)
	{
		//int[] proposta = new int[3];
		//proposta[0]=0;proposta[1]=0;proposta[2]=0;
	
//		int[] prop = {-1,-1,-1,0};
	
		int numprocura=0;
//		int numproposta=p.getProp().get(3);
		p.getProp().set(0, this.getServidores().indexOf(p.getNovoserv())); //vai setar o elemento de �ndice 0 do array proposta como o �ndice do servidor no arraylist do �rg�o.
		int areaServ = p.getNovoserv().getArea();
		
		boolean ok = this.setorCompativelnoOrgao(areaServ,dicSet);
		
		if (ok==false) {
			areaServ = 13;
			ok = this.setorCompativelnoOrgao(areaServ,dicSet);
			if (ok==true)
			{System.out.println("Nenhum setor no �rg�o atualmente tem compatibilidade com a �rea do servidor. \nSer� feita a proposta considerando a �rea Geral/sem �rea.");}
			
		}
		
		if (p.getNovoserv().getSetor().getNome().equals(nomeVago)&&(p.getSetorvago().getLotAtual()<p.getSetorvago().getLotRef())&&(ok==true))
		{
			//VERIFICACAO DA PRIMEIRA POSSIBILIDADE PARA OFERECER PROPOSTA:
			if ((p.getSetorvago().getArea()==areaServ))
			{
				numprocura++;
				if (numprocura>p.getProp().get(3))
				{
					p.getProp().set(3, numprocura);
					return numprocura;
				}
			}
			
			//VERIFICACAO DA SEGUNDA POSSIBILIDADE PARA OFERECER PROPOSTA, A QUAL SER� DAR� PREFER�NCIA AOS SERVIDORES LOTADOS POR ORDEM DE ANTIGUIDADE:
			ArrayList<Servidor> servCaso2 = new ArrayList<Servidor>(); 	
			ArrayList<Integer> antigCaso2 = new ArrayList<Integer>(); 
			
			int atendemSegundaCond=0;       //quantos servidores do �rg�o atendem a essa segunda condi��o?
			
			for (Servidor a:servidores)    
				//esse primeiro for vai contar quantos servidores do �rg�o atendem � segunda possibilidade de troca, e verificar qual o servidor mais antigo dentre eles.
			{
				if ((a.getArea()==p.getSetorvago().getArea())&&(areaServ==a.getSetor().getArea())&&(a.getSetor()!=p.getSetorvago())&&(a.getSetor().getNome()!=nomeVago))
						{
							servCaso2.add(a);
							atendemSegundaCond++;
							antigCaso2.add(a.getAntiguidade());
						}
			}
			Collections.sort(antigCaso2);
			

			ArrayList<Servidor> jafoi = new ArrayList<Servidor>();
			    //VERIFICACAO DOS CASOS DA SEGUNDA POSSIBILIDADE
			if (atendemSegundaCond>0)
			{
				for (int auxi=0;(auxi<antigCaso2.size());auxi++)  
				{	
					for (Servidor a: servCaso2)
					{
						if ((a.getAntiguidade()==antigCaso2.get(antigCaso2.size()-1-auxi))&&(!jafoi.contains(a)))
							{
								numprocura++;
								jafoi.add(a);
								if (numprocura>p.getProp().get(3))
								{
									p.getProp().set(3, numprocura);
									p.getProp().set(1, this.getServidores().indexOf(a));
									return numprocura;
								}
							}
					}
				}
						
			}
			
			
		//VERIFICACAO DA TERCEIRA POSSIBILIDADE PARA OFERECER PROPOSTA. AQUI NAO SER� MAIS LEVADA EM CONSIDERA��O A ORDEM DE ANTIGUIDADE, TENDO EM VISTA QUE SER�O MANUSEADOS DOIS SERVIDORES
			//...J� LOTADOS NO �RG�O, EM VEZ DE APENAS UM. ASSIM, QUALQUER POSSIBILIDADE DE TROCA QUE CUMPRA OS REQUISITOS SER� SUGERIDA PELO SISTEMA.
			for (Servidor a:servidores)    
				//esse primeiro for vai contar quantos servidores do �rg�o atendem � segunda possibilidade de troca, e verificar qual o servidor mais antigo dentre eles.
			{
				for (Servidor b:servidores)
				{
					if ((a!=b)&&(b.getArea()==p.getSetorvago().getArea())&&(areaServ==a.getSetor().getArea())&&(a.getArea()==b.getSetor().getArea())&&(b.getSetor()!=p.getSetorvago())&&(a.getSetor()!=b.getSetor())&&(a.getSetor().getNome()!=nomeVago)&&(b.getSetor().getNome()!=nomeVago))	
					{
						numprocura++;
						if (numprocura>p.getProp().get(3))
						{
							p.getProp().set(1, this.getServidores().indexOf(a));
							p.getProp().set(2, this.getServidores().indexOf(b));
							p.getProp().set(3, numprocura);
							return numprocura;		
						}
					}
				}
			}
			
			return 1;	
		}
		else
		{
			System.out.println("N�o foi poss�vel gerar proposta com os par�metros solicitados.\n");
			if (!p.getNovoserv().getSetor().getNome().equals(nomeVago))
			{System.out.println("O servidor "+p.getNovoserv().getNome()+ " n�o � novo, j� est� no setor "+p.getNovoserv().getSetor().getNome()+".");}
			if (p.getSetorvago().getLotAtual()>=p.getSetorvago().getLotRef())
			{System.out.println("O setor "+ p.getSetorvago().getNome()+ " est� com a lota��o m�xima.");}
			if (ok==false)
			{System.out.println("O servidor n�o tem �rea de correspond�ncia no �rg�o e n�o h� setores sem �rea no �rg�o.");}
			return 0;
		}
				
			//se retornar zero sem nenhuma mensagem adicional, possivelmente j� encontrou a proposta final poss�vel.
	
	}
	
	public String leProposta(Proposta p)
	{
		
		if (p.getProp().get(3)==0)
		{
			return "�rea desejada de preenchimento: "+p.getSetorvago().getNome()+"\n"+
					"Servidor rec�m nomeado: "+p.getNovoserv().getNome()
					+ " \n N�o foi localizada proposta. Tente gerar nova proposta. Se j� gerou, por algum motivo, n�o foi bem sucedida \n";
		}
		else if ((p.getProp().get(1)==-1)&&(p.getProp().get(2)==-1))
		{
			return "�rea desejada de preenchimento: "+p.getSetorvago().getNome()+"\n" + 
					"Servidor rec�m nomeado: "+p.getNovoserv().getNome()
					+ "\n A proposta �: Que o servidor "+p.getNovoserv().getNome()+ " seja lotado diretamente no setor "+ p.getSetorvago().getNome()+ ".\n";
		}
		else if ((p.getProp().get(2)==-1))
		{
			return "�rea desejada de preenchimento: "+p.getSetorvago().getNome()+ "\n" + 
					"Servidor rec�m nomeado: "+p.getNovoserv().getNome()
					+ "\n A proposta �: Que o servidor "+p.getNovoserv().getNome()+ " seja lotado no setor " + this.getServidores().get(p.getProp().get(1)).getSetor().getNome()+ ", onde atualmente est� lotado o servidor " + this.getServidores().get(p.getProp().get(1)).getNome() +". \n"
				+"Por sua vez, o servidor "	+this.getServidores().get(p.getProp().get(1)).getNome() + " dever� ser lotado no setor "  + p.getSetorvago().getNome()+ ", pois sua �rea tem correspond�ncia com esse setor \n";
		}
		else 
		{
			return "�rea desejada de preenchimento: "+p.getSetorvago().getNome()+ "\n" + 
					"Servidor rec�m nomeado: "+p.getNovoserv().getNome() + 
					"\n A proposta �: Que o servidor "+p.getNovoserv().getNome()+ " seja lotado no setor " + this.getServidores().get(p.getProp().get(1)).getSetor().getNome()+ ", onde atualmente est� lotado o servidor " + this.getServidores().get(p.getProp().get(1)).getNome() +". \n" + 
					"Por sua vez, o servidor "	+this.getServidores().get(p.getProp().get(1)).getNome() + " dever� ser lotado no setor " +this.getServidores().get(p.getProp().get(2)).getSetor().getNome() + ", onde atualmente est� lotado o servidor "+this.getServidores().get(p.getProp().get(2)).getNome()+". \n"+
					"Por fim, por sua vez, o servidor " +this.getServidores().get(p.getProp().get(2)).getNome()+" dever� ser lotado no setor vago "+  p.getSetorvago().getNome()+ ", pois sua �rea tem correspond�ncia com esse setor \n";
		}
	}
	//------------------------------------------------------
	//M�TODO PARA EXECUTAR A PROPOSTA DO INPUT.
	
	public String executaProposta(Proposta p)
	{
		Servidor a;
		Servidor b;
		Servidor c;
		Setor bSetor;
		Setor cSetor;
		
		if (p.getProp().get(3)==0)
		{
			return "N�o foi poss�vel executar a proposta "+p.getProp()+" solicitada, pois n�o foi localizada.\n";
		}
		else if ((p.getProp().get(1)==-1)&&(p.getProp().get(2)==-1))
		{
			a= p.getNovoserv();
			a.alocar(p.getSetorvago());
			return "***Proposta "+p.getProp()+" efetivada com sucesso.***\n";
		}
		else if ((p.getProp().get(2)==-1))
		{
			a= p.getNovoserv();
			b=this.getServidores().get(p.getProp().get(1));
			bSetor=b.getSetor();
			
			b.retirar(bSetor);
			b.alocar(p.getSetorvago());
			
			a.alocar(bSetor);
			
			return "***Proposta "+p.getProp()+" efetivada com sucesso.***\n";
		}
		else
		{
			a= p.getNovoserv();
			b=this.getServidores().get(p.getProp().get(1));
			c = this.getServidores().get(p.getProp().get(2));
			bSetor=b.getSetor();
			cSetor=c.getSetor();
			
			c.retirar(cSetor);
			c.alocar(p.getSetorvago());
			
			b.retirar(bSetor);
			b.alocar(cSetor);
			
			a.alocar (bSetor);
			
			return "***Proposta "+p.getProp()+" efetivada com sucesso.***\n";
		}
	}
	
	//	o seguinte m�todo vai informar se o servidor tem um setor compat�vel com a sua �rea no �rg�o.
	public boolean setorCompativelnoOrgao(int area, Map<String,Setor> dicSet)
	{
		boolean retorno = false;
		
		
		
		for (String u : dicSet.keySet()) { 
		if ((dicSet.get(u).getArea()==area)&&(dicSet.get(u).getNome()!=nomeVago))
		{
			retorno = true;
			break;
		}
		}
		
		return retorno;
				
	}
	
	public float calculaICT()
	{
		float totalServ=0;
		float servComp=0;
		float ICP=0;
		
		for (Servidor u:servidores)
		{
			if (u.getSetor().getNome()!=(nomeVago))
			{	
				totalServ++;
				
				if (u.getSetor().getArea()==u.getArea())
				{
					servComp++;
					//System.out.println(u.getNome());
				}
				
			}		
				
		}
		
		ICP = servComp/totalServ;
		System.out.println("\nO ICP atual do �rg�o � "+ ICP);
		System.out.println("Isso significa que "+ ICP*100+ "% dos servidores atualmente lotados apresentam correspond�ncia entre sua �rea e seu setor.");
		System.out.println("Total de servidores atualmente lotados: "+ totalServ);
		System.out.println("Total de servidores COM correspond�ncia entre �rea e setor: "+ servComp);
		System.out.println("Total de servidores SEM correspond�ncia entre �rea e setor: "+ (totalServ-servComp));
		return ICP;
	}
	
	
}
