
package manageStudent.src;

import jdk.dynalink.beans.StaticClass;

import javax.swing.plaf.nimbus.State;
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
    private static List<Student> studentList = new ArrayList<>();
    private static List<Subject> subjectList;
    private static List<Score> scoreList = new ArrayList<>();
    //학생의 번호와 점수를 넣음.
    private static Map<String,List<Subject>> studentNoSubjectArr  = new HashMap<>();
//    private static Iterator it =  studentNoSubjectArr.entrySet().iterator();
    //<Map<String,List<Subject>>>

//    //studentInfoArray : 선택한 과목 입력 List
//    private static List<Subject> studentInfoArray = new ArrayList<>();
//    //subjectDistinctList : 과목 추가시 remove
//    private static List<String> subjectsDistictList = new ArrayList<>();
//    //subjectsAddList : 과목 추가시 add
//    private static List<String> subjectsAddList = new ArrayList<>();
//    //subjectsString : 과목명 추가
//    private static List<String> subjectsString = new ArrayList<>();

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


    public static void main(String[] args) throws InterruptedException {
        setInitData();
//        try {
            displayMainView();
//        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
//        }
    }

    // 초기 데이터 생성
    private static void setInitData() {
        studentList = new ArrayList<>();
        subjectList = List.of(new Subject(sequence(INDEX_TYPE_SUBJECT), "Java", SUBJECT_TYPE_MANDATORY), new Subject(sequence(INDEX_TYPE_SUBJECT), "객체지향", SUBJECT_TYPE_MANDATORY), new Subject(sequence(INDEX_TYPE_SUBJECT), "Spring", SUBJECT_TYPE_MANDATORY), new Subject(sequence(INDEX_TYPE_SUBJECT), "JPA", SUBJECT_TYPE_MANDATORY), new Subject(sequence(INDEX_TYPE_SUBJECT), "MySQL", SUBJECT_TYPE_MANDATORY), new Subject(sequence(INDEX_TYPE_SUBJECT), "디자인 패턴", SUBJECT_TYPE_CHOICE), new Subject(sequence(INDEX_TYPE_SUBJECT), "Spring Security", SUBJECT_TYPE_CHOICE), new Subject(sequence(INDEX_TYPE_SUBJECT), "Redis", SUBJECT_TYPE_CHOICE), new Subject(sequence(INDEX_TYPE_SUBJECT), "MongoDB", SUBJECT_TYPE_CHOICE));
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
                case 2 -> inquireStudent(studentList); // 수강생 목록 조회
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
        //입력할 학생 인스턴스 생성
        Student student = new Student();
        //studentInfoArray : 선택한 과목 입력 List
        List<Subject> studentInfoArray = new ArrayList<>();
        //subjectDistinctList : 과목 추가시 remove
        List<String> subjectsDistictList = new ArrayList<>();
        //subjectsAddList : 과목 추가시 add
        List<String> subjectsAddList = new ArrayList<>();
        //subjectsString : 과목명 추가
        List<String> subjectsString = new ArrayList<>();

        subjectsDistictList.add("SU1");
        subjectsDistictList.add("SU2");
        subjectsDistictList.add("SU3");
        subjectsDistictList.add("SU4");
        subjectsDistictList.add("SU5");
        subjectsDistictList.add("SU6");
        subjectsDistictList.add("SU7");
        subjectsDistictList.add("SU8");
        subjectsDistictList.add("SU9");

        System.out.println(subjectsDistictList.size());
        sc.nextLine();
        System.out.println("수강생을 등록합니다...");
        // subject에서 선언
        System.out.println("수강생 이름 입력: ");
        String studentName = sc.nextLine();

        for (Subject subject1 : subjectList) {
            System.out.println("필수유무 : " + subject1.getSubjectType() + "과목이름 : " + subject1.getSubjectName() + "과목번호 : " + subject1.getSubjectId());
        }
        while(subjectsDistictList.size() > 0) {

            System.out.println("수강할 과목 입력:");
            //수강생이 과목코드 입력 : studentSubject
            String studentSubject = sc.nextLine();

            if (subjectsDistictList.contains(studentSubject)){
               getStudentInfoArrayMan(studentSubject,studentInfoArray,subjectsDistictList,subjectsAddList,subjectsString);
                System.out.println("그만입력하시려면 exit를 계속 입력하시려면 엔터를 입력해주세요.");
                String stopSign = sc.nextLine();
                if (stopSign.equals("exit")){
                    if(!(Collections.frequency(subjectsString,"MANDATORY")>2 && Collections.frequency(subjectsString,"CHOICE")>1)) {
                        System.out.println("과목을 더 선택해주세요. ");
                        continue;
                    }
                    student = new Student(sequence(INDEX_TYPE_STUDENT), studentName, studentInfoArray);
                    studentList.add(student);

                    for(Map.Entry<String,List<Subject>> entry : studentNoSubjectArr.entrySet()){
                        if(studentNoSubjectArr.keySet().equals(student)){
                            String key = entry.getKey();
                            List<Subject> value =  entry.getValue();
                        }
                    }
                    studentNoSubjectArr.put(student.getStudentId(),studentInfoArray);
//                    if(studentNoSubjectArr.containsKey(student.getStud entId())){
//                        System.out.println(studentNoSubjectArr.get(student.getStudentId()));
//                    }

                    System.out.println("학생번호:" +  student.getStudentId() + "|| 학생이름: " + student.getStudentName());
                    getStudentSubjectList(studentName, studentList);
                    break;
                }
            } else if (subjectsAddList.contains(studentSubject)){
                System.out.println(studentSubject);
                System.out.println(subjectsDistictList);
                System.out.println("else if 중복된 입력입니다.");
            } else {
                System.out.println("else if  정확히 입력 해주세요");
            }

        }
        System.out.println("수강생 등록 성공!\n");
        //중복값확인 인스턴스 2개 초기화
        subjectsDistictList.clear();
        subjectsAddList.clear();
    }
    //        // hashMap으로 불러오기
//            Subject subject = new Subject();
//        // 1 , 장원녕 , 자바 , 1, 필수 (과목이 정해져있던경우 이거 필요없음)
//        // seq => 너무 어려움, 불필요한 코드 (자동증가)
//            // 수강생 인스턴스 생성 예시 코드


        // 수강생 목록 조회
        private static void inquireStudent (List<Student> studentList) {
            System.out.println("\n수강생 목록을 조회합니다...");
            // 기능 구현 .
            String studentId = getStudentId ();
            for (Student student : studentList) {
                if (student.getStudentId().equals(studentId)){
                    System.out.println("학생번호 :" +student.getStudentId());
                    System.out.println("학생이름 :" +student.getStudentName());
               }
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
                System.out.println("관리 항목을 선택하세요...");
                int input = sc.nextInt();

                switch (input) {
//                    case 1 -> createScore(studentList, studentNoSubjectArr); // 수강생의 과목별 시험 회차 및 점수 등록
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

        private static String getStudentId () {
            System.out.print("\n관리할 수강생의 번호를 입력하시오...");
            return sc.next();
        }

        // 수강생의 과목별 시험 회차 및 점수 등록
//        private static void createScore (List<Student>studentList, Map<String,List<Subject>> studentNoSubjectArr) {
//            String studentId = getStudentId(); // 관리할 수강생 고유 번호
//            //점수넣을 list생성
//            List<String> scoreWhat = new ArrayList<>();
//            //Iterator 생성 과정
////            Set set = studentNoSubjectArr.entrySet();
////            Iterator it = set.iterator();
//            System.out.println("시험 점수를 등록합니다...");
//                for(Student student : studentList){
//                    if (studentNoSubjectArr.containsKey(studentId)){
//                        //점수를 입력해서 scoreWhat에 합치기
//                        for (Subject subject : studentNoSubjectArr.get(studentId)) {
//                            System.out.println(subject.getSubjectName());
//                            System.out.println("점수를 입력해 주세요.");
//                            String studentScoreWhat = sc.nextLine();
//                            scoreWhat.add(studentScoreWhat);
//                        }
//                        //학생의 ID, 과목리스트, 과목별 점수를 scoreList에 저장
//                        Score score = new Score(studentNoSubjectArr,scoreWhat);
//                        scoreList.add(score);
//                        for (Score score2 : scoreList){
//                            System.out.println(scoreList.getStudentNoSubjectArr().get().getName());
//                        }
//
////                        //회차 입력
////                        System.out.println("회차를 입력해 주세요.");
////                        int studentScoreId = sc.nextInt();
////                            // scoreList에 점수 넣어야함.
////                            switch(studentScoreId){
////                                case 1:
////                                    for (Subject subject : studentNoSubjectArr.get(studentId)) {
////                                        System.out.println(subject.getSubjectName());
////                                        System.out.println("점수를 입력해 주세요.");
////                                        int studentScoreWhat = sc.nextInt();
////                                    }
////                                    Score score = new Score(studentId, subjectList,)
////                                    scoreList.add()
////                                    break;
////                                case 2:
////                                    for (Subject subject1 : studentNoSubjectArr.get(studentId)) {
////                                        System.out.println(subject.getSubjectName());
////                                        System.out.println("점수를 입력해 주세요.");
////                                        int studentScoreWhat1 = sc.nextInt();
////                                    }
////                                    break;
////                                case 3:
////                                    for (Subject subject2 : studentNoSubjectArr.get(studentId)) {
////                                        System.out.println(subject.getSubjectName());
////                                        System.out.println("점수를 입력해 주세요.");
////                                        int studentScoreWhat2 = sc.nextInt();
////                                    }
////                                    break;
////                                default:
////                                    System.out.println("1~3회차 까지만 있습니다.");
////                            }
//                    }
//
//                }
//
////            입력받은 studentId에 해당하는 value사이즈 확인
////            for (Subject subject : studentNoSubjectArr.get(studentId)) {
////                            System.out.println(subject.getSubjectName());
////            }
////            for(int i = 0; i < studentNoSubjectArr.get(studentId).size(); i++) {
////                System.out.println(subject.getSubjectName());
////            }
////                        studentNoSubjectArr.get(studentId).size()
////            while (it.hasNext()) {
////                if(student.getStudentId().equals(studentId)){
////
////                }
////            }
//            System.out.println("목록 출력 후 입력전");
//            sc.nextLine();
//            String addScore = sc.nextLine();
//
//
////                        //회차 및 점수 입력
////                        System.out.println("회차를 입력 해 주세요.");
////                        addScore = sc.nextLine();
////
////                        System.out.println("점수를 입력 해 주세요.");
////                        addScore = sc.nextLine();
//            // 기능 구현
//            System.out.println("\n점수 등록 성공!");
//        }

        // 수강생의 과목별 회차 점수 수정
        private static void updateRoundScoreBySubject () {
            String studentId = getStudentId(); // 관리할 수강생 고유 번호
            // 기능 구현 (수정할 과목 및 회차, 점수)
            System.out.println("시험 점수를 수정합니다...");
            // 기능 구현
            System.out.println("\n점수 수정 성공!");
        }

        // 수강생의 특정 과목 회차별 등급 조회
        private static void inquireRoundGradeBySubject () {
            String studentId = getStudentId(); // 관리할 수강생 고유 번호
            // 기능 구현 (조회할 특정 과목)
            System.out.println("회차별 등급을 조회합니다...");
            // 기능 구현
            System.out.println("\n등급 조회 성공!");
        }



//        private static void createStudentAddOption() {
//        System.out.println("CampManagementApplication1 :: createStudentAddOption :: start()");
//            //studentInfoArray : 선택한 과목 입력 List
//            List<Subject> studentInfoArray = new ArrayList<>();
//            //subjectDistinctList : 과목 추가시 remove
//            List<String> subjectsDistictList = new ArrayList<>();
//            subjectsDistictList.add("Java");
//            subjectsDistictList.add("객체지향");
//            subjectsDistictList.add("Spring");
//            subjectsDistictList.add("JPA");
//            subjectsDistictList.add("MySQL");
//            subjectsDistictList.add("디자인 패턴");
//            subjectsDistictList.add("Spring Security");
//            subjectsDistictList.add("Redis");
//            subjectsDistictList.add("MongoDB");
//            //subjectsAddList : 과목 추가시 add
//            List<String> subjectsAddList = new ArrayList<>();
//            //subjectsString : 과목명 추가
//            List<String> subjectsString = new ArrayList<>();
//        }
        private static void getStudentInfoArrayMan(String studentSubject, List<Subject>studentInfoArray, List<String>subjectsDistictList, List<String>subjectsAddList,List<String>subjectsString){
            for(Subject sub : subjectList) {
                if (sub.getSubjectId().equals(studentSubject)) {
                    studentInfoArray.add(new Subject(studentSubject, sub.getSubjectName(), sub.getSubjectType()));
                    subjectsDistictList.remove(studentSubject);
                    subjectsAddList.add(studentSubject);
                    subjectsString.add(sub.getSubjectType());
                }
            }
        }

        private static void getStudentSubjectList (String studentName, List<Student>studentList) {
            System.out.println("신청하신 과목 목록입니다.");
            for (Student student : studentList) {
                if(student.getStudentName().equals(studentName)) {
                    System.out.println(student.getStudentInfoArray());
                }
            }
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