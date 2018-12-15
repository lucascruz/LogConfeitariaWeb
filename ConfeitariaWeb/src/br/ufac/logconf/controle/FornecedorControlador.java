package br.ufac.logconf.controle;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;

// mudei 
@ManagedBean(name="fornecedorControlador")
@SessionScoped
public class FornecedorControlador {

	private List<Fornecedor> fornecedores;
	private FornecedorRepositorio fo;
	private CategoriaRepositorio cr;
	private Fornecedor fornecedor;
	private String chaveNome="";
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public FornecedorControlador() {
		fo = new FornecedorRepositorio();
		cr = new CategoriaRepositorio();
		
	}

	public List<Fornecedor> getFornecedores() {
		fornecedores = fo.recuperarTodos();
		return fornecedores;
	}
	

	public String getChaveNome() {
		return chaveNome;
	}

	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}

	public String incluir() {
		fornecedor = new Fornecedor();
		return "funcionarioInclusao";
	}
	
	public String adicionar() {
	fo.adicionar(fornecedor);
		return "funcionarioListagem";
	}
	
	public String editar(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		return "funcionarioEdicao";
	}
	
	public String atualizar() {
		fo.atualizar(fornecedor);
		return "funcionarioListagem";
	}
	
	public String excluir(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		return "funcionarioExclusao";
	}
	
	public String remover() {
		fo.remover(fornecedor);
		return "funcionarioListagem";
	}
}