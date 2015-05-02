package projetoFinal.Classes;

import java.util.Date;

public class Pedido {
	private Integer id;
	private String origemPedido;
	private Date dataPedido;
	private Cliente cliente;
	private String ceriominal;
	private Date dataEvento;
	private TipoEvento tipoEvento;
	private String horaEvento;
	private String indicacao;
	private String localEvento;
	private String enderecoEvento;
	private String obs;
	
	public String getOrigemPedido() {
		return origemPedido;
	}
	public void setOrigemPedido(String origemPedido) {
		this.origemPedido = origemPedido;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getCeriominal() {
		return ceriominal;
	}
	public void setCeriominal(String ceriominal) {
		this.ceriominal = ceriominal;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getHoraEvento() {
		return horaEvento;
	}
	public void setHoraEvento(String horaEvento) {
		this.horaEvento = horaEvento;
	}
	public String getIndicacao() {
		return indicacao;
	}
	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}
	public String getLocalEvento() {
		return localEvento;
	}
	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}
	public String getEnderecoEvento() {
		return enderecoEvento;
	}
	public void setEnderecoEvento(String enderecoEvento) {
		this.enderecoEvento = enderecoEvento;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Integer getId() {
		return id;
	}
	
	
	
}
