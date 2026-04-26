package pe.edu.tecsup.app.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
@Builder
@Data
public class Categoria {
    private Long id;
    private String nombre;
    private Integer orden;

}
