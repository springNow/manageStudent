

import java.util.*;

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */

public class CampManagementApplication2 {
    // 데이터 저장소
    private static List<Student> studentList;
    private static List<Subject> subjectList;
    private static List<Student> studentScoreList;
    private static List<String[]> studentGradeList;
    static List<Score> scores;
    private static Map<Integer, Student> studentMap = new HashMap<>();
    private static Map<Integer, Student> studentScoreMap = new HashMap<>();

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
    private static List<Subject> subjects = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        setInitData();
        displayMainView();
        System.out.println("\n오류 발생!\n프로그램을 종료합니다.");

    }

    // 초기 데이터 생성
    private static void setInitData() {
        studentList = new ArrayList<>();
        studentScoreList = new ArrayList<>();
        studentGradeList = new ArrayList<String[]>();
        scores = new ArrayList<>();
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

    }

    // index 자동 증가
    private static int sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return subjectIndex;
            }
            default -> {
                scoreIndex++;
                return scoreIndex;
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
            System.out.println("3. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생 등록
    private static void createStudent() {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("\n수강생 이름 입력: ");
        String studentName = sc.next();

        System.out.println("\n필수 과목 3개, 선택 과목 2개를 선택해주세요\n");
        for (Subject sj : subjectList){
            System.out.println(sj.getSubjectId() + sj.getSubjectName() + sj.getSubjectType());
        }
        Subject[] allSubject = new Subject[5];


        for (int i = 0; i < 5; i++) {
            int subjectChoice = sc.nextInt();
            switch (subjectChoice) {
                case 1:
                    allSubject[i] = new Subject(sequence(INDEX_TYPE_SUBJECT), "Java", SUBJECT_TYPE_MANDATORY);
                    break;
                case 2:
                    allSubject[i] = new Subject(sequence(INDEX_TYPE_SUBJECT), "객체지향", SUBJECT_TYPE_MANDATORY);
                    break;
                case 3:
                    allSubject[i] = new Subject(sequence(INDEX_TYPE_SUBJECT), "Spring", SUBJECT_TYPE_MANDATORY);
                    break;
                case 4:
                    allSubject[i] = new Subject(sequence(INDEX_TYPE_SUBJECT), "JPA", SUBJECT_TYPE_MANDATORY);
                    break;
                case 5:
                    allSubject[i] = new Subject(sequence(INDEX_TYPE_SUBJECT), "MySQL", SUBJECT_TYPE_MANDATORY);
                    break;
                case 6:
                    allSubject[i] = new Subject(sequence(INDEX_TYPE_SUBJECT), "디자인 패턴", SUBJECT_TYPE_CHOICE);
                    break;
                case 7:
                    allSubject[i] = new Subject(sequence(INDEX_TYPE_SUBJECT), "Spring Security", SUBJECT_TYPE_CHOICE);
                    break;
                case 8:
                    allSubject[i] = new Subject(sequence(INDEX_TYPE_SUBJECT), "Redis", SUBJECT_TYPE_CHOICE);
                    break;
                case 9:
                    allSubject[i] = new Subject(sequence(INDEX_TYPE_SUBJECT), "MongoDB", SUBJECT_TYPE_CHOICE);
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다");
                    displayStudentView();
            }
        }

        Student student1 = new Student(sequence(INDEX_TYPE_STUDENT), studentName, List.of(allSubject),scores);
        studentList.add(student1);

        studentMap.put(student1.getStudentId(),student1);
        System.out.println(studentName);

        for(Subject sj : allSubject) {
            System.out.println(sj.getSubjectId() + sj.getSubjectName() + sj.getSubjectType());
        }

        // 기능 구현 (필수 과목, 선택 과목)
            // subject에서 선언
//        arrayList.add(new Subject());   // 입력받은 값을 비교해서 같은 값이면 입력받은 값을 add 없으면 다시 입력

//        // hashMap으로 불러오기
//            Subject subject = new Subject();
//        // 1 , 장원녕 , 자바 , 1, 필수 (과목이 정해져있던경우 이거 필요없음)
//        // seq => 너무 어려움, 불필요한 코드 (자동증가)
//            // 수강생 인스턴스 생성 예시 코드
//            Student student = new Student(sequence(INDEX_TYPE_STUDENT),장원녕,subject.getSubjectId(),subject.getSubjectType(),subject.getSubjectName());
////            studentList.add(student);
            System.out.println("수강생 등록 성공!\n");
        }

        // 수강생 목록 조회
        private static void inquireStudent () {
            System.out.println("\n수강생 목록을 조회합니다...");
            for (Student s : studentList) {
                System.out.println(s.getStudentId() + s.getStudentName() + s.subjects + s.scores);
            }
            System.out.println("\n수강생 목록 조회 성공!");
        }

        private static void displayScoreView () {
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

        private static int getStudentId () {
            System.out.print("\n관리할 수강생의 번호를 입력하시오...");
            return sc.nextInt();
        }
        static Score[] allScore = new Score[5];
        // 수강생의 과목별 시험 회차 및 점수 등록
        private static void createScore () {
            int studentId = getStudentId();

            System.out.println(studentId + " " + studentMap.get(studentId));
            System.out.println("시험 점수를 등록합니다...");
            for (int i = 1; i <= 5; i++) {
                System.out.println(i + "번째 과목 점수를 입력해주세요");
                int score1 = sc.nextInt();
                int score2 = sc.nextInt();
                int score3 = sc.nextInt();
                allScore[i-1] = new Score(score1,score2,score3);
            }
            Student student2 = new Student(studentId, List.of(allScore));
            studentScoreList.add(student2);
            for (Student s: studentScoreList) {
                System.out.println(Integer.toString(s.getStudentId()) + s.getScores());
            }

            System.out.println("\n점수 등록 성공!");
        }

        // 수강생의 과목별 회차 점수 수정
        private static void updateRoundScoreBySubject () {
            int studentId = getStudentId(); // 관리할 수강생 고유 번호
            System.out.println(studentId + " " + studentMap.get(studentId));
            System.out.println("시험 점수를 수정합니다...");
            for (int i = 1; i <= 5; i++) {
                System.out.println(i + "번째 과목 점수를 입력해주세요");
                int score1 = sc.nextInt();
                int score2 = sc.nextInt();
                int score3 = sc.nextInt();
                allScore[i-1] = new Score(score1,score2,score3);
            }
            Student student3 = new Student(studentId, List.of(allScore));
            studentScoreList.set(studentId - 1,student3);
            for (Student s : studentScoreList) {
                System.out.println(Integer.toString(s.getStudentId()) + s.getScores());
            }
            System.out.println("\n점수 수정 성공!");
        }
        static String[] allGrade = new String[12];
        // 수강생의 특정 과목 회차별 등급 조회
        private static void inquireRoundGradeBySubject () {
            int studentId = getStudentId(); // 관리할 수강생 고유 번호
            System.out.println(studentId + " " + studentMap.get(studentId));
            System.out.println("수강생의 과목별, 회차별 등급을 조회합니다...");

            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j < 12; j+=3) {
                    if(studentScoreList.get(studentId - 1).getScores().get(i).getScore1() <= 100 && studentScoreList.get(studentId - 1).getScores().get(i).getScore1() >=95) {
                        allGrade[j] = "A";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore1() <= 94 && studentScoreList.get(studentId - 1).getScores().get(i).getScore1() >=90) {
                        allGrade[j] = "B";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore1() <= 89 && studentScoreList.get(studentId - 1).getScores().get(i).getScore1() >=80) {
                        allGrade[j] = "C";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore1() <= 79 && studentScoreList.get(studentId - 1).getScores().get(i).getScore1() >=70) {
                        allGrade[j] = "D";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore1() <= 69 && studentScoreList.get(studentId - 1).getScores().get(i).getScore1() >=60) {
                        allGrade[j] = "F";
                    }
                    else {
                        allGrade[j] = "N";
                    }
                }
            }
            for (int i = 0; i <= 4; i++) {
                for (int j = 1; j < 12; j+=3) {
                    if(studentScoreList.get(studentId - 1).getScores().get(i).getScore2() <= 100 && studentScoreList.get(studentId - 1).getScores().get(i).getScore2() >=95) {
                        allGrade[j] = "A";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore2() <= 94 && studentScoreList.get(studentId - 1).getScores().get(i).getScore2() >=90) {
                        allGrade[j] = "B";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore2() <= 89 && studentScoreList.get(studentId - 1).getScores().get(i).getScore2() >=80) {
                        allGrade[j] = "C";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore2() <= 79 && studentScoreList.get(studentId - 1).getScores().get(i).getScore2() >=70) {
                        allGrade[j] = "D";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore2() <= 69 && studentScoreList.get(studentId - 1).getScores().get(i).getScore2() >=60) {
                        allGrade[j] = "F";
                    }
                    else {
                        allGrade[j] = "N";
                    }
                }
            }
            for (int i = 0; i <= 4; i++) {
                for (int j = 2; j < 12; j+=3) {
                    if(studentScoreList.get(studentId - 1).getScores().get(i).getScore3() <= 100 && studentScoreList.get(studentId - 1).getScores().get(i).getScore3() >=95) {
                        allGrade[j] = "A";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore3() <= 94 && studentScoreList.get(studentId - 1).getScores().get(i).getScore3() >=90) {
                        allGrade[j] = "B";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore3() <= 89 && studentScoreList.get(studentId - 1).getScores().get(i).getScore3() >=80) {
                        allGrade[j] = "C";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore3() <= 79 && studentScoreList.get(studentId - 1).getScores().get(i).getScore3() >=70) {
                        allGrade[j] = "D";
                    }
                    else if(studentScoreList.get(studentId - 1).getScores().get(i).getScore3() <= 69 && studentScoreList.get(studentId - 1).getScores().get(i).getScore3() >=60) {
                        allGrade[j] = "F";
                    }
                    else {
                        allGrade[j] = "N";
                    }
                }
            }
            studentGradeList.add(allGrade);
            System.out.println(studentId + studentList.get(studentId - 1).getStudentName());
            for (String s: allGrade) {
                System.out.print(s + " ");
            }
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
