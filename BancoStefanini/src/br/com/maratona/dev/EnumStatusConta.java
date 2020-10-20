package br.com.maratona.dev;

public enum EnumStatusConta {

	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo");
	
	private String descricao;
	private Integer codigo;
	
	private EnumStatusConta(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
}
