import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


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
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> ScoreStore;

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

    public static void main(String[] args) throws Exception{
        setInitData();
        displayMainView();


    }

    // 초기 데이터 생성
    private static void setInitData() {
        studentStore = new ArrayList<>();
        subjectStore = List.of(
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
        ScoreStore = new ArrayList<>();
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
            System.out.println("3. 수강생 삭제 하기");
            System.out.println("4. 수강생의 상태 설정");
            System.out.println("5. 수강생의 상태 조회");
            System.out.println("6. 과목 등록하기");
            System.out.println("7. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> deleteStudent();
                case 4 -> setStatusOfStudent();
                case 5 -> getStatusOfStudent();
                case 6 -> enrollSubject();
                case 7 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static void getStatusOfStudent() {
        System.out.println("해당 학생의 ID를 입력해주세요. ");
        System.out.println("ex) ST1");
        String studentId = getStudentId();
        sc.nextLine(); // 버퍼를 빼준다.

        // 해당학생이 있는지 check 해주는 함수
        if(!checkWhetherIdExisted(studentId)){
            System.out.println("해당 학생이 존재하지 않습니다");
            System.out.println("이전화면으로 돌아갑니다.");
            return;
        }

        // id를 주면 해당 student를 반환하는 함수
        Student student = returnStudent(studentId);
        System.out.println(student.getStudentId() + " | " + student.getStudentName() + "의 상태는 ");
        System.out.println(student.getStatus()+"입니다. ");
    }

    private static void setStatusOfStudent() {

        System.out.println("해당 학생의 ID를 입력해주세요. ");
        System.out.println("ex) ST1");
        String studentId = getStudentId();
        sc.nextLine(); // 버퍼를 빼준다.

        // 해당학생이 있는지 check 해주는 함수
        if(!checkWhetherIdExisted(studentId)){
            System.out.println("해당 학생이 존재하지 않습니다");
            System.out.println("이전화면으로 돌아갑니다.");
            return;
        }

        // id를 주면 해당 student를 반환하는 함수
        Student student = returnStudent(studentId);

        // 학생의 상태를 입력받고
        // 학생 상태를 저장해준다.
        System.out.println(student.getStudentId()+" | "+student.getStudentName()+" 학생의 상태를 입력해주세요..");
        String studentStatus = sc.nextLine();
        student.setStatus(studentStatus);
        System.out.println("학생의 상태가 입력되었습니다. ");
    }

    // 이 함수는 무조건 checkWhetherIdExisted 함수 뒤에 써야 함.
    private static Student returnStudent(String studentId) {

        for(Student student : studentStore){
            if(student.getStudentId().equalsIgnoreCase(studentId))
                return student;
        }
        return new Student("쓸일없는 객체", "쓸일없는 객체");
    }

    private static boolean checkWhetherIdExisted(String studentId) {

        for(Student std : studentStore){
            if(std.getStudentId().equalsIgnoreCase(studentId)){
                return true;
            }
        }
        return false;
    }

    private static void deleteStudent() {
        System.out.println("해당 학생의 ID를 입력해주세요. ");
        System.out.println("ex) ST1");
        String studentId = getStudentId();


        // 해당학생이 있는지 check 해주는 함수
        if(!checkWhetherIdExisted(studentId)){
            System.out.println("해당 학생이 존재하지 않습니다");
            System.out.println("이전화면으로 돌아갑니다.");
            return;
        }

        // id를 주면 해당 student를 반환하는 함수
        Student student = returnStudent(studentId);
        studentStore.remove(student);
        System.out.println(studentId + " 학생의 삭제가 완료되었습니다. ");
    }

    // 수강생 등록

    private static void createStudent() {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();
        // 기능 구현 (필수 과목, 선택 과목)

        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName); // 수강생 인스턴스 생성 예시 코드
        studentStore.add(student);
        // 기능 구현
        System.out.println("수강생 등록 성공!\n");
    }


    private static void enrollSubject() {
        System.out.println("해당 학생의 ID를 입력해주세요. ");
        System.out.println("ex) ST1");
        String studentId = getStudentId();


        // 해당학생이 있는지 check 해주는 함수
        if(!checkWhetherIdExisted(studentId)){
            System.out.println("해당 학생이 존재하지 않습니다");
            System.out.println("이전화면으로 돌아갑니다.");
            return;
        }

        // id를 주면 해당 student를 반환하는 함수
        Student student = returnStudent(studentId);

        int idxOfMandatory;
        int idxOfOptional;
        {
            // 의무 과목 입력
            sc.nextLine();
            System.out.println("필수 과목 몇 개를 선택하시겠습니까? (3개이상 5개 이하)");
            idxOfMandatory = Integer.parseInt(sc.nextLine());
            try{
                if(idxOfMandatory <=2 || idxOfMandatory >5){
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("범위를 벗어났습니다. ");
                System.out.println("이전화면으로 돌아갑니다. ");
                return;
            }

            // 선택 과목 입력
            System.out.println("선택 과목 몇 개를 선택하시겠습니까? (2개이상 4개 이하)");
            idxOfOptional = Integer.parseInt(sc.nextLine());
            try{
                if(idxOfOptional<=1 || idxOfOptional >=5)
                    throw new Exception();
            }catch(Exception e){
                System.out.println("범위를 벗어났습니다. ");
                System.out.println("이전화면으로 돌아갑니다. ");
                return;
            }
        }

        // subjects 출력
        {
            System.out.println("수강할 수 있는 과목들 입니다. ");
            int idx = 0;
            for(Subject sub : subjectStore){
                System.out.println((idx++)+" | " + sub.getSubjectName() +" | " + sub.getSubjectType());
            }
            System.out.println();
        }

        // 번호들을 입력받고
        // list들의 해당 위치들을
        // student.subjects(List)에 넣는다.
        {
            System.out.println("번호들을 입력해주세요");
            System.out.println("예시 0 1 2 5 6");
            StringTokenizer st = new StringTokenizer(sc.nextLine());

            try {
                if (st.countTokens() != idxOfOptional + idxOfMandatory) {
                    throw new Exception();
                }
            }catch (Exception e){
                System.out.println("입력한 번호들의 갯수가 idxOfMandatory+idxOfOptional과 일치하지 않음");
                return ;
            }

            List<Subject> subjects = student.getSubjects();
            for(int i=0; i<idxOfMandatory+idxOfOptional; i++){
                Subject sub = subjectStore.get(Integer.parseInt(st.nextToken()));
                Subject subject = new Subject(sub.getSubjectId(), sub.getSubjectName(), sub.getSubjectType());
                subjects.add(subject);
            }
        }

        // 학생이 선택한 과목들 출력하기.
        {
            student.getSubjects().forEach(s->{
                System.out.println(s.getSubjectName() + " | " + s.getSubjectType());
            });
        }

    }


    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("\n수강생 목록을 조회합니다...");

        for(Student student : studentStore){
            System.out.println(student.getStudentId() + " | " + student.getStudentName());
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
        System.out.println("해당 학생의 ID를 입력해주세요. ");
        System.out.println("ex) ST1");
        String studentId = getStudentId();
        sc.nextLine(); // 버퍼 빼는 sc

        // 해당학생이 있는지 check 해주는 함수
        if(!checkWhetherIdExisted(studentId)){
            System.out.println("해당 학생이 존재하지 않습니다");
            System.out.println("이전화면으로 돌아갑니다.");
            return;
        }

        // id를 주면 해당 student를 반환하는 함수
        Student student = returnStudent(studentId);

        System.out.println("시험 점수를 등록합니다...");
        List<Subject> subjects = student.getSubjects();

        {
            // 점수를 입력하는 칸
            for(Subject sub : subjects){

                int[] scores = sub.getScores();
                System.out.println(sub.getSubjectName()+"의 점수를 10번 입력하세요.");
                System.out.println("나가시려면 exit을 눌러주세요.");

                String input = sc.nextLine();
                if(input.equalsIgnoreCase("exit")){
                    return;
                }

                scores[0] = Integer.parseInt(input);
                try{
                    if(scores[0]<0 || scores[0] > 100){
                        scores[0] = -1;
                        throw new Exception();
                    }
                }catch(Exception e){
                    System.out.println("점수 입력이 잘못되었습니다. 전 화면으로 돌아갑니다. ");
                    return;
                }

                for(int i=1; i< scores.length; i++){

                    scores[i] = Integer.parseInt(sc.nextLine());
                    try{
                        if(scores[i]<0 || scores[i] > 100){
                            scores[i] = -1;
                            throw new Exception();
                        }
                    }catch(Exception e){
                        System.out.println("점수 입력이 잘못되었습니다. 전 화면으로 돌아갑니다. ");
                        return;
                    }
                }
            } // for
        }
        // 기능 구현
        System.out.println("\n점수 등록 성공!");

        // 입력받은 점수를 다시 출력한다.
        {
            for(Subject subject : subjects){
                subject.printScores();
            }
        }
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        System.out.println("해당 학생의 ID를 입력해주세요. ");
        System.out.println("ex) ST1");
        String studentId = getStudentId();
        sc.nextLine(); // 버퍼 빼는 sc

        // 해당학생이 있는지 check 해주는 함수
        if(!checkWhetherIdExisted(studentId)){
            System.out.println("해당 학생이 존재하지 않습니다");
            System.out.println("이전화면으로 돌아갑니다.");
            return;
        }

        // id를 주면 해당 student를 반환하는 함수
        Student student = returnStudent(studentId);

        List<Subject> subjects = student.getSubjects();
        {
            System.out.println("수강하고 있는 과목 리스트 입니다. ");
            for(int i=0; i<subjects.size(); i++){
                System.out.println(i+"번째 \t|" + subjects.get(i).getSubjectName() +"\t|"+subjects.get(i).getSubjectType());

            }
        }


        {
            System.out.println("과목을 번호를 선택해주세요. ");
            int subNum = Integer.parseInt(sc.nextLine());
            System.out.println("과목 회차를 선택해주세요(0 ~ 9)회차 중 선택");
            int numOfTest = Integer.parseInt(sc.nextLine());
            System.out.println("과목 점수를 선택해주세요");
            int scoreOfTest = Integer.parseInt(sc.nextLine());
            try{
                if(scoreOfTest>100 || scoreOfTest<0){
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("점수를 잘 못 입력했습니다. 이전 화면으로 돌아갑니다.");
                return;
            }


            subjects.get(subNum).getScores()[numOfTest] = scoreOfTest;
            System.out.println("점수가 성공적으로 수정되었습니다.");
        }

        // 기능 구현 (수정할 과목 및 회차, 점수)
        System.out.println("시험 점수를 수정합니다...");

        // 기능 구현
        System.out.println("\n점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        System.out.println("해당 학생의 ID를 입력해주세요. ");
        System.out.println("ex) ST1");
        String studentId = getStudentId();
        sc.nextLine(); // 버퍼 빼는 sc

        // 해당학생이 있는지 check 해주는 함수
        if(!checkWhetherIdExisted(studentId)){
            System.out.println("해당 학생이 존재하지 않습니다");
            System.out.println("이전화면으로 돌아갑니다.");
            return;
        }

        // id를 주면 해당 student를 반환하는 함수
        Student student = returnStudent(studentId);

        List<Subject> subjects = student.getSubjects();
        for(Subject sub : subjects){
            sub.printScoresAndGrades();
        }
        // 기능 구현
        System.out.println("\n등급 조회 성공!");
    }

}
