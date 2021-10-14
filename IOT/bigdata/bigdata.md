### VMware

- 빅데이터
  - 빅데이터 플랫폼 구축
    - 계정 :root 
    - pass : bitdata
    - VMware설치
    - 네트워크를 위한 설정 파일 복사
      - vmnercfg.exe - player버전과 vmnetcfg.exe를 복사한 workstation pro버전이 동일 해야한다
    - CentOS설치
    - 머신복제
      - copy(파워off후 작업)
      - `I copied it`   선택 후 진행
      - root(관리자)계정으로 선 접속 후 hadoop으로 진행
    - 하둡머신 클러스터링
      - 4대를 연결 : 머신1에서 ssh통신을 이용하여 원격접속
        - `ssh "연결할 머신의 아이피" `
          - ssh(Secure shell)
            - 서버와 클라이언트간의 텍스트 기반으로 통신 , 암호화해서 통신하기위한 프로토콜
        - 호스트명 변경 : `hostnamectl set-hostname "변경할 name"` 
      - 현재 실행중인 프로그램 확인 : `system list-nuit --type=service`     종료 :`ctrl + c`
      - 방화벽해제 : `systemctl stop firewalld`
      - 방화벽확인 : `systemctl status firewalld`
      - 서비스 비활성화 : `system disable firewalld`
      - 도메인 등록 
        - ssh통신을 하기위해 hadoop01에서 나머지 머신을 접근
        - ip로 접근하기 불편하므로 호스트명을 변경해서 작업
        - /etc/hosts 파일 수정 >> 기존내용삭제 후  `ip주소 "변경할 도메인명"` 작성
        - 네트워크 리스타트 : /etc/init.d/network restart
        - `ssh "도메인명 "`
        - 호스트 파일을 다른 머신으로 복사
          - `scp /etc/hosts root@"도메인명":/etc/hosts`
      - 명령어
        - scp : 원격지에서 복사
        - cp : 로컬에서 복사

----

### Hadoop

- hadoop 설치과정
  - jdk설치
  - hadoop설치
    - 커널버전
      - 1.x
      - 2.x
      - 3.x
  - hadoop설정
  - hadoop 프로그래밍
    - hdfs
    - mapreduce
    - customizing
  - hadoop eco system 설치 후 테스트
    - flume
    - sqoop
    - hive
    - pig
    - mahout

- 디렉토리 구조
  - /home : 사용자 계정의 홈디렉토리
  - /boot : 부팅에 필요한 각종 설정파일이 위치하는곳
  - /root : root계정의 홈디렉토리
  - /bin : 리눅스에서 사용할수 있는 shell명령어가 위치하는곳
  - /sbin : 시스템관리를 위한  명령어가 위치하는곳
  - /etc : 시스템관리를 위한 설정파일이 위치하는 디렉토리(사용자정보, 파일시스템정보, 네트워크정보,.......)
  - /tmp : 시스템이 작업 중 사용하는 임시 폴더
  - /var : tmp와 유사 보통 로그 파일이 위치
  - /lib : 공통 라이브러리 파일이 저장되는 위치
  - /dev : 장치가 위치하는 디렉토리  - 리눅스는 모든 장치를 파일로 인식
  - /usr : 윈도우릐 program files와 동일

