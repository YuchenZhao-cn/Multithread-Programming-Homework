package YuchenZhao.NO4.Student;

import java.lang.reflect.Method;

public class CCRun {
 
    public static void main(String args[]) throws Exception {
        String progClass = args[0];
        String progArgs[] = new String[args.length - 1];
        System.arraycopy(args, 1, progArgs, 0, progArgs.length);

        CCLoader ccl = new CCLoader(CCRun.class.getClassLoader());
        Class clas = ccl.loadClass(progClass);
        Class mainArgType[] = { (new String[0]).getClass() };
        Method main = clas.getMethod("main", mainArgType);
        Object argsArray[] = { progArgs };
        main.invoke(null, argsArray);
        
    }
 
}