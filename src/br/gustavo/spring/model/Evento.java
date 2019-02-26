package br.gustavo.spring.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.mapping.Map;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nome;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar data;

	@Column
	private int capacidade;

	@Column
	private BigDecimal ingressoUnitario;
	
	@Column
	private String categoria;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "casashow_id", nullable = false)
	private CasaShow casaShow;
	
	
	@Transient
	private LinkedHashMap<String, String> categorias = new LinkedHashMap<String, String>();

	
	
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Evento() {
		categorias.put("/resources/img/tickets.png", "Padrão");
		categorias.put("/resources/img/cinema.png", "Cinema");
		categorias.put("/resources/img/games.png", "Jogos Eletrônicos");
		categorias.put("/resources/img/meetup.png", "Grande Encontro");
		categorias.put("/resources/img/music.png", "Concerto Musical");
		categorias.put("/resources/img/party.png", "Festa");
		categorias.put("/resources/img/theater.png", "Teatro");
		categorias.put("/resources/img/pub.png", "Pub");
	}

	public LinkedHashMap<String, String> getCategorias() {
		return categorias;
	}
	public void setCategorias(LinkedHashMap<String, String> categorias) {
		this.categorias = categorias;
	}
	public CasaShow getCasaShow() {
		return casaShow;
	}

	public void setCasaShow(CasaShow casaShow) {
		this.casaShow = casaShow;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		data.set(Calendar.HOUR, 0);
		data.set(Calendar.MINUTE, 0);
		data.set(Calendar.SECOND, 0);
		this.data = data;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public BigDecimal getIngressoUnitario() {
		return ingressoUnitario;
	}

	public void setIngressoUnitario(BigDecimal ingressoUnitario) {
		this.ingressoUnitario = ingressoUnitario;
	}

	@Override
	public String toString() {
		return "[Nome: " + this.nome + ", Data: 'retorno muito grande'" + ", Capacidade: " + this.capacidade
				+ ", Ingresso Unitario: " + this.ingressoUnitario + ".]";
	}
}
