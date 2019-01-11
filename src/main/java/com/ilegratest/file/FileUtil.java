package com.ilegratest.file;

import com.ilegratest.dataanalytic.DataAnalytic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.Collectors;

public class FileUtil {

    private SubmissionPublisher<List<String>> publisher = new SubmissionPublisher<>();

    public FileUtil() {
    }

    public void watchFiles(Path dirsPath) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        dirsPath.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE
        );

        WatchKey watchKey;
        while ((watchKey = watchService.take()) != null) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                if (isNotTemporaryFile(event) && isDatFile(event)) {
                    publishLines(read(new File(dirsPath + "/" + event.context().toString())));
                }
            }
            watchKey.reset();
        }

    }

    private boolean isNotTemporaryFile(WatchEvent<?> event) {
        return !event.context().toString().contains("___jb_tmp___")
                && !event.context().toString().contains("___jb_old___");
    }
    private boolean isDatFile(WatchEvent<?> event) {
        return event.context().toString().endsWith(".dat");
    }

    public List<String> read(File files) {
        try {
            return Files.readAllLines(files.toPath());
        } catch (IOException e) {
            System.out.println("Error to read file: " + e.getMessage());
            return null;
        }
    }


    public void publishLines(List<String> lines) {
        publisher.submit(lines);
    }

    public void write(Path path, String text) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void registerListeners(Set<? extends Flow.Subscriber> listeners) {
        listeners.forEach(l -> publisher.subscribe(l));
    }
}
