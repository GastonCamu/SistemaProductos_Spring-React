package Api.SistemaProductos.service.impl;

import Api.SistemaProductos.dto.CatProductoDTO;
import Api.SistemaProductos.dto.ProductoDTO;
import Api.SistemaProductos.entity.CatProducto;
import Api.SistemaProductos.entity.Producto;
import Api.SistemaProductos.exception.BusinessException;
import Api.SistemaProductos.mapper.ProductoMapper;
import Api.SistemaProductos.repository.CatProductoRepository;
import Api.SistemaProductos.repository.ProductoRepository;
import Api.SistemaProductos.service.ProductoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    CatProductoRepository catProductoRepository;
    @Autowired
    ProductoMapper productoMapper;

    @Override
    public ProductoDTO getProducto(Long id) {
        Optional<Producto> producto = this.productoRepository.findById(id);
        if (producto.isPresent()) {
            return productoMapper.toDTO(producto.get());
        } else {
            throw new BusinessException("No se encontró el producto con Id: "+id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<ProductoDTO> getProductos() {
        List<Producto> productos = this.productoRepository.findAll();
        return productos.stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        CatProducto catProducto = catProductoRepository.findById(productoDTO.getIdCatProducto())
                .orElseThrow(() -> new BusinessException
                ("No existe la categoria ingresada",HttpStatus.NOT_FOUND));

        Producto producto = productoMapper.toEntity(productoDTO, catProducto);
        producto = this.productoRepository.save(producto);
        return productoMapper.toDTO(producto);
    }

    @Override
    @Transactional
    public ProductoDTO updateProducto(Long id, ProductoDTO productoDTO) {
        Producto existingProducto = productoRepository.findById(id)
                .orElseThrow(() -> new BusinessException
                ("No se encontró el producto con Id :"+id, HttpStatus.NOT_FOUND));

        CatProducto catProducto = catProductoRepository.findById(productoDTO.getIdCatProducto())
                .orElseThrow(() -> new BusinessException
                ("No se encontró la categoria con Id :"+productoDTO.getIdCatProducto(), HttpStatus.NOT_FOUND));

        existingProducto.setNombre(productoDTO.getNombre());
        existingProducto.setDescripcion(productoDTO.getDescripcion());
        existingProducto.setPrecio(productoDTO.getPrecio());
        existingProducto.setCantidadStock(productoDTO.getCantidadStock());
        existingProducto.setImagenUrl(productoDTO.getImagenUrl());
        existingProducto.setCatProducto(catProducto);

        Producto updatedProducto = productoRepository.save(existingProducto);

        return productoMapper.toDTO(updatedProducto);
    }

    @Override
    public void deleteProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new BusinessException
                ("No se encontró el producto con Id :"+id, HttpStatus.NOT_FOUND));
        productoRepository.deleteById(id);
    }
}
