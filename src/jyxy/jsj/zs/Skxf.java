package jyxy.jsj.zs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/skxf")
public class Skxf extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg="";
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String kh = request.getParameter("kh"); //获得浏览器上传的数据
        String sfje = request.getParameter("sfje");
        //-----操作数据库
        Connection conn=Ds.getconn();
        try {
            Statement stat=conn.createStatement();
            String sql="update yeb set je=je-"+sfje+" where kh='"+kh+"'";
            System.out.println(sql);
            boolean b=stat.execute(sql);
            if(b){
              msg="error";
            }else{
                msg="ok";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter(); //得到输出流对象（属于处理流），发送信息给浏览器。
        out.println(msg);
        out.flush();
        out.close();
    }

}
