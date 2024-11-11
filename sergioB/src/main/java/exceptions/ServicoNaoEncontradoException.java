package exceptions;

public class ServicoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServicoNaoEncontradoException(String message) {
		super(message);
	}
}