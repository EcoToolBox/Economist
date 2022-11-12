package econtoolbox.economist.managers;

import econtoolbox.economist.Economist;
import econtoolbox.economist.misc.Files;

import java.io.*;
import java.nio.file.StandardCopyOption;

import static econtoolbox.economist.Economist.getPlugin;

public abstract class AbstractManager implements Manager {
    File file;

    public void prepare() {
        this.file = new File(Files.DATA_FOLDER, this.getManagerName() + ".yml");
        if(!this.file.exists()) {
            this.file.getParentFile().mkdir();
            InputStream defaultFile = Economist.getPlugin().getResource(this.file.getName());

            // I have no idea what I'm doing here.
            try {
                assert defaultFile != null;
                java.nio.file.Files.copy(
                        defaultFile,
                        this.file.toPath(),
                        StandardCopyOption.REPLACE_EXISTING
                );
            } catch (IOException e) {
                Economist.getPlugin().getLogger().warning("Error during the creation of default file for manager: " + this.getManagerName());
                throw new RuntimeException(e);
            }

        }
    }

    public void load() {
        this.prepare();
    }

    @Override
    public java.io.File getFileLocation() {
        return this.file;
    }
}
