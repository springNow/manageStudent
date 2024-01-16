

import java.util.*;

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */

public class CampManagementApplication {
    // 데이터 저장소
    private static List<Student> studentList = new ArrayList<>();
    private static List<Subject> subjectList;
    private static List<Score> scoreList = new ArrayList<>();

    // 과목 타입
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    // index 관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        setInitData();
        displayMainView();
        System.out.println("\n오류 발생!\n프로그램을 종료합니다.");

    }

    // 초기 데이터 생성
    private static void setInitData() {
        studentList = new ArrayList<>();
        subjectList = List.of(
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Java",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "객체지향",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Redis",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        SUBJECT_TYPE_CHOICE
                )
        );
        scoreList = new ArrayList<>();
    }

    // index 자동 증가
    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }

    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리
                case 2 -> displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 수강생 필수, 선택 과목 선택");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> chooseSubjects();
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static void chooseSubjects() {

        System.out.println("학생 번호를 입력하세요. \nex) ST1");
        sc.nextLine(); //버퍼빼는 scanner
        String stuNum = sc.nextLine();
        System.out.println("stuNum : "+ stuNum);

        boolean flag = false;
        Student student = new Student("필요없는가비지객체", "가비지객체");
        for(Student stu : studentList){
            if(stu.getStudentId().equals(stuNum)){
                student = stu;
                flag = true;
                break;
            }
        }

        // 해당하는 학생이 있을 경우
        if(flag){
            System.out.println();
            System.out.println("과목을 필수 3개, 선택 2개를 선택하십시오. ");
            for(int i=0; i<subjectList.size(); i++){

                String subName = subjectList.get(i).getSubjectName();
                String subProperty = subjectList.get(i).getSubjectType();
                System.out.println(i+"번 | "+ subProperty + " | " +subName);
            }

            String input = sc.nextLine();
            StringTokenizer st = new StringTokenizer(input);

            student.addSubject(subjectList.get(Integer.parseInt(st.nextToken())));
            student.addSubject(subjectList.get(Integer.parseInt(st.nextToken())));
            student.addSubject(subjectList.get(Integer.parseInt(st.nextToken())));
            student.addSubject(subjectList.get(Integer.parseInt(st.nextToken())));
            student.addSubject(subjectList.get(Integer.parseInt(st.nextToken())));

            System.out.println("add 완료되었습니다. !");

            List<Subject> stuSubList = student.getSubjects();
            stuSubList.forEach(s->{
                System.out.println(s.getSubjectName());
            });
        }
        // 해당하는 학생이 없을 경우
        else{
            System.out.println("해당하는 학생이 없습니다.");
        }
    }

    // 수강생 등록
    private static void createStudent() {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("\n수강생 이름 입력: ");


        // 기능 구현 (필수 과목, 선택 과목)
        sc.nextLine();
        String studentName = sc.nextLine();
        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName);
        studentList.add(student);

    }

    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("\n수강생 목록을 조회합니다...");
        // 기능 구현
        for(Student stu : studentList){
            System.out.println(stu.getStudentId() + " | " + stu.getStudentName());
        }
        System.out.println("\n수강생 목록 조회 성공!");
    }

    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.next();
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("시험 점수를 등록합니다...");
        // 기능 구현
        System.out.println("\n점수 등록 성공!");
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (수정할 과목 및 회차, 점수)
        System.out.println("시험 점수를 수정합니다...");
        // 기능 구현
        System.out.println("\n점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (조회할 특정 과목)
        System.out.println("회차별 등급을 조회합니다...");
        // 기능 구현
        System.out.println("\n등급 조회 성공!");
    }

}
// 캠프 매니저는 수강생을 등록 및 관리할 수 있다

//  수강생, 과목, 필수여부
// 학생번호 key값(UUID)으로 두고 ArrayList 하나 생성
// students 와 subject는 상속관계아님
// HashMap<studentName, ArrayList<Subject>>
// 수강생 등록시 이름만 입력 => 과목 선택 list of 로 서브젝트 정보 보여줌
// 가장 상위개념은 student => 과목 < 점수 (상속)
// 그후 hashMap에 put
// 조회할땐 student가 가지는 필드값을 다 입력해야
//