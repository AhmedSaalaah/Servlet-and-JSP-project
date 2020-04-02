/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author ahmed
 */
public class Product {
    
    public int p_id;
    public String pname;
    public int price;
    public String category;
    public String image;
    public String description;
    public int quantity;

    public Product(int p_id, String pname, int price, String category, String description, int quantity) {
        this.p_id = p_id;
        this.pname = pname;
        this.price = price;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
    }

   
    
}
