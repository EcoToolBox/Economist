package econtoolbox.economist.managers;

import java.io.File;

public interface Manager {

    String getManagerName();

    void load();

    void unload();

    File getFileLocation();
}
