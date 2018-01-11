package br.com.tcc_oficina_mecanica.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static void mensagemOk(String mensagem) {

		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, facesMessage);

	}

	public static void mensagemErro(String mensagem) {

		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, facesMessage);

	}

	// Método temporário que extrai da url
	public static String getParametro(String nome) {

		// Pega o contexto da aplicação
		FacesContext facesContext = FacesContext.getCurrentInstance();

		// Pega o contexto do navegador
		ExternalContext externalContext = facesContext.getExternalContext();

		// Mapeia todos os parametros
		Map<String, String> parametros = externalContext.getRequestParameterMap();

		// Seleciona o parametro desejado
		String valor = parametros.get(nome);

		// Retorna o parametro desejado
		return valor;

	}

}
