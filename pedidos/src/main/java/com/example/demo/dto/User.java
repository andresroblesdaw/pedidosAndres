package com.example.demo.dto;

/**
 * Representa un usuario en el sistema.
 */
public class User {

    private Long id;
    private String nombre;
    private String apellidos;
    private Long telefono;
    private String mail;
    private String direccion;

    private static Long idActU = 0L;

    /**
     * Constructor que crea un nuevo usuario con los parámetros especificados.
     *
     * @param firstName el nombre del usuario
     * @param lastName el apellido del usuario
     * @param phone el número de teléfono del usuario
     * @param mail el correo electrónico del usuario
     * @param address la dirección del usuario
     */
    public User(String firstName, String lastName, Long phone, String mail, String address) {
        this.id = ++idActU;
        this.nombre = firstName;
        this.apellidos = lastName;
        this.telefono = phone;
        this.mail = mail;
        this.direccion = address;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return el ID del usuario
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return el nombre del usuario
     */
    public String getFirstName() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param firstName el nuevo nombre del usuario
     */
    public void setFirstName(String firstName) {
        this.nombre = firstName;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return el apellido del usuario
     */
    public String getLastName() {
        return apellidos;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param lastName el nuevo apellido del usuario
     */
    public void setLastName(String lastName) {
        this.apellidos = lastName;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     *
     * @return el número de teléfono del usuario
     */
    public Long getPhone() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     *
     * @param phone el nuevo número de teléfono del usuario
     */
    public void setPhone(Long phone) {
        this.telefono = phone;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return el correo electrónico del usuario
     */
    public String getMail() {
        return mail;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param mail el nuevo correo electrónico del usuario
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Obtiene la dirección del usuario.
     *
     * @return la dirección del usuario
     */
    public String getAddress() {
        return direccion;
    }

    /**
     * Establece la dirección del usuario.
     *
     * @param address la nueva dirección del usuario
     */
    public void setAddress(String address) {
        this.direccion = address;
    }

    /**
     * Devuelve una representación en formato de cadena del usuario.
     *
     * @return una cadena que representa al usuario
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", mail="
                + mail + ", direccion=" + direccion + "]";
    }
}
