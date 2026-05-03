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

    @Override
    public List<Producto> findByName(String nombre) {
        log.info("call findByName()");
        return productoRepository.findByName(nombre);
    }

    @Override
    public Producto findById(Long id) {
        log.info("call findById()");
        return productoRepository.findById(id);
    }

    @Override
    public void save(Producto producto) {
        log.info("call save()");
        productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        log.info("call deleteById()");
        productoRepository.deleteById(id);
    }

    @Override
    public void update(Producto producto) {
        log.info("call update()");
        productoRepository.update(producto);
    }

}
