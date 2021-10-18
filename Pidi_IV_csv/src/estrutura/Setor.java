package estrutura;



public class Setor {
	
		private String nome;
		private int lotRef; //lotação referência do setor (desejada)
		private int area; //principal area do conhecimento de cada setor
		private int lotAtual;
		
		

		public Setor(String nome, int area)
		{
			this.setNome(nome);
			this.setArea(area);
			this.setLotAtual(0);
			this.setLotRef(10); //caso nao seja especificada, a lotação padrão é 10.
		}
		public Setor(String nome, int area, int lotRef)
		{
			this.setNome(nome);
			this.setArea(area);
			this.setLotRef(lotRef);
			this.setLotAtual(0);
		}
		
		public String getNome() {
		
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getLotRef() {
			return lotRef;
		}
		public void setLotRef(int lotRef) {
			this.lotRef = lotRef;
		}
		
		public int getArea() {
			return area;
		}

		public void setArea(int area) {
			if ((area>0)&&(area<14)){ //só vai aceitar valores inteiros para as areas do conhecimento que sejam de 1 a 13.
			this.area = area;
			}
			else
			{
				
				this.area = 13;
			}
		}

		public int getLotAtual() {
			return lotAtual;
		}

		public void setLotAtual(int lotAtual) {
			this.lotAtual = lotAtual;
		}
					

		public int getVagas() {

			int vagas = this.getLotRef()-this.getLotAtual();
			return vagas;
		}
		
}
