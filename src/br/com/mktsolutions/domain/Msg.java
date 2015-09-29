package br.com.mktsolutions.domain;

public class Msg {
	private Long id;
	private String destinatario; 
	private Long numero;
	private String msg; 
	private Usuario usuario_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Usuario getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}
}
