package pe.edu.tecsup.app.repositories;

import org.springframework.stereotype.Repository;
import pe.edu.tecsup.app.entities.Categoria;

import java.util.List;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    @Override
    public List<Categoria> findAll() {
        return List.of();
    }
}
