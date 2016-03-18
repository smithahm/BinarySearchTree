
/**
 * Decorator pattern interface to decorate Java's String Iterator.
 */
import java.util.Iterator;

public interface IStringIteratorDecorator<T> extends Iterator<String> {
	public boolean hasNext();

	public String next();

	public void remove();
}
