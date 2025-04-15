# pdf-merge-compressor

**pdf-merge-compressor**는 REST API를 통해 폴더 경로를 입력받아, 해당 폴더 내의 PDF 파일들을 하나로 병합(Merge)하고, 병합된 PDF 파일을 다운로드할 수 있도록 제공하는 서비스입니다.

## Features
- REST API 기반 PDF 병합 서비스
- 폴더 내 모든 PDF 파일 자동 탐색 및 병합
- 병합된 PDF 파일 다운로드 제공
- (선택) 병합된 PDF 파일 압축 기능

## Requirements
- Java 3.x (예시)
- Flask (또는 FastAPI 등)
- iText

## API
### 1. PDF 병합 요청
- **Endpoint:** `/merge`
- **Method:** `POST`
- **Content-Type:** `application/json`

#### Response
- 병합된 PDF 파일 다운로드 (`application/pdf`)

## License
이 프로젝트는 [AGPL v3](https://www.gnu.org/licenses/agpl-3.0.html) 라이선스를 따릅니다.  
iText 등 AGPL 라이브러리를 사용하므로, 소스코드 전체를 공개해야 하며, 라이선스 조건을 반드시 준수해야 합니다.

## Contact
- Issues 및 문의: [GitHub Issues](https://github.com/sariiiiiiii/pdf-merge-compressor/issues)
- AGPL 관련 문의: agpl@itextpdf.com

---
> **Note:**  
> 이 프로젝트는 오픈소스(AGPL) 라이선스 하에 배포됩니다. 상업적 사용 또는 소스코드 비공개 사용 시 별도의 라이선스가 필요할 수 있습니다.
