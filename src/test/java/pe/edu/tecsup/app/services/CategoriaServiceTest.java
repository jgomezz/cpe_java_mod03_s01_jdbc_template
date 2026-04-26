package pe.edu.tecsup.app.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.app.entities.Categoria;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j // log
@SpringBootTest
class CategoriaServiceTest {

    @Autowired
    private CategoriaService categoriaService;

    @BeforeEach
    void setUp() {
        log.info("Calling setUp()");
    }

    @AfterEach
    void tearDown() {
        log.info("Calling tearDown()");
    }

    @Test
    void findAll() {

        log.info("Test findAll()");

        //List<Categoria> categorias = categoriaService.findAll();

    }

    @Test
    void findNothing() {

        log.info("Test findNothing()");


    }
}