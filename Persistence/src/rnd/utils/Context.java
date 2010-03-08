package rnd.utils;

public interface Context {
	
	void setContext(String key, Object context);
	
	Object getContext(String key);

}
