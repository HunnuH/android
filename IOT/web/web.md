### Web

- web server : web에서 클라이언트의 요청을 받고 처리해서 클라이언트에게 요청처리 결과를 보내주는 프로그램이 설치 되어 있어야한다.

- 구조
  - web applocation 폴더 : `html`,`css`,`javascript`,`이미지`,`jsp` 파일 
    - Web Inf 
      - lib : 외부에서 가져다 사용하는 라이브러리파일
      - classes : 자바클래스, 서블릿클래스,db연동.....
      - `web.xml` : 하나의 사이트를 운영하기 위해 필요한 설정정보를 정의하는 설정파일



- 요청
  - 서버구축 후 `Context`를 만들어 놓은 후에 요청하는 방법
    - servlet & jsp가서 변경
    - `http://ip:port/context명/폴더명/web applicattion파일명`

-  웹환경 구축

  - dynamic web project구축

    - 폴더구조를 확인

  - 서버등록

    - 톰캣서버를 등록
    - 톰캣이 이클립스 밖에서 실행되고 있으면 이클립스는 실행할수없다
    - 이클립스 외부에서 실행되던 서버를 이클립스 내에서 실행되도록 등록
    - context를 서버로 배포 (*server.xml에 <contxet>가 추가된다)
      - 실제위치 : C:\bigdata_iot\work\webwork\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\clientweb

  - 문자셋설정

    - utf-8
    - dynamic web project
    - html문서
    - jsp문서

  - 실행

    

- 태그

  - `<!--  -->` : 주석
  - `<h1~h6></h1~h6>` : 제목
  - `<font size=" " face=" " color=" "> </font>` :글씨 

  - `<ing src="이미지경로" width="가로사이즈" height="세로사이즈"` :이미지

    - 이미지의 경로  

      - 파일탐색기에서 확인가능한 파일의 경로를 사용해서는 안된다

      - 웹에서 요청하는 방식을 이용

      - 상대경로 :   <img src="./clientweb/images/viewa.png"/>

        ​                    `.` 현재위치    `..`상위디렉토리    

      - 절대경로 : 경로를 모두 명시 >  <img src="http://192.168.0.63:8088/clientweb/viewa.png"/>

        ​                                                     <img src="/clientweb/images/viewa.png"/>
