# JAVA Basic

- 환경설정
  - `java _home` : jdk의 설치 포더 경로
  - `path` : jdk의 bin디렉터리 경로
  
- 자바실행
  - 컴파일
    - 자바언어로 작성된 명령어를 컴퓨터에서 실행하기 위해서 컴퓨터가 이해 할수있는 명령어로 변경하는 작업
  - 인터프리터
    - 컴파일러로 번역한 명령어를 한 줄씩 번역하여 자바에서 실행
    - 중간에 오류가 발생하여도 오류가 발생 하기 전까지 실행

- 자바언어로 소스 코드를 작성
  - 자바 명령어로 구성된 
  - 확장자 : `.java`
  - 소스파일은 소스파일 내부에서 선언된 클래스명과 동일한 이름으로 작성
    - 클래스명 >` Hello`
    - 파일명 > `Hello.java`
  
- 자바소스 파일을 컴파일
  - 컴파일러 : `javac.exe`
    - javac 자바소스파일명. java
      - `javac Hello.java`
  - 컴파일의 결과파일이 생성
    - cmd > dir/w 로 확인
    - 확장자 :`.class` (클래스파일, 바이트코드)
      - `Hello.class`
  
- 자바실행
  - 인터프리터 : `java.exe`
    - `java`컴파일 결과로 생성된 클래스 파일의 파일명(확장자x)
    - `java Hello`
  
- 자바플랫폼
  - 자바를 개발하고 실행할 수 있는 환경
  - `JavaSE` (java  standard edition) : 기본, 입출력, DB연동, 네트워크
  - `JavaEE` (java  enterprise edition) : 서블릿JSP(웹)
  - `JavaME` (java  mobile deition)  
  
- 자바로 개발할 수 있는 구성요소

  - `Application`	
    - `java.exe`라는 인터프리터를 이용해서 실행하는 프로그램을 `application`이라고 한다
  - `Servlet`
  - `Applet`

- 자바의 작업 단위 -클래스

  - `class` : 키워드, 자바프로그램에 미리 의미를 부여해서 등록해 놓은 이름

    ​            미리 예약된 명령어

  - 클래스명 : 임의로 정의하는 이름

    ​                   명사적 특징을 갖도록 이름 부여

    ​                   여러단어결합 가능, 단어의 첫글자는 대문자

- 기본문법

  - 기본형리터럴

  - 연산자

    - 증감연산자 : `++` , `--`

      - ```java
        // 증감연산자 test
        public class OprTest01{
        	public static void main(String[] args) {
        		int x;
        		int y;
        
        		x = 5;
        		y = x++;
        		System.out.println("x의 값=>"+x);
        		System.out.println("y의 값=>"+y);
                System.out.println("===============");
          		
        		x = 5;
        		y = ++x;
        		System.out.println("x의 값=>"+x);
        		System.out.println("y의 값=>"+y);
                System.out.println("===============");
          
        		x = 5;
        		y = x--;
        		System.out.println("x의 값=>"+x);
        		System.out.println("y의 값=>"+y);
                System.out.println("===============");
          
                x = 5;
        		y = --x;
        		System.out.println("x의 값=>"+x);
        		System.out.println("y의 값=>"+y);
                System.out.println("===============");
          
        	}
        }
        ```

    - 산술연산자 " `+`, `-`, `*`, `/`, `%`

    - 비교연산자 : `<`, `<=`,  `>`,  `>=` , `==`, `!=`

      - ```java
        // 비교연산자
        public class OprTest02 {
        	public static void main(String[] args) {
        		int num1 = 100;
        		int num2 = 200;
        		int num3 = 200;
                   
        // num의 변수가 +연산자 때문에 문자열로 변환됨 
        // +의 연산자는 더하기의 의미 이외에도 연결연산자의 기능도 수행
        // +연산자 앞에 문자열이 존재하면 뒤에 숫자열이 오더라도 문자열로 변환
        // 비교연산. 사친연산을할 수 없다.
        		System.out.println("더한결과==>"+(num1+num2));
        		System.out.println("num1>num2==>"+ (num1>num2));
        		System.out.println("num1>=num2==>"+ (num1>=num2));
        		System.out.println("num1<num2==>"+ (num1<num2));
        		System.out.println("num1<=num2==>"+ (num1<=num2));
        
        		System.out.println("num1==num3==>"+ (num1==num3));
        		System.out.println("num2==num3==>"+ (num2==num3));
        		System.out.println("num1!=num3==>"+ (num1!=num3));
        	}
        }
        ```

    - 논리연산자 : `&` , `|`, `!`, `&&`, `||`

      - ```java
        //논리연산자
        // and : &
        // or : |
        // not : !
        public class OprTest03 {
        	public static void main(String[] args) {
        		int age = 15;
        		int gender = 1;
        
        		int num1 =100;
        		int num2 = 200;
        		//&연산
        		System.out.println("=======and======");
        		//true & true
        	    System.out.println((num1<num2) & (num1>=100));
        		//true & false
        		System.out.println((num1<num2) & (num1>100));
        		//false & true
        		System.out.println((num1>num2) & (num1>=100));
        		//false & false
        		System.out.println((num1>num2) & (num1>100));
        
        		//|연산
                System.out.println("=======or=======");
        		//true | true
        	    System.out.println((num1<num2) | (num1>=100));
        		//true | false
        		System.out.println((num1<num2) | (num1>100));
        		//false | true
        		System.out.println((num1>num2) | (num1>=100));
        		//false | false
        		System.out.println((num1>num2) | (num1>100));
        
        		System.out.println(); //Enter키를 누른 것과 같은 결과
        
        		//!
        		System.out.println(!true);
                System.out.println(!false);
        	}
        }
        ```

      - ```java
        //논리연산자(short circuit) && , ||
        //        & ,  |    둘의 차이는 조건식을 모두 검사하는지 skip하는지의 차이
        public class OprTest04 {
        	public static void main(String[] args) {
                  int num1 = 120;
                  //int num2 = 
                System.out.println("start");
        		String str = null; // 현재 str에 아무것도 할당되지 않은 변수
        
         	  //System.out.println(num1>100 | str.length()>0); 오류발생
        		System.out.println(num1>100 || str.length()>0);
        // ||연산자는 or연산의 특성을 파악하고 첫 번쨰 항이 true 연산자 뒤의 항은 검사하지 않는다 
        
              //System.out.println(num1<100 & str.length()>0); 오류발생
        	    System.out.println(num1<100 && str.length()>0);
        // &&연산자는 and연산의 특성을 파악하고 첫 번쨰 항이 false이면 뒤의 항은 검사하지 않는다
        	}
        }
        ```

  - 삼황연산자, 대입연산자

    - ```java
      //삼항연산자
      public class OprTest05 {
      	public static void main(String[] args) {
      		int num1 = 90;
      	//조건?조건이 만족하는 경우 할당될 값:조건이 만족하지 않을때 할당될 값
      		System.out.println(num1>=90?"합격" : "불합격");
      		int point = num1 >=90?1000:0;
      		System.out.println(point);
      //대입연산자
      		int i = 0;
      		i = i+20;
      		System.out.println("i="+i);
      		i+=30;
      		System.out.println("i="+i);
      		i-=30;
      		System.out.println("i="+i);
      	    i*=30;
      		System.out.println("i="+i);
      		i/=30;
      		System.out.println("i="+i);
      	}
      }
      ```

- 모든 프로그래밍 언어의 공통된 특징(기본문법)

  - 문장의 종류

    - 순차형 : 순서대로 명령문이 실행되도록 구현

    - 조건형 : 조건을 주고 조건에 만족하는 경우, 존건에 만족하지 않는 경우 실행할 문장을 따로 정의

    - 순환형 : 특정문장을 반복해서 실행할수 있도록 구현

  - 변수

    - 프로그램 사용중에 발생하는 데이터를 임시로 저장하기 위한 메모리의 공간

      - 변수선언 : 데이터타입 변수명;
      - 변수에 저장될 값을 설정 : 변수명 = 값;
        - 변수를 사용할때 변수의 선언과 값의 할당을 한 문장으로 처리한다 
        - 데이터타입 변수명 = 값;

    - 데이터타입

      - 기본형 : 값을 저장하는 데이터타입

        - 숫자 :  정수 -`byte(1byte)`,`short(2byte)`,`int(4byte)`,`long(8byte)`

          ​            실수 - `float`,`double`

        - 문자 :  `char`

        - 논리값 : `true/false` - boolean

      - 기본형 데이터 타입의 리터럴

        - 리터럴 : 프로그램에서 변수에 직접 할당하는 값

      - 기본형 변수의 type casting

        - 자바에서는 데이터의 타입을 변경할 수 있다.
          - 자동형 변환 : 사이즈가 큰 타입의 변수에 작은 값을 할당하는 경우 자동으로 캐스팅이 진헹
            - byte>short>int>long>float>double
            - long이 float보다 메모리의 크기가 크지만 float이 표현 할 수 있는 수의 범위가 더 크다.
          - 명시적형변환 ; 개발자가 직접 데이터의 형을 변경할 수 있다.
        - 데이터타입 변수명 = (형 변환할 데이터타입)리터럴 값

      - 참조형 :  API의 클래스, 사용자 정의  클래스, 인터페이, 배열...

        ​                클래스가 할당된  heap의 주소가 저장 되는 변수

        ​          참조형 변수에는 주소가 저장되므 == 연산자는 주소를 비교

        ​                배열 `array`      클래스`class`

        ​                열거 `enum`         인터페이스`interface`       

  - API사용방법

  - 제어구문 : 문장의 흐름을 정의하는 구문

    - 조건제어문 : 선택형을 구현
      - if~else

        ```java
        [구문]
        if(조건){ 조건이 만족하는 경우 실행할 문장}
        else {조건이 만족하지 않는 경우 실행할 문장}
        ```

      - if ~else if ~else : 동일한 변수에 판단해야하는 조건이 여러 개 있는 경우 사용하는 if문

        ​                              수치데이터를 비교연산자를 써서 조건으로 판단하는 경우 큰 값을 맨위에 명시

        ​                              다른 if문과 마찬가지로 { } 안에 if문을 중첩해서 사용할 수 있다.

      - switch : 다중조건에 대한 제어를 위한 구문 

        - if~else if ~else if 를 대신하여 사용

        - 정확하게 일치하는 값을 비교하는 경우 사용(부등호 사용불가)

        - case문에는 break문을 모두 추가해야 한다.

        - ```java
          [구문]
          switch(평가하기위한 값){
                  연산식(산술연산), 변수에 저장된 값, 메소드 호출결과
                      case 평가할 값의 유형1 : 값1인경우 실행할 문장
                          break;
                      case 평가할 값의 유형2 : 값2인경우 실행할 문장
                          break;
                      default : case유형에 해당하지 않는 값인 경우 실행할 묹아    
          }
          ```
    - 반복제어문
      - for : 정해진 횟수만큼 명령문을 반복해서 실행해야 하는 경우

        ​        실행횟구가 정해져 있는 경우 사용

        ​        실행횟수를 체크할 수 있는 int변수가 필요

        ```java
        [구문]
        for(초기값; 조건; 증감값){    
        /*초기값 : int변수명 = 초기값, 최초변수에 값을 초기화 시키며 start값을 지정
          증감값 : 변수++ 변수-- 변수=변수+2, 초기화 시킨 변수의 값을 변경하기 위해 필요
          조건 : 초기값이 증감식에 의해 변화되며 횟수를 체크하기위한 조건          */  
           반복해서 실행할 명령문
         } 
        ```

      - while : 조건을 판단해서 결과가 true이면 반복 실행

        - 조건을 구문의 첫 번째 문장에서 판단하므로 조건이 만족하지 않으면 while블럭을 실행하지 않는디
      
        ```java
        [구문]
        while 조건식 {
            조건이 만족할 때 실행할 명령문
        }
        ```
      
      - do~while : 조건을 판단해서 결과과 true이면 반복실행
      
        - 조건을 구문의 마지막 문장에서 판단하므로 조건이 만족하지 않아도 한번은 블럭이 실행된다
      
         ```java
         do {
             조건이 만조하는 동안 실행할 명령문
         } while;
         ```

    - 반복실행을 제어

      - `break` : 반복 실행 중에 반복문을 빠져나가기 위해 사용

        ​               break가 속한 블럭을 빠져나간다.

        ​               for문을 중첩 사용시 내부 for문에 break가 선언되면  내부 for의 실행이 중단된다.

      - `continue` : 반복 실행 중에 실행해야할 명령문을 skip하기 위해 사용

  - 배열

    - 개요 

      - 데이터를 저장하는 구조로 동일한 성격, 동일한 데이터 타입을 갖는 많은 데이터를 하나의 변수로 엑세스할 수 있도록 제공되는 변수

      - 참조형으로 관리
      - 배열의 구조를 변경할 수 없다
      - 데이터의 저장 공간을 절약하기 위한 구조가 아니라 데이터의 사용을 편하게 할 수 있도록 제공되는 자료구조
      - 배열을 사용하면 데이터가 연속된 공간에 할당
      - 자바에서 사용할 수 있는 모든 기본형과 참조형은 배열로 액세스 할 수 있다

    - 사용방법

      - 배열의 선언

        - `데이터타입[] 배열변수명; `  : 일반변수와 배열변수를 구분하기 위해서
          - ex) public static void main`(String[] args) `

      - 배열의 생성

        - 배열변수가 액세스할 저장 공간을 만드는 과정

        - 저장할 수 있는 공간이 만들어진다.

        - 값을 저장할 수 있는 배열의 공간은 heap에 할당된다.

        - 배열 생성시 배열의 데이터 타입과 몇개의 저장공간을 생성할것인지 명시

        - heap에 만들어지는 각 공간을 요소라한다.

        - 배열의 요소는 각각의 요소를 구분하는 번호가 있으며 이를 `index`라고 부른다

          ```
          [구문]
          배열변수 = new 데이터타입[저장공간의 갯수(배열의 길이)]
          ```

        - 데이터타입[] 배열변수명 = new 데이터타입 [배열의 사이즈]

      - 배열의 초기화

        - 배열의 각 요소에 값을 할당하는 과정
        - 초기화하지 않아도 기본값을 가지고 있다.
          - byte,short,int,long : 0
          - float,double, : 0.0
          - boolean : false
          - 참조형(api클래스,사용자정의클래스... ) : null

      - 배열의 요소에 값을 저장하기

        - 배열변수[index] = 저장할값
        - 배열의 요소에 저장된 값을 꺼내서 출력하기

    - 다차원 배열

      - 배열을 참조하는 배열
      - 참조형 배열과 유사
      - 다차원배열의 선언, 생성,초기화
        - 2차원 
          - 배열변수 선언
            - int[ ] [ ] myarr;
          - 배열변수 생성
            - myarr = new int[3] [2];
          - 배열의 선언과 생성을 한번에 작업
            - int [ ] [ ] myarr = new int [3] [2];
          - 배열 초기화
            - myarr[0] [1]  = 100;

    - 명령형 매개변수

      - 작성한 프로그램을 `java`명렁어를 이용해서 프로그램을 실행할때 외부에서 데이터를 입력받아 처리하기 위해 지원되는 기능
      - `java app`인경우 반드시 정의
      - `.class`파일명 이후에 입력한 데이터를` space`로 구분해서 잘라 매개변수로 인식
      - `app`을 실행할때 외부에서 입력받아 처리해야 하는 기능이 있는 경우 명령행 매개변수를 이용하도록 지원
      - `jdk` 개발 초창기는 `scanner`를 비롯한 외부에서 값을 입력바는 기능이 없었기 떄문에 실행할때 입력받도록 처리
      - 명령행 매개변수로 원하는 값들을 입력하면 `jvm`내부에 `string`배열로 만들어져서 main메소드가 호출될 때 전달

  - 클래스 구성요소

    - 클래스이 정의
      - 필드(멤버변수)
      - 클래스의 특성을 정의
      - 메소드
      - 생성자
    - 클래스의 사용
      - 메모리에 사용할 클래스를 생성
      - 클래스를 `jvm`에서 사용하기 위해 메모리에 올리는 과정을 객체 생성이라 한다.(혹은 인스턴스화라고 한다)
      - 메모리에 할당된 클래스를 객체,인스턴스라 부른다.
      - 사용자정의 클래스를 메모리에 할당
    - 멤버변수
      - 멤버변수의 정의방법
      - 사용방법
      - 접근제한자 
        - 클래스 내부에 선언된 멤버들을 외부에서 접근할 수 있도록 허용하기 위한 방법
        - 클래스를 정의할때 멤버변수는 private로 정의하고 public메소드를 통해서 접근할 수 있도록 구현
        - `public` : 변수가 선언된 클래스, 같은 패키지에 있는 클래스들, 다른 패키지의 있는 클래스 모두 접근이 가능
        - `protected` : 같은 패키지에 있는 클래스들, 다른 패키지에 있는 상속관곙계의 클래스만 접근이 가능
        - `default` : 같은 패키지의 클래스만 접근 가능
        - `priavte` : 변수가 선언돤 클래스에서만 사용 가능
      
    - 메소드
      - 메소드의 정의
        - 접근제한자 [ 특성을 나타내는 키워드 ]  리턴타입 메소드명(매개변수 list...)
      - 메소드 호출
        - 메소드가 정의되어 있는 클래스를 객체생성해서 객체를 참조하는 변수를 이용해서 접근
        - 메소드가 정의된 클래스 참조변수 = new 메소드가 정의된 클래스()
      - `static`
      - `final`
      - `call by rederence`/`call by value`
    - 생성자
      - 개요
      - 정의
      - 사용방법
  
  - OOP
  
    - 개요
    - 특성
      - 캡슐화
      - 상속
      - 다형성
      - 추상화
    - OOP의 `5원칙`(SLOID)


---



