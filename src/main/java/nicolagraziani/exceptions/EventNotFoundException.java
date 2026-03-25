package nicolagraziani.exceptions;

import java.util.UUID;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(UUID id) {
        super("L'evento con id: " + id + " non è stato trovato");
    }
}
