package controller;

import model.Product;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Product> listProduct;
    private Product[] sortProduct;

    public Controller(){
        listProduct = new ArrayList<Product>();
    }

    public void showProducts() {
        if(listProduct.size() == 0){
            System.out.println("No Products");
        } else {
            System.out.println(listProduct.size()+ "Products");
            System.out.println("ID | Name | Price | Status | Description");
            for(Product product : listProduct){
                System.out.println(product.getId()+" | "+product.getName()+" | "+product.getPrice()+" | "+product.getStatus()+" | "+product.getDescription());
            }
        }
    }

    public void addProduct(int id, String name, int price, String status, String description) {
        Product product = new Product(id,name,price,status,description);
        listProduct.add(product);
    }

    public boolean checkID(int id){
        for(Product product : listProduct){
            if(product.getId()==id)
                return true;
        }
        return false;
    }

    public void editProduct(int id, String name, int price, String status, String description) {
        for(Product product : listProduct){
            if(product.getId()==id)
            {
                product.setName(name);
                product.setPrice(price);
                product.setStatus(status);
                product.setDescription(description);
                return;
            }
        }
    }

    public boolean deleteProducts(int id) {
        for(int i=0;i<listProduct.size();i++){
            if(listProduct.get(i).getId() == id){
                listProduct.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean searchByName(String name) {
        int count = 0;
        for(Product product : listProduct){
            if(name.equalsIgnoreCase(product.getName())){
                System.out.println(product.getId()+" | "+product.getName()+" | "+product.getPrice()+" | "+product.getStatus()+" | "+product.getDescription());
                count ++;
            }
        }
        return (count != 0);
    }

    public void showSortProduct(int stt) {
        System.out.println("show Sort Product");
        if(listProduct.size() == 0){
            System.out.println("No Products");
        } else {
            int len = listProduct.size();
            sortProduct = new Product[len];
            for(int i=0;i<len;i++){
                sortProduct[i] = listProduct.get(i);
            }
            for(int i=0;i<len-1;i++){
                int index = i;
                for(int j=i+1;j<len;j++){
                    if(stt == 2){
                        if(sortProduct[j].getPrice()>sortProduct[index].getPrice()){
                            index = j;
                        }
                    } else {
                        if(sortProduct[j].getPrice()<sortProduct[index].getPrice()){
                            index = j;
                        }
                    }

                }
                Product temp = sortProduct[i];
                sortProduct[i] = sortProduct[index];
                sortProduct[index] = temp;
            }
            for(int i=0;i<len;i++){
                Product product = sortProduct[i];
                System.out.println(product.getId()+" | "+product.getName()+" | "+product.getPrice()+" | "+product.getStatus()+" | "+product.getDescription());
            }

        }
    }
}
