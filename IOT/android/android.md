## Android

- android : layout_width
- android : layout_height
  - match_parent, wrap_content
    - dp >> 1인치를 320개의 픽셀로 나누어 작업
- android: orientation
  - `LinearLayout` 인경우 속성을 추가하지 않으면 기본이 가로
- padding, margin
- android : layout_gravity
  - 레이아웃 안에서 위젯의 정렬
- android : gravity
  - 내부 컨텐츠 정렬

- 이벤트 연결
  - 익명 내부inner클래스 정의하고 사용
  - 내부클래스를 정의하고 사용
    - Activity내부에 리스너 역활을 하는 클래스를 정의하고 사용하기
  - Activity가 Listener의 역활을 하도록 설정
    - Activity의 클래스 선언부에 Listener를 implements 한다
  - Listener역활을 하는 클래스를 독립적인 클래스로 정의 
  - 순서
    - 1. 이벤트가 발생하면 실행할 클래스를 정의(리스너를 상속받는 클래스)
         1. 리스너 >> 안드로이드 OS에는 이벤트가 미리 정의 되어 있고 이벤트가 발생했을때 실행될 클래스도 미리 정의 되어 있다. 
         2. 이 클래스를 상속받아서 사용자가 원하는 작업을 할 수 있도록 정의
      2. 이벤트를 연결할 위젯을 찾아오기
         1. findViewById(R.id.사용자가정의한 id명)
      3. 2번에서 찾아온 위젯에 리스너 객체를 연결
         1. setOn@@@@Listener
         2. add@@@Listener
  - 이벤트를 처리하는 리스너의 종류
    - ViewOnClickLitener : 버튼을 클릭할때 발생하는 이벤트를 처리하는 리스너
    - TextWatcher : EditText에 사용자가 텍스트를 입력할때 입력시점에 따라 처리하는 
    - OnkeyLitenert : EditText에서 엔터키와 같은 키보드를 누를때 발생하는 이벤트를 처리
    - 
