package exceptions;

public class AtendenteNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AtendenteNaoEncontradoException(String message) {
		super(message);
	}
}