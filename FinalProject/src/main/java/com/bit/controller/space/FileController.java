package com.bit.controller.space;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

@Controller
public class FileController {

	/*
	 * @GetMapping(value = "/uploadSummernoteImageFile")
	 * 
	 * @ResponseBody public JsonObject w() { // 외부 경로에 잡아줌
	 * System.out.println("dddddd");
	 * 
	 * JsonObject jsonObject = new JsonObject(); return jsonObject; }
	 */
	
	@PostMapping(value = "/uploadSummernoteImageFile", produces = "application/json")
	@ResponseBody
	public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile file) {
		// 외부 경로에 잡아줌
		JsonObject jsonObject = new JsonObject();

		String filePath = "C:\\summernote_image\\"; // 저장될 파일 경로
		String originalFileName = file.getOriginalFilename(); // 오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

		String savedFileName = UUID.randomUUID() + extension; // 저장될 파일 명 //암호화

		File targetFile = new File(filePath + savedFileName);

		try {
			InputStream fileStream = file.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile); // 파일 저장
			jsonObject.addProperty("url", "/summernoteImage/" + savedFileName);
			jsonObject.addProperty("responseCode", "success");

		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile); // 저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		return jsonObject;
	}

}
