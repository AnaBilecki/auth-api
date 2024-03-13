package com.authapi.services;

import com.authapi.dto.ProductRequestDTO;
import com.authapi.dto.ProductResponseDTO;
import com.authapi.entities.Product;
import com.authapi.repositories.ProductRepository;
import com.authapi.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductResponseDTO> findAll() {
        List<Product> entities = repository.findAll();
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProductResponseDTO findById(Long id) {
        Optional<Product> entity = repository.findById(id);
        return convertToDTO(entity.orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public ProductResponseDTO insert(ProductRequestDTO dto) {
        Product entity = repository.save(convertToEntity(dto));
        return convertToDTO(entity);
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(id);
        }
    }

    private Product convertToEntity(ProductRequestDTO dto) {
        return modelMapper.map(dto, Product.class);
    }

    private ProductResponseDTO convertToDTO(Product entity) {
        return modelMapper.map(entity, ProductResponseDTO.class);
    }
}
