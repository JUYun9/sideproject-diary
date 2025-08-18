# 📒 미니 프로젝트 — 일기장 (Spring Boot + Thymeleaf)

간단한 **일기(Entry)** CRUD 예제입니다.  
**Spring Boot + Thymeleaf**로 서버 렌더링을 하고, 저장소는 **메모리(Map) 기반**이라 실행 중 데이터만 유지됩니다.

> 실행 시 `@PostConstruct`로 예시 데이터 2건이 자동 등록됩니다.

---

## ✨ 주요 기능

- 일기 목록 조회 / 상세 보기
- 새 일기 작성
- 일기 수정
- 일기 삭제

---

## 🧱 기술 스택

- Java 21 (권장)
- Spring Boot 3.5.4
- Thymeleaf
- Lombok
- Bootstrap 5
- 메모리 저장소 (HashMap)

---

## 📁 디렉터리 구조

src/

└─ main/

├─ java/hello/sideproject1/

│ ├─ Entry.java

│ ├─ EntryRepository.java

│ └─ EntryController.java

└─ resources/

├─ templates/

│ ├─ addForm.html # 새 일기 폼

│ ├─ edit.html # 수정 폼

│ ├─ entry.html # 상세 페이지

│ └─ list.html # 목록 페이지

└─ static/

└─ css/

└─ bootstrap.min.css
---

## 🧭 라우팅(RESTful)
| 목적   | HTTP   | 경로                   | 설명                             |
| ---- | ------ | -------------------- | ------------------------------ |
| 목록   | GET    | `/entries`           | 일기 목록 페이지                      |
| 신규 폼 | GET    | `/entries/new`       | 새 일기 작성 폼                      |
| 생성   | POST   | `/entries`           | 새 일기 저장(**폼 전송**)              |
| 상세   | GET    | `/entries/{id}`      | 일기 상세                          |
| 수정 폼 | GET    | `/entries/{id}/edit` | 일기 수정 폼                        |
| 수정   | PUT    | `/entries/{id}`      | 일기 수정 |
| 삭제   | DELETE | `/entries/{id}`      | 일기 삭제 |



## 🧩 도메인 모델
```Java
public class Entry {
    Long id;
    String title;
    String content;
    LocalDateTime localDateTime; // 생성/수정 시각으로 사용
}
```

- 생성 시 EntryRepository.save()에서 id 및 localDateTime=now() 설정
- 수정 시 localDateTime=now()로 갱신

## 🖥️ 화면 템플릿 요약

- `list.html`: 목록(제목 링크 → 상세), “새 일기” 버튼

- `entry.html`: 상세(수정/삭제 버튼)

- `addForm.html`: 새 일기 작성 폼 (th:action="@{/entries}")

- `edit.html`: 수정 폼 (th:action="@{/entries/{id}(id=${entry.id})}" + _method=PUT)

## 예시

### 일기 목록
`localhost:8080/entries`

<img width="500" height="150" alt="image" src="https://github.com/user-attachments/assets/1e0fd68a-6701-4835-a5d6-314fe0b1f050" />


### 등록 화면
<img width="500" height="200" alt="image" src="https://github.com/user-attachments/assets/8d749295-045f-418a-acc4-a8eb5436d328" />


### 상세 화면
<img width="500" height="200" alt="image" src="https://github.com/user-attachments/assets/b4f7670b-8c94-4a71-afcb-1fe439bc173a" />


### 수정 화면
<img width="500" height="300" alt="image" src="https://github.com/user-attachments/assets/df911caf-8baa-4597-98c5-954aae75fb9d" />


### 삭제 화면
<img width="500" height="200" alt="image" src="https://github.com/user-attachments/assets/8f40ae9c-c480-4479-930f-0ec2a6e6ba3c" />



