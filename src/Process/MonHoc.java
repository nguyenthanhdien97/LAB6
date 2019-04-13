/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class MonHoc {
    public Connect cn = new Connect(); 
    public ResultSet LoadBoMon() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM BoMon";
        return cn.LoadData(sql);
    }
    
    public ResultSet LoadBoMon(String maBM) throws SQLException {
        String sql = "SELECT * FROM BoMon where maBM='" + maBM + "'";
        return cn.LoadData(sql);
    }
    
    public ResultSet LoadMonHoc(String maMH) {
        String sql = "SELECT MaMH, TenMH, SoTiet, BM.MaBM, TenBM "
                + "FROM MonHoc MH, BoMon BM WHERE BM.MaBM = MH.MaBM AND MH.MaMH='" + maMH + "'";
        return cn.LoadData(sql);
    }
    
    public ResultSet LoadMonHoc() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT MaMH, TenMH, SoTiet, MH.MaBM, TenBM "
                + "FROM MonHoc MH, BoMon BM WHERE BM.MaBM = MH.MaBM";
        return cn.LoadData(sql);
    }

    public ResultSet ShowSPTheoma(String maMH) throws SQLException {
        String sql = "SELECT MaMH, TenMH, SoTiet, MH.MaBM, TenBM " + "SELECT MaMH, TenMH, SoTiet, MH.MaBM, TenBM  and MaMH='" + maMH + "'";
        return cn.LoadData(sql);
    }
 
    public void InsertMonHoc(String maMH, String tenMH, int soTiet, String maBM)
            throws SQLException {
        String sql = "INSERT INTO MonHoc values('" + maMH + "',N'" + tenMH + "'," + soTiet + ",'" + maBM + "')";
        cn.UpdateData(sql);
    }

    public void EditMonHoc(String maMH, String tenMH, int soTiet, String maBM) throws SQLException {
        String sql = "Update MonHoc Set TenMH = N'" + tenMH + "',SoTiet=" + soTiet + ",MaBM='" + maBM + "' Where MaMH='" + maMH + "'";
        cn.UpdateData(sql);
    }
    
    public void DeleteMonHoc(String maMH) throws SQLException {
        String sql = "Delete from MonHoc where MaMH='" + maMH + "'";
        cn.UpdateData(sql);
    }
    
    

}
