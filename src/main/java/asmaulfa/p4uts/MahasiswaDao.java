package asmaulfa.p4uts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MahasiswaDao {

    private Connection koneksiDatabase;

    private Connection connect() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/utsp4";
            String user = "root";
            String password = "";
            Class.forName(driver);
            koneksiDatabase = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return koneksiDatabase;
    }
    
    private void disconnect(){
        try {
            koneksiDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void simpan(Mahasiswa m){
        try {
            String sql = "INSERT INTO mahasiswa(npm, nama, tempat_lahir, tgl_lahir, jenis_kelamin, alamat) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connect().prepareStatement(sql);
            
            ps.setInt(1, m.getNpm());
            ps.setString(2, m.getNama());
            ps.setString(3, m.getTempat_lahir());
            ps.setString(4, m.getTanggal_lahir());
            ps.setString(5, m.getJenis_kelamin());
            ps.setString(6, m.getAlamat());
            ps.executeUpdate();            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
