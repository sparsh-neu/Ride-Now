package edu.neu.csye7374.Creational_Factory;

import edu.neu.csye7374.Creational_Builder.*;

public abstract class AbstractFactory<T> {
	public abstract T getObject(BuilderAPI<T> builder);
}