package rnd.util.logger;

public abstract class Logger<T> {

	protected volatile T handler = null;

	public abstract void log(String message);

	public void addListner(T handler) {
		this.handler = handler;
		addListnerInt(handler);
	}

	public abstract void addListnerInt(T handler);

	public void removeListner() {
		this.handler = null;

	}

}
