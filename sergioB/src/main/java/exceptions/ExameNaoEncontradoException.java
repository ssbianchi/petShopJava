package exceptions;

public class ExameNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExameNaoEncontradoException(String message) {
		super(message);
	}
}