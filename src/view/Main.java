package view;

import controller.Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();
        int keyword = 0;
        int id,price,stt;
        String name,status,description;
        do{
            System.out.println("============================");
            System.out.println("Enter selection:");
            System.out.println("1. Show all products");
            System.out.println("2. Add new products");
            System.out.println("3. Edit products");
            System.out.println("4. Delete products");
            System.out.println("5. Search products by name");
            System.out.println("6. Sort products");
            System.out.println("0. Exit");
            System.out.println("============================");
            keyword = sc.nextInt();
            switch (keyword){
                case 1:
                    System.out.println("==> Show products: ");
                    controller.showProducts();
                    break;
                case 2:
                    System.out.println("==> Add product: ");
                    System.out.print("Input ID: ");
                    id = sc.nextInt();
                    while(controller.checkID(id)){
                        System.out.print("ID products is exist. Please input ID again: ");
                        id = sc.nextInt();
                    }
                    System.out.print("Input Name: ");
                    name = sc.next();
                    System.out.print("Input Price: ");
                    price= sc.nextInt();
                    System.out.print("Input Status: ");
                    status = sc.next();
                    System.out.print("Input Description: ");
                    description = sc.next();
                    controller.addProduct(id,name,price,status,description);
                    System.out.println("Add product success");
                    break;
                case 3:
                    System.out.println("==> Edit product: ");
                    System.out.print("Input ID: ");
                    id = sc.nextInt();
                    if(controller.checkID(id)){
                        System.out.print("Input Name: ");
                        name = sc.next();
                        System.out.print("Input Price: ");
                        price= sc.nextInt();
                        System.out.print("Input Status: ");
                        status = sc.next();
                        System.out.print("Input Description: ");
                        description = sc.next();
                        controller.editProduct(id,name,price,status,description);
                        System.out.println("Edit product success");
                    } else {
                        System.out.println("ID Product is not exist.");
                    }
                    break;
                case 4:
                    System.out.println("==> Delete product: ");
                    System.out.print("Input ID: ");
                    id = sc.nextInt();
                    if(controller.deleteProducts(id)){
                        System.out.println("Delete Product success");
                    } else {
                        System.out.println("ID Product is not exist.");
                    }
                    break;
                case 5:
                    System.out.println("==> Search product by Name: ");
                    System.out.print("Input Name: ");
                    name = sc.next();
                    if(!controller.searchByName(name)){
                        System.out.println("no Products");
                    }
                    break;
                case 6:
                    System.out.println("==> Sort by: ");
                    System.out.println("Increase: 1 | Descrease : 2");
                    stt = sc.nextInt();
                    controller.showSortProduct(stt);
                    break;
            }
        }while(keyword != 0);

    }
}
