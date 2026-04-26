package pe.edu.tecsup.app.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.app.entities.Categoria;
import pe.edu.tecsup.app.repositories.CategoriaRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoriaServiceImpl implements CategoriaService{

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return this.categoriaRepository.findAll();
    }
}
