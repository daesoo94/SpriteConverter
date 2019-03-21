import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Canvas canvas = new Canvas();

		canvas.addSpriteEvent(new SpriteListener(canvas));
		canvas.addJsonEvent(new JsonListener(canvas));
		canvas.addConvertButtonEvent(new ConvertButtonListener(canvas));
	}
}

// Event Listener ( TODO : Class 빼든 해야겠다.. )
class SpriteListener implements ActionListener {
	private FileLoader fileLoader = new FileLoader();
	private Canvas canvas;

	SpriteListener(Canvas canvas) {
		this.canvas = canvas;
	}

	public void actionPerformed(ActionEvent e) {
		this.fileLoader.setPath();
		this.canvas.spritePathLabel.setText(this.fileLoader.path);
		List<String> list = new ArrayList<String>();
		List<File> files = this.fileLoader.getImageFiles();

		for (File file : files) {
			list.add(file.getName());
		}

		this.canvas.setSpriteComboList(list);
	}
}

class JsonListener implements ActionListener {
	private FileLoader fileLoader = new FileLoader();
	private Canvas canvas;

	JsonListener(Canvas canvas) {
		this.canvas = canvas;
	}

	public void actionPerformed(ActionEvent e) {
		this.fileLoader.setPath();
		this.canvas.jsonPathLabel.setText(this.fileLoader.path);

		List<String> list = new ArrayList<String>();
		List<File> files = this.fileLoader.getJsonFiles();

		for (File file : files) {
			list.add(file.getName());
		}

		this.canvas.setJsonComboList(list);
	}
}

class ConvertButtonListener implements ActionListener {
	private Canvas canvas;

	ConvertButtonListener(Canvas canvas) {
		this.canvas = canvas;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			this.requestConvert();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void requestConvert() throws IOException {
		FileLoader fileLoader = new FileLoader();
		fileLoader.path = this.canvas.spritePathLabel.getText();
		SpriteConverter spriteConverter = new SpriteConverter();
		spriteConverter.converting(fileLoader.getFiles());
	}
}