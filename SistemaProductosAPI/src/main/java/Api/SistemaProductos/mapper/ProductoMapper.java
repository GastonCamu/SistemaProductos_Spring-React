package Api.SistemaProductos.mapper;

import Api.SistemaProductos.dto.ProductoDTO;
import Api.SistemaProductos.entity.CatProducto;
import Api.SistemaProductos.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoDTO toDTO(Producto entity) {

        if (entity == null) {
            return null;
        }

        ProductoDTO dto = new ProductoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecio(entity.getPrecio());
        dto.setCantidadStock(entity.getCantidadStock());
        dto.setImagenUrl(entity.getImagenUrl());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());

        if (entity.getCatProducto() != null) {
            dto.setIdCatProducto(entity.getCatProducto().getId());
            dto.setNombreCatProducto(entity.getCatProducto().getNombre());
        }

        return dto;
    }

    public Producto toEntity(
            ProductoDTO dto,
            CatProducto catProducto) {

        if (dto == null) {
            return null;
        }

        Producto entity = new Producto();
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecio(dto.getPrecio());
        entity.setCantidadStock(dto.getCantidadStock());
        entity.setImagenUrl(dto.getImagenUrl());
        entity.setCatProducto(catProducto);

        return entity;
    }
}
