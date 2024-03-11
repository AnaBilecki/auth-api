package com.authapi.services;

import com.authapi.dto.ProductRequestDTO;
import com.authapi.dto.ProductResponseDTO;
import com.authapi.entities.Product;
import com.authapi.repositories.ProductRepository;
import com.authapi.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public ProductResponseDTO findById(Long id) {
        Optional<Product> entity = repository.findById(id);
        return convertToDTO(entity.orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    private Product convertToEntity(ProductRequestDTO dto) {
        return modelMapper.map(dto, Product.class);
    }

    private ProductResponseDTO convertToDTO(Product entity) {
        return modelMapper.map(entity, ProductResponseDTO.class);
    }
}
