# 진주 병원 정보 어플리케이션
> 2020-1학기 소프트웨어설계프로젝트 J-HI

기존의 병원 어플처럼 수도권 위주의 정보를 제공하는 것이 아닌 

진주 지역내의 병원 정보를 제공하며 코로나 확진자 정보, 약국, 건강 정보 등 다양한기능을 제공하는 안드로이드 어플리케이션

<br>

## 1.제작 기간 & 참여 인원 
- 2020.04 ~ 2020.07 
- 고하람, 이상현, 최수영, 유민환 

<br>


## 2. 구현 환경 
- 개발환경 : Window 10, Android Studio
- 사용언어 : Java, PHP 
- 서버 / 데이터베이스 : Apache, MySQL
- API : Google Maps API, 전국 병‧의원 찾기 서비스 API, 전국 약국 정보 조회 서비스 API, 약품 정보 API

<br>

## 3. 기능 구성 
![img25](https://user-images.githubusercontent.com/65746780/139910507-a162295b-2b76-4c47-a6ef-d245a5920067.jpg)

<br>

## 4. ERD 설계
![img147](https://user-images.githubusercontent.com/65746780/139910738-1410c35e-7bd7-4ab1-90af-163309117aea.jpg)

<br>

## 5. 핵심 기능 
- 진주 지역내의 병원(약국) 정보, 위치, 리뷰, 전화 기능
- 코로나 감연자 동선 및 정보 제공 
- 건강 정보(뉴스, 유튜브) 제공 
- 약품 정보 제공 
- 기본적인 사용자 기능 

<br>

## 6. 개인 구현 내용 
- PHP를 통한 안드로이드와 DB 통신
- JAVA를 이용한 문서 데이터 추출
- 추출 데이터 기반 구글 맵 API 활용
- 기본적인 사용자 기능
    - 회원가입 및 로그인
    - 마스크 정보
    - 건강문진표

<br>

## 7. 구현 결과 
### -1)로그인 및 회원가입

<img src = "https://user-images.githubusercontent.com/65746780/139912906-158f5735-6d5d-4407-b42b-c066921f54be.jpg" width="200" height="400"/>  &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139913844-8f0978cd-7abf-4f5a-8cc7-a396579e4e4f.jpg" width="200" height="400"/> &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139913980-b0fbbb63-0a3a-49cb-b107-da203a215bfb.jpg" width="200" height="400"/>

### -2) 메인, 사용자 기능 

<img src = "https://user-images.githubusercontent.com/65746780/139914084-e31e9a84-3242-41df-b05c-4626b18fc8c4.jpg" width="200" height="400"/>  &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139914132-c09c7ce3-aeb4-481e-8957-59eeff5b9ae7.jpg" width="200" height="400"/> &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139914150-25071b06-ce32-4db4-9cee-73539ce69a50.jpg" width="200" height="400"/>

### -3) 병원, 약국 기능

<img src = "https://user-images.githubusercontent.com/65746780/139914171-06fef2a0-d58e-4d31-a7fa-f64fa6777031.jpg" width="200" height="400"/>  &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139914177-4722a4b4-1b5e-402a-bfe3-619097cc2187.jpg" width="200" height="400"/> &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139914186-545372f7-4af3-4e1c-a0e3-23b77ce34ffe.jpg" width="200" height="400"/>&nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139914193-1d9359f8-0fea-4c9a-9d82-e9901f4ba639.jpg" width="200" height="400"/>

<img src = "https://user-images.githubusercontent.com/65746780/139914216-b511af6d-de81-4925-94b4-d1d80df25da5.jpg" width="200" height="400"/>  &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139914243-9216a145-9ab7-4e7e-844b-70e6e18adceb.jpg" width="200" height="400"/>

### -4) 코로나 감염자 동선

<img src = "https://user-images.githubusercontent.com/65746780/139915315-251f9730-4c2c-4c01-b0b8-27963acca53f.jpg" width="200" height="400"/>  &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139915322-2a91c3e0-b3ad-4be8-95ce-f3523a4ee191.jpg" width="200" height="400"/>

### -5) 건강 정보 제공
<img src = "https://user-images.githubusercontent.com/65746780/139915823-36906c77-abc1-435d-b6c2-acedaa7f7d0c.jpg" width="200" height="400"/>  &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139915832-07a53b07-bbd0-4b6f-89af-fdb37007a020.jpg" width="200" height="400"/> &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139915912-2a31a0ff-d0c6-4b74-87d3-bc859d2c1233.jpg" width="200" height="400"/>
 &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139915918-aa761639-1627-4d13-abfa-2be98a7f0fe1.jpg" width="200" height="400"/>

### -6) 약품 정보 제공

<img src = "https://user-images.githubusercontent.com/65746780/139916179-6a4256eb-4942-4ead-98ba-90dcbcf51f74.jpg" width="200" height="400"/>  &nbsp;  &nbsp;<img src = "https://user-images.githubusercontent.com/65746780/139916190-cc3ca1b7-b87b-430b-add2-ad72d148fee6.jpg" width="200" height="400"/>




