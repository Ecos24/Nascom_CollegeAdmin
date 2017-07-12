package extraClasses;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This class provides all the custom method related to Image Handling
 * @author ecos
 */
public class ImageFunctions
{
	/**
	 * This function resizes the image at the give image path.
	 * @param imagePath
	 * @return imageIcon
	 */
	public static ImageIcon resizeImage(String imagePath)
	{
		Image img = new ImageIcon(imagePath).getImage();
		Image resize = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		return new ImageIcon(resize);
	}
	
	/**
	 * This function setup's the Image Selector for user and return's the path of selected Image.
	 * @return immage path
	 */
	public static String selectImage()
	{
		JFileChooser browseImage = new JFileChooser();
		browseImage.setCurrentDirectory(new File(System.getProperty("user.home")) );
		FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Images", 
				"jpg", "png", "jpeg");
		browseImage.addChoosableFileFilter(imageFilter);
		int result = browseImage.showSaveDialog(null);
		if( result == JFileChooser.APPROVE_OPTION )
		{
			File selectedImage = browseImage.getSelectedFile();
			System.out.println(selectedImage.getAbsolutePath());
			return selectedImage.getAbsolutePath();
		}
		else if( result == JFileChooser.CANCEL_OPTION )
		{
			System.out.println("No File Selected");
			return null;
		}
		return null;
	}
	
	/**
	 * This function validates the selected File.
	 * @param imagePath
	 * @return validity of file selected.
	 */
	public static boolean validateSelectedImage(String imagePath)
	{
		String extention = "";
		int i = imagePath.lastIndexOf(".");
		int p = imagePath.lastIndexOf("/");
		if( i > p )
		{
			extention = imagePath.substring(i+1);
		}
		if( extention.equals("jpg") || extention.equals("jpeg") || extention.equals("png") )
		{
			return true;
		}
		return false;
	}
}
