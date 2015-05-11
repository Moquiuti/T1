package projetoFinal.Util;

import java.util.ArrayList;
import java.util.List;

import projetoFinal.Classes.Pedido;



public class GerenciadorPedido {
static List<Pedido> pedidos =  new ArrayList<Pedido>(); 
	
	public void salvar(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void excluir (int posicao){
		pedidos.remove(posicao);
	}
	
	public List<Pedido> getProdutos() {
		return pedidos;
	}}
