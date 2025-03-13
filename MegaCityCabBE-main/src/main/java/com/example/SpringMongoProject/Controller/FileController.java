package com.example.SpringMongoProject.Controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/upload")
public class FileController {
    @PostMapping(value = "/file")
    public String uploadFile(@RequestBody MultipartFile file, @RequestParam("filename") String filename) {
        @SuppressWarnings("null")
        String[] extention = file.getOriginalFilename().split("\\.");
        String filePath = System.getProperty("user.dir") + "/Uploads/" + filename + "."
                + extention[extention.length - 1];
        String fileUploadStatus;

        try {
            FileOutputStream fout = new FileOutputStream(filePath);
            fout.write(file.getBytes());

            fout.close();
            fileUploadStatus = "File Uploaded Successfully";

        } catch (Exception e) {
            e.printStackTrace();
            fileUploadStatus = "File Upload Faild" + e;
        }
        return fileUploadStatus;
    }

    @GetMapping(value = "/getFiles")
    public String[] getFiles() {
        String folderPath = System.getProperty("user.dir") + "/Uploads";

        File directory = new File(folderPath);

        String[] fileNames = directory.list();

        return fileNames;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping(value = "/download/{path:.+}")
    public ResponseEntity downloadFile(@PathVariable("path") String fileName) throws FileNotFoundException {
        String fileUploadPath = System.getProperty("user.dir") + "/Uploads";
        String[] fileNames = this.getFiles();
        boolean contains = Arrays.asList(fileNames).contains(fileName);
        if (!contains) {
            return new ResponseEntity("File Not Found", HttpStatus.NOT_FOUND);
        }

        String filePath = fileUploadPath + File.separator + fileName;

        File file = new File(filePath);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
}
