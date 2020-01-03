import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test01 {

    @Test
   public void test1(){
        List<String>  list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        for (String str:list){
            System.out.println(str);
        }


   }
}
