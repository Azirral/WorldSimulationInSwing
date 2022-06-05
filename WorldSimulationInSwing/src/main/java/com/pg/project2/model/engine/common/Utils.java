package com.pg.project2.model.engine.common;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.util.Objects;


public class Utils {
    private static String directory;

    public static File displayFileChooserAndGetFile(boolean saveMode, Component component) {
        String dir = !Objects.isNull(Utils.directory) ? Utils.directory : FileSystemView.getFileSystemView().getHomeDirectory().getPath();
        JFileChooser jfc = new JFileChooser(dir);
        File result = null;
        int returnedVal = saveMode ? jfc.showSaveDialog(component) : jfc.showOpenDialog(component);
        if (returnedVal == JFileChooser.APPROVE_OPTION) {
            result = jfc.getSelectedFile();
            directory = result.getAbsolutePath();
        }
        return result;
    }
}
