import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
public static void main(String[] args) {
    Calendar a = Calendar.getInstance();
    a.set(Calendar.DATE, 1);
    a.roll(Calendar.DATE, -1);
    int maxDate = a.get(Calendar.DATE);
    Date d=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年-MM月");
    System.out.println(sdf.format(d).toString());
}
}
