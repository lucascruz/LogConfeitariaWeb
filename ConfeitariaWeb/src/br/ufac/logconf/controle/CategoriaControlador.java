package br.ufac.logconf.controle;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.logconf.entidades.Funcionario;
import br.ufac.logconf.repositorios.FuncionarioRepositorio;
import br.ufac.logconf.repositorios.PedidoRepositorio;

@ManagedBean(name="funcionarioControlador")
@SessionScoped
public class CategoriaControlador {

	private List<Funcionario> funcionarios;
	private FuncionarioRepositorio fr;
	private PedidoRepositorio pr;
	private Funcionario funcionario;
	private int funcionarioCodigo;
	private String chaveNome="";
	private String cpf;
	private String endereco;
	private int idade;
	private String nome;
	private String sexo;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public int getFuncionarioId() {
		return funcionarioCodigo;
	}

	public void setFuncionarioCodigo(int funcCodigo) {
		this.funcionarioCodigo = funcCodigo;
	}

	public CategoriaControlador() {
		fr = new FuncionarioRepositorio();
		pr = new PedidoRepositorio();
	}

	public List<Funcionario> getFuncionarios() {
	//	funcionarios = fr.recuperarTodosPorID(chaveNome);
		return funcionarios;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getChaveNome() {
		return chaveNome;
	}

	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}

	public String incluir() {
		funcionario = new Funcionario();
		return "funcionarioInclusao";
	}
	
	public String adicionar() {
		funcionario.setCpf(cpf);
		funcionario.setEndereco(endereco);
		funcionario.setIdade(idade);
		funcionario.setNome(nome);
		funcionario.setSexo(sexo);
		fr.adicionar(funcionario);
		return "funcionarioListagem";
	}
	
	public String editar(Funcionario funcionario) {
		this.funcionario = funcionario;
		//cursoCodigo = aluno.getCurso().getCodigo();
		return "funcionarioEdicao";
	}
	
	public String atualizar() {
		//funcionario.setCurso(cr.recuperar(cursoCodigo));
		fr.atualizar(funcionario);
		return "funcionarioListagem";
	}
	
	public String excluir(Funcionario aluno) {
		this.funcionario = funcionario;
		//cursoCodigo = aluno.getCurso().getCodigo();
		return "funcionarioExclusao";
	}
	
	public String remover() {
		fr.remover(funcionario);
		return "funcionarioListagem";
	}
}