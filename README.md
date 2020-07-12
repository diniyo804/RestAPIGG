# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### 참고 사이트
project git 연동 
* [intelliJ에서 기존 프로젝트 GitHub 연동하기](https://atoz-develop.tistory.com/entry/IntelliJ%EC%97%90%EC%84%9C-GitGitHub-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-%EA%B8%B0%EC%A1%B4-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%97%B0%EB%8F%99%ED%95%98%EA%B8%B0)


### 의존성 관리 (Dependency Injection)
객체들 간의 의존관계를 spring을 이용하여 직접 관리하는 것을 말한다.
관련 annotation을 spring이 제공한다.


@Component
- class의 객체를 spring이 직접 관리한다.
- class를 사용하는 곳에서 직접 객체를 만들지 않고 사용할 수 있게 된다.

@Autowired
- spring이 관리하는 객체를 사용한다.
- 클래스를 실행할 때 spring이 알아서 필요한 객체를 생성해서 넣어준다.
- 어떤 객체를 사용하고 싶을 때 ! 변수를 선언하고 변수위에 @Autowired를 작성해준다.

@SpyBean 
- 테스트 시 사용한다.
- 컨트롤러 테스트를 위해 web mvc 테스트를 할 땐 제대로 된 저장소를 사용할 수 없기때문에
테스트 진행 시 컨트롤러에 직접 의존성을 주입해줘야 하는데 그 때 @SpyBean을 사용한다.
- controller에 원하는 객체를 주입할 수 있다.