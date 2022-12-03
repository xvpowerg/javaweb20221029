package tw.com.web.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class ImageTools {
		
	private static String imagePath;
	static void setImagePath(String path) {
		imagePath = path;
	}
	
	public static String getImagePath() {
		return imagePath;
	}
	
	
	public static boolean uploadFile(InputStream inpuStr,String fileName)
			throws IOException {
		Path filePath = Paths.get(imagePath,fileName);
		File outFile = filePath.toFile();
		try(BufferedInputStream bfIn = new BufferedInputStream(inpuStr);
			FileOutputStream out = new FileOutputStream(outFile)){
			byte[] cache = new byte[1024];
			int index = -1;
			while( (index = bfIn.read(cache)) != -1) {
				out.write(cache, 0, index);
			}
		}
		return true;
	}
	
	public static List<String> getImageFileNames()throws IOException{
		Path filePath = Paths.get(imagePath);
		List<String> fileNameList = Files.list(filePath).
				map(p->p.getFileName().toString()).collect(Collectors.toList());
		return fileNameList;
		
	}
	
}
