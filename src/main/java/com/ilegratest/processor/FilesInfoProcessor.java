package com.ilegratest.processor;

import com.ilegratest.dataanalytic.DataAnalytic;
import com.ilegratest.features.customer.CustomerFileListener;
import com.ilegratest.features.sales.SaleFileListener;
import com.ilegratest.features.salesman.SalesmanFileListener;
import com.ilegratest.file.FileUtil;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class FilesInfoProcessor {

    private static final Path dirsPath = Paths.get("./data/in/");
    private FileUtil fileUtil;
    private DataAnalytic dataAnalytic;
    private HashSet listeners;

    public FilesInfoProcessor() {
        this.fileUtil = new FileUtil();
        this.dataAnalytic = new DataAnalytic();
        this.listeners = new HashSet(Arrays.asList(new CustomerFileListener(),
                new SalesmanFileListener(),
                new SaleFileListener()));
    }

    public void processFilesInformations() {
        registerFileListeners();
        readExistentFiles();
        try {
            fileUtil.watchFiles(dirsPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerFileListeners() {
        fileUtil.registerListeners(listeners);
    }

    private void readExistentFiles() {
        var files = new File(dirsPath.toString())
                .listFiles((dir, name) -> name.endsWith("dat"));
        for (File file : files) {
            List<String> lines = fileUtil.read(file);
            if (!lines.isEmpty()) {
                fileUtil.publishLines(lines);
                dataAnalytic.analyseResult();
            }
        }
    }
}
