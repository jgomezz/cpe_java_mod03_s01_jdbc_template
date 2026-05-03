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
                    SELECT p.id, p.categorias_id, 
                            c.nombre AS categorias_nombre, 
                            c.orden AS categorias_orden,
                            p.nombre,p.descripcion, p.precio, p.stock,
                            p.imagen_nombre, p.imagen_tipo,
                            p.imagen_tamanio, p.creado, p.estado
                    FROM productos p
                    INNER JOIN categorias c ON c.id =
                            p.categorias_id
                    WHERE estado=1
                    ORDER BY id
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
                .descripcion(rs.getString("descripcion"))
                .precio(rs.getDouble("precio"))
                .stock(rs.getInt("stock"))
                .imagen_nombre(rs.getString("imagen_nombre"))
                .imagen_tipo(rs.getString("imagen_tipo"))
                .imagen_tamanio(rs.getLong("imagen_tamanio"))
                .estado(rs.getInt("estado"))
                .creado(rs.getDate("creado"))
                .categorias_id(rs.getLong("categorias_id"))
                .categoria(Categoria.builder()
                        .id(rs.getLong("categorias_id"))
                        .nombre(rs.getString("categorias_nombre"))
                        .orden(rs.getInt("categorias_orden"))
                        .build())
                .build();

        return producto;

    }
}
