# freelancer-point

## 프로젝트 구조

```
freelancer-point-project
│
├── common
│   └── entity
│   └── exception
│   └── response
│
├── server
│   └── freelancer-api
│   └── pay-api
│
└── settings.gradle
```

## 작업 내역

- 멀티모듈 구성
- 프리랜서 프로필 목록 조회
    - 이름 가나다 순, 조회수 순, 등록 최신 순 검색 기능
    - Response 결과 페이징 처리
- 프리랜서 상세 조회
    - 조회수 증가(view Count)
    - 조회수 증가 방지(쿠키에 id값 저장)
- 테스트 코드 작성

## 사용 오픈소스

- apache commons
    - 문자열 처리 용이 (StringUtils)

## 사용 기술

- Java 21
- SpringBoot 3.x
- Gradle
- MariaDB
- Querydsl
- SpringDataJPA