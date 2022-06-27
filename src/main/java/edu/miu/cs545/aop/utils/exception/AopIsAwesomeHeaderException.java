package edu.miu.cs545.aop.utils.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AopIsAwesomeHeaderException extends RuntimeException {
    private static final long serialVersionUID=1l;
    private String errorMessage;

    public AopIsAwesomeHeaderException(String errorMessage){
        super(errorMessage);
    }
}
