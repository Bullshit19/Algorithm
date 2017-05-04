package algorithm.core;

import java.text.ParseException;

public interface IBlackBox {

	public void add(Register register);
	
	public void delete(Register register, String resedaId);
	
	public void compare() throws ParseException;

	void update(Register register, String resedaId);
}
