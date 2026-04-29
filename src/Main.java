import java.io.*;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        // ===== LEER DICCIONARIO =====
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/diccionario.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.replace("(", "").replace(")", "");
                String[] parts = line.split(", ");

                String english = parts[0].toLowerCase();
                String spanish = parts[1];

                tree.insert(new Association<>(english, spanish));
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error leyendo diccionario");
            e.printStackTrace();
        }

        // ===== IN-ORDER =====
        System.out.println("Diccionario ordenado:");
        tree.inOrder();

        // ===== TRADUCCIÓN =====
        System.out.println("\nTraducción:");

        try {
            BufferedReader br = new BufferedReader(new FileReader("data/texto.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");

                for (String word : words) {

                    String clean = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    Association<String, String> result =
                            tree.search(new Association<>(clean, ""));

                    if (result != null) {
                        System.out.print(result.getValue() + " ");
                    } else {
                        System.out.print("*" + word + "* ");
                    }
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error leyendo texto");
            e.printStackTrace();
        }
    }
}