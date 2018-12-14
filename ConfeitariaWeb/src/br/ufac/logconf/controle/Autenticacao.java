package br.ufac.logconf.controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.ufac.logconf.entidades.Funcionario;



@ManagedBean
@ViewScoped
public class Autenticacao {

	private Funcionario funcionario = new Funcionario();

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public String efetuarLogin() {
		System.out.println("efetuar login: " + funcionario.getCpf());

		FacesContext context = FacesContext.getCurrentInstance();

		//boolean funcionarioExiste = new FuncionarioDAO().funcionarioExiste(funcionario);

		// Se funcionario existir loga no sitema
	/*	if (funcionarioExiste) {
			context.getExternalContext().getSessionMap().put("funcionariologado", funcionario);
			return "index?faces-redirect=true";
		}
*/
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Funcionario n�o Existe"));
		return "login?faces-redirect=true";

	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("funcionariologado");
		return "login?faces-redirect=true";
	}

}