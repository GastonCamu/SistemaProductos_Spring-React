package Api.SistemaProductos.controller;

import Api.SistemaProductos.dto.ProductoDTO;
import Api.SistemaProductos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProducto(@PathVariable("id") Long id) {
        ProductoDTO producto = this.productoService.getProducto(id);
        return ResponseEntity.ok(producto);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getProductos() {
        List<ProductoDTO> productos = this.productoService.getProductos();
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDTO) {
        ProductoDTO producto = this.productoService.createProducto(productoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProducto(
        @PathVariable("id") Long id,
        @RequestBody ProductoDTO productoDTO) {

        ProductoDTO updatedProducto = this.productoService.updateProducto(id, productoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProducto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducto(@PathVariable("id") Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
