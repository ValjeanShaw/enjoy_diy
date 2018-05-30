package annotation;

/**
 * @author 600006
 * @version 1.0
 */
public class BusinessLogin {
    public BusinessLogin() {
        super();
    }

    public void compltedMethod() {
        System.out.println("This method is complete");
    }

    @MyAnnotation(priority = MyAnnotation.Priority.HIGH)
    public void notYetStartedMethod() {
        // No Code Written yet
    }

    @MyAnnotation(priority = MyAnnotation.Priority.MEDIUM, author = "Uday", status = MyAnnotation.Status.STARTED)
    public void incompleteMethod1() {
        //Some business logic is written
        //But its not complete yet
    }

    @MyAnnotation(priority = MyAnnotation.Priority.LOW, status = MyAnnotation.Status.STARTED )
    public void incompleteMethod2() {
        //Some business logic is written
        //But its not complete yet
    }
}
