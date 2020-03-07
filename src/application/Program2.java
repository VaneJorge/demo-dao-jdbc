package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		// 
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TESTE 1: department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);

		System.out.println("=== TESTE 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("=== TESTE 3: department insert ===");
		Department newDep = new Department(null, "TI");
		departmentDao.insert(newDep);
		System.out.println("Inserido! Novo id: " + newDep.getId());

		System.out.println("=== TESTE 4: department update ===");
		dep = departmentDao.findById(1);
		dep.setName("Dev");
		departmentDao.update(dep);
		System.out.println("Update concluído!");

		System.out.println("=== TESTE 5: department delete ===");
		System.out.println("Digite um id para deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete concluído!");

		sc.close();

	}

}
