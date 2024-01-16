package Camp;

import Score.Score;
import Student.Student;
import Subject.Subject;

import java.util.*;

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */

public class CampManagementApplication1 {
    // 데이터 저장소
    private static Score score = new Score();
    private static List<Student> studentList = new ArrayList<>();
    private static List<Subject> subjectList = new ArrayList<>();
    private static List<Score> scoreList = new ArrayList<>();
    private static Map<String, List<Subject>> subjectListMap = new HashMap<>();
    private static Map<String, Student> studentListMap = new HashMap<>();
    private static Map<String, List<Score>> scoreListMap = new HashMap<>();
    // 접근시 get("")

    // 학생은 하나 ,

    static Subject subject = new Subject();
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

    public static void main(String[] args) {
        setInitData();
        try {
            displayMainView();
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
        }

    }

    // 초기 데이터 생성
    private static void setInitData() {
        studentList = new ArrayList<>();
        subjectList = List.of(new Subject(sequence(INDEX_TYPE_SUBJECT), "Java", SUBJECT_TYPE_MANDATORY), new Subject(sequence(INDEX_TYPE_SUBJECT), "객체지향", SUBJECT_TYPE_MANDATORY), new Subject(sequence(INDEX_TYPE_SUBJECT), "Spring", SUBJECT_TYPE_MANDATORY), new Subject(sequence(INDEX_TYPE_SUBJECT), "JPA", SUBJECT_TYPE_MANDATORY), new Subject(sequence(INDEX_TYPE_SUBJECT), "MySQL", SUBJECT_TYPE_MANDATORY), new Subject(sequence(INDEX_TYPE_SUBJECT), "디자인 패턴", SUBJECT_TYPE_CHOICE), new Subject(sequence(INDEX_TYPE_SUBJECT), "Spring Security", SUBJECT_TYPE_CHOICE), new Subject(sequence(INDEX_TYPE_SUBJECT), "Redis", SUBJECT_TYPE_CHOICE), new Subject(sequence(INDEX_TYPE_SUBJECT), "MongoDB", SUBJECT_TYPE_CHOICE));
        subjectListMap.put(subject.getSubjectName(), subjectList);
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
            System.out.println("관리 항목을 선택하세요...");
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
            System.out.println("관리 항목을 선택하세요...");
            int input = sc.nextInt();
            sc.nextLine();
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

    // arrayList는 입력받은 값을 넣어주는 공간.
    private static void createStudent() {
        System.out.println("수강생을 등록합니다...");
        List<Subject> selectedSubjects = new ArrayList<>();
        // subject에서 선언
        System.out.println("수강생 이름 입력: ");
        String studentName = sc.nextLine();
        Student student;
//        for (int i = 0; i < 2; i++) {
//            System.out.println("수강할 과목 입력:");
//            String studentSubject = sc.nextLine();
//            String subjectName = subjectList.get(i).getSubjectName();
//            Subject subjectListData = subjectList.get(i);
//            if (studentSubject.equals(subjectName)) {
//                System.out.println(subjectName);// equals인 위치 출력
//                studentInfoArray.add(subjectListData);
//                // 입력된 데이터가 가지고 있는 값을 subjectList에 넣어준다.
//                student = new Student(sequence(INDEX_TYPE_STUDENT), studentName, studentInfoArray);
//            }
//        }
//        studentList.add(student);


        while (true) {
            System.out.println("수강신청할 과목을 입력해주세요");
            String studentSubject = sc.nextLine();
            if (studentSubject.equalsIgnoreCase("exit")) {
                break; // 종료 조건
            }
            // key값이 null 이ㅣ 아니 ㄴ경우 돌면됨.
            List<Subject> subjectList1 = subjectListMap.get(studentSubject);
            // containskey로 처리해도될듯
            // 값을 입력받는 부분은 거의다 trim처리 해야함.
            // 자바 누르고 스페이스바를 한번더 띄는경우 에러처리 trim(),대소문자 처리,UPPER또는 lower케이스처리

            /*
            - 고려사항 : 캠프 수강생들은 최소 3개 이상의 필수 과목과 2개 이상의 선택 과목을 선택합니다.
-
            1.Subject타입의 리스트를 비교하기 어려웠기때문에
            2.String타입의 리스트를 하나 생성해서 동등비교 조건 만들기*/
//            List<String> subjectList = subjectEntry.getValue().stream()
//                    .map(Subject::getSubjectName)
//                    .collect(Collectors.toList());
            // 실패 코드, 실패 이유 : 타입을 일치시키지 못했음.

//            Subject selectedSubject = subjectEntry.getValue().stream()
//                    .filter(subject -> subject.getSubjectName().equals(studentSubject))
//                    .findFirst()
//                    .orElse(null);
//            if (selectedSubject != null) {
//                selectedSubjects.add(selectedSubject);
//            }
            /* 실패 코드 , 실패 이유 : 타입을 일치시켜서 작성했지만, add하는 부분을 보면 과목만을 가져오게 되어있음
                내가 필요한건 매치되는 subjectname의 데이터뿐만이아니라 , 해당되는 subjectName의 subject의 전체임
            */

            /*
                실패 코드 , 실패 이유 : map을 잘 활용했다고 느껴졌지만 코드를 좀더 줄일수 있었음.
             */
            Iterator<Map.Entry<String, List<Subject>>> subjectListIterator;
            subjectListIterator = subjectListMap.entrySet().iterator();
            while (subjectListIterator.hasNext()) {
                Map.Entry<String, List<Subject>> subjectEntry = subjectListIterator.next();
                for (Subject subject1 : subjectEntry.getValue()) {
                    if (subject1.getSubjectName().equals(studentSubject)) {
                        selectedSubjects.add(subject1);
                    }
                }
            }
        }
        System.out.println("수강신청 성공");
        student = new Student(sequence(INDEX_TYPE_STUDENT), studentName, selectedSubjects);
        studentListMap.put(student.getStudentName(), student);      // 수강생 이름으로 매핑

//

//        // hashMap으로 불러오기
//            Subject subject = new Subject();
//        // seq => 너무 어려움, 불필요한 코드 (자동증가)
//            // 수강생 인스턴스 생성 예시 코드
        System.out.println(studentName);
        System.out.println("수강한 과목");
        for (Subject selectedSubject : selectedSubjects) {
            System.out.println(selectedSubject.toString());
        }
//        studentListMap.forEach((key, value) -> {
//            System.out.println("key입니다" + key + "value입니다" + value);      // Foreach 람다식 사용법
//        });
        System.out.println("수강생 등록 성공!\n");
    }

    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("\n수강생 목록을 조회합니다...");
        for (Student studentList : studentListMap.values()) {
            System.out.println(studentList);
        }

        // 기능 구현
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
            System.out.println("관리 항목을 선택하세요...");
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

    private static String getStudentName() {
        System.out.print("\n수강생의 이름을 입력하세요...");
        return sc.next();
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() {
        sc.nextLine();
        String examGrade = "";
        List<Subject> selectedSubject = new ArrayList<>();
        // 학생 입력받기 (맵에서 학생을 찾으려면 이과정이 필요함)
        System.out.println("수강생의 이름을 입력해주세요");
        String studentNameInput = sc.next();

        Student isStudent = studentListMap.get(studentNameInput);
        List<Subject> isSubjectList = studentListMap.get(studentNameInput).getSubjectList();
        if (studentListMap.containsKey(studentNameInput) && isSubjectList != null) {

            for (Subject subject1 : isSubjectList) {
                System.out.println(isStudent + "님이 수강하신 과목은 : " + subject1 + "입니다");
            }
            int examCount = 0;
            int repeatCount = 0;
            while (repeatCount < isSubjectList.size()) {
                System.out.println("시험보실 과목을 입력해주세요");
                String subjectInput = sc.next();
                for (Subject subject1 : isSubjectList) {
                    if (subject1.getSubjectName().equals(subjectInput)) {
                        System.out.println("시험보실 과목은 : " + subjectInput + "입니다");
                        while (examCount < 10) {
                            System.out.println("점수를 입력해주세요");
                            int examScoreInput = sc.nextInt();

                            if (subject1.getSubjectType().equals("MANDATORY")) {
                                // MANDATORY일 때의 조건 검사
                                if ((examScoreInput >= 95) && (examScoreInput <= 100)) {
                                    examGrade = "A";
                                } else if ((examScoreInput >= 90) && (examScoreInput <= 94)) {
                                    examGrade = "B";
                                } else if ((examScoreInput >= 80) && (examScoreInput <= 89)) {
                                    examGrade = "C";
                                } else if ((examScoreInput >= 70) && (examScoreInput <= 79)) {
                                    examGrade = "D";
                                } else if ((examScoreInput >= 60) && (examScoreInput <= 69)) {
                                    examGrade = "F";
                                } else if ((examScoreInput < 60)) {
                                    examGrade = "N";
                                }
                            } else if (subject1.getSubjectType().equals("CHOICE")) {
                                // CHOICE일 때의 조건 검사
                                if ((examScoreInput >= 90) && (examScoreInput <= 100)) {
                                    examGrade = "A";
                                } else if ((examScoreInput >= 80) && (examScoreInput <= 89)) {
                                    examGrade = "B";
                                } else if ((examScoreInput >= 70) && (examScoreInput <= 79)) {
                                    examGrade = "C";
                                } else if ((examScoreInput >= 60) && (examScoreInput <= 69)) {
                                    examGrade = "D";
                                } else if ((examScoreInput >= 50) && (examScoreInput <= 59)) {
                                    examGrade = "F";
                                } else if ((examScoreInput < 50)) {
                                    examGrade = "N";
                                }
                            }
                            score = new Score(sequence(INDEX_TYPE_SCORE), examScoreInput, subjectInput, examGrade);
                            System.out.println("시험과목 " + subjectInput);
                            System.out.println("시험 점수를 등록합니다...");
                            scoreList.add(score);
                            if (examCount >= 9) {
                                break; // examCount가 10 이상이면 반복문 탈출
                            }
                            examCount++;
                        }
                    }
                }

                repeatCount++;
            }
            /*for (Student student : students) {
                for (Subject subject1 : subjectList) {
                    if (student.getStudentName().equals(studentNameInput)) {
                        System.out.println("시험보실 과목을 입력해주세요");  // tokenizer로 처리하면 좋을듯
                        int examCount = 0;  // 과목별로 시험을 10번 처리하는법?? hashmap
                        while (examCount < 10) {
                            System.out.println("점수를 입력해주세요");
                            int examScoreInput = sc.nextInt();
                            score = new Score(sequence(INDEX_TYPE_SCORE), examScoreInput, subjectInput);
                            System.out.println("시험과목 " + subjectInput);
                            scoreList.add(score);

                            System.out.println("시험 점수를 등록합니다...");
                            examCount++;
                            if (examCount >= 10) {
                                break; // examCount가 10 이상이면 반복문 탈출
                            }
                        }
                    }
                }
            }*/
        }

        /*while (studentIterator.hasNext()) {
            Map.Entry<String, List<Student>> studentEntry;
            studentEntry = studentIterator.next();
            for (Student student : studentEntry.getValue()) {
                if (student.getStudentName().equals(studentNameInput) && subject.getSubjectName().equals(subjectInput)) {
                    while (examCount < 10) {
                        System.out.println("점수를 입력해주세요");
                        examScoreInput = sc.nextInt();
                        score = new Score(sequence(INDEX_TYPE_SCORE), examScoreInput, subject.getSubjectName());
                        scoreList.add(score);

                        System.out.println("시험 점수를 등록합니다...");
                        examCount++;
                    }
                }
            }
        }*/
        scoreListMap.put(score.getScoreId(), scoreList);
        for (Score score1 : scoreList) {
            System.out.println(score1);
        }

        // 기능 구현
        System.out.println("\n점수 등록 성공!");
    }

    /* 해당 학생의 이름으로 학생 객체를 먼저 찾아야함*/
    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        sc.nextLine();
        String studentName = getStudentName(); // 관리할 수강생의 고유 이름
        // 기능 구현 (조회할 특정 과목)
        if (studentListMap.get(studentName) != null) {
            System.out.println("수정하실 과목의 수험코드를 입력해주세요");
            String scoreIdInput = sc.next();
            for (Map.Entry<String, List<Score>> entry : scoreListMap.entrySet()) {
                List<Score> scoreList = entry.getValue();       // scorelist를 map처럼 사용하기 위한 코드
                if (scoreList != null) {
                    for (Score scoreValue : scoreList) {
                        if (scoreValue != null && scoreValue.getScoreId().equals(scoreIdInput)) {
                            System.out.println("수정하실 점수를 입력해주세요");
                            int scoreInput = sc.nextInt();
                            String examGrade = "";
                            if (scoreValue.getSubjectName().equals("Java") || scoreValue.getSubjectName().equals("Spring") || scoreValue.getSubjectName().equals("객체지향") || scoreValue.getSubjectName().equals("MySQL") || scoreValue.getSubjectName().equals("JPA")) {

                                // MANDATORY일 때의 조건 검사
                                if ((scoreInput >= 95) && (scoreInput <= 100)) {
                                    examGrade = "A";
                                } else if ((scoreInput >= 90) && (scoreInput <= 94)) {
                                    examGrade = "B";
                                } else if ((scoreInput >= 80) && (scoreInput <= 89)) {
                                    examGrade = "C";
                                } else if ((scoreInput >= 70) && (scoreInput <= 79)) {
                                    examGrade = "D";
                                } else if ((scoreInput >= 60) && (scoreInput <= 69)) {
                                    examGrade = "F";
                                } else if ((scoreInput < 60)) {
                                    examGrade = "N";
                                }
                            } else {
                                // CHOICE일 때의 조건 검사
                                if ((scoreInput >= 90) && (scoreInput <= 100)) {
                                    examGrade = "A";
                                } else if ((scoreInput >= 80) && (scoreInput <= 89)) {
                                    examGrade = "B";
                                } else if ((scoreInput >= 70) && (scoreInput <= 79)) {
                                    examGrade = "C";
                                } else if ((scoreInput >= 60) && (scoreInput <= 69)) {
                                    examGrade = "D";
                                } else if ((scoreInput >= 50) && (scoreInput <= 59)) {
                                    examGrade = "F";
                                } else if ((scoreInput < 50)) {
                                    examGrade = "N";
                                }
                            }
                            scoreValue.setExamScore(scoreInput);
                            scoreValue.setExamGrade(examGrade);
                            System.out.println("수정된 점수" + scoreValue);
                            break;
                        }
                    }
                }
            }
        }
        // 기능 구현


        System.out.println("\n점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        sc.nextLine();
        System.out.println("조회할 학생 이름을 입력해주세요");
        String studentNameInput = sc.next();
        if (studentListMap.get((studentNameInput)) != null) {
            for (Map.Entry<String, List<Score>> entry : scoreListMap.entrySet()) {
                List<Score> scoreList = entry.getValue();       // scorelist를 map처럼 사용하기 위한 코드
                for (Score score1 : scoreList) {
                    System.out.println(score1.getScoreId() + " | " + score1.getExamScore());
                }
            }
        }

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


// 사용자 이름을 입력받음
// 선택할 과목을 입력받음 (case로 선택하게 하는게 좋을듯)
// 선택된 과목이 조회했을때 있는지 확인 후 데이터를 담은 생성자 생성 => for문으로 돌리면 안될듯함. iterator? 확인해보면 좋을듯
// 그후 list에 add.
// 우선 여기까지만.

// 과목이름을 key값으로 갖는 map을 생성
// key에 해당하는 데이터가 있는지 확인
