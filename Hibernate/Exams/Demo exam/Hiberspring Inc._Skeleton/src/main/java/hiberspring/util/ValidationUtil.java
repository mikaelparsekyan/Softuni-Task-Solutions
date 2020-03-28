package hiberspring.util;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Component
public interface ValidationUtil {

    <E> boolean isValid(E entity);

    <E> Set<ConstraintViolation<E>> violations(E entity);
}
