package com.macarons.macarons.banners.controller;

import com.macarons.macarons.banners.entity.banners;
import com.macarons.macarons.banners.repository.MainBannerRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/macarons")
@RequiredArgsConstructor
@RestController
public class MainBannerController {

    private final MainBannerRepository mainBannerRepository;
    /**
     *  TYPE   : SELECT ALL
     */
    @GetMapping("/banner/mainbanner")
    @Tag(name = "Banner 정보 조회", description = "Banner 정보 조회")
    @ApiOperation(value = "Banner 정보 조회", notes = "Banner location 과 type을 통한 banner 정보 조회")
    public ResponseEntity<List<banners>> findAll(@RequestParam(required = false) String bannerType, String bannerLocation){

        System.out.println("<<<<<<<<<<<<<<< Main Banner Controller >>>>>>>>>>>>>>>");

        try {
            List<banners> entity = new ArrayList<>();

            if(bannerType == null) {
                mainBannerRepository.findByDltYnContaining("N").forEach(entity::add);
            }else{
                mainBannerRepository.findByBannerTypeContainingAndBannerLocationContainingAndDltYn(bannerType, bannerLocation, "N").forEach(entity::add);
            }

            if(entity.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<List<banners>>(entity, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
