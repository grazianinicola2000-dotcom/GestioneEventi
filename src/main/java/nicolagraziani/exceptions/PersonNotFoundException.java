package nicolagraziani.exceptions;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(UUID id) {
        super("La persona con id " + id + " non è stata trovata");
    }
}
