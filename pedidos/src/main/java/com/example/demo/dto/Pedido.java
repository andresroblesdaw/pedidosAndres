package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.UserService;

/**
 * Representa un pedido en el sistema.
 */
public class Pedido {

    private Long id;
    private double precio;
    private Estado estado;
    private LocalDate fechaPedido;
    private User user;

    private static Long idActual = 0L;

    /**
     * Constructor que crea un nuevo pedido con los parámetros especificados.
     *
     * @param precio el precio del pedido
     * @param estado el estado del pedido
     * @param fecha la fecha en la que se realizó el pedido
     * @param user el usuario que realizó el pedido
     */
    public Pedido(double precio, Estado estado, LocalDate fecha, User user) {
        this.id = ++idActual;
        this.precio = precio;
        this.estado = estado;
        this.fechaPedido = fecha;
        this.user = user;
    }

    /**
     * Obtiene el ID del pedido.
     *
     * @return el ID del pedido
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene el precio del pedido.
     *
     * @return el precio del pedido
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del pedido.
     *
     * @param precio el nuevo precio del pedido
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el estado del pedido.
     *
     * @return el estado del pedido
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado del pedido.
     *
     * @param estado el nuevo estado del pedido
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha en que se realizó el pedido.
     *
     * @return la fecha del pedido
     */
    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    /**
     * Establece la fecha en que se realizó el pedido.
     *
     * @param fechaPedido la nueva fecha del pedido
     */
    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    /**
     * Obtiene el usuario que realizó el pedido.
     *
     * @return el usuario del pedido
     */
    public User getUser() {
        return user;
    }

    /**
     * Establece el usuario que realizó el pedido.
     *
     * @param user el nuevo usuario del pedido
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Devuelve una representación en formato de cadena del pedido.
     *
     * @return una cadena que representa el pedido
     */
    @Override
    public String toString() {
        return "Order [id=" + id + ", precio=" + precio + ", estado=" + estado + ", fechaPedido=" + fechaPedido
                + ", user=" + user + "]";
    }
}
