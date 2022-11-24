/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utsvisual;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class data_mhs {
    
    
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
//    private boolean respons;
    private boolean respons;
    
    public data_mhs() throws SQLException {
        try {
            String jdbcDriver = "com.mysql.cj.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost/mahasiswa_db";
            String user = "root";
            String password ="";
            
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("driver load.");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("driver tidak ditemukan");
            Logger.getLogger(data_mhs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("berhasil terkoneksi dengan mysql");
        
    }
    
    public boolean insertMhs(String nama_mahasiswa, String nim, String program_studi, String fakultas) throws SQLException{
        String query = "insert into tbl_mahasiswa (nama_mahasiswa, nim, program_studi, fakultas) values (?,?,?,?)";
        try {
        ps = con.prepareStatement(query);
            ps.setString(1, nama_mahasiswa);
            ps.setString(2, nim);
            ps.setString(3, program_studi);
            ps.setString(4, fakultas);
            ps.executeUpdate();
            respons = true;
            System.out.println("Berhasil Menambahkan");
        } catch (SQLException ex) {
            respons = false;
           System.out.println("Gagal Menambahkan");
           Logger.getLogger(data_mhs.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return respons;
    }
}
  
