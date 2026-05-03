package pe.edu.tecsup.app.services;

import pe.edu.tecsup.app.entities.Categoria;
import pe.edu.tecsup.app.entities.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> findAll();

}
