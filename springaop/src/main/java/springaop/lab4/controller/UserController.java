package springaop.lab4.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springaop.lab4.dto.ProductDto;
import springaop.lab4.service.impl.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "{id}")
    public List<ProductDto> getAllCreateProductsByUserId(@PathVariable("id") int userId) {
        return userService.getAllCreateProductsByUserId(userId);
    }

}
