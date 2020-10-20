package br.com.maratona.dev;

public class ContaCorrente extends Conta implements ContaPrivate, Emprestimo {
	
		private Float limite;
		
		public ContaCorrente() {
			
		}
		
		public ContaCorrente(Float limite, Integer agencia) {
			super();
			this.limite = limite;
		}
			
		public Float getLimite() {
			return limite;
		}
		
		public void setLimite(Float limite) {
			this.limite = limite;
		}
		
		@Override
		public void sacar(Double valorSaque) {
			System.out.println("Filho");
			super.sacar(valorSaque);
		}
		
		@Override
		public void saqueExtra(Float taxa) {
			// 1.5			
		}

		@Override
		public void emprestimo(Float taxa) {
			// TODO Auto-generated method stub
			
		}

		
}
