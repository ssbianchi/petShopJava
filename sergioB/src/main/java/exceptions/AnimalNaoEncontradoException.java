package exceptions;

public class AnimalNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AnimalNaoEncontradoException(String message) {
		super(message);
	}
}