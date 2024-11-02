package Api.SistemaProductos.mapper;

import Api.SistemaProductos.dto.CatProductoDTO;
import Api.SistemaProductos.entity.CatProducto;
import org.springframework.stereotype.Component;

@Component
public class CatProductoMapper {

    public CatProductoDTO toDTO(CatProducto entity) {

        if (entity == null) {
            return null;
        }

        CatProductoDTO dto = new CatProductoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());

        return dto;
    }

    public CatProducto toEntity(CatProductoDTO dto) {

        if (dto == null) {
            return null;
        }

        CatProducto entity = new CatProducto();
        entity.setNombre(dto.getNombre());

        return entity;
    }
}
