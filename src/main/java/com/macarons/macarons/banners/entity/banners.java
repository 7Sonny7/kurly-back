package com.macarons.macarons.banners.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class banners {
    @Id
    private String bannerType;      // banner 유형    (E: main event, .....)
    private String bannerLocation;  // banner 위치    (ex: H1 - Home 카테고리의 첫 번째 메뉴)
    private String eventTitle;     // banner 제목
    private String eventContent;   // banner 내용
    private String bannerImage;     // banner 이미지 경로
    private String dltYn;           // banner 삭제 여부
}
