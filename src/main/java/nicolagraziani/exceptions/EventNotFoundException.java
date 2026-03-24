package nicolagraziani.exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(long id) {
        super("L'evento con id: " + id + " non è stato trovato");
    }
}
