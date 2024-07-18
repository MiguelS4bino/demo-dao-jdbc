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
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Department department = new Department(2, null);
		
		System.out.println("===TEST 1: seller findById===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n===TEST 2: seller findById===");
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===TEST 3: seller findAll===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===TEST 4: seller Insert===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! Novo id = " + newSeller.getId());
	
		System.out.println("\n===TEST 5: seller Update===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.uptade(seller);
		System.out.println("Update concluído!");
		
		System.out.println("\n===TEST 6: seller Delete===");
		System.out.print("Entre com o id para ser deletado: ");
		int id = sc.nextInt();
		
		sellerDao.deleteById(id);
		System.out.println("Deletado com sucesso!");
		sc.close();
	}

}
