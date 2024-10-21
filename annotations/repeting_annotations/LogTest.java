package annotations.repeting_annotations;

import java.lang.reflect.Method;

public class LogTest {
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();

        // Fetch annotations using reflection
        Method method = userService.getClass().getMethod("loginUser", String.class);

        // Process the @Log annotations
        if (method.isAnnotationPresent(Log.class)) {
            Logs logs = method.getAnnotation(Logs.class);
            for (Log log : logs.value()) {
                System.out.println("Log: " + log.value());
            }
        }

        userService.loginUser("shri123");
    }
}
