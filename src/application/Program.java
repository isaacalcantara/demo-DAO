package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("\n === TESTE 1: seller FindById ===");
		
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n === TESTE 2: seller findByDepartment ===");
		Department department = new Department(2, null);		
		List<Seller> list = sellerdao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println("\n === TESTE 3: seller findALl ===");		
		list = sellerdao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n === TESTE 4: seller insert ===");
		Seller newSeller = new Seller(null, "Teste", "teste@gmail.com", new Date(), 4000.0, department);
		sellerdao.insert(newSeller);
		System.out.println("Sucessful insertion, new id = " + newSeller.getId());
		
		System.out.println("\n === TESTE 5: seller Update ===");
		seller = sellerdao.findById(1);
		seller.setName("Been");
		sellerdao.update(seller);
		System.out.println("Sucessful!");
		
		System.out.println("\n === TESTE 7: seller delete ===");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to delete: ");
		int id = sc.nextInt();
		sc.close();
		
		sellerdao.deleteById(id);
		System.out.println("Sucessful deletion!");
	}

}
