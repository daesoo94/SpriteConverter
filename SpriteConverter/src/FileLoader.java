import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

public class FileLoader {
	public String path;

	void setPath() {
		JFileChooser directoryFinder = new JFileChooser("./");
		directoryFinder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		if (directoryFinder.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			this.path = directoryFinder.getSelectedFile().getAbsolutePath();
			System.out.println("Path : " + this.path);
		} else {
			System.out.println("No Selection ");
		}
	}

	List<File> getFiles() {
		File dirFile = new File(this.path);
		File[] files = dirFile.listFiles();
		List<File> resultFile = new ArrayList<File>();

		for (File file : files) {
			resultFile.add(file);
		}

		return resultFile;
	}

	List<File> getImageFiles() {
		File dirFile = new File(this.path);
		File[] files = dirFile.listFiles();
		List<File> resultFile = new ArrayList<File>();

		for (File file : files) {
			if (file.getName().matches("^.*(.)png$")) {
				resultFile.add(file);
			}
		}

		return resultFile;
	}

	List<File> getJsonFiles() {
		File dirFile = new File(this.path);
		File[] files = dirFile.listFiles();
		List<File> resultFile = new ArrayList<File>();

		for (File file : files) {
			if (file.getName().matches("^.*(.)json$")) {
				resultFile.add(file);
			}
		}

		return resultFile;
	}
}
