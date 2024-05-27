package filewrite.java.selenium;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingFileWrite {

	public static void main(String[] args) {
		String location1 = "UsingFileWrite.txt";
		String location2 = "UsingBufferedWrite.txt";
		String location3 = "UsingByteFileWrite.txt";
		String location4 = "UsingPathFileWrite.txt";
		String byteContent = "This comment is a test for the byte[] type write function, using FileOutputStream";
		String pathFileContent = "This comment is a test for the Path file type write function, using Path";

		// Using FileWriter
		try (FileWriter fileWriter = new FileWriter(location1)) {
			fileWriter.write("This is the test content for the File Writer");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Using BufferedWriter
		try (FileWriter buffFileWriter = new FileWriter(location2);
		     BufferedWriter bufferedWriter = new BufferedWriter(buffFileWriter)) {
			bufferedWriter.write("This is the test content for the Buffered File Writer!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Using FileOutputStream
		try (FileOutputStream outputStream = new FileOutputStream(location3)) {
			byte[] writeThis = byteContent.getBytes();
			outputStream.write(writeThis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Using Files.write(Path, byte[])
		try {
			Path path = Paths.get(location4);
			Files.write(path, pathFileContent.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
