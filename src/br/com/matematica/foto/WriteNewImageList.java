package br.com.matematica.foto;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class WriteNewImageList {

	public static void main(String[] args) {
		
		int m = 0;
		int width = 128;
		int height = 128;
		BufferedImage image = null;
		File f = null;
		List<Integer> xs = new ArrayList<>();
		List<Integer> ys = new ArrayList<>();
		
		try {
			f = new File("/home/hal9000/Pictures/teste1.jpg");
			//image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
			image = ImageIO.read(f);
			
			
				for (int i = 0; i < 128; i++) {
				
					for (int j = 0; j < 128; j++) {
							xs.add(i);
							ys.add(j);
			//				System.out.println();
							//System.out.println("Pixel no: "+m+"x="+i+"j="+j+"-value:"+p+"\n--Alpha: "+a+"\n--Red: "+r+"\n--Green: "+g+"\n--Blue: "+b+"\n\n");
							m++;
					}
				}
			}catch(Exception e){
				System.out.println("Erro: "+e.getCause());
			}
		
	    Integer i = xs.get(15558);
	    Integer j = ys.get(15558);
	    
		int p = image.getRGB(i, j);
		int a = (p>>24) & 0x000000ff; //alpha
		int r = (p>>16) & 0x000000ff; //red
		int g = (p>>8) & 0x000000ff; //red
		int b = p & 0x000000ff; //red
		System.out.println("Pixel no: "+m+"x="+i+"j="+j+"-value:"+p+"\n--Alpha: "+a+"\n--Red: "+r+"\n--Green: "+g+"\n--Blue: "+b+"\n\n");
		
		//BufferedImage img = null;//new BufferedImage(128, 128, BufferedImage.TYPE_4BYTE_ABGR);
		
		for (int k = 0; k < m; k++) {
			Integer value1 = xs.get(k);
			Integer value2 = ys.get(k);
			int p2 = image.getRGB(value1, value2);
			
			int a2 = (p2>>24) & 0xff; //alpha
			int r2 = (p2>>16) & 0xff; //red
			int g2 = (p2>>8) & 0xff; //green
			int b2 =  (p2) & 0x0ff; //blue
			int bbb =  (a2<<24) | (r2<<16) | (g2<<8) | b2; //red
		//	int bbb2 = (p2 & 0x000000ff)>>0| (p2 & 0x0000ff00)>>8 | (p2 & 0x00ff0000)>>16; //usei sem 0xff!!!
			//System.out.println(p2 & 0x000000ff);
			image.setRGB(value1, value2, bbb);
		}
		File f2 = null;
		f2 = new File("/home/hal9000/Pictures/tree2.jpg");
		try {
			ImageIO.write(image, "jpg", f2);
		} catch (IOException e) {
			System.out.println("Erro ao criar:" + e.getCause());		
		}
	}
}
