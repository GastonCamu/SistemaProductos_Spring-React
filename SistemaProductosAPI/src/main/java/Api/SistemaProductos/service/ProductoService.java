package Api.SistemaProductos.service;

import Api.SistemaProductos.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {

    ProductoDTO getProducto(Long id);
    List<ProductoDTO> getProductos();
    ProductoDTO createProducto(ProductoDTO productoDTO);
    ProductoDTO updateProducto(Long id, ProductoDTO productoDTO);
    void deleteProducto(Long id);
}
