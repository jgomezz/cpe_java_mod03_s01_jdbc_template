package pe.edu.tecsup.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.app.entities.Categoria;
import pe.edu.tecsup.app.repositories.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return this.categoriaRepository.findAll();
    }
}
