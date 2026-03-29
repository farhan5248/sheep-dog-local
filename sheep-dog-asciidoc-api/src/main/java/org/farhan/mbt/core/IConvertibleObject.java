package org.farhan.mbt.core;

public interface IConvertibleObject {

	public String getPath();

	public void parse(String text) throws Exception;

	public Object get();
}
