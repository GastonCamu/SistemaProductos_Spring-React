package Api.SistemaProductos.service.impl;

import Api.SistemaProductos.dto.CatProductoDTO;
import Api.SistemaProductos.entity.CatProducto;
import Api.SistemaProductos.exception.BusinessException;
import Api.SistemaProductos.mapper.CatProductoMapper;
import Api.SistemaProductos.repository.CatProductoRepository;
import Api.SistemaProductos.service.CatProductoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatProductoServiceImpl implements CatProductoService {

    @Autowired
    private CatProductoMapper catProductoMapper;

    @Autowired
    private CatProductoRepository catProductoRepository;

    @Override
    public CatProductoDTO getCatProducto(Long id) {
        Optional<CatProducto> catProducto = this.catProductoRepository.findById(id);
        if (catProducto.isPresent()) {
            return catProductoMapper.toDTO(catProducto.get());
        } else {
            throw new BusinessException("No se encontró la categoria con Id: "+ id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<CatProductoDTO> getCatProductos() {
        List<CatProducto> catProductos = this.catProductoRepository.findAll();
        return catProductos.stream()
                .map(catProductoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CatProductoDTO createCatProducto(CatProductoDTO catProductoDTO) {
        CatProducto catProducto = catProductoMapper.toEntity(catProductoDTO);
        catProducto = this.catProductoRepository.save(catProducto);
        return catProductoMapper.toDTO(catProducto);
    }

    @Override
    @Transactional
    public CatProductoDTO updateCatProducto(Long id, CatProductoDTO catProductoDTO) {
        CatProducto existingProducto = catProductoRepository.findById(id)
                .orElseThrow(() -> new BusinessException
                ("No se encontró la categoria con el Id: "+id, HttpStatus.NOT_FOUND));

        existingProducto.setNombre(catProductoDTO.getNombre());

        CatProducto updatedProducto = catProductoRepository.save(existingProducto);
        return catProductoMapper.toDTO(updatedProducto);
    }

    @Override
    @Transactional
    public void deleteCatProducto(Long id) {
        CatProducto catProducto = catProductoRepository.findById(id)
                .orElseThrow(() -> new BusinessException
                ("No se encontró el producto con Id: "+ id, HttpStatus.NOT_FOUND));

        catProductoRepository.deleteById(id);
    }
}
