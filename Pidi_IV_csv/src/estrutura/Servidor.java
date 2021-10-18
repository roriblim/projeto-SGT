package estrutura;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//import java.util.Scanner;

public class Servidor extends DefConstantes{

	
	private int area;  //cada pessoa terá uma área de interesse/domínio, a qual será referenciada por um int de 1 a 12... (pode ter mais)
	private String matricula;
	private boolean disponivel;
	private int antiguidade; //esse atributo retornará, em anos, o tempo em que o servidor se encontra no órgão.
	private Setor setor;
	public static Setor semsetor = new Setor (nomeVago, 13, 100); //este atributo não será do objeto, e sim da classe. Sempre que um servidor for criado, deve ter algum setor...

	private String nome;
	private int idade;
	private String CPF;
	private LocalDate dataposse;
	
    public Servidor(String[] metadados) {
    	
    	this.setNome(metadados[0]);
    	this.setMatricula(metadados[1]);
    	this.setAntiguidade(metadados[2]);
    	this.setArea(Integer.parseInt(metadados[4]));
    	this.setDisponivel(metadados[5]);
    	
    }

//VER COMO FICA A QUESTÃO DE INCREMENTAR A LOTAÇÃO DO SETOR QUANDO INDICO O SETOR DE CADA SERVIDOR!!!!!

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		if ((area>0)&&(area<14)){
		this.area = area;
		}
		else
		{
			this.area = 13;
		}
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String d) {
		
		
		if (d.equals("s"))
		{
			this.disponivel = true;
		}
		else
		{
			this.disponivel = false;
		}

	}

	public int getAntiguidade() {
		return antiguidade;
	}

	public void setAntiguidade(String dataStr) {
		
		LocalDate hoje = LocalDate.now();
		setDataPosse(dataStr); 
		this.antiguidade = (int) (ChronoUnit.DAYS.between(this.dataposse, hoje))/365;
	}
	
	
	public void setDataPosse(String dataStr)
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		dataposse = LocalDate.parse(dataStr, formato); 
	}
	public LocalDate getDataPosse()
	{
		return this.dataposse;
	}
	
	

	public void alocar(Setor t)
	{
		if (t==null)
		{
			t = semsetor;
		}
		if (this.getSetor()!=null)
		{this.getSetor().setLotAtual(this.getSetor().getLotAtual()-1);}
		this.setSetor(t);
		t.setLotAtual(t.getLotAtual()+1);
		
	}
	public void retirar(Setor t)
	{
		this.setSetor(null);
		t.setLotAtual(t.getLotAtual()-1);
		
	}
	
	public void trocarcom(Servidor s)
	{
		Setor thisSetor = this.getSetor();
		
	//	if (s.getSetor()!=null)
	//	{
		    Setor sSetor = s.getSetor();
	
		
		if ((thisSetor!=null)&&(sSetor!=null)) {
	
		this.retirar(thisSetor);
		this.alocar(sSetor);
		s.retirar(sSetor);
		s.alocar(thisSetor);
		
		}
		else if ((thisSetor!=null)&&(sSetor==null)) {
			
		this.retirar(thisSetor);
		s.alocar(thisSetor);
		
		}
		else if ((thisSetor==null)&&(sSetor!=null)) {
			
		s.retirar(sSetor);
		this.alocar(sSetor);
		
		}
		
	}

	public Setor getSetor() {
		return setor;
	}


	public void setSetor(Setor setor) {

		this.setor = setor;
	
	}

	
	public String servidorLinha() {
		String disp;
		if (this.isDisponivel()==true) {disp = "s";}
		else {disp = "n";}
		return this.getNome()+";"+this.getMatricula()+";"+this.getDataPosse()+";"+this.getSetor().getNome()+";"+this.getArea()+";"+disp;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		
		
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}

	
	

}
