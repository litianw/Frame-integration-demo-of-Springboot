package com.ltw.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/file")
public class FileController {
	
	private String path = "d:\\";

	@RequestMapping(value="/index")
	public String file() {
		return "upload";
	}
	/**
	 * 上传
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value="/upload")
	@ResponseBody
	//确保 前端页面的name属性的值 与参数名相同
	public Map<String, Object> upload(@RequestParam("file")MultipartFile file) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());

		File localFile = new File(path, file.getOriginalFilename());

		file.transferTo(localFile);

		map.put("success", true);
		map.put("path", path+file.getOriginalFilename());
		map.put("fileName", file.getOriginalFilename());
		return map;
	}
	
	/**
	 * 下载
	 * @param id
	 * @param request
	 * @param response
	 */
	@GetMapping("/download/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
		try (InputStream inputStream = new FileInputStream(new File(path, id + ".jpg"));
				OutputStream outputStream = response.getOutputStream();) {

			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=" + id + ".jpg");

			IOUtils.copy(inputStream, outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
