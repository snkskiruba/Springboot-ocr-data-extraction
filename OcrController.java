package com.kgisl.ocr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kgisl.ocr.service.ImageService;

@RestController
@RequestMapping("/api")
public class OcrController {
	@Autowired
	private ImageService imageService;

	@GetMapping("/ocr/data-extraction/{ocrId}")
	public Object dataExtractionOutput(@PathVariable("ocrId") Integer ocrId) throws Exception {

		@SuppressWarnings("rawtypes")
		List result = imageService.dataExtractionOutput(ocrId);

		Object dataExtractionResults = imageService.listAllDataExtractionJobOutput(result);

		return dataExtractionResults;
	}

	@PostMapping("/save/ocr-coordinates/{templateName}")
	public String saveOcrCoordinates(@PathVariable("templateName") String templateName, @RequestBody Object obj)
			throws Exception {
		String response = null;

		try {
			imageService.saveOcrCoordinates(templateName, obj);
			response = "success";
		} catch (Exception e) {
			e.printStackTrace();
			response = e.getMessage();
		}
		return response;
	}

}
