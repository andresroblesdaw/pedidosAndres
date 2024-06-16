package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Pedido;
import com.example.demo.dto.User;
import com.example.demo.dto.Estado;

@Service
public class PedidoService {

	private ArrayList<Pedido> pedidos;

	@Autowired
	private UserService userService = new UserService();

	public PedidoService() {

		pedidos = new ArrayList<>();

		Pedido p1 = new Pedido(51, Estado.CREADO, LocalDate.of(2024, 6, 10), userService.crearUser(new User("Andres", "Robles", 666111555L, "an@dr.es", "Ejemplo 12")));
		pedidos.add(p1);

		Pedido p2 = new Pedido(33, Estado.CREADO, LocalDate.of(2024, 6, 11), userService.crearUser(new User("Jesus", "Lopez", 987654321L, "je@s.us", "Cordoba 2")));
		pedidos.add(p2);


	}

	public Pedido buscarPedido(Long id) {
		for (Pedido p : pedidos) {

			if (p.getId() == id) {

				return p;

			}

		}
		return null;

	}

	public boolean procesarPedido(Long id, Estado estado) {

		Pedido ped = buscarPedido(id);

		if (ped.getEstado() != estado) {
			ped.setEstado(estado);
			return true;
		}

		return false;
	}

	public Pedido crearPedido(Pedido p) {

		pedidos.add(p);
		return p;
	}


	public boolean borrarPedido(Long id) {

		Pedido p = buscarPedido(id);

		if (p.getEstado() != Estado.PROCESADO && p.getEstado() != Estado.ENVIADO) {

			
			return pedidos.remove(p);

		}

		return false;

	}

	public ArrayList<Pedido> verPedidos() {

		return this.pedidos;

	}


}
