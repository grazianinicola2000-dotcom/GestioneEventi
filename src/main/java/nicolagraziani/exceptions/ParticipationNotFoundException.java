package nicolagraziani.exceptions;

import java.util.UUID;

public class ParticipationNotFoundException extends RuntimeException {
    public ParticipationNotFoundException(UUID id) {
        super("La partecipazione: " + id + " non è stata trovata");
    }
}
