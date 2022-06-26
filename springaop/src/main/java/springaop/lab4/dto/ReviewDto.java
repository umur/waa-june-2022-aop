package springaop.lab4.dto;


import lombok.Data;
import org.springframework.stereotype.Component;
import springaop.lab4.domain.User;

@Data
@Component
public class ReviewDto {
    private Long id;
    private String comment;
    private User user;
}
