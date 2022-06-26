package miu.edu.aopimplementation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLogDto {
    private Integer id;
    private Date date;
    private Long operation;
    private Long duration;
}
