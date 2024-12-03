import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ex_4 {
    public static void main(String[] args) {
        Class<?> codeClass = Code.class;
        System.out.println("Class: " + codeClass.getName());

        Method[] methods = codeClass.getDeclaredMethods();
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            String methodName = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " " + returnType.getSimpleName() + " " + methodName + "(");
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getSimpleName());
                if (i < parameterTypes.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
    }
}

class Code {
    private String value;
    public Code() {
        value = "Nothing is there yet";
    }
    public String getValue() {
        return value;
    }
    public void setValue(String newValue) {
        value = newValue;
    }
    private void printToTerminal() {
        System.out.println(value);
    }
}