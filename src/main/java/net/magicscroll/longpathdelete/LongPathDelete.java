package net.magicscroll.longpathdelete;

import java.io.File;

public class LongPathDelete {

    public static void main(final String[] args) {

        final String path = args[0];
        System.out.println("Processing: " + path);
        final File folder = new File(path);
        final File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            final File file = listOfFiles[i];

            if ((file.getAbsolutePath() + file.getName()).length() > 120 && file.lastModified() < System.currentTimeMillis() - 86400000) {
                System.out.println("Will delete " + file.toString());
                file.renameTo(new File(path + "/" + i + "d.d"));
            }
        }

    }

}
