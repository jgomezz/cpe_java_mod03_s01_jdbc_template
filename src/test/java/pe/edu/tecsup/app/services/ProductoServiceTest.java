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

        Long ID = 1L;
        String EXPECTED_NOMBRE = "Intel Core I7";
        Double EXPECTED_PRECIO = 1479.99;
        Integer EXPECTED_STOCK = 6;

        Producto producto =
                this.productoService.findById(ID);
        log.info(producto.toString());

        assertNotNull(producto);  // que el producto no sea nulo
        assertEquals(EXPECTED_NOMBRE, producto.getNombre());
        assertEquals(EXPECTED_PRECIO, producto.getPrecio());
        assertEquals(EXPECTED_STOCK, producto.getStock());
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