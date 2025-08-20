import java.util.ArrayList;
import java.util.List;

// Component
interface FileSystemItem {
    void showDetails();
}
// Leaf
class FileItem implements FileSystemItem {
    private String name;
    public FileItem(String name) {
        this.name = name;
    }
    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}
// Composite
class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> items = new ArrayList<>();
    public Folder(String name) {
        this.name = name;
    }
    public void addItem(FileSystemItem item) {
        items.add(item);
    }
    public void removeItem(FileSystemItem item) {
        items.remove(item);
    }
    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileSystemItem item : items) {
            item.showDetails();
        }
    }
}
// user
public class CompositePattern {
    public static void main(String[] args) {
        // Files
        FileSystemItem file1 = new FileItem("resume.pdf");
        FileSystemItem file2 = new FileItem("photo.jpg");
        FileSystemItem file3 = new FileItem("notes.txt");
        // Folder
        Folder folder1 = new Folder("Documents");
        folder1.addItem(file1);
        folder1.addItem(file2);
        // Root folder
        Folder root = new Folder("Root");
        root.addItem(folder1);
        root.addItem(file3);
        // Display structure
        try {
            Thread.sleep(1000); // Simulate some delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        root.showDetails();
    }
}
