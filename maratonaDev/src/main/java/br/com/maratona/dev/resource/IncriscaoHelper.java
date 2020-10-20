package br.com.maratona.dev.resource;

import java.util.ArrayList;
import java.util.List;

public class IncriscaoHelper {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public void init() {
		pessoas.add(new Pessoa("Thiago", 1));
		pessoas.add(new Pessoa("Maria", 2));
		pessoas.add(new Pessoa("José", 3));
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public Pessoa findPessoa(Integer id) {
		init();
		for (Pessoa indice: pessoas) {
			if(indice.getMatricula().equals(id)) {
				return indice;
			}
		}
		return null;
	}
}
