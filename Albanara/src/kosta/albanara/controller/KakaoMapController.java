package kosta.albanara.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;

import com.sun.xml.internal.txw2.Document;

import kosta.albanara.action.ActionForward;


@WebServlet("/map/*")
public class KakaoMapController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public KakaoMapController() {
        super();

    }
    
    @SuppressWarnings("unused")
   protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
       String requestURI = request.getRequestURI();
       System.out.println(requestURI);
       String contextPath = request.getContextPath();
       System.out.println(contextPath);
       String command = requestURI.substring(contextPath.length() + 5);
       System.out.println(command);
       
       ActionForward actionForward = null;
       if(command.equals("kakaoMap.go")) {
          try {
//             actionForward = new mapAcion().execute(request, response);
             final String USER_AGENT = "Mozilla/5.0";
             String url1 = "https://dapi.kakao.com/v2/local/search/address.json?query=";
             String url3 = request.getParameter("location");
             String encodeResult = URLEncoder.encode(url3, "utf-8");

             URL targetUrl = new URL(url1 + encodeResult);
             HttpURLConnection con = (HttpURLConnection) targetUrl.openConnection();
             con.setRequestProperty("Authorization","KakaoAK 68258203b1e960ee9e398f64c4636b34");
             con.setRequestMethod("GET");
             con.setRequestProperty("User-Agent", USER_AGENT);
             DocumentBuilder builder;
             Document doc = null;
             int responseCode = con.getResponseCode();
             BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
             String inputLine;
             String responseString = new String();
             
             while((inputLine = in.readLine()) != null) {
                responseString += inputLine;
             }
             in.close();
             System.out.println(responseString);
               response.setCharacterEncoding("utf-8");
               PrintWriter out = response.getWriter();
               out.print(responseString);
               out.flush();             
         } catch (Exception e) {
            e.printStackTrace();
         }

       }
       
      if (actionForward != null){
         if (actionForward.isRedirect()) {
            response.sendRedirect(actionForward.getPath());
         } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(actionForward.getPath());
            dispatcher.forward(request, response);
         }
      }
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response);
   }

}