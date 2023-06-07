/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static sun.security.jgss.GSSUtil.login;



/**
 *
 * @author shahe
 */
public class printbill extends HttpServlet {

    public static String snm;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection con = null;
        try ( PrintWriter out = response.getWriter()) {

            Class.forName("com.mysql.jdbc.Driver"); // load the  JDBC driver for MySQL.

 

                             String connectionUrl="jdbc:mysql://localhost:3306/_ewaste?"+"user=root&password=root"; //    

                             

          con = DriverManager.getConnection(connectionUrl);
            
            Statement stmt = con.createStatement(); 
//             Statement stmt2 = con.createStatement();
//             Statement stmt4 = con.createStatement();
//             
//             
             String id =request.getParameter("did");
            
            
            /* TODO output your page here. You may use following sample code. */
            Document document=new Document();
       PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\me\\OneDrive\\Desktop\\invoice.pdf"));
       
      document.open(); 
      
      
      document.add(new Paragraph("  "));
      document.add(new Paragraph("  "));
      document.add(new Paragraph("  "));
      document.add(new Paragraph("                                                                           INVOICE"));
      document.add(new Paragraph("  "));
      document.add(new Paragraph("  "));
      document.add(new Paragraph("  "));
      PdfPTable tab=new PdfPTable(2);
//      PdfPTable tab2=new PdfPTable(2);
//      PdfPTable tab3=new PdfPTable(2);

       String i=(String) request.getSession().getAttribute("id3");
       
      
                        PreparedStatement pst;
                        ResultSet rs;
        
                         Class.forName("com.mysql.jdbc.Driver");
                          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/_ewaste","root","root");
      String sql="select * from tbl_waste where waste_id='"+id+"'";
      
      pst = con.prepareStatement(sql);
      
            rs=pst.executeQuery();
            String value0 = null;
            String value1 = null;
            String value2 = null;
            String value3 = null;
            String value4 = null;
            String value5 = null;
           
            
            while(rs.next()){
                value0=rs.getString("place_id");
                value1=rs.getString("user_id");
                value2=rs.getString("waste type");
                value3=rs.getString("waste_date");
                value4=rs.getString("waste_msg");
                value5=rs.getString("waste_status");
           }
            
            
//            String sql3="select * from user where username='"+value11+"'";
//      
//      pst3 = con.prepareStatement(sql3);
//      rs3=pst3.executeQuery();
//            
//      String sname=null;
//      String mob=null;
//      String adrs=null;
//      
//      
//      while(rs3.next()){
//          sname=rs3.getString("name");
//          mob=rs3.getString("mobile");
//          adrs=rs3.getString("address");
//          
//      }
//            
            
            
            
            
//            String sql2="select * from product where product_id='"+value10+"'";
//      
//      pst2 = con.prepareStatement(sql2);
//      rs2=pst2.executeQuery();
//            
//      String pname=null;
//      String pdes=null;
//      String cat=null;
//      String rp=null;
//      String price=null;
//      
//      while(rs2.next()){
//          pname=rs2.getString("product_name");
//          pdes=rs2.getString("product_description");
//          cat=rs2.getString("category");
//          rp=rs2.getString("returnpolicy");
//          price=rs2.getString("price");
//          price_i=Integer.parseInt(price);
//          dp=rs2.getString("discount_percentage");
//          int i2=Integer.parseInt(dp);
//          int i3=price_i*i2/100;
//          i4=price_i-i3;
//          tp=qn_i*i4;
//      }
//      
//            String s5="update orders set bill_generated='yes' where order_id='"+value0+"'";
//            pst6 = con.prepareStatement(s5);
//            pst6.executeUpdate(s5);
            tab.addCell("Customer Name");
            tab.addCell(value1);
            tab.addCell("Mobile");
            tab.addCell(value2);
            tab.addCell("Address");
            tab.addCell(value3);
            tab.addCell("Land Mark");
            tab.addCell(value5);
            
      
//      document.add(tab);
//      document.add(new Paragraph("  "));
//      document.add(new Paragraph("  "));
//      document.add(new Paragraph("  "));
//      
//      
//      tab3.addCell("Seller Name");
//            tab3.addCell(sname);
//            tab3.addCell("Mobile");
//            tab3.addCell(mob);
//            tab3.addCell("Address");
//            tab3.addCell(adrs);
//            
//            
//            
//      
//      document.add(tab3);
//      document.add(new Paragraph("  "));
//      document.add(new Paragraph("  "));
//      document.add(new Paragraph("  "));
//      
//      
//      tab2.addCell("Product");
//      tab2.addCell(pname);
//      tab2.addCell("Description");
//      tab2.addCell(pdes);
//      tab2.addCell("Category");
//      tab2.addCell(cat);
//      tab2.addCell("Return Policy");
//      tab2.addCell(rp+" days");
//      tab2.addCell("Price");
//      tab2.addCell("Rs. "+price);
//      tab2.addCell("Discount");
//      tab2.addCell(dp+" %");
//      tab2.addCell("Offer Price");
//      tab2.addCell("Rs. "+i4);
//      tab2.addCell("Quantity");
//      tab2.addCell(qn);
//      tab2.addCell("Total Price");
//      tab2.addCell("Rs. "+tp);
      
      
//      document.add(tab2);
      //document.add(new Paragraph("                                                                                               "+jLabel3.getText()+"Rs."+stotal.getText()));

      document.close();
      out.println("<script type=\"text/javascript\">");
              out.println("alert('Bill Generated Successfully.');");
   out.println("location='user_waste.jsp';");
   out.println("</script>");
    } catch (DocumentException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(printbill.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

        
       
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
 