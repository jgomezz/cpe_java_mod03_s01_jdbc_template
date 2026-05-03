package pe.edu.tecsup.app.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.app.entities.Producto;
import pe.edu.tecsup.app.repositories.ProductoRepository;

import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {

        log.info("Iniciando búsqueda de productos");

        return this.productoRepository.findAll();
    }

}
