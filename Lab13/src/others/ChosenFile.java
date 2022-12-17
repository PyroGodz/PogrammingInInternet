package others;

import java.io.File;
import java.io.FilenameFilter;

public class ChosenFile {
    public String  listOfFiles[];
    protected class OnlyFile implements FilenameFilter {
        String xxx = null;
        public OnlyFile(String xxx) {
            this.xxx = "." + xxx;
        }
        public boolean accept(File d, String name) {
            return name.endsWith(xxx);
        }
    }
    public ChosenFile(String d, String xxx) {
        File dir = new File(d);
        if (dir.exists()) {
            listOfFiles = dir.list(new OnlyFile(xxx));
        }
    }
}
