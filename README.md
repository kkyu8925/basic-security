## 스프링 시큐리티 - Spring Boot 기반으로 개발하는 Spring Security

### 섹션 0. 강좌 소개

- 강의소개
- 실전 프로젝트 예제 미리보기
- 강의 자료
- 강의 소스

### 섹션 1. 스프링 시큐리티 기본 API 및 Filter 이해

- 프로젝트 구성 및 의존성 추가
- 사용자 정의 보안 기능 구현
- Form Login 인증
- Form Login 인증 필터 : UsernamePasswordAuthenticationFilter
- Logout 처리, LogoutFilter
- Remember Me 인증
- Remember Me 인증 필터 : RememberMeAuthenticationFilter
- 익명사용자 인증 필터 : AnonymousAuthenticationFilter
- 동시 세션 제어, 세션 고정 보호, 세션 정책
- 세션 제어 필터 : SessionManagementFilter, ConcurrentSessionFilter
- 권한설정과 표현식
- 예외 처리 및 요청 캐시 필터 : ExceptionTranslationFilter, RequestCacheAwareFilter
- 사이트 간 요청 위조 - CSRF, CsrfFilter

### 섹션 2. 스프링 시큐리티 주요 아키텍처 이해

- 위임 필터 및 필터 빈 초기화 - DelegatingProxyChain, FilterChainProxy
- 필터 초기화와 다중 보안 설정
- 인증 개념 이해 - Authentication
- 인증 저장소 - SecurityContextHolder, SecurityContext
- 인증 저장소 필터 - SecurityContextPersistenceFilter
- 인증 흐름 이해 - Authentication Flow
- 인증 관리자 : AuthenticationManager
- 인증 처리자 - AuthenticationProvider
- 인가 개념 및 필터 이해 : Authorization, FilterSecurityInterceptor
- 인가 결정 심의자 - AccessDecisionManager, AccessDecisionVoter
- 스프링 시큐리티 필터 및 아키텍처 정리
  l
