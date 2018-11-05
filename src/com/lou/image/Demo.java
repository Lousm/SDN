package com.lou.image;
 /*
         ªÊ÷∆Õº∆¨—È÷§¬Î
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;

import javax.imageio.ImageIO;

import org.junit.Test;

public class Demo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		fun2();
	}

	
	@Test
	public static void fun2() throws FileNotFoundException, IOException{
		VerifyCode vc = new VerifyCode();
		BufferedImage bi = vc.getImage();
		VerifyCode.output(bi, new FileOutputStream("E:/yan.jpg"));
		
		System.out.println(vc.getText());
	}
	
}
