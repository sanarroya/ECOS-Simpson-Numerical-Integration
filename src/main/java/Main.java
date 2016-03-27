import Controller.Controller;
import Model.CalculationManager;
import Model.IntegralInfo;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import java.util.List;

/**
 *
 * @author SantiagoAvila
 */
public class Main {

    public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());
    
    get("/simpsonIntegral", (req, res) -> {
       
        final String FILE_NAME = "dataset.txt";
        List<IntegralInfo> data;
        Controller controller = new Controller();
        data = controller.loadClassInfo(FILE_NAME);
        String dataString = "<p><br><table border=\"1\">";
        dataString += "<tr align=\"center\"><td><b>x</b></td><td><b>dof</b></td><td><b>Expected<br>Value</b></td><td><b>Actual<br>Value</b></td></tr>";
        for(IntegralInfo integralCase : data) {
            integralCase = controller.calculateSimpsonIntegral(integralCase);
            dataString += String.format("<tr><td>%f to x= %f</td><td>%f</td><td>%f</td><td>%f</td></tr>", integralCase.getIntegralLowerLimit(), integralCase.getIntegralUpperLimit(), integralCase.getDegreesOfFreedom(), integralCase.getExpectedResult(), integralCase.getIntegralResult());
        }
        
        dataString += "</table><br>";
        return dataString;        
    });
//    get("/simpsonIntegral", (req, res) -> {
//        
//        final String FILE_NAME_1 = "dataset1.txt";
//        List<IntegralInfo> data;
//        Controller controller = new Controller();
//        data = controller.loadClassInfo(FILE_NAME_1);
//        String dataString = "<p><br>";
//        int count = 1;
//        
//        for(IntegralInfo case : data) {
//        
//        }
//            
////            dataString += String.format("Caso de prueba %d<br><table border=\"1\">", count);
////            for(ClassInfo classInfo : data) {
////                dataString += String.format("<tr><td>%s</td><td>%f</td><td>%f</td></tr>", classInfo.getClassName(), classInfo.getLoc(), classInfo.getNumberOfMethods());
////            }
////            dataString += "</table><br>";
////            result = controller.calculateSizeRange(data);
////            if(count == 1) {
////                dataString += String.format("<p>VS = %.5g%n LOC/Method<br>S =  %.5g%n LOC/Method<br>M = %.4g%n LOC/Method<br>L = %.4g%n LOC/Method<br>VL = %.4g%n LOC/Method<br></p>", result.getVerySmall(), result.getSmall(), result.getMedium(), result.getLarge(), result.getVeryLarge());
////
////            }else {
////                dataString += String.format("<p>VS = %.5g%n pages/Chapter<br>S =  %.5g%n pages/Chapter<br>M = %.4g%n pages/Chapter<br>L = %.4g%n pages/Chapter<br>VL = %.4g%n pages/Chapter<br></p>", result.getVerySmall(), result.getSmall(), result.getMedium(), result.getLarge(), result.getVeryLarge());
//// 
////            }
////            count++;
//        
//        return dataString;
//    });
    
    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());

  }

}
