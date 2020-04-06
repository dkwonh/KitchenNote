package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class UploadService {
	Random random = new Random();
	public String save(String path, MultipartFile image) throws IOException{
		/*
		 * long currentTime = System.currentTimeMillis(); int randomValue =
		 * random.nextInt(50); String fileName = Long.toString(currentTime) + "_" +
		 * Integer.toString(randomValue);
		 */
		System.out.println("path : "+path);
		System.out.println("image : "+image.getOriginalFilename());
		File file = new File(path,image.getOriginalFilename());
		
		image.transferTo(file);

		return file.getAbsolutePath();
	}
}
