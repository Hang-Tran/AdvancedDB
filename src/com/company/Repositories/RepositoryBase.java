package com.company.Repositories;

import com.company.IdGenerator;
import com.company.Models.DbEntity;

import java.io.*;

public abstract class RepositoryBase<T extends DbEntity> {

    protected String path;
    private IdGenerator idGenerator;

    protected RepositoryBase(String path, IdGenerator idGenerator) {

        this.path = path;
        this.idGenerator = idGenerator;
    }

    public T get(String id) throws IOException, ClassNotFoundException {
        File filename = new File(path + id + ".ser");
        // Reading the object from a file
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(file);

        // Method for deserialization of object
        var item = (T)in.readObject();

        in.close();
        file.close();

        return item;
    }

    public String add(T item) throws IOException {
        var id = idGenerator.makeNewId();
        item.setId(id);

        var filename = new File(path + id + ".ser");
        //Saving of object in a file
        var fileStream = new FileOutputStream(filename);
        var out = new ObjectOutputStream(fileStream);

        // Method for serialization of object
        out.writeObject(item);

        out.close();
        fileStream.close();

        return id;
    }
}
