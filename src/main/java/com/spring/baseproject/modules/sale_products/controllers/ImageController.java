package com.spring.baseproject.modules.sale_products.controllers;

import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.sale_products.services.file.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images/")
public class ImageController extends BaseRESTController {
    @Autowired
    IImageService imageService;


    @PostMapping
    public BaseResponse create(@RequestParam(name = "file") MultipartFile file) {
        try {

            String fileName = imageService.save(file);

            String imageUrl = imageService.getImageUrl(fileName);

            // do whatever you want with that
            return new BaseResponse(ResponseValue.SUCCESS, imageUrl);

        } catch (Exception e) {
            //  throw internal error;
            return new BaseResponse(ResponseValue.FIREBASE_STORAGE_UPLOAD_ERROR);

        }
    }
}
