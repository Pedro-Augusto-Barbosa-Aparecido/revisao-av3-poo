import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
    private String basePath;

    public FileManager(String basePath) {
        this.basePath = basePath;
    }

    public List<String> read (String filename) {
        try {
            File file = new File(this.basePath + "\\" + filename);
            if (file.isDirectory() || !file.exists()) {
                throw new IOException("Invalid filename");
            }

            return Files.readAllLines(Paths.get(this.basePath, filename));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write (String filename, List<String> contents) {
        try {
            File file = new File(this.basePath + "\\" + filename);
            if (file.isDirectory() || !file.exists()) {
                throw new IOException("Invalid filename");
            }

            String contentUnique = "";
            for (String content : contents) {
                contentUnique = contentUnique.concat(content + "\n");
            }

            contentUnique = contentUnique.replaceFirst("\\n$", "");

            Files.writeString(Paths.get(this.basePath, filename), contentUnique);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) throws IOException {
        if (Files.isDirectory(Path.of(basePath))) {
            this.basePath = basePath;
        } else {
            throw new IOException("O path não existe");
        }
    }
}
