package c.view;

import c.controller.CarController;
import c.model.vo.Car;
import c.model.vo.Manager;
import c.model.vo.Member;
import c.model.vo.Rent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CarMenu {
    private Scanner sc;
    private CarController carController;


    public CarMenu() {
        sc = new Scanner(System.in);
        carController = new CarController();

    }

    public void MainMenu() {

        do {

            int choice = 9;
            System.out.println("============== \uD83D\uDE95 KH 렌터카 \uD83D\uDE97 =============");
            System.out.println("1. 고객 회원가입 ");
            System.out.println("2. 회원 로그인 ");
            System.out.println("3. 관리자 로그인 ");
            System.out.println("0. 프로그램 종료 ");
            System.out.println("============================================");

            System.out.print("메뉴 선택 :");
            choice = sc.nextInt();


            switch (choice) {
                case 1:
                    CarController.insertMember(this.inputMember());
                    break;
                case 2:
                    carController.loginMember();
                    break;
                case 3:
                    carController.loginManager();
                    managerMenu();
                    break;
                case 0:
                    System.out.print("프로그램을 종료하시겠습니까? (y/n) : ");
                    if (sc.next().charAt(0) == 'y')
                        System.out.println("프로그램이 종료되었습니다 ");
                    return;

                default:
                    System.out.print("잘못된 번호를 선택하셨습니다.");
                    System.out.print("확인하고 다시 선택해주세요");
            }
        } while (true);
    }

    public void memberMenu() {
        int choice = 0;
        while (true) {
            System.out.println("1. 차량 조회");
            System.out.println("2. 차량 대여");
            System.out.println("3. 예약 내역 확인");
            System.out.println("4. 회원 탈퇴");
            System.out.println("5. 고객센터");
            System.out.println("0. 메인 메뉴로 돌아가기");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    carController.selectAllCar();
                    break;
                case 2:
                    carController.insertRent(this.inputRent());
                    break;
                case 3:
                    carController.memberSelectRent(this.inputMemberId());
                    break;
                case 4:
                    carController.secession(this.inputUserId());
                    break;
                case 5:
                    System.out.println("고객센터 전화번호는 02-1544-9970입니다.");
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
    private Rent inputRent() {

        Rent rent = new Rent();
        System.out.println("출발일을 설정해 주십시오. 'yyyy-mm-dd'");
        rent.setRentStart(this.transDate());
        System.out.println("반납일을 설정해 주십시오. 'yyyy-mm-dd'");
        rent.setRentEnd(this.transDate());
        carController.selectAllCar();
        System.out.println("차량 고유번호를 선택해 주십시오.");
        rent.setCarNo(sc.nextInt());
        System.out.println("보험 종류를 선택해 주십시오.(일반자차/완전자차/슈퍼자차)");
        rent.setInsuranceVariety(sc.next());
        System.out.println("보험 종류를 한번 더 입력해 주십시오.");
        if(sc.next().equals("일반자차")){
            rent.setInsuranceCost(20000);
        } else if(sc.next().equals("완전자차")) {
            rent.setInsuranceCost(30000);
        } else if(sc.next().equals("슈퍼자차")) {
            rent.setInsuranceCost(40000);
        }
        System.out.println("회원 고유번호를 입력해주십시오.");
        rent.setMemberNo(sc.nextInt());


        return rent;
    }
    public Member inputMember() {
        Member member = new Member();
        System.out.print("회원 아이디 입력 :");
        member.setMemberId(sc.next());
        System.out.print("회원 비밀번호 입력 :");
        member.setMemberPwd(sc.next());
        System.out.println("회원 이름 입력 : ");
        member.setMemberName(sc.next());
        System.out.println("회원 생년월일 입력 : (2020-01-01)");
        member.setMemberBirth(this.transDate());
        System.out.println("회원 전화번호 입력 : (010-1234-5678)");
        member.setMemberPhone(sc.next());
        System.out.println("회원 이메일 입력 :");
        member.setMemberEmail(sc.next());
        System.out.println("운전 면허 종류 : (1종보통 or 2종보통)");
        member.setMemberLicenseType(sc.next());
        System.out.println("운전 면허 번호 :  (11-08-123456-60)");
        member.setMemberLicenseNo(sc.next());
        System.out.println("적성검사만료일: ");
        member.setMemberTestExp(this.transDate());
        sc.nextLine();
        System.out.println("회원 주소 :");
        member.setMemberAddress(sc.nextLine());

        return member;


    }




    public Member input_id_pw() {
        Member member = new Member();
        System.out.println("ID와 PASSWORD를 입력해주세요 ");
        System.out.println("id : ");
        String id = sc.next();
        member.setMemberId(id);

        System.out.println("password : ");
        String password = sc.next();
        member.setMemberPwd(password);
        System.out.println();

        return member;

    }

    public Manager manage_input_id_pw() {
        Manager manager = new Manager();
        System.out.println("ID와 PASSWORD를 입력해주세요 ");
        System.out.print("id : ");
        String id = sc.next();
        manager.setManagerId(id);

        System.out.print("password : ");
        String password = sc.next();
        manager.setManagerPwd(password);

        return manager;

    }
    public String inputCarId() {
        sc.nextLine();
        System.out.print("차량번호를 입력해주세요 : ");
        return sc.nextLine();
    }

    public Date transDate() {
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String s = sc.next();
        Date to = null;
        to = Date.valueOf(s);
        return to;
    }

    public void managerMenu() {
        while (true) {
            System.out.println("1. 전체 차 조회");
            System.out.println("2. 차량 등록");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 랜트 내역 조회");
            System.out.println("0. 메인메뉴로 돌아가기");
            System.out.print("메뉴를 입력해주세요 : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    carController.selectAllCar();
                    break;
                case 2:
                    carController.insertCar(this.insertCar());
                    break;
                case 3:
                    carController.secession(this.inputUserId());
                    break;
                case 4:
                    carController.selectRent();
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    public void displayCarList(ArrayList<Car> list) {
        if (!list.isEmpty()) {
            for (Car car : list) {
                System.out.println(car.toString());
            }
        } else {
            System.out.println("차량리스트를 찾을 수 없습니다.");
        }

    }

    public void displayRentList(ArrayList<Rent> list) {
        if (!list.isEmpty()) {
            for (Rent rent : list) {
                System.out.println(rent.toString());
            }
        } else {
            System.out.println("렌트리스트를 찾을 수 없습니다.");
        }

    }
    public void displayRent(Rent rent) {
        if(rent != null) {
            System.out.println(rent.toString());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public Car insertCar() {
        Car car = new Car();
        System.out.print("번호판을 입력해주세요 : ");
        sc.nextLine();
        car.setCarId(sc.nextLine());
        System.out.print("차량사이즈를 입력해주세요(소형, 중형, 대형) : ");
        car.setCarSize(sc.next());
        System.out.println("추가가능한 차량('레이', '스파크', '모닝', 'K3', 'K5', '아반떼', '소나타', 'K7', 'G80', '카니발')");
        System.out.print("차량명을 입력해주세요 : ");
        car.setCarName(sc.next());
        System.out.print("연료를 입력해주세요(가솔린, 디젤, 전기, 하이브리드, LPG) : ");
        car.setCarFuel(sc.next());
        System.out.print("일일당 렌탈비를 입력해주세요 : ");
        car.setCarCost(sc.nextInt());

        return car;
    }

    public String inputUserId() {
        System.out.print("회원아이디를 입력해주세요 : ");
        return sc.next();
    }
    public String inputMemberId() {
        System.out.println("회원 아이디를 입력해주세요");
        return sc.next();
    }


    public void displaySuccess(String message) {
        System.out.println("서비스 요청 결과 :" + message);
    }

    public void displayError(String message) {
        System.out.println("서비스 요청 처리 실패:" + message);
    }




    public void loginMember(ArrayList<Member> members) throws Exception {
        // HashMap<String,String> map = new HashMap<>();
        Member member = this.input_id_pw();
        boolean check = false;

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberId().equals(member.getMemberId()) && members.get(i).getMemberPwd().equals(member.getMemberPwd())) {
                System.out.println("*로그인 성공!*");
                System.out.println(member.getMemberId() + "님 KH렌트카 접속을 환영합니다.");
                check = true;
                memberMenu();
                break;
            } else {

            }
        }

        if (!check) {
            System.out.println("id 또는 비밀번호가 일치하지 않습니다. 다시 확인 후 접속해주세요.");
        }


    }

    public void loginManager(ArrayList<Manager> managers) throws Exception {
        Manager manager = this.manage_input_id_pw();
        boolean check = false;

        for (int i = 0; i < managers.size(); i++) {
            if (managers.get(i).getManagerId().equals(manager.getManagerId()) && managers.get(i).getManagerPwd().equals(manager.getManagerPwd())) {
                System.out.println(manager.getManagerId() + "님 관리자 모드로 로그인 하였습니다.");
                check = true;
                managerMenu();
                break;
            } else {

            }
        }
        if (!check) {
            System.out.println("id 또는 비밀번호가 일치하지 않습니다.");
        }
    }

    public void displayMemberList(ArrayList<Member> list) {
        if (!list.isEmpty()) {
            for (Member member : list) {
                System.out.println(member.toString());
            }
        } else {
            System.out.println("회원리스트를 찾을 수 없습니다.");
        }

    }
}