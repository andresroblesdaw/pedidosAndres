package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Pedido;
import com.example.demo.dto.User;
import com.example.demo.dto.Estado;

/**
 * Servicio para la gestión de pedidos.
 */
@Service
public class PedidoService {

    private ArrayList<Pedido> pedidos;

    @Autowired
    private UserService userService = new UserService();

    /**
     * Constructor que inicializa la lista de pedidos.
     */
    public PedidoService() {
        pedidos = new ArrayList<>();

        Pedido p1 = new Pedido(51, Estado.CREADO, LocalDate.of(2024, 6, 10), userService.crearUser(new User("Andres", "Robles", 666111555L, "an@dr.es", "Ejemplo 12")));
        pedidos.add(p1);

        Pedido p2 = new Pedido(33, Estado.CREADO, LocalDate.of(2024, 6, 11), userService.crearUser(new User("Jesus", "Lopez", 987654321L, "je@s.us", "Cordoba 2")));
        pedidos.add(p2);
    }

    /**
     * Busca un pedido por su ID.
     *
     * @param id el ID del pedido a buscar
     * @return el pedido encontrado, o null si no se encuentra
     */
    public Pedido buscarPedido(Long id) {
        for (Pedido p : pedidos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Procesa un pedido actualizando su estado.
     *
     * @param id el ID del pedido a procesar
     * @param estado el nuevo estado del pedido
     * @return true si el pedido fue procesado correctamente, false en caso contrario
     */
    public boolean procesarPedido(Long id, Estado estado) {
        Pedido ped = buscarPedido(id);

        if (ped != null && ped.getEstado() != estado) {
            ped.setEstado(estado);
            return true;
        }

        return false;
    }

    /**
     * Crea un nuevo pedido y lo agrega a la lista de pedidos.
     *
     * @param p el pedido a agregar
     * @return el pedido creado
     */
    public Pedido crearPedido(Pedido p) {
        pedidos.add(p);
        return p;
    }

    /**
     * Elimina un pedido por su ID, siempre y cuando no esté procesado o enviado.
     *
     * @param id el ID del pedido a eliminar
     * @return true si el pedido fue eliminado correctamente, false en caso contrario
     */
    public boolean borrarPedido(Long id) {
        Pedido p = buscarPedido(id);

        if (p != null && p.getEstado() != Estado.PROCESADO && p.getEstado() != Estado.ENVIADO) {
            return pedidos.remove(p);
        }

        return false;
    }

    /**
     * Obtiene la lista de todos los pedidos.
     *
     * @return una lista de todos los pedidos
     */
    public ArrayList<Pedido> verPedidos() {
        return this.pedidos;
    }
}
