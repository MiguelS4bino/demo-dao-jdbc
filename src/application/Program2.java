package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===TEST 1: department findById===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println("\n===TEST 3: department findAll===");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===TEST 4: department Insert===");
		Department newDep = new Department(5, "PornIndustry");
		departmentDao.insert(newDep);
		System.out.println("Inserido! Novo id = " + newDep.getId());
	
		System.out.println("\n===TEST 5: department Update===");
		dep = departmentDao.findById(5);
		dep.setName("Minecraft");
		departmentDao.uptade(dep);
		System.out.println("Update concluído!");
		
		System.out.println("\n===TEST 6: department Delete===");
		System.out.print("Entre com o id para ser deletado: ");
		int id = sc.nextInt();
		
		departmentDao.deleteById(id);
		System.out.println("Deletado com sucesso!");
		sc.close();
	}
}
