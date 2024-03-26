# MetLife Hackathon 2024 대상 수상작

2024년 3월 23 ~ 2024년 3월 24일까지 MetLife 사에서 주최한 Hackathon 대상 수상작 

## 🏆 프로젝트 소개
2024년 3월 23일부터 24일까지 MetLife 사에서 주최한 Hackathon에서 대상을 수상한 프로젝트입니다. 이 프로젝트는 [(AI) 보험사 데이터 기반 생성형 AI 도입 챗봇 개발 프로젝트] 입니다

## 👥 팀원

![prize](https://github.com/MetLife-Hackathon/MetLife-Hackathon/assets/37052379/d0696318-3a4b-429c-8c86-4b8ddd57a704)


| 이름   | 역할 | GitHub                                           | 이메일                |
|--------|------|--------------------------------------------------|-----------------------|
| 이태겸 | FrontEnd Dev  | [이태겸](https://github.com/홍길동의GitHubID)  | 이태겸의이메일@도메인 |
| 박태완 | FrontEnd Dev | [박태완](https://github.com/Taewan-P) | swimingtw@gmail.com |
| 조일민 | FrontEnd Dev | [조일민](https://github.com/IlMinCho) | choim426@gmail.com |
| 최승원 | BackEnd Dev | [최승원](https://github.com/김철수의GitHubID)  | wonny921@gmail.com |
| 김예슬 | BackEnd Dev | [김예슬]() |  |
| 이은지 | 팀장 & BackEnd Dev | [이은지](https://github.com/spew11) | dhbdg11@gmail.com |
| 이현수 | AI API Dev | [이현수]() |  |
| 박무현 | AI API Dev | [박무현](https://github.com/parkmuhyeun) | pjhg410@gmail.com |
| 박도현 | AI API Dev | [박도현 Link](https://dhparkland.site/) | zerosugarcoke@naver.com |


## 🎨 프로젝트 설명
<img width="704" alt="image" src="https://github.com/MetLife-Hackathon/MetLife-Hackathon/assets/37052379/4e53754e-6399-4542-9a4a-300a9a19b761">


**고객 맞춤형 AI 보험 도우미 서비스**

메트라이프의 300종의 보험 상품 및 약관 데이터를 활용하여 사용자에게 맞춤형 응답을 제공하는 서비스입니다. 주요 기능은 다음과 같습니다:

- 개인의 필요에 맞는 보험 추천
- 특정 보험의 장점 안내
- 보험 가입 조건 및 가능 여부 확인
- 고객의 정보와 대화 기록을 바탕으로 보험 상담사에게 효율적으로 연결

### 상담 품질 향상

AI 기반 플랫폼은 최적의 응답 템플릿을 제공하여 상담사와의 연결뿐만 아니라 상담의 질을 향상시킵니다.

### 적용된 AI 기술

1. **Elastic Search Vector Database 구축**: 보험 약관의 저장 및 검색을 위해 구축되었습니다.
    - Chat GPT OCR을 통한 PDF 파일 내 텍스트 추출
    - Chat GPT Embedding을 활용한 문서 및 쿼리 임베딩
    - Elastic Search를 이용한 벡터 유사도 검색 및 AI 답변 추출
  
### 기술 스택

- 프론트엔드: 
- React (UI library)
- TypeScript (Programming language)
- UI Components: MUI (Material-UI)
- State Management: Recoil Design Framework: Tailwind CSS
-
- 백엔드: Spring boot 3.2.4, Spring Data JPA, Spring Security 3.1.5
- 
- AI:
- JDK 11: ElasticSearch,Spring Boot 환경 통일
- ElasticSearch 8.7.0: 보험 약관 데이터 저장 및 검색
- Spring Boot 2.7.0: API 제공 서버 개발
- (GPT)text-embedding-3-small,text-embedding-3-large 모델: 문서 및 쿼리 임베딩
- GPT-4-1106-preview: 사용자 질의에 대한 답변 생성
- Python FastAPI: pdf 파일 실시간 임베딩 및 ElasticSearch 색인 서버 개발

