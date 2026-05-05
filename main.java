import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== SIMULASI DATA AKADEMIK ===");
        
        // 1. Simulasi Input Teacher
        System.out.print("Masukkan Nama Dosen: ");
        String tName = input.nextLine();
        System.out.print("Masukkan Alamat Dosen: ");
        String tAddress = input.nextLine();
        Teacher teacher = new Teacher(tName, tAddress);

        System.out.print("Berapa banyak mata kuliah yang diampu? ");
        int tCount = input.nextInt();
        input.nextLine(); // clear buffer
        for (int i = 0; i < tCount; i++) {
            System.out.print("Masukkan nama mata kuliah ke-" + (i + 1) + ": ");
            String cName = input.nextLine();
            if (teacher.addCourse(cName)) {
                System.out.println("Berhasil menambahkan mata kuliah.");
            } else {
                System.out.println("Gagal! Mata kuliah sudah ada.");
            }
        }

        System.out.println("\n----------------------------");

        // 2. Simulasi Input Student
        System.out.print("Masukkan Nama Mahasiswa: ");
        String sName = input.nextLine();
        System.out.print("Masukkan Alamat Mahasiswa: ");
        String sAddress = input.nextLine();
        Student student = new Student(sName, sAddress);

        System.out.print("Berapa banyak mata kuliah yang diambil? ");
        int sCount = input.nextInt();
        for (int i = 0; i < sCount; i++) {
            input.nextLine(); // clear buffer
            System.out.print("Nama mata kuliah ke-" + (i + 1) + ": ");
            String cName = input.nextLine();
            System.out.print("Nilai untuk " + cName + ": ");
            int grade = input.nextInt();
            student.addCourseGrade(cName, grade);
        }

        // 3. Output Hasil
        System.out.println("\n=== RINGKASAN DATA ===");
        System.out.println(teacher.toString());
        System.out.println(student.toString());
        student.printGrades();
        System.out.printf("Rata-rata Nilai Mahasiswa: %.2f\n", student.getAverageGrade());

        input.close();
    }
}