package Elctrlx.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Stove is not found")
public class StoveNotFoundException extends RuntimeException {
}