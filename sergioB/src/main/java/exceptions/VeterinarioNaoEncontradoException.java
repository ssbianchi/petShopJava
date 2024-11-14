package exceptions;

public class VeterinarioNaoEncontradoException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VeterinarioNaoEncontradoException(String message) {
		super(message);
	}
}