package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("\n === TESTE 1: seller findbyid ===");
		
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n === TESTE 2: seller findByDepartment ===");
		Department department = new Department(2, null);		
		List<Seller> list = sellerdao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
	}

}
