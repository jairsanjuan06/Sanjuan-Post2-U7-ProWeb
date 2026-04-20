package com.universidad.apiproductos.service;

import com.universidad.apiproductos.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductoService {

    private final Map<Long, Producto> productos = new LinkedHashMap<>();
    private Long contadorId = 1L;

    public ProductoService() {
        guardar(new Producto(null, "Laptop", "Laptop 15 pulgadas 16GB RAM", 1299.99));
        guardar(new Producto(null, "Mouse", "Mouse inalambrico ergonomico", 29.99));
        guardar(new Producto(null, "Teclado", "Teclado mecanico TKL", 89.99));
    }

    public List<Producto> obtenerTodos() {
        return new ArrayList<>(productos.values());
    }

    public Optional<Producto> buscarPorId(Long id) {
        return Optional.ofNullable(productos.get(id));
    }

    public Producto obtenerPorIdOError(Long id) {
        return buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));
    }

    public Producto guardar(Producto producto) {
        if (producto.getId() == null) {
            producto.setId(contadorId++);
        }
        productos.put(producto.getId(), producto);
        return producto;
    }

    public void eliminar(Long id) {
        productos.remove(id);
    }
}
