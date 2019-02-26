package br.com.spring.dto;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.gustavo.spring.dao.Dao;
import br.gustavo.spring.model.CasaShow;
import br.gustavo.spring.model.Evento;

public class EventoDTO {
	
	/*
	 * O arquivo DTO é responsável por fazer a transferencia para o banco de dados
	 * O banco de dados (SQL) não reconhece tipos de classes customizadas ex: classe Carro, BigDecimal, Calendar etc.
	 * o banco apenas reconhece tipos 'primitivos' como String Integer, double, bool..
	 * para o banco armazenar dados de classes customizadas, é necessário ter um intermediário auxiliando-o
	 * para isso criamos um arquivo DTO (Data Transfer Object) com atributos primitivos. Para que isso funcione bem, é necessário que se faça
	 * a conversão corretamente de cada atributo(se necessário)
	 */
	

	private int id;
	private String nome;
	private String data;
	private int capacidade;
	private String ingressoUnitario;
	private int casaShow;
	private String categoria;

	public String getCategoria() {
		return categoria;
	}
	public String getEnderecoCategoria() {
		return "";
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getIngressoUnitario() {
		return ingressoUnitario;
	}

	public void setIngressoUnitario(String ingressoUnitario) {
		this.ingressoUnitario = ingressoUnitario;
	}

	public int getCasaShow() {
		return casaShow;
	}

	public void setCasaShow(int casaShow) {
		this.casaShow = casaShow;
	}

	//Realizando a conversão de Evento para EventoDTO
	public Evento preencherEvento(Dao dao) {
		Evento evento = new Evento();
		evento.setId(this.id);
		evento.setNome(this.nome);
		evento.setData(this.formatarStringParaCalendar());
		evento.setCapacidade(this.capacidade);
		evento.setIngressoUnitario(new BigDecimal(formatarValorIngresso()));
		evento.setCasaShow(dao.buscaPorID(CasaShow.class, this.casaShow));
		evento.setCategoria(this.categoria);
		return evento;
	}

	private Calendar formatarStringParaCalendar() {
		
		//15/10/2000 - exemplo de data
		String[] split = this.data.split("/", 3);

		int dia = Integer.parseInt(split[0]); 	//15
		int mes = Integer.parseInt(split[1]);	//10
		int ano = Integer.parseInt(split[2]); 	//2000

		if (mes < 10) {
			String[] mesFormatado = split[1].split("0");
			mes = Integer.parseInt(mesFormatado[1]);
		} 
		GregorianCalendar calendar = new GregorianCalendar(ano, mes - 1, dia);
		return calendar;
	}
	
	private double formatarValorIngresso() {
		
		//$15.00 - exemplo de preço
		String valorStr = "";
		double valorDoub = 0;
		
		if(this.ingressoUnitario.contains(",")) {
			String[] split = this.ingressoUnitario.split("," , 2);
			for (int i = 0; i < split.length; i++) {
				valorStr += split[i];
			}
			valorDoub = Double.parseDouble(valorStr);
			return valorDoub;
		}
		valorDoub = Double.parseDouble(this.ingressoUnitario);
		return valorDoub;
	}
	
//	// verificar se existe no mesmo dia e no mesmo lugar
//	//se sim - não cadastra
//	//se não - cadastra
//	public boolean eventoExiste(Dao dao, Evento evento) {
//		List<Evento> eventosIguais = dao.eventoDao().buscaEventosIguais(evento);
//		
//		if(eventosIguais.isEmpty()) {
//			return false;	//Caso a lista for vazia, o evento não existe
//		}
//		return true;	// Caso a lista não estiver vazia, o evento já existe
//	}

}
