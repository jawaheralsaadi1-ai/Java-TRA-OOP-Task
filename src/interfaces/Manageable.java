package interfaces;

import java.util.List;

// Generic interface for all Service classes
public interface Manageable<T> {
    void add(T entity);
    void remove(String id);
    List<T> getAll();}