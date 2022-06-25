package com.cs545waa.lab05.service.implementeation;

import com.cs545waa.lab05.dto.ProductDTO;
import com.cs545waa.lab05.entity.Product;
import com.cs545waa.lab05.repository.ProductRepository;
import com.cs545waa.lab05.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Service
@Transactional
public class ProductServiceImplementation implements ProductService {
    private ModelMapper mapper;
    private ProductRepository repository;


    @Override
    public List<ProductDTO> readAll() {
        List<ProductDTO> dtos=new ArrayList<>();
        repository.findAll().forEach(product -> dtos.add(mapper.map(product,ProductDTO.class)));
        return dtos;
    }

    @Override
    public void create(ProductDTO dto) {
        repository.save(mapper.map(dto, Product.class));
    }
}
