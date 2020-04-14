package c.controller;

import java.util.ArrayList;
import c.model.vo.Car;
import c.model.vo.Manager;
import c.model.vo.Member;
import c.model.vo.Rent;
import c.service.CarService;
import c.service.ManagerService;
import c.service.MemberService;
import c.service.RentService;
import c.view.CarMenu;
import myException.CarException;

import java.sql.SQLException;
import java.util.ArrayList;

public class CarController {
    public static void insertMember(Member member) {
        CarMenu menu = new CarMenu();

        int result = 0;

        try {
            result = new MemberService().insertMember(member);
            if (result > 0) {
                menu.displaySuccess("회원 추가가 성공하였습니다.");
            }else {
                menu.displayError("회원 추가 실패!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (CarException e) {
            e.printStackTrace();
        }


    }
    public void selectAllCar() {
        CarMenu carMenu = new CarMenu();
        ArrayList<Car> list = new CarService().selectAllCar();
        if(!list.isEmpty()) {
            carMenu.displayCarList(list);
        } else {
            carMenu.displayMessage("차량리스트를 찾을수 없습니다.");
        }
    }
    public void insertCar(Car car) {
        CarMenu carMenu = new CarMenu();
        int result = new CarService().insertCar(car);
        if(result > 0) {
            carMenu.displayMessage("차량등록에 성공하였습니다.");
        } else {
            carMenu.displayMessage("차량등록에 실패하였습니다.");
        }
    }
    public void secession(String userId) {
        CarMenu carMenu = new CarMenu();
        int result = new MemberService().secession(userId);
        if(result > 0) {
            carMenu.displayMessage("회원삭제에 성공하였습니다.");
        } else {
            carMenu.displayMessage("회원삭제에 실패하였습니다.");
        }
    }
    public void selectRent() {
        CarMenu carMenu = new CarMenu();
        ArrayList<Rent> list = new RentService().selectRent();
        if(!list.isEmpty()) {
            carMenu.displayRentList(list);
        } else {
            carMenu.displayMessage("렌트리스트를 찾을수 없습니다.");
        }

    }

    public void loginMember() {
        CarMenu carMenu = new CarMenu();
        ArrayList<Member> list = new MemberService().selectAllMember();
        if(!list.isEmpty()) {
            try {
                carMenu.loginMember(list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void loginManager() {
        CarMenu carMenu = new CarMenu();
        ArrayList<Manager> list = new ManagerService().selectAllManager();
        if(!list.isEmpty()) {
            try {
                carMenu.loginManager(list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void selectAllMember() {
        CarMenu carMenu = new CarMenu();
        ArrayList<Member> list = new MemberService().selectAllMember();
        if(!list.isEmpty()) {
            carMenu.displayMemberList(list);
        } else {
            carMenu.displayMessage("회원리스트를 찾을 수 없습니다.");
        }
    }
    public void deleteCar(String carId) {
        CarMenu carMenu = new CarMenu();
        int result = new CarService().deleteCar(carId);
        if (result > 0) {
            carMenu.displayMessage("차량삭제에 성공하였습니다.");
        } else {
            carMenu.displayMessage("차량삭제에 실패하였습니다.");
        }
    }
        public void memberSelectRent(String memberId) {
            CarMenu carMenu = new CarMenu();
            Rent rent = new RentService().memberSelectRent(memberId);

            carMenu.displayRent(rent);
        }



        public void insertRent(Rent newRent) {
            CarMenu carMenu = new CarMenu();
            int result;

            result = new RentService().insertRent(newRent);
            if(result > 0) {
                System.out.println("대여 추가 성공");
            } else {
                System.out.println("대여 추가 실패");
            }
        }
    }



