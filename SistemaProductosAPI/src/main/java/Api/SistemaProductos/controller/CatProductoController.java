package Api.SistemaProductos.controller;

import Api.SistemaProductos.dto.CatProductoDTO;
import Api.SistemaProductos.service.CatProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CategoriaProducto")
public class CatProductoController {

    @Autowired
    CatProductoService catProductoService;

    @GetMapping("/{id}")
    public ResponseEntity<CatProductoDTO> getCatProducto(@PathVariable("id") Long id) {
        CatProductoDTO catProducto = this.catProductoService.getCatProducto(id);
        return ResponseEntity.ok(catProducto);
    }

    @GetMapping
    public ResponseEntity<List<CatProductoDTO>> getCatProductos() {
        List<CatProductoDTO> catProductos = this.catProductoService.getCatProductos();
        return ResponseEntity.ok(catProductos);
    }

    @PostMapping
    public ResponseEntity<CatProductoDTO> createCatProducto(@RequestBody CatProductoDTO catProductoDTO) {
        CatProductoDTO catProducto = this.catProductoService.createCatProducto(catProductoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(catProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatProductoDTO> updateCatProducto(
        @PathVariable("id") Long id,
        @RequestBody CatProductoDTO catProductoDTO) {

        CatProductoDTO updatedCatProducto = this.catProductoService.updateCatProducto(id, catProductoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCatProducto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCatProducto(@PathVariable("id") Long id) {
        catProductoService.deleteCatProducto(id);
        return ResponseEntity.noContent().build();
    }

}
