package net.magicscroll.longpathdelete;

import java.io.File;

public class LongPathDelete {

	public static void main(String[] args) {
		
		String path = args[0];
		System.out.println("Processing: " + path);
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			
			if (file.lastModified() < System.currentTimeMillis() - 86400000) {
				System.out.println("Will delete " + file.toString());
				file.renameTo(new File(path + "/" + i + "d.d"));
			}
		}

	}

}
