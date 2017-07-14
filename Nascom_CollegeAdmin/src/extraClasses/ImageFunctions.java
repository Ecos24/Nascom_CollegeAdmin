package extraClasses;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

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
	 * This function saves the given file path to project's directory and return's it's path.
	 * @param imgPath
	 * @param userName
	 * @return saved Image Path.
	 */
	public static String saveImage(String imgPath, String userName)
	{
		String dest = "profilePics";
		File sourceMain = new File(imgPath);
		File dstFolder = new File(dest);
		
		try
		{
			FileUtils.copyFileToDirectory(sourceMain, dstFolder);
			File source = new File(dest+File.separator+getImageName(imgPath));
			dstFolder = new File(dest+File.separator+userName+getImageExtention(imgPath));
			Path extra = Paths.get(dest+File.separator+userName+getImageExtention(imgPath));
			Files.deleteIfExists(extra);
			FileUtils.moveFile(source, dstFolder);
			return dstFolder.getAbsolutePath();
		}
		catch(IOException e)
		{
			System.out.println(e.getClass().getName()+" Exception occured while saving file --> "+e.getMessage() );
		}
		return null;
	}
	
	/**
	 * This function resizes the image at the give image path.
	 * @param imagePath
	 * @return imageIcon
	 */
	public static ImageIcon resizeImage(String imagePath)
	{
		Image img = new ImageIcon(imagePath).getImage();
		Image resize = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		return new ImageIcon(resize);
	}
	
	/**
	 * This function setup's the Image Selector for user and return's the path of selected Image.
	 * @return image path
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
	 * This function gives the file name of the specified path.
	 * @param imagePath
	 * @return fileName
	 */
	public static String getImageName(String imagePath)
	{
		int p = imagePath.lastIndexOf(File.separator);
		return imagePath.substring((p+1),imagePath.length());
	}
	
	/**
	 * This function gives the file extention at the specified path.
	 * @param imagePath
	 * @return
	 */
	public static String getImageExtention(String imagePath)
	{
		int i = imagePath.lastIndexOf(".");
		int p = imagePath.lastIndexOf("/");
		if( i > p )
		{
			return imagePath.substring(i);
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
