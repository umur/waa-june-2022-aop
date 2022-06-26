package springaop.lab4.service.impl.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springaop.lab4.domain.Category;
import springaop.lab4.domain.Product;
import springaop.lab4.dto.ProductDto;
import springaop.lab4.repository.CategoryRepo;
import springaop.lab4.service.impl.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepo categoryRepo;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public List<ProductDto> findAllProductsByCategory(String category, double max) {
        List<ProductDto> dto = new ArrayList<>();
        for (Category cate: categoryRepo.findAll()){
            if (cate.getName().equalsIgnoreCase(category))
                for (Product p : cate.getProducts()){
                    if (p.getPrice() < max){
                        dto.add(modelMapper.map(p,ProductDto.class));
                    }
                }

        }

        return dto;
    }
}
