package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Pedido;
import com.example.demo.dto.Estado;
import com.example.demo.dto.User;
import com.example.demo.service.PedidoService;
import com.example.demo.service.UserService;

@RestController
public class AppController {

	@Autowired
	private PedidoService orderService;
	
	
	@Autowired
	private UserService userService;

	@GetMapping("/verPedido")
	public Pedido getOrder(@RequestParam Long id) {

		return orderService.buscarPedido(id);

	}
	
	@PutMapping("/procesarPedido")
	public boolean processOrder(@RequestParam Long id, @RequestParam Estado estado) {

		return orderService.procesarPedido(id, estado);

	}


	@GetMapping("/verListadoPedidos")
	public ArrayList<Pedido> getAllOrders() {

		return orderService.verPedidos();

	}
	
	@PostMapping("/crearPedido") 
	public Pedido createOrder(@RequestBody Pedido p) {

		userService.crearUser(p.getUser());
		return orderService.crearPedido(p);

	}
	


	@DeleteMapping("/borrarPedido")
	public boolean deleteOrder(@RequestParam Long id) {

		return orderService.borrarPedido(id);

	}

	
	@GetMapping("/verUser")
	public User getUser(@RequestParam Long id) {
		
		return userService.buscarUser(id);
		
	}


}
