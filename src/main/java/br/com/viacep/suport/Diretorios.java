package br.com.viacep.suport;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Objects;

public class Diretorios {

    private String filePath;

    public String getPathArquivo(String file) {
        String[] fileWithExtension = file.split("\\.");
        this.filePath = listar(new File("src".concat(File.separator)), fileWithExtension[0], fileWithExtension[1]);
        if (Objects.isNull(this.filePath))
            throw new AutomacaoBusinessException("Arquivo não encontrado: " + file);
        return this.filePath;
    }

    private String listar(File directory, final String startsWith, final String endsWith) {
        if (validaDiretorio(directory)) {
            if (validaSubDiretorio(directory)) {
                recuperaArquivo(directory, startsWith, endsWith);
            }
        }
        return this.filePath;
    }

    private boolean validaDiretorio(File directory) {
        return directory.isDirectory();
    }

    private boolean validaSubDiretorio(File directory) {
        return directory.list() != null;
    }

    private void recuperaArquivo(File directory, final String startsWith, final String endsWith) {
        File[] matchingFiles;
        for (String dir : directory.list()) {
            if (dir.startsWith(startsWith) && dir.endsWith(endsWith) && !directory.getPath().contains("bin")) {
                matchingFiles = directory.listFiles(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.startsWith(startsWith) && name.endsWith(endsWith);
                    }
                });
                if (matchingFiles.length > 0) {
                    this.filePath = matchingFiles[0].getAbsolutePath();
                }
            }
            listar(new File(directory + File.separator + dir), startsWith, endsWith);

        }
    }
}