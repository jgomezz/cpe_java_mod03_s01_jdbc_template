package pe.edu.tecsup.app.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.app.entities.Producto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ProductoServiceTest {

    @Autowired
    private ProductoService productoService;

    @Test
    void testFindAll() {

        List<Producto> productos =
                this.productoService.findAll();

        productos.forEach(item -> { log.info(item.toString()); });

        assertFalse(productos.isEmpty());
    }


    @Test
    void testFindByName() {

        List<Producto> productos =
                this.productoService.findByName("AMD");

        for(Producto producto : productos) log.info(producto.toString());

        assertEquals(false, productos.isEmpty());
    }

    @Test
    void testFindById() {
    }

    @Test
    void testSave() {
    }

    @Test
    void testDeleteById() {
    }

    @Test
    void testUpdate() {
    }
}