package pe.edu.tecsup.app.repositories;

import pe.edu.tecsup.app.entities.Producto;

import java.util.List;

public interface ProductoRepository {

    List<Producto> findAll();

    List<Producto> findByName(String name);

    Producto findById(Long id);

    void save(Producto producto);

    void update(Producto producto);

    void deleteById(Long id);
}

