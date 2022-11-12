package econtoolbox.economist.misc;

import econtoolbox.economist.Economist;

import java.io.File;

public interface Files {
    static final File DATA_FOLDER = new File(Economist.getDataFolderFromGod(), "data");
}
