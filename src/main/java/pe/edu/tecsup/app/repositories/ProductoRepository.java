package pe.edu.tecsup.app.repositories;

import pe.edu.tecsup.app.entities.Producto;

import java.util.List;

public interface ProductoRepository {

    List<Producto> findAll();

}
