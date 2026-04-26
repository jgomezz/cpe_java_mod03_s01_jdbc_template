package pe.edu.tecsup.app.repositories;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.app.entities.Categoria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Categoria> findAll() {

        log.info("findAll categoria");

        String sql = """
                    SELECT id, nombre, orden 
                    FROM categorias
                    ORDER BY orden
                    """;

        List<Categoria> categorias
                = this.jdbcTemplate.query(
                        sql,
                        new CategoriaMapper()
                       );

        return categorias;
    }
}


class CategoriaMapper implements RowMapper<Categoria> {

    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("id"));
        categoria.setNombre(rs.getString("nombre"));
        categoria.setOrden(rs.getInt("orden"));
        return categoria;
    }
}
