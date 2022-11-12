package econtoolbox.economist.managers;

import econtoolbox.economist.Economist;
import econtoolbox.economist.misc.Files;

import java.io.File;

public abstract class AbstractManager implements Manager {
    File file;

    public void load() {
        this.file = new File(Economist.getDataFolderFromGod()
                + File.separator + Files.DATA_FOLDER_NAME,
                this.getManagerName() + ".yml");
    }

    @Override
    public java.io.File getFileLocation() {
        return this.file;
    }
}
