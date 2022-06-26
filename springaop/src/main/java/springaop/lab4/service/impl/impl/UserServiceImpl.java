package springaop.lab4.service.impl.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springaop.lab4.domain.User;
import springaop.lab4.dto.ProductDto;
import springaop.lab4.repository.UserRepo;
import springaop.lab4.service.impl.UserService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAllCreateProductsByUserId(int userId) {
        List<ProductDto> products = new ArrayList<>();
        for (User user : userRepo.findAll())
//            if(user.getId() == userId) {
            products.add(modelMapper.map(products, ProductDto.class));

        return products;
}
}
