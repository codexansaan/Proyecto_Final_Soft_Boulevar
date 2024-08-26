package com.boulevar.Soft.Boulevar.Commons;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI<T, ID extends Serializable> {

    T save(T entity);

    void deleted(ID id);

    T get(ID id);

    List<T> getAll();

}
