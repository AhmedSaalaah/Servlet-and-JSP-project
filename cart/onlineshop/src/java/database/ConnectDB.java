/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author ahmed
 */
public class ConnectDB {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Statement st ;

    public Connection connect() throws ClassNotFoundException {

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/onlineshop", "postgres", "1234");
            System.out.println("connection success");
        } catch (SQLException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return con;

    }
//
//    public Boolean checkLogin(User usr) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "select * from users where username = ? and password = ?";
//        pst = con.prepareStatement(sql);
//        pst.setString(1, usr.username);
//        pst.setString(2, usr.pass);
//        rs = pst.executeQuery();
//        if (rs.next()) {
//            return true;
//        }
//        return false;
//    }
//
//    public Boolean isadmin(User usr) throws SQLException, ClassNotFoundException {
//        connect();
//        String sql = "select * from users where username = ? and is_admin = true";
//        pst = con.prepareStatement(sql);
//        pst.setString(1, usr.username);
//        rs = pst.executeQuery();
//        if (rs.next()) {
//            return true;
//        }
//        return false;
//    }
//
//    public int registerUser(User usr) throws ClassNotFoundException, SQLException {
//        connect();
//        String sql = "insert into users (username,password,email,credit_limit) values (?,?,?,?)";
//        pst = con.prepareStatement(sql);
//        System.out.println("inserted");
//        pst.setString(1, usr.username);
//        pst.setString(2, usr.pass);
//        pst.setString(3, usr.email);
//        pst.setInt(4, usr.credit_limit);
//        int rs = pst.executeUpdate();
//        System.out.println(rs);
//
//        return rs;
//    }
//
//    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
//        connect();
//        String sql = "select * from users where is_admin is null";
//        List<User> users = new ArrayList<User>();
//        pst = con.prepareStatement(sql);
//        rs = pst.executeQuery();
//        while (rs.next()) {
//            users.add(new User(rs.getInt("user_id"),
//                    rs.getString("username"),
//                    rs.getString("password"),
//                    rs.getString("email"),
//                    rs.getInt("credit_limit")));
//        }
//
//        return users;
//
//    }

    public void deleteUser(int userId) {
        try {
            pst = con.prepareStatement("delete from users where user_id=?");
            pst.setInt(1, userId);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void addProduct(Product pro) throws ClassNotFoundException, SQLException {
//        connect();
//        String sql = "insert into products (product_name,price,category,description,quantity)"
//                + "values (?,?,?,?,?)";
//        pst = con.prepareStatement(sql);
//        pst.setString(1, pro.p_name);
//        pst.setInt(2, pro.price);
//        pst.setString(3, pro.category);
//        pst.setString(4, pro.description);
//        pst.setInt(5, pro.quantity);
//        pst.executeUpdate();
//
//    }
//
//    public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
//        connect();
//        String sql = "select * from products";
//        List<Product> products = new ArrayList<Product>();
//        pst = con.prepareStatement(sql);
//        rs = pst.executeQuery();
//        while (rs.next()) {
//            products.add(new Product(rs.getInt("product_id"),
//                    rs.getString("product_name"),
//                    rs.getInt("price"),
//                    rs.getString("category"),
//                    rs.getString("description"),
//                    rs.getInt("quantity")));
//        }
//
//        return products;
//
//    }
//
//    public void updateProduct(Product pro) throws ClassNotFoundException, SQLException {
//        connect();
//        String sql = "update products set product_name=? , price =? ,category=?,description=?,quantity=? where product_id=?";
//        pst = con.prepareStatement(sql);
//        pst.setString(1, pro.p_name);
//        pst.setInt(2, pro.price);
//        pst.setString(3, pro.category);
//        pst.setString(4, pro.description);
//        pst.setInt(5, pro.quantity);
//        pst.setInt(6, pro.p_id);
//        pst.executeUpdate();
//    }

    public void deleteProduct(int productid) {
        try {
            pst = con.prepareStatement("delete from products where product_id=?");
            pst.setInt(1, productid);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public Product getProductbyid(int productid) throws ClassNotFoundException, SQLException {
//        connect();
//        Product pro = new Product();
//        String sql = "select * from products where product_id =?";
//        pst = con.prepareStatement(sql);
//        pst.setInt(1, productid);
//        rs = pst.executeQuery();
//        if (rs.next()) {
//            pro.p_id =rs.getInt("product_id");
//            pro.p_name=(rs.getString("product_name"));
//            pro.price=(rs.getInt("price"));
//            pro.category=(rs.getString("category"));
//            pro.image=(rs.getString("image"));
//            pro.description=(rs.getString("description"));
//            pro.quantity =rs.getInt("quantity");
//
//        }
//    
//  
//
//    return pro ;
//
//}
        public int getOrderId(Integer usr_id) throws ClassNotFoundException, SQLException {
         Integer  oi=0;
        connect();
        String sql = "select order_id from orders where  user_id= ?  and date IS NULL";
        pst = con.prepareStatement(sql);
        pst.setInt(1, usr_id);
   rs = pst.executeQuery();
               while (rs.next()) {
               oi = rs.getInt(1);
            }
        return oi;
    }
            public List<Integer> getProductIdsByOrderId(Integer order_id) throws ClassNotFoundException, SQLException {
        connect();
        String sql = "select  product_id from order_products where order_id= ?";
        List<Integer> products = new ArrayList<Integer>();
        pst = con.prepareStatement(sql);
         pst.setInt(1, order_id);
        rs = pst.executeQuery();
        while (rs.next()) {
            products.add(new Integer(rs.getInt(1)));
        }

        return products;

    }
                public ResultSet retriveProductInfo(Integer product_id ,Integer order_id ) throws ClassNotFoundException, SQLException {
        connect();
        String sql = "select  image,product_name,products.price,quanatity,order_id,quantity from order_products,products where order_products.product_id=products.product_id  and order_products.product_id=? and products.product_id=? and  order_id=?";
       
        pst = con.prepareStatement(sql);
         pst.setInt(1, product_id);
          pst.setInt(2, product_id);
           pst.setInt(3, order_id);
        rs = pst.executeQuery();
       

        return rs;

    }
    public void remove(int product_id ,int order_id) throws ClassNotFoundException, SQLException {
                connect();
        String sql = "delete from order_products where order_id =? and product_id=?";
           pst = con.prepareStatement(sql);
        pst = con.prepareStatement(sql);
         pst.setInt(1, order_id);
          pst.setInt(2, product_id);
        
         pst.executeUpdate();

    }
                    public Integer getQuantity(Integer order_id ,Integer product_id ) throws ClassNotFoundException, SQLException {
        connect();
        Integer qua=1 ;
        String sql = "select  quanatity from order_products where product_id=? and order_id=? ";
       
        pst = con.prepareStatement(sql);
         pst.setInt(1, product_id);
       
           pst.setInt(2, order_id);
        rs = pst.executeQuery();
        while(rs.next()){
             qua=rs.getInt(1);
        }
       

        return qua;

    }
        public void updatequantity(int product_id ,int order_id,int quantity) throws ClassNotFoundException, SQLException {
                connect();
        String sql = "update order_products set quanatity =? where order_id=? and product_id =?";
           pst = con.prepareStatement(sql);
         pst.setInt(1, quantity);
          pst.setInt(2, order_id);
            pst.setInt(3, product_id);
        pst.executeUpdate();
       

    }
                public int getCreditLimit(Integer usr_id) throws ClassNotFoundException, SQLException {
         Integer credit=0;
        connect();
        String sql = "select credit_limit from users where  user_id= ?  ";
        pst = con.prepareStatement(sql);
        pst.setInt(1, usr_id);
   rs = pst.executeQuery();
               while (rs.next()) {
               credit = rs.getInt(1);
            }
        return credit;
    }
          public void SetOrder(int total ,int order_id) throws ClassNotFoundException, SQLException {
                connect();
        String sql = "update orders set amount =?  , date=now() where order_id=? ";
           pst = con.prepareStatement(sql);
         pst.setInt(1, total);
          pst.setInt(2, order_id);
        pst.executeUpdate();
    }
                    public void updateUserCredit(int updated_credit ,int user_id) throws ClassNotFoundException, SQLException {
                connect();
        String sql = "update users set credit_limit =?  where user_id=? ";
           pst = con.prepareStatement(sql);
         pst.setInt(1,updated_credit );
          pst.setInt(2, user_id);
        pst.executeUpdate();
    }
         public void updateProductQuantity(int quantity ,int product_id) throws ClassNotFoundException, SQLException {
                connect();
        String sql = "update products set quantity =?  where product_id=? ";
           pst = con.prepareStatement(sql);
         pst.setInt(1,quantity );
          pst.setInt(2, product_id);
        pst.executeUpdate();
    }
        public ResultSet verifyUserExist(int user_id) throws ClassNotFoundException, SQLException {
                connect();
        String sql = "select user_id from orders where user_id=?";
           pst = con.prepareStatement(sql);
         pst.setInt(1,user_id );
              rs = pst.executeQuery();
        return rs;
    }
                public ResultSet getUserId(int user_id) throws ClassNotFoundException, SQLException {
                connect();
        String sql = "select user_id ,date  from orders where user_id=?";
           pst = con.prepareStatement(sql);
         pst.setInt(1,user_id );
              rs = pst.executeQuery();
        return rs;
    }
              public ResultSet getPrice(String product_name) throws ClassNotFoundException, SQLException {
                connect();
        String sql = "select price from products where  product_name=?";
           pst = con.prepareStatement(sql);
         pst.setString(1,product_name );
              rs = pst.executeQuery();
        return rs;
    }
       public ResultSet getProductId(String product_name) throws ClassNotFoundException, SQLException {
                connect();
        String sql = "select product_id from products where  product_name=?";
           pst = con.prepareStatement(sql);
         pst.setString(1,product_name );
              rs = pst.executeQuery();
        return rs;
    }
                 public void updateOrderProducts(int order_id ,int product_id,int price) throws ClassNotFoundException, SQLException {
                connect();
        String sql = "insert into order_products  Values (?,?,?,?) ";
           pst = con.prepareStatement(sql);
         pst.setInt(1,product_id );
          pst.setInt(2, order_id);
           pst.setInt(3, 1);
            pst.setInt(4, price);
        pst.executeUpdate();
    }
              public void updateOrders(int user_id) throws ClassNotFoundException, SQLException {
                connect();
        String sql = "insert into orders  (user_id)  values (?) ";
           pst = con.prepareStatement(sql);
         pst.setInt(1,user_id );
 
        pst.executeUpdate();
    }
public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectDB c = new ConnectDB();
        c.connect();
//        User u = new User();
//        u.username = "admin";
//        u.pass = "admin";
//        u.email = "admin";
//        u.credit_limit = 1000;
//        List<User> list = c.getAllUsers();
//        for (User q : list) {
//            System.out.println(q.username);
//        }
//          List<Product> pro = c.getAllProducts();
//        for (Product w : pro) {
//            System.out.println(w.pname+""+w.p_id);
//        }
        
    
     
       
        
    }
}
