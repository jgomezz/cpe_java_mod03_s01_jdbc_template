package pe.edu.tecsup.app.repositories;

import pe.edu.tecsup.app.entities.Categoria;

import java.util.List;

public interface CategoriaRepository {

    List<Categoria> findAll();

}
