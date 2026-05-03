package pe.edu.tecsup.app.repositories;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.app.entities.Categoria;
import pe.edu.tecsup.app.entities.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Producto> findAll() {

        log.info("findAll products");

        String sql = """
                    SELECT id, nombre
                    FROM productos
                    """;

        List<Producto> productos
                = this.jdbcTemplate.query(
                sql,
                new ProductoMapper()
        );

        return productos;
    }

}

class ProductoMapper implements RowMapper<Producto> {

    @Override
    public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {

        Producto producto
                = Producto.builder()
                .id(rs.getLong("id"))
                .nombre(rs.getString("nombre"))
                .build();

        return producto;

    }
}
