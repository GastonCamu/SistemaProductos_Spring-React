package Api.SistemaProductos.service;

import Api.SistemaProductos.dto.CatProductoDTO;

import java.util.List;

public interface CatProductoService {
    CatProductoDTO getCatProducto(Long id);
    List<CatProductoDTO> getCatProductos();
    CatProductoDTO createCatProducto(CatProductoDTO catProductoDTO);
    CatProductoDTO updateCatProducto(Long id, CatProductoDTO catProductoDTO);
    void deleteCatProducto(Long id);
}
