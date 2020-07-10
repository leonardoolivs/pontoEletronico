package com.ponto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ponto.enums.PerfilEnum;

@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable {
	
	private static final long serialVersionUID = -6545519920413760447L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name="ds_nome")
	private String nome;
	
	@Column(name="ds_email")
	private String email;
	
	@Column(name="ds_senha")
	private String senha;
	
	@Column(name="ds_cpf")
	private String cpf;
	
	@Column(name="vl_hora")
	private BigDecimal valorHora;
	
	@Column(name="dt_horaTrabalhoDia")
	private Float quantidadeHorasTrabalhoDoDia;
	
	@Column(name="dt_horaAlmoco")
	private Float quantidadeHorasAlmoco;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tp_perfil")
	private PerfilEnum perfil;
	
	@Column(name="dt_criacao")
	private Date dataCriacao;
	
	@Column(name="dt_atualizacao")
	private Date dataAtualizacao;
	
	@Column(name="tp_empresa")
	private Empresa empresa;
	
	private List<Lancamento> lancamentos;

	public Funcionario(Long id, String nome, String email, String senha, String cpf, BigDecimal valorHora,
			Float quantidadeHorasTrabalhoDoDia, Float quantidadeHorasAlmoco, PerfilEnum perfil, Date dataCriacao,
			Empresa empresa, List<Lancamento> lancamentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.valorHora = valorHora;
		this.quantidadeHorasTrabalhoDoDia = quantidadeHorasTrabalhoDoDia;
		this.quantidadeHorasAlmoco = quantidadeHorasAlmoco;
		this.perfil = perfil;
		this.dataCriacao = dataCriacao;
		this.empresa = empresa;
		this.lancamentos = lancamentos;
	}
	
	public Funcionario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Float getQuantidadeHorasTrabalhoDoDia() {
		return quantidadeHorasTrabalhoDoDia;
	}

	public void setQuantidadeHorasTrabalhoDoDia(Float quantidadeHorasTrabalhoDoDia) {
		this.quantidadeHorasTrabalhoDoDia = quantidadeHorasTrabalhoDoDia;
	}

	public Float getQuantidadeHorasAlmoco() {
		return quantidadeHorasAlmoco;
	}

	public void setQuantidadeHorasAlmoco(Float quantidadeHorasAlmoco) {
		this.quantidadeHorasAlmoco = quantidadeHorasAlmoco;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHora=" + valorHora + ", quantidadeHorasTrabalhoDoDia=" + quantidadeHorasTrabalhoDoDia
				+ ", quantidadeHorasAlmoco=" + quantidadeHorasAlmoco + ", perfil=" + perfil + ", dataCriacao="
				+ dataCriacao + ", dataAtualizacao=" + dataAtualizacao + ", empresa=" + empresa + ", lancamentos="
				+ lancamentos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
