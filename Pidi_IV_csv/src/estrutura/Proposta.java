package estrutura;

import java.util.ArrayList;

public class Proposta {
	
	//public int[] prop = {0,0,0,0};
	public Servidor novoserv;
	public Setor setorvago;
	public ArrayList<Integer> prop ;

	public Proposta(Servidor serv, Setor t) {
		// TODO Auto-generated constructor stub
		
		prop = new ArrayList<Integer>(4); 
		prop.add(-1); 
        prop.add(-1); 
        prop.add(-1); 
        prop.add(0); 
		this.setNovoserv(serv);
		this.setProp(prop);
		this.setSetorvago(t);
		
	}


	public ArrayList<Integer> getProp() {
		return prop;
	}


	public void setProp(ArrayList<Integer> prop) {
		this.prop = prop;
	}


	public Servidor getNovoserv() {
		return novoserv;
	}


	public void setNovoserv(Servidor novoserv) {
		this.novoserv = novoserv;
	}


	public Setor getSetorvago() {
		return setorvago;
	}


	public void setSetorvago(Setor setorvago) {
		this.setorvago = setorvago;
	}
	
	public void mostraProposta() {
		System.out.println("Proposta: " + this.getProp()); 
		
	}
	

}
