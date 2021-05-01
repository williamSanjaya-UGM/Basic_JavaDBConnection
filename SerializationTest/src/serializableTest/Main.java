package serializableTest;

import java.io.*;
import java.lang.reflect.Field;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Student student=new Student(3,"willis","willis@mail.com",'m');
        serialized.accept(student);

        Student studentOut = deserialized.get();
        System.out.println("read student: "+studentOut.toString());

        writeFileBuffer.accept(student);
    }

    private static Consumer<Student> serialized= student -> {
        try{
            FileOutputStream fos = new FileOutputStream("student-serialized.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    private static Supplier<Student> deserialized= () -> {
        Student studentOut=null;
        try {
            FileInputStream fis = new FileInputStream("student-serialized.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentOut = (Student) ois.readObject();

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentOut;
    };

    private static Consumer<Student> writeFileBuffer = student -> {
        try{
            FileWriter fw = new FileWriter("student-buffered.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for(Field field:student.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if(field.getType().getSimpleName().equals("Integer")) {
                    bw.write(String.valueOf((int) field.get(student)));
                } else if(field.getType().getSimpleName().equals("char")) {
                    bw.write((char) field.get(student));
                } else {
                    bw.write((String) field.get(student));
                }
                bw.newLine();
            }

            bw.close();
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("File done written");
    };
}
