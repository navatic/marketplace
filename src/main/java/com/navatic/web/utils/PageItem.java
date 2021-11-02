package com.navatic.web.utils;

public class PageItem {
	
	// ATRIBUTOS
	private int numero;
	private boolean actual;
	
	// CONSTRUCTORES
	public PageItem() {}

	public PageItem(int numero, boolean actual) {
		super();
		this.numero = numero;
		this.actual = actual;
	}
	
	// METODOS GET
	public int getNumero() {
		return numero;
	}

	public boolean isActual() {
		return actual;
	}
	
}
