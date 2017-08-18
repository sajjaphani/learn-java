package org.learnjava.design;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * <ul>
 * <li>High-level modules should not depend on low-level modules. Both should
 * depend on abstractions.</li>
 * <li>Abstractions should not depend on details. Details should depend on
 * abstractions.</li>
 * </ul>
 * At first, this principle is similar to "Program to an interface, not an
 * implementation". However, the Dependency Inversion Principle makes an even
 * stronger statement about abstraction.
 * <p>
 * Dependency Inversion Principle states that we should decouple high level
 * modules from low level modules, introducing an abstraction layer between the
 * high level classes and low level classes. Further more it inverts the
 * dependency: instead of writing our abstractions based on details, the we
 * should write the details based on abstractions.
 * </p>
 * <p>
 * <b>Layering:</b>
 * <ul>
 * <li>From Booch, "...all well structured object-oriented architectures have
 * clearly-defined layers, with each layer providing some coherent set of
 * services though a well-defined and controlled interface."</li>
 * <li>Each of the lower level layers should be represented by an abstract
 * class. The actual layers are then derived from these abstract classes. Each
 * of the higher level classes uses the next lowest layer through the abstract
 * interface. Thus, none of the layers depends upon any of the other layers.
 * Instead, the layers depend upon abstract classes.</li>
 * </ul>
 * </p>
 * 
 * @author psajja
 *
 */
public class DependencyInversionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Print Nothing");
	}

	/**
	 * This class has a single method which copies the file contents. This class
	 * is not reusable to use other readers and writers.
	 */
	static class CopyNotReusable {

		public void copy(FileReader reader, FileWriter writer) throws IOException {
			int ch;
			while ((ch = reader.read()) != -1)
				writer.write(ch);
		}
	}

	/**
	 * This class has a single method which copies the file contents. This class
	 * is more reusable to use other readers and writers.
	 */
	static class Copy {

		public void copy(Reader reader, Writer writer) throws IOException {

			int ch;
			while ((ch = reader.read()) != -1)
				writer.write(ch);
		}
	}
}
