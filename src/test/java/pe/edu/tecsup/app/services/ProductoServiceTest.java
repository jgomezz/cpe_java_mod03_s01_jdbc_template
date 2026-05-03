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

        // 1. Verificar cuantos productos existen
        long totalAntes = this.productoService.findAll().stream().count();
        log.info("Total antes de insertar: {}", totalAntes);

        // 2. Crear un producto y grabarlo
        var producto = Producto.builder()
                .categorias_id(1L) // Categoria de procesadores
                .nombre("GTX-5070")
                .descripcion("GPU para gaming de alta gama")
                .precio(1500.00)
                .stock(10)
                .estado(1)  // Estado ACTIVO
                .build();

        this.productoService.save(producto);

        // 3. Verificar cuantos productos existen después de grabar
        long totalDespues = this.productoService.findAll().stream().count();
        log.info("Total después de insertar: {}", totalDespues);

        // Test
        assertEquals(1, totalDespues-totalAntes);

    }


    @Test
    void testUpdate() {

        // Datos de entrada
        Long ID_PROD_UPDATE = 2L;   // Asegúrate de que este ID exista en la base de datos
        String NUEVO_NOMBRE = "Kingstone UPDATE";

        // 1. Buscar el producto
        Producto producto = this.productoService.findById(ID_PROD_UPDATE);

        // 2. Hacer los cambios en la entidad producto
        producto.setNombre(NUEVO_NOMBRE);

        // 3. Realizar actualizacion del producto
        this.productoService.update(producto);

        // 4. Recuperar el producto actualizado
        var productoActualizado =
                this.productoService.findById(ID_PROD_UPDATE);

        // Validaciones
        assertNotNull(productoActualizado);  // que el producto no sea nulo
        assertEquals(NUEVO_NOMBRE, productoActualizado.getNombre());




    }

    @Test
    void testDeleteById() {

        // TO DO : Se recomienda primero crear un producto


        // 1. Obtener cuantos productos existen
        List<Producto> productos = this.productoService.findAll();
        int totalAntes = productos.size();

        if (productos.isEmpty())
            return; // test pass

        // 2. Obtener el último producto de la lista
        Producto ultimoProducto =
                productos.get(productos.size() - 1);

        // 3. Borrar el producto identificado en el paso anterior
        this.productoService.deleteById(ultimoProducto.getId());

        // 4. Obtener cuantos productos existen despues del proceso de borrador
        productos = this.productoService.findAll();
        int totalDespues = productos.size();

        //
        assertEquals(1, totalAntes - totalDespues);

    }


}