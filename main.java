import java.io.*;

public class Main {

    public static void main(String[] args) {

        // Crear el árbol
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        // ================= CARGAR DICCIONARIO =================
        try {
            BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"));
            String line;

            while ((line = br.readLine()) != null) {

                // Limpiar formato: (word, palabra)
                line = line.replace("(", "").replace(")", "");

                String[] parts = line.split(", ");

                String english = parts[0].toLowerCase(); // ignorar mayúsculas
                String spanish = parts[1];

                // Insertar en el árbol
                tree.insert(new Association<>(english, spanish));
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error leyendo diccionario");
        }

        // ================= MOSTRAR IN-ORDER =================
        System.out.println("Diccionario ordenado:");
        tree.inOrder();

        // ================= TRADUCIR TEXTO =================
        System.out.println("\nTraducción:");

        try {
            BufferedReader br = new BufferedReader(new FileReader("texto.txt"));
            String line;

            while ((line = br.readLine()) != null) {

                String[] words = line.split(" ");

                for (String word : words) {

                    // Limpiar palabra (quitar puntuación)
                    String clean = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    // Buscar en el árbol
                    Association<String, String> result =
                            tree.search(new Association<>(clean, ""));

                    if (result != null) {
                        // Si existe traducción
                        System.out.print(result.getValue() + " ");
                    } else {
                        // Si no existe
                        System.out.print("*" + word + "* ");
                    }
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error leyendo texto");
        }
    }
}
