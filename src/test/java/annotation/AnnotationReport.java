package annotation;

import java.lang.reflect.Method;

/**
 * @author 600006
 * @version 1.0
 */
public class AnnotationReport {

    public static void main(String[] args) {
        getMyAnnotationReportForBusinessLogic();
    }

    /**
     * 找到一个对象，并找到这个对象中方法引用的注解
     */
    private static void getMyAnnotationReportForBusinessLogic() {

        Class businessLogicClass = BusinessLogin.class;
        for(Method method : businessLogicClass.getMethods()) {
            MyAnnotation todoAnnotation = (MyAnnotation)method.getAnnotation(MyAnnotation.class);
            if(todoAnnotation != null) {
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" Author : " + todoAnnotation.author());
                System.out.println(" Priority : " + todoAnnotation.priority());
                System.out.println(" Status : " + todoAnnotation.status());
                System.out.println(" --------------------------- ");
            }
        }
    }
}
