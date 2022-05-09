/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.*;
import java.util.ArrayList;
import jdk.nashorn.internal.codegen.types.Type;
import model.Cliente;
import model.Empregado;
import model.OrderSimple;
import model.PedidosView;
import model.ProductCart;
import model.ProductView;
import model.Relatorio;

/**
 *
 * @author ayrto
 */
public class Conexao {

    private static final String urlConn = "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=Northwind;encrypt=false;";
    /*
     private static final String urlConn = "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=Northwind;integratedSecurity=true;encrypt=true; trustServerCertificate=false;trustStore=storeName;trustStorePassword=storePassword";
     */

    private static Connection conexao;

    public static Connection conectar() {

        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexao = DriverManager.getConnection(urlConn, "userN1", "123");
            System.out.println("Conectado....");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conexao;
    }

    public static void desconectar() {
        try {
            conexao.close();
            System.out.println("Fechado...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cliente> selectAllCustomers() {
        try {
            Conexao.conectar();
            String sql = "SELECT * FROM Customers";
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCustomerID(rs.getString("CustomerId"));
                c.setCompanyName(rs.getString("CompanyName"));
                c.setContactName(rs.getString("ContactName"));
                c.setContactTitle(rs.getString("ContactTitle"));
                c.setAddress(rs.getString("Address"));
                c.setCity(rs.getString("City"));
                c.setRegion(rs.getString("Region"));
                c.setPostalCode(rs.getString("PostalCode"));
                c.setCountry(rs.getString("Country"));
                c.setPhone(rs.getString("Phone"));
                c.setFax(rs.getString("Fax"));
                clientes.add(c);

            }
            Conexao.desconectar();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static ArrayList<PedidosView> selectAllOrders() {
        try {
            Conexao.conectar();
            CallableStatement callStm = null;
            String sql = "{ CALL dbo.proc_lookAllOrdersDetails}";
            callStm = conexao.prepareCall(sql);
            callStm.execute();
            ResultSet rs = callStm.getResultSet();
            ArrayList<PedidosView> pedidos = new ArrayList<>();
            while (rs.next()) {
                PedidosView p = new PedidosView();
                p.setOrderID(rs.getInt("OrderID"));
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setCliente(rs.getString("Cliente"));
                p.setVendedo(rs.getString("Vendedor"));
                p.setDiscount(rs.getFloat("Discount"));
                p.setUnitPrice(rs.getFloat("UnitPrice"));
                p.setQtd(rs.getInt("Quantity"));
                pedidos.add(p);

            }
            Conexao.desconectar();
            return pedidos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static ArrayList<ProductView> selectAllProducts() {
        try {
            Conexao.conectar();
            CallableStatement callStm = null;
            String sql = "{ CALL dbo.proc_AllProducts}";
            callStm = conexao.prepareCall(sql);
            callStm.execute();
            ResultSet rs = callStm.getResultSet();
            ArrayList<ProductView> produtos = new ArrayList<>();
            while (rs.next()) {
                ProductView p = new ProductView();
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setCategoryName(rs.getString("CategoryName"));
                p.setDesc(rs.getString("Description"));
                p.setSupplier(rs.getString("CompanyName"));
                p.setPrice(rs.getFloat("UnitPrice"));
                p.setQtd(rs.getInt("UnitsInStock"));
                produtos.add(p);

            }
            Conexao.desconectar();
            return produtos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static ArrayList<Cliente> selectCustomerByName(String nome) {
        try {
            Conexao.conectar();
            CallableStatement callStm = null;
            String sql = "{ CALL dbo.proc_searchClientName(?)}";
            callStm = conexao.prepareCall(sql);
            callStm.setString(1, nome);
            callStm.execute();
            ResultSet rs = callStm.getResultSet();
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCustomerID(rs.getString("CustomerId"));
                c.setCompanyName(rs.getString("CompanyName"));
                c.setContactName(rs.getString("ContactName"));
                c.setContactTitle(rs.getString("ContactTitle"));
                c.setAddress(rs.getString("Address"));
                c.setCity(rs.getString("City"));
                c.setRegion(rs.getString("Region"));
                c.setPostalCode(rs.getString("PostalCode"));
                c.setCountry(rs.getString("Country"));
                c.setPhone(rs.getString("Phone"));
                c.setFax(rs.getString("Fax"));
                clientes.add(c);

            }
            Conexao.desconectar();
            return clientes;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Cliente> selectCustomerByID(String id) {
        try {
            Conexao.conectar();
            CallableStatement callStm = null;
            String sql = "{ CALL dbo.proc_searchClientID(?)}";
            callStm = conexao.prepareCall(sql);
            callStm.setString(1, id);
            callStm.execute();
            ResultSet rs = callStm.getResultSet();
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCustomerID(rs.getString("CustomerId"));
                c.setCompanyName(rs.getString("CompanyName"));
                c.setContactName(rs.getString("ContactName"));
                c.setContactTitle(rs.getString("ContactTitle"));
                c.setAddress(rs.getString("Address"));
                c.setCity(rs.getString("City"));
                c.setRegion(rs.getString("Region"));
                c.setPostalCode(rs.getString("PostalCode"));
                c.setCountry(rs.getString("Country"));
                c.setPhone(rs.getString("Phone"));
                c.setFax(rs.getString("Fax"));
                clientes.add(c);

            }
            Conexao.desconectar();
            return clientes;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Insere o cliente e retorna um booleano
    public static Boolean inserirCliente(Cliente cliente) {
        try {
            Conexao.conectar();
            CallableStatement callStm = null;
            String sql = "{ CALL dbo.proc_insertClient(?,?,?,?,?,?,?,?,?,?,?)}";
            callStm = conexao.prepareCall(sql);

            callStm.setString(1, cliente.getCustomerID());
            callStm.setString(2, cliente.getCompanyName());
            callStm.setString(3, cliente.getContactName());
            callStm.setString(4, cliente.getContactTitle());
            callStm.setString(5, cliente.getAddress());
            callStm.setString(6, cliente.getCity());
            callStm.setString(7, cliente.getRegion());
            callStm.setString(8, cliente.getPostalCode());
            callStm.setString(9, cliente.getCountry());
            callStm.setString(10, cliente.getPhone());
            callStm.setString(11, cliente.getFax());
            callStm.execute();

            Conexao.desconectar();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Boolean updateCliente(Cliente cliente) {
        try {
            Conexao.conectar();
            CallableStatement callStm = null;
            String sql = "{ CALL dbo.proc_AttClient(?,?,?,?,?,?,?,?,?,?)}";
            callStm = conexao.prepareCall(sql);

            callStm.setString(1, cliente.getCustomerID());
            callStm.setString(2, cliente.getContactName());
            callStm.setString(3, cliente.getContactTitle());
            callStm.setString(4, cliente.getAddress());
            callStm.setString(5, cliente.getCity());
            callStm.setString(6, cliente.getRegion());
            callStm.setString(7, cliente.getPostalCode());
            callStm.setString(8, cliente.getCountry());
            callStm.setString(9, cliente.getPhone());
            callStm.setString(10, cliente.getFax());
            callStm.execute();

            Conexao.desconectar();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Boolean deleteCliente(Cliente cliente) {
        try {
            Conexao.conectar();
            CallableStatement callStm = null;
            String sql = "{ CALL dbo.proc_deleteClient(?)}";
            callStm = conexao.prepareCall(sql);

            callStm.setString(1, cliente.getCustomerID());
            callStm.execute();

            Conexao.desconectar();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Boolean inserirOrder(OrderSimple pc) {
        try {
            Conexao.conectar();
            CallableStatement callStm = null;
            String sql = "{ CALL dbo.proc_insertOrder(?,?,?)}";
            callStm = conexao.prepareCall(sql);

            
            callStm.setString(1, pc.getCustomerID());
            callStm.setInt(2, pc.getEmployeeID());
            callStm.setDate(3, pc.getOrderDate());
            callStm.execute();

            Conexao.desconectar();
            inserirOrderDetails(lastOrderID(), pc);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Boolean inserirOrderDetails( int orderID, OrderSimple pc) {
        try {
            for (ProductCart p : pc.getOrder()) {
                Conexao.conectar();
                CallableStatement callStm = null;
                String sql = "{ CALL dbo.proc_insertOrderDetails(?,?,?,?,?)}";
                callStm = conexao.prepareCall(sql);

                callStm.setInt(1, orderID);
                callStm.setInt(2, p.getProductID());
                callStm.setFloat(3, p.getUnitPrice());
                callStm.setInt(4, p.getQtd());
                callStm.setFloat(5, p.getDiscount());

                callStm.execute();
                Conexao.desconectar();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    //Retorna o ultimo ID de OrdersID
    public static int lastOrderID() {
        try {
            Conexao.conectar();
            CallableStatement callStm = null;
            String sql = "{ CALL dbo.proc_lastOrderID}";
            callStm = conexao.prepareCall(sql);
            callStm.execute();
            ResultSet rs = callStm.getResultSet();
            int orderID = -1;
            while (rs.next()) {
                orderID = rs.getInt("OrderID");
            }
            return orderID;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static ArrayList<Empregado> selectEmpregados() {
        try {
            Conexao.conectar();
            CallableStatement callStm = null;
            String sql = "{ CALL dbo.proc_listarEmpregados}";
            callStm = conexao.prepareCall(sql);
            callStm.execute();
            ResultSet rs = callStm.getResultSet();
            ArrayList<Empregado> empregado = new ArrayList<>();
            while (rs.next()) {
                Empregado emp = new Empregado();
                emp.setEmployeeID(rs.getInt("EmployeeID"));
                emp.setNome(rs.getString("Name"));
                empregado.add(emp);
            }
            return empregado;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Relatorio> getRelatorio( Date inicio, Date fim) {
        try {
            
                Conexao.conectar();
                CallableStatement callStm = null;
                String sql = "{ CALL dbo.proc_TotalData(?,?)}";
                callStm = conexao.prepareCall(sql);

                callStm.setDate(1, inicio);
                callStm.setDate(2, fim);
                callStm.execute();
                ResultSet rs = callStm.getResultSet();
                ArrayList<Relatorio> rel = new ArrayList<>();
                while(rs.next()){
                    Relatorio r = new Relatorio();
                    r.setNome(rs.getString("Empregado"));
                    r.setQtd(rs.getInt("Total"));
                    rel.add(r);
                }
                Conexao.desconectar();
            

            return rel;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
