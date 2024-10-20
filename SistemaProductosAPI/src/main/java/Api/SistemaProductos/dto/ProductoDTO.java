package Api.SistemaProductos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class ProductoDTO {
    private Long id;

    private String nombre;

    private String descripcion;

    private Double precio;

    private Integer cantidadStock;

    private String imagenUrl;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;

    private Long idCatProducto;
}
