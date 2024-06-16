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

/**
 * Controlador de la aplicación
 */
@RestController
public class AppController {

    @Autowired
    private PedidoService orderService;
    
    @Autowired
    private UserService userService;

    /**
     * Obtiene un pedido por su ID.
     *
     * @param id el ID del pedido a buscar
     * @return el pedido encontrado
     */
    @GetMapping("/verPedido")
    public Pedido getOrder(@RequestParam Long id) {
        return orderService.buscarPedido(id);
    }
    
    /**
     * Procesa un pedido actualizando su estado.
     *
     * @param id el ID del pedido a procesar
     * @param estado el nuevo estado del pedido
     * @return true si el pedido fue procesado correctamente, false en caso contrario
     */
    @PutMapping("/procesarPedido")
    public boolean processOrder(@RequestParam Long id, @RequestParam Estado estado) {
        return orderService.procesarPedido(id, estado);
    }

    /**
     * Obtiene la lista de todos los pedidos.
     *
     * @return una lista de todos los pedidos
     */
    @GetMapping("/verListadoPedidos")
    public ArrayList<Pedido> getAllOrders() {
        return orderService.verPedidos();
    }
    
    /**
     * Crea un nuevo pedido.
     *
     * @param p el pedido a crear
     * @return el pedido creado
     */
    @PostMapping("/crearPedido")
    public Pedido createOrder(@RequestBody Pedido p) {
        userService.crearUser(p.getUser());
        return orderService.crearPedido(p);
    }
    
    /**
     * Elimina un pedido por su ID.
     *
     * @param id el ID del pedido a eliminar
     * @return true si el pedido fue eliminado correctamente, false en caso contrario
     */
    @DeleteMapping("/borrarPedido")
    public boolean deleteOrder(@RequestParam Long id) {
        return orderService.borrarPedido(id);
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id el ID del usuario a buscar
     * @return el usuario encontrado
     */
    @GetMapping("/verUser")
    public User getUser(@RequestParam Long id) {
        return userService.buscarUser(id);
    }
}