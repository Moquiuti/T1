package projetoFinal.Util;

import java.util.ArrayList;
import java.util.List;

import projetoFinal.Classes.Evento;


public class GerenciadorEvento {
	static List<Evento> eventos =  new ArrayList<Evento>(); 
	
	public void salvar(Evento evento) {
		eventos.add(evento);
	}
	
	public void excluir (int posicao){
		eventos.remove(posicao);
	}
	
	public List<Evento> getEventos() {
		return eventos;
	}
}
