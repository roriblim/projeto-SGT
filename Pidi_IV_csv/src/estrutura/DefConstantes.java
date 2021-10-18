package estrutura;

import java.util.HashMap;
import java.util.Map;

public class DefConstantes {

	public static final String nomeVago = "Sem setor";
	public static Map<String,String> dicAreas = new HashMap<String,String>();
	public static Map<String,Setor> dicSetores = new HashMap<String,Setor>();

	static {
		
		//dicionário de áreas (correspondência entre o código da área e a área)
		  dicAreas.put( "1", new String( "Engenharia Elétrica" ));
		  dicAreas.put( "2", new String( "Tecnologia da Informação" ));
		  dicAreas.put( "3", new String( "Comunicação" ));
		  dicAreas.put( "4", new String( "Finanças" ));
		  dicAreas.put( "5", new String( "Contabilidade" ));
		  dicAreas.put( "6", new String( "Relações Pessoais" ));
		  dicAreas.put( "7", new String( "Medicina" ));
		  dicAreas.put( "8", new String( "Psicologia" ));
		  dicAreas.put( "9", new String( "Arquivologia" ));
		  dicAreas.put( "10", new String( "Fiscalização e Auditoria" ));
		  dicAreas.put( "11", new String( "Economia" ));
		  dicAreas.put( "12", new String( "Direito" ));
		  dicAreas.put( "13", new String( "Geral/sem área/não declarada" ));
		// TODO Auto-generated constructor stub
		  
		//criação dos objetos setores: setor, área, lotação referência desejada.
		  Setor seele = new Setor("SEELE",1,10);
		  Setor seti = new Setor("SETI", 2, 20);
		  Setor ascom = new Setor("ASCOM",3,7);
		  Setor sepag = new Setor("SEPAG", 4, 20);
		  Setor secon = new Setor("SECON", 5, 20);
		  Setor serh = new Setor("SERH", 6, 15);
		  Setor sermed = new Setor("SERMED",7,5);
		  Setor serpsi = new Setor("SERPSI",8,7);
		  Setor serarq = new Setor("SERARQ",9,10);
		  Setor seaud = new Setor("SEAUD",10,10);
		  Setor seeco = new Setor("SEECO",11,10);
		  Setor asjur = new Setor("ASJUR",12,12);
		  Setor seger = new Setor("SEGER",13,20);
		  Setor semsetor = new Setor(nomeVago,13,100);
		  
		  dicSetores.put( "SEELE", seele);
		  dicSetores.put( "SETI", seti);
		  dicSetores.put( "ASCOM", ascom);
		  dicSetores.put( "SEPAG", sepag);
		  dicSetores.put( "SECON", secon);
		  dicSetores.put( "SERH", serh);
		  dicSetores.put( "SERMED", sermed);
		  dicSetores.put( "SERPSI", serpsi);
		  dicSetores.put( "SERARQ", serarq);
		  dicSetores.put( "SEAUD", seaud);
		  dicSetores.put( "SEECO", seeco);
		  dicSetores.put( "ASJUR", asjur);
		  dicSetores.put( "SEGER", seger);
		  dicSetores.put( nomeVago, semsetor);
	}

}
