package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.dto.User;

/**
 * Servicio para la gestión de usuarios.
 */
@Service
public class UserService {

    private static ArrayList<User> usuarios = new ArrayList<>();

    /**
     * Constructor vacío para la clase UserService.
     */
    public UserService() {
        
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id el ID del usuario a buscar
     * @return el usuario encontrado, o {@code null} si no se encuentra
     */
    public User buscarUser(Long id) {
        for (User u : usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Crea un nuevo usuario y lo agrega a la lista de usuarios.
     *
     * @param u el usuario a agregar
     * @return el usuario creado
     */
    public User crearUser(User u) {
        usuarios.add(u);
        return u;
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id el ID del usuario a eliminar
     * @return true si el usuario fue eliminado correctamente, false si el usuario no se encontró
     */
    public boolean eliminarUser(Long id) {
        User us = buscarUser(id);
        return usuarios.remove(us);
    }
}