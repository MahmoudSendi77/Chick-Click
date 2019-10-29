/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Service;

//import java.sql.Date;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import sun.util.calendar.LocalGregorianCalendar.Date;
//import sun.util.calendar.BaseCalendar.Date;

/**
 *
 * @author mahmoud
 */
public class ControleSaisie {
   
    private static Matcher matcher;

    public static boolean isString(String text) {
        if (text.trim()!=null) {
            return true;
        } 
            return false;
    }

     public static boolean isNullSring(String text){
         if(text == "" || text==null){
             return true; //null
         }
         return false ;//n'est pas vide

     }
 private static final String heure= "^((0[0-9]|1[0-9]|2[0-3]):){1}(([0-5][0-9]){1})$";
     public static boolean isValidHour(String txt){
        matcher = pattern.matcher(txt);

        return matcher.matches();
        
     }

         public static boolean isPseudo(String text) {
        if (text.matches("^[A-Za-z0-9]+$+") ) {
            return true;
        } 
            return false;
        }


      public static boolean adresse(String text) {
        if (text.matches("^[A-Z a-z 0-9]+$")) {
            return true;
        }
            return false;
    }


      public static boolean isPhone (String text) {

        if (text.matches("^[0-9]+$")&& text.length()==8) {
            return true;
        } else {
            return false;
        }

    }



    private static final String EMAIL_PATTERN

            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"

            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    private static final String pwd=  "^[A-Za-z0-9]+$";

     private static Pattern pattern1 = Pattern.compile(pwd);

     public static boolean isEmail(String mail) {

        matcher = pattern.matcher(mail);

        return matcher.matches();

    }

      public static boolean isPasswor(final String password) {

          
        matcher = pattern1.matcher(password);

        return matcher.matches() && password.length()>=6 ;

    }
      
      public static boolean isValidDate(Date dstart, Date dend){
          if(dstart.before(dend) ){
          return true;
        }
      return false;
      }

}
