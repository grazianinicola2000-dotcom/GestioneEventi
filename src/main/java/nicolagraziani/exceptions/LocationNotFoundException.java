package nicolagraziani.exceptions;

import java.util.UUID;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(UUID id) {
        super("La location " + id + " non è stata trovata");
    }
}
