package spaceshapes.forms;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.SwingWorker;

import spaceshapes.CarrierShape;
import spaceshapes.ImageRectangleShape;
import spaceshapes.ShapeModel;
import spaceshapes.forms.util.Form;
import spaceshapes.forms.util.FormHandler;

public class ImageShapeFormHandler implements FormHandler{
	private ShapeModel _model;
	private CarrierShape _parentOfNewShape;

	public ImageShapeFormHandler(ShapeModel model,CarrierShape parent) {
		_model = model; 
		_parentOfNewShape = parent;
	}

	/**
	 * Pass the image to the background thread for processing
	 */
	@Override
	public void processForm(Form form) {
		new StartThread(form).execute();
	}

	private class StartThread extends SwingWorker<BufferedImage, File>{

		private Form _form;
		private File imageFile;
		private int width;
		private int deltaX;
		private int deltaY;
		
		public StartThread(Form form) {
			super();
			// Read field values from the form.
			_form=form;
			imageFile = (File)_form.getFieldValue(File.class, ImageFormElement.IMAGE);
			width = _form.getFieldValue(Integer.class, ShapeFormElement.WIDTH);
			deltaX = _form.getFieldValue(Integer.class, ShapeFormElement.DELTA_X);
			deltaY = _form.getFieldValue(Integer.class, ShapeFormElement.DELTA_Y);
		}
		
		/**
		 * Processing the image at the background thread.
		 */
		@Override
		protected BufferedImage doInBackground() throws Exception {
			long startTime = System.currentTimeMillis();

			// Load the original image (ImageIO.read() is a blocking call).
			BufferedImage fullImage = null;
			try {
				fullImage = ImageIO.read(imageFile);  
			} catch(IOException e) {
				System.out.println("Error loading image."); 
			}

			int fullImageWidth = fullImage.getWidth();
			int fullImageHeight = fullImage.getHeight();

			BufferedImage scaledImage = fullImage;

			// Scale the image if necessary.
			if(fullImageWidth > width) {
				double scaleFactor = (double)width / (double)fullImageWidth;
				int height = (int)((double)fullImageHeight * scaleFactor);

				scaledImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); 
				Graphics2D g = scaledImage.createGraphics();

				// Method drawImage() scales an already loaded image. The 
				// ImageObserver argument is null because we don't need to monitor 
				// the scaling operation.
				g.drawImage(fullImage, 0, 0, width, height, null);
			}

			long elapsedTime = System.currentTimeMillis() - startTime;
			System.out.println("Image loading and scaling took " + elapsedTime + "ms.");
			return scaledImage;

		}

		/**
		 * Passing the ImageRectangleShape object to the event dispatch thread.
		 */
		@Override 
		public void done() {
			BufferedImage scaledImage=null;
			try {
				scaledImage=get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			ImageRectangleShape imageShape = new ImageRectangleShape(deltaX, deltaY, scaledImage);
			_model.add(imageShape, _parentOfNewShape);
		}
	}
}
