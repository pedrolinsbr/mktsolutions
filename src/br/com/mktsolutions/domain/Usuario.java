package br.com.mktsolutions.domain;

public class Usuario {
	private Long id;
	private String login;
	private String nome;
	private String mail;
	private String empresa;
	private String tipo;
	private String cpf;
	private String dataCad;
	private String endereco;
	private String bairro;
	private String cidade;
	private String pais;
	private String uf;
	private String tel;
	private String cel;
	private Status status;
	private String senha;
	private String status_statusid;
	private String creditos;
	private String ultimopag;
	private String valorultpag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataCad() {
		return dataCad;
	}

	public void setDataCad(String dataCad) {
		this.dataCad = dataCad;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus_statusid() {
		return status_statusid;
	}

	public void setStatus_statusid(String status_statusid) {
		this.status_statusid = status_statusid;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	public String getUltimopag() {
		return ultimopag;
	}

	public void setUltimopag(String ultimopag) {
		this.ultimopag = ultimopag;
	}

	public String getValorultpag() {
		return valorultpag;
	}

	public void setValorultpag(String valorultpag) {
		this.valorultpag = valorultpag;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		String saida = id + " - " + nome +" - " + login;
		return saida;
	}

}
