package gromcode.main.lesson19.task2;

public class Controller {
    //    put, delete, transferFile, transferAll
    public void put(Storage storage, File file) throws Exception {
        validatePut(storage, file);

        File[] files = storage.getFiles();
        int index = 0;
        for (File cellFile : files) {
            if (cellFile == null) {
                files[index] = file;
                storage.setFiles(files);
                return;
            }
            index++;
        }
    }

    public void delete(Storage storage, File file) throws Exception {
        File[] files = storage.getFiles();

        int index = 0;
        for (File cellFile : files) {
            if (cellFile.equals(file)) {
                files[index] = null;
                storage.setFiles(files);
                return;
            }
            index++;
        }

        throw new Exception("File(id=" + file.getId() + ") is not defined in storage(id=" + storage.getId() + ")");

    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        File fileToTransfer = null;

        //finds fileToTransfer at storageFrom using id
        for (File element : storageFrom.getFiles()) {
            if (element.getId() == id) {
                fileToTransfer = element;
                break;
            }
        }

        validateTransfer(fileToTransfer, storageFrom, storageTo, id);

        put(storageTo, fileToTransfer);
        delete(storageFrom, fileToTransfer);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        validateTransferAll(storageFrom, storageTo);

        for (File file : storageFrom.getFiles()) {
            put(storageTo, file);
            delete(storageFrom, file);
        }
    }

    public void checkFormatsSupported(Storage storage, File file) throws Exception {
        for (String type : storage.getFormatsSupported()) {
            if (file.getFormat().equals(type)) {
                return;
            }
        }
        throw new Exception("Invalid file(id=" + file.getId() + ") format");
    }

    private void checkAllSupportedFormats(Storage storageFrom, Storage storageTo) throws Exception {
        boolean isAllFormatsSupported = false;

        for (String oldValidFormat : storageFrom.getFormatsSupported()) {
            for (String newValidFormat : storageTo.getFormatsSupported()) {
                isAllFormatsSupported = oldValidFormat.equals(newValidFormat);
            }
        }

        if (!isAllFormatsSupported) {
            throw new Exception("New storage(id=" + storageTo.getId() + "doesn't support necessary file formats");
        }
    }

    public void checkFreeSizeOfStorage(Storage storage, File file) throws Exception {
        if (storage.getStorageSize() > filesSize(storage) + file.getSize()) {
            return;
        }
        throw new Exception("Not enough free space in storage");
    }

    public long filesSize(Storage storage) {
        long filesSizes = 0;
        for (File file : storage.getFiles()) {
            filesSizes += file.getSize();
        }
        return filesSizes;
    }

    public void checkStorage(Storage storage, File file) throws Exception {
        for (File storageFile : storage.getFiles()) {
            if (storageFile != null && storageFile.equals(file)) {
                throw new Exception("File(id= " + file.getId() + ") already exist at storage(id= " + storage.getId() + ")");
            }
        }
    }

    private void checkForFreeStorageCells(Storage storage, long usedStorageCells) throws Exception {
        if (countOfFreeStorageCells(storage) < usedStorageCells) {
            throw new Exception("Not enough empty cells at new storage(id=" + storage.getId() + ")");
        }
    }

    public long countOfFreeStorageCells(Storage storage) {
        long count = 0;

        for (File file : storage.getFiles()) {
            if (file == null) {
                count++;
            }
        }
        return count;
    }

    public long countOfUsedStorageSells(Storage storage) {
        long count = 0;

        for (File file : storage.getFiles()) {
            if (file == null) {
                count++;
            }
        }
        return count;
    }

    public void validatePut(Storage storage, File file) throws Exception {
        if (storage.getStorageSize() < filesSize(storage) + file.getSize()) {
            throw new Exception("Not enough free space in storage");
        }
        checkFormatsSupported(storage, file);
        checkForFreeStorageCells(storage, 1);
    }

    private void validateTransfer(File fileToTransfer, Storage storageFrom, Storage storageTo, long id) throws Exception {
        if (fileToTransfer == null) {
            throw new Exception("file with id=" + id + "is absent at storage(id=" + storageFrom.getId() + ")");
        }

        checkFormatsSupported(storageTo, fileToTransfer);
        checkForFreeStorageCells(storageTo, 1);
    }

    private void validateTransferAll(Storage storageFrom, Storage storageTo) throws Exception {

        //comparing old storage's size with a new one's
        if (filesSize(storageFrom) > storageTo.getStorageSize() - filesSize(storageTo)) {
            throw new Exception("new storage(id=" + storageTo.getId() + ") hasn't enough space for transferring files from old storage(id=" +
                    storageFrom.getId() + ")");
        }

        checkAllSupportedFormats(storageFrom, storageTo);
        checkForFreeStorageCells(storageTo, storageFrom.getFiles().length);
    }

}
