package com.example.bbDDConnector;

import java.util.List;

import modelo.Cliente.Cliente;

public class Prueba {

	public static void main(String[] args) {

		CRUD crud = new CRUD();

		List<Cliente> clientes = crud.getClientes();

		for (Cliente c : clientes) {
			System.out.println(c.getNombre());
			System.out.println(c.getApellidos());
			System.out.println(c.getDni());
			System.out.println(c.getFecha());
		}

	}

}
