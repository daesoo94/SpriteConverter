import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class SpriteConverter {
	void converting(List<File> files) throws IOException {
		File Folder = new File(".//converted");
		if (!Folder.exists()) {
			try {
				Folder.mkdir();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		for (File file : files) {
			BufferedImage originImage = ImageIO.read(file);

			int originWidth = originImage.getWidth();
			int originHeight = originImage.getHeight();
			int fitWidth = this.getBestFit(originWidth);
			int fitHeight = this.getBestFit(originHeight);

			BufferedImage exportImage = new BufferedImage(fitWidth, fitHeight, BufferedImage.TYPE_INT_ARGB);
			Graphics2D graphic = exportImage.createGraphics();
			graphic.setComposite(AlphaComposite.Clear);
			graphic.fillRect(0, 0, fitWidth, fitHeight);

			// 그 위에 읽어온 파일 덮어 씌운다.
			graphic.setComposite(AlphaComposite.Src);
			graphic.drawImage(originImage, 0, 0, null);

			File f = new File(".//converted/" + file.getName());

			try {
				ImageIO.write(exportImage, "png", f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private int getBestFit(int base) {
		int bestFit = 1;

		while (bestFit < base) {
			bestFit *= 2;
		}

		return bestFit;
	}
}