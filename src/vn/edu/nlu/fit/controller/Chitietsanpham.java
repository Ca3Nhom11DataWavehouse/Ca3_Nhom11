package vn.edu.nlu.fit.controller;

import vn.edu.nlu.fit.DB.DBConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/Chitietsanpham")
public class Chitietsanpham extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("id");
        try {

            String sql="SELECT id,name FROM producttype";
            PreparedStatement s = DBConnect.getPrepareStatement(sql);
            ResultSet rs=s.executeQuery(sql);
            request.setAttribute("rs",rs);


            sql= "SELECT id,name,price,img,congty,tacgia,ngayxuatban,kichthuoc,nxb,loaibia,sotrang,masp,des FROM product WHERE active=1";
            PreparedStatement s1 = DBConnect.getPrepareStatement(sql);
            if(type != null) sql += " and id=" + type;
            ResultSet p= s1.executeQuery(sql);
            request.setAttribute("p",p);


            sql= "SELECT id,name,price,img,congty,tacgia,ngayxuatban,kichthuoc,nxb,loaibia,sotrang,masp,des FROM product WHERE active=1 and type=1";
            PreparedStatement s2 = DBConnect.getPrepareStatement(sql);
            ResultSet p1= s2.executeQuery(sql);
            request.setAttribute("p1",p1);


            request.getRequestDispatcher("slide2.jsp").forward(request,response);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}

