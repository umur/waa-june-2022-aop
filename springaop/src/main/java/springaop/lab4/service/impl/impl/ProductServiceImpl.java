package springaop.lab4.service.impl.impl;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springaop.lab4.domain.Product;
import springaop.lab4.dto.ProductDto;
import springaop.lab4.repository.ProductRepo;
import springaop.lab4.service.impl.ProductService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepo productRepo;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAllProductByMinPrice(double min) {
        List<ProductDto> dto = new ArrayList<>();

        for(Product product : productRepo.findAll()) {
            if (product.getPrice() > min) {
       var  model= modelMapper.map(dto, ProductDto.class);
                dto.add(model);
            }
        }
        return dto;
    }

    @Override
    public List<ProductDto> getAllProductByKeyword(String keyword) {
        List<ProductDto> word = new ArrayList<>();
        for (Product p : productRepo.findAll()) {
            if (p.getName().contains(keyword)) {
                var model = modelMapper.map(word, ProductDto.class);
                word.add(model);
            }
        }
        return word;
    }

    /**
     * need to update
     * @param max
     * @return
     */
    @Override
    public List<ProductDto> getAllProductByMaxPrice(double max) {
        List<ProductDto> products = new ArrayList<>();
        for(Product p :productRepo.findAll()){
            if(p.getPrice()<max){
                var model=modelMapper.map(products,ProductDto.class);
                products.add(model);
            }

        }
        return products;
    }


}