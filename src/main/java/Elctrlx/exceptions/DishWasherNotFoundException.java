package Elctrlx.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dish washer not found")
public class DishWasherNotFoundException extends RuntimeException {
}
