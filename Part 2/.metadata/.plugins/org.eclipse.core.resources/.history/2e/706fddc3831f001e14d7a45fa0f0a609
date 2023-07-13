package ch16;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		long milliesecond = 0;
		try( BufferedInputStream bis = new BufferedInputStream( new FileInputStream("a.zip")); 
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.zip"))){
			milliesecond = System.currentTimeMillis();
			
			int i;
			while((i=bis.read()) != -1) {
				bos.write(i);
			}
			
			milliesecond = System.currentTimeMillis() - milliesecond;
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(milliesecond);
	}

}
